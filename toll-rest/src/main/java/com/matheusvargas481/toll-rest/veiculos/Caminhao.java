package com.matheusvargas481.cloudnative.rest.veiculos;

public class Caminhao implements Veiculo {
    private final Double precoPedagio = 3.95;

    @Override
    public Double pagar(Double pagamento) { return pagamento-precoPedagio; }

    @Override
    public String toString() { return "Caminhao: R$"+precoPedagio+" mais valor adicional por eixo"; }

    public String getTipoVeiculo() {
        return this.getClass().getSimpleName();
    }

    public Double getPrecoPedagio() {
        return precoPedagio;
    }
}
