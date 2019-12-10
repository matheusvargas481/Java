package com.matheusvargas481.cloudnative.rxnetty;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.matheusvargas481.cloudnative.rxnetty.configuracao.AppConfig;
import com.matheusvargas481.cloudnative.rxnetty.exception.DivisaoPorZeroNaoExisteException;
import com.matheusvargas481.cloudnative.rxnetty.exception.ParametroIncorretoException;
import com.matheusvargas481.cloudnative.rxnetty.service.CalculadoraService;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

	private final String healthCheckUri;
	private final HealthCheckEndpoint healthCheckEndpoint;
	Injector injector = Guice.createInjector(new AppConfig());
	CalculadoraService calculadoraService = injector.getInstance(CalculadoraService.class);

	public RxNettyHandler(String healthCheckUri, HealthCheckEndpoint healthCheckEndpoint) {
		this.healthCheckUri = healthCheckUri;
		this.healthCheckEndpoint = healthCheckEndpoint;
	}

	@Override
	public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
		if (request.getUri().startsWith(healthCheckUri)) {
			return healthCheckEndpoint.handle(request, response);
		} else if (request.getUri().startsWith("/calculadora/")) {
			int prefixLength = "/calculadora/".length();
			String[] parameters = request.getPath().substring(prefixLength).split("/");
			if (parameters.length == 3) {
				try {
					String numeroUm = parameters[0];
					String operacao = parameters[1];
					String numeroDois = parameters[2];
					Double resultado = calculadoraService.calcular(operacao, Double.parseDouble(numeroUm),
							Double.parseDouble(numeroDois));
					return response.writeStringAndFlush("{\"numeroUm\":\"" + numeroUm + "\", \"operacao\":\"" + operacao + "\", \"numeroDois\":\"" + numeroDois + "\", \"resultado\":\"" + resultado + "\"}");
				} catch (ParametroIncorretoException e) {
					response.setStatus(HttpResponseStatus.BAD_REQUEST);
					return response.writeStringAndFlush(
							"{\"Error\":\"Please provide valid numbers. The URI should be /calculadora/{numeroUm}/{operacao}/{numeroDois}\"}");
				} catch (DivisaoPorZeroNaoExisteException e) {
					response.setStatus(HttpResponseStatus.BAD_REQUEST);
					return response.writeStringAndFlush(
							"{\"Error\":\"Please provide valid second number for division. The URI should be /calculadora/{numeroUm}/div/{numeroDois != 0}\"}");
				}
			} else {
				response.setStatus(HttpResponseStatus.BAD_REQUEST);
				return response.writeStringAndFlush(
						"{\"Error\":\"Please provide valid number parameters. The URI should be /calculadora/{numeroUm}/{operacao}/{numeroDois}\"}");
			}
		} else if (request.getUri().startsWith("/historico")) {
			response.setStatus(HttpResponseStatus.BAD_REQUEST);
			return response.writeStringAndFlush(calculadoraService.listarHistorico().toString());
		} else {
			response.setStatus(HttpResponseStatus.NOT_FOUND);
			return response.close();
		}
	}
}
