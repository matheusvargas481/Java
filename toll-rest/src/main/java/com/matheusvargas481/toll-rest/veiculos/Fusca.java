package com.matheusvargas481.cloudnative.rest.veiculos;

public class Fusca implements Veiculo {
    private final Double precoPedagio = 2.11;

    @Override
    public Double pagar(Double pagamento) {
        return pagamento-this.precoPedagio;
    }

    @Override
    public String toString() { return "Fusca: R$"+ this.precoPedagio; }

    public String getTipoVeiculo() { return this.getClass().getSimpleName(); }

    public Double getPrecoPedagio() { return precoPedagio; }
}
