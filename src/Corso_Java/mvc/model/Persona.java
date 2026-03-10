package Corso_Java.mvc.model;

import Corso_Java.mvc.utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Persona {
    private String name;
    private String surname;
    private String codiceFiscale;
    private LocalDate dataDiNascita;

    public Persona(){}

    public Persona(String name, String surname, String codiceFiscale,LocalDate dataDiNascita) {
        this.name = name;
        this.surname = surname;
        this.codiceFiscale = codiceFiscale;
        this.dataDiNascita = dataDiNascita;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    @Override
    public String toString() {
        return " name = " + name + " surname = " + surname +  "codice fiscale: " + codiceFiscale + " data di nascita: " + Utils.formatter(dataDiNascita) + " età: " + Utils.calcolaEta(dataDiNascita);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(getName(), persona.getName()) && Objects.equals(getSurname(), persona.getSurname()) && Objects.equals(getCodiceFiscale(), persona.getCodiceFiscale()) && Objects.equals(getDataDiNascita(), persona.getDataDiNascita());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getCodiceFiscale(), getDataDiNascita());
    }
}
