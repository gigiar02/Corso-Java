package Corso_Java.mvc.model;

import Corso_Java.mvc.utils.Utils;

import java.time.LocalDate;
import java.util.Objects;

public class Dipendente extends Persona {
    double salary;
    LocalDate hiringData;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHiringData() {
        return hiringData;
    }

    public void setHiringData(LocalDate hiringData) {
        this.hiringData = hiringData;
    }

    @Override
    public String toString() {
        return super.toString() + " Stipendio: " + salary + " Data di assunzione: " + Utils.formatter(hiringData);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dipendente that = (Dipendente) o;
        return super.equals(o) && Double.compare(getSalary(), that.getSalary()) == 0 && Objects.equals(getHiringData(), that.getHiringData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSalary(), getHiringData());
    }
}
