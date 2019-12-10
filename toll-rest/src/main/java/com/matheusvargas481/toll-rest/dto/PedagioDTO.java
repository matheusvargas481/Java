package com.matheusvargas481.cloudnative.rest.dto;

public class PedagioDTO {
    private final Double precoPorEixo = 25D;
    private String tipoDeVeiculo;
    private Double pagamento;
    private int eixo;

    public Double getPrecoPorEixo() {
        return precoPorEixo;
    }

    public String getTipoDeVeiculo() {
        return tipoDeVeiculo;
    }

    public void setTipoDeVeiculo(String tipoDeVeiculo) {
        this.tipoDeVeiculo = tipoDeVeiculo;
    }

    public Double getPagamento() {
        return pagamento;
    }

    public void setPagamento(Double pagamento) {
        this.pagamento = pagamento;
    }

    public int getEixo() {
        return eixo;
    }

    public void setEixo(int eixo) {
        this.eixo = eixo;
    }
}
