package model;

import model.Obra;

public class Pintura extends Obra {

    private String tecnica;

    public Pintura() {
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
}
