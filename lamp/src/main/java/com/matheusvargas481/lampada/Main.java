package com.matheussoilegra.coreengineering.tema5;

public class Main {

    public static void main(String args[]) {

        Fluorescente fluorescente = new Fluorescente();
        Led led = new Led();
        Lustre lustreFluorescente = new Lustre(fluorescente);
        Lustre lustreLed= new Lustre(led);

    }
}
