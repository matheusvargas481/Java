package com.matheusvargas481.cloudnative.rest.veiculos;

public class Moto implements Veiculo {
    private final Double precoPedagio = 1D;

    @Override
    public Double pagar(Double pagamento) { return pagamento - this.precoPedagio; }

    @Override
    public String toString() { return "Moto: R$" + this.precoPedagio; }

    public String getTipoVeiculo() {
        return this.getClass().getSimpleName();
    }

    public Double getPrecoPedagio() {
        return precoPedagio;
    }
}
