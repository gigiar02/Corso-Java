package Corso_Java.mvc.utils;

import Corso_Java.mvc.Enumerazioni.Ruolo;
import Corso_Java.mvc.exception.EtaException;
import Corso_Java.mvc.model.Dipendente;
import Corso_Java.mvc.model.Manager;
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

    public static Ruolo getRuolo(String ruolo)
    {
        switch (ruolo.toUpperCase()){
            case "PROJECT MANAGER": return Ruolo.PROJECT_MANAGER;
            case "TEAM LEADER": return Ruolo.TEAM_LEADER;
            case "TOP MANAGER": return Ruolo.TOP_MENAGER;
            default: return Ruolo.NONVALIDO;
        }
    }


    //Data una persona p in input restituisce il tipo di persona
    public static String getTypeOfEntity(Persona p)
    {
        if(p instanceof Manager){return "MANAGER";}
        if(p instanceof Dipendente){return "DIPENDENTE";}
        return "PERSONA";

    }
}
