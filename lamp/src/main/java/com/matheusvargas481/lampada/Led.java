package com.matheussoilegra.coreengineering.tema5;

public class Led implements LampadaCenario {

    private boolean state;

    public Led() {
        this.state = false;
    }

    @Override
    public  boolean isOn(){
        return state;
    }

    @Override
    public void on() {
        state = true;
        System.out.println("Led acesa");
    }

    @Override
    public void off() {
        state = false;
        System.out.println("Led apagada");
    }
}
