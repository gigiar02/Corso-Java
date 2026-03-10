package Corso_Java.mvc.utils;

import Corso_Java.mvc.exception.EtaException;
import Corso_Java.mvc.model.Persona;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static int calcolaEta(LocalDate dataDiNascita) {
        LocalDate dataAttuale = LocalDate.now();
        int eta = Period.between(dataDiNascita,dataAttuale).getYears();

        return Period.between(dataDiNascita,dataAttuale).getYears();
    }

    public static String formatter(LocalDate data)
    {
        DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ITALIAN);
        return data.format(dataFormattata);
    }
}
