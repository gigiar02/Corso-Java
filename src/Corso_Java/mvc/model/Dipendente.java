package Corso_Java.mvc.model;

import java.time.LocalDate;

public class Dipendente extends Persona {
    double stipendio;
    LocalDate dataDiAssunzione;

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public LocalDate getDataDiAssunzione() {
        return dataDiAssunzione;
    }

    public void setDataDiAssunzione(LocalDate dataDiAssunzione) {
        this.dataDiAssunzione = dataDiAssunzione;
    }

    @Override
    public String toString() {
        return super.toString() + "Stipendio: " + stipendio + "Data di assunzione: " + dataDiAssunzione;
    }
}
