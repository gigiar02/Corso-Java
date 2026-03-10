package Corso_Java.mvc.model;

public class Persona {
    private String name;
    private String surname;
    private String codiceFiscale;
    private int age;

    public Persona(){}

    public Persona(String name, String surname, String codiceFiscale, int age) {
        this.name = name;
        this.surname = surname;
        this.codiceFiscale = codiceFiscale;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCodiceFiscale(){return codiceFiscale;}

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public String toString() {
        return " name = " + name + " surname = " + surname + " age = " + age + "codice fiscale: " + codiceFiscale;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
