package com.matheusvargas481.cloudnative.rest.veiculos;

public class Onibus implements Veiculo {
    private final Double precoPedagio = 1.59;

    @Override
    public Double pagar(Double pagamento) { return pagamento - this.precoPedagio; }

    @Override
    public String toString() { return "Onibus: R$" + this.precoPedagio; }

    public String getTipoVeiculo() {
        return this.getClass().getSimpleName();
    }

    public Double getPrecoPedagio() {
        return precoPedagio;
    }
}
