package com.matheusvargas481.cloudnative.rest.veiculos;

public class Bicicleta implements Veiculo {
    private final Double precoPedagio = 0.49;

    @Override
    public Double pagar(Double pagamento) {
        return pagamento-this.precoPedagio;
    }

    @Override
    public String toString() { return "Bicicleta: R$"+ this.precoPedagio; }


    public String getTipoVeiculo() { return this.getClass().getSimpleName(); }

    public Double getPrecoPedagio() {
        return precoPedagio;
    }
}
