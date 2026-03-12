package Corso_Java.mvc.model;

import Corso_Java.mvc.utils.Utils;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
    private String name;
    private String surname;
    private String fiscalCode;
    private LocalDate birthday;
    private static int  GlobalID;
    private int id;

    public Persona(){
        id = GlobalID++;
    }

    public Persona(String name, String surname, String fiscalCode, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.birthday = birthday;
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

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return " ID = " + getID() + " name: " + name + " surname: " + surname +  " codice fiscale: " + fiscalCode + " data di nascita: " + Utils.formatter(birthday) + " età: " + Utils.getAge(birthday);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(getName(), persona.getName()) && Objects.equals(getSurname(), persona.getSurname()) && Objects.equals(getFiscalCode(), persona.getFiscalCode()) && Objects.equals(getBirthday(), persona.getBirthday());
    }



    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getFiscalCode(), getBirthday());
    }

    public int getID() {
        return id;
    }
}
