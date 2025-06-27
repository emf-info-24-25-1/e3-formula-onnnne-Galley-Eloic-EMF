package app.models;

import java.text.DecimalFormat;

public class Voiture {

    private int numero;
    private String nomEquipe;

    public Voiture(int numero, String nomEquipe) {
        this.numero = numero;
        this.nomEquipe = nomEquipe;
    }

    public int getNumero() {
        return numero;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    @Override
    public String toString(){
       
        return "Voiture N°0" + numero + " de l'équipe '" + nomEquipe + "'";
    }

    
}
