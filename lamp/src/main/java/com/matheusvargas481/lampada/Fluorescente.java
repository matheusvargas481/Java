package com.matheussoilegra.coreengineering.tema5;

public class Fluorescente implements LampadaCenario {

    private boolean state;

    public Fluorescente() {
        this.state = false;
    }

    @Override
    public  boolean isOn(){
        return state;
    }

    @Override
    public void on() {
        state = true;
        System.out.println("Fluorescente acesa");
    }

    @Override
    public void off() {
        state = false;
        System.out.println("Fluorescente apagada");
    }
}


