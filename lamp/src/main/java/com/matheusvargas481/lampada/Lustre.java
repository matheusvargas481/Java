package com.matheussoilegra.coreengineering.tema5;

public class Lustre {

    LampadaCenario lampadaAtual;

    Lustre(LampadaCenario led){

        this.lampadaAtual = led;
    }

    public void acionarSwitch(){

        if(lampadaAtual.isOn()){
            lampadaAtual.off();

        }else{
            lampadaAtual.on();
        }
    }

}

