package Corso_Java.mvc.utils;

import Corso_Java.mvc.Enumerazioni.Role;
import Corso_Java.mvc.exception.RegexStringException;
import Corso_Java.mvc.model.Dipendente;
import Corso_Java.mvc.model.Manager;
import Corso_Java.mvc.model.Persona;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static Corso_Java.mvc.Enumerazioni.Role.RUOLONONVALIDO;

public class Utils {


    public static boolean checkDataDiNascita(LocalDate dataDiNascita) {
        return Period.between(dataDiNascita,LocalDate.now()).getYears() >= 18 && !dataDiNascita.isAfter(LocalDate.now());
    }

    public static boolean checkDataDiAssunzione(LocalDate dataDiAssunzione,LocalDate dataDiNascita)
    {
        return !dataDiAssunzione.isBefore(dataDiNascita) && Period.between(dataDiNascita,dataDiAssunzione).getYears() >= 18 && !dataDiAssunzione.isAfter(LocalDate.now());
    }

    public static int getAge(LocalDate dataDiNascita)
    {
        return Period.between(dataDiNascita,LocalDate.now()).getYears();
    }



    public static String formatter(LocalDate data)
    {
        DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ITALIAN);
        return data.format(dataFormattata);
    }

    public static Role getRuolo(String ruolo)
    {
        switch (ruolo.toUpperCase()){
            case "PROJECT MANAGER": return Role.PROJECT_MANAGER;
            case "TEAM LEADER": return Role.TEAM_LEADER;
            case "TOP MANAGER": return Role.TOP_MANAGER;
            default: return RUOLONONVALIDO;
        }
    }


    //Data una persona p in input restituisce il tipo di persona
    public static String getTypeOfEntity(Persona p)
    {
        if(p instanceof Manager){return "MANAGER";}
        if(p instanceof Dipendente){return "DIPENDENTE";}
        return "PERSONA";

    }


    //Verifica che una stringa rispetti una regex. Lancia un'eccezione se non lo fa, altrimenti restiuisce la stringa
    public static String StringMatch(String regex,String s) throws RegexStringException {
        if(!s.matches(regex))
        {
            throw new RegexStringException("La stringa deve contenere da 3 a 16 caratteri");
        }

        return s;
    }
}
