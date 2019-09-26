package br.edu.ifsul.casa_automatizada.model;

public class Dormitorio {
    private Boolean lampada;
    private Boolean hvac;

    public Dormitorio() {
    }

    public Boolean getLampada() {
        return lampada;
    }

    public void setLampada(Boolean lampada) {
        this.lampada = lampada;
    }

    public Boolean getHvac() {
        return hvac;
    }

    public void setHvac(Boolean hvac) {
        this.hvac = hvac;
    }
}
