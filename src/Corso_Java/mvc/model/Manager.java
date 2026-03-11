package Corso_Java.mvc.model;

import Corso_Java.mvc.Enumerazioni.Ruolo;

public class Manager extends Dipendente{
    double bonus;
    private Ruolo tipoRuolo;


    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Ruolo getTipoRuolo() {
        return tipoRuolo;
    }

    public void setTipoRuolo(Ruolo tipoRuolo) {
        this.tipoRuolo = tipoRuolo;
    }

    @Override
    public String toString() {
        return  super.toString() + " bonus: " + bonus + " ruolo ricoperto: " + tipoRuolo.toString();
    }
}
