package com.matheusvargas481.cloudnative.rest;

import com.matheusvargas481.cloudnative.rest.dto.PedagioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/")
public class PedagioController extends Application {
    @Autowired
    private Pedagio pedagio;

    @GET
    @Path("/tabela")
    @Produces("application/json")
    public Response tabelaDePrecos() {
        return Response.ok(pedagio.tabelaDeTaxas()).build();
    }

    @GET
    @Produces("application/json")
    public Response pagarPedagio(@RequestBody PedagioDTO pedagioDTO) {
        return Response.ok(pedagio.pagarPedagio(pedagioDTO)).build();
    }
}