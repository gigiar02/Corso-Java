package Corso_Java.mvc.view;

import Corso_Java.mvc.Enumerazioni.Role;
import Corso_Java.mvc.Enumerazioni.Entities;
import Corso_Java.mvc.exception.EtaException;
import Corso_Java.mvc.exception.RegexStringException;
import Corso_Java.mvc.model.Dipendente;
import Corso_Java.mvc.model.Manager;
import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static Corso_Java.mvc.Enumerazioni.Entities.*;
import static Corso_Java.mvc.Enumerazioni.Role.*;
import static Corso_Java.mvc.utils.Constants.Regex.stringRegex;
import static Corso_Java.mvc.utils.Utils.*;

public class View {
    private Scanner scanner = new Scanner(System.in);


    //Legge una stringa e la restituisce
    public String readString(String s)
    {
        System.out.println(s);
        return scanner.nextLine();
    }


    /*
       Controlla che la stringa "s" ricevuta in input rispetti la regex. Se non la rispetta lancia un'eccezione.
     */

    //Legge una stringa e verifica che rispetti la regex. Se la rispetta è restituita la stringa altrimenti viene lanciata un'eccezione
    public String readStringRegex(String regola) throws RegexStringException {
        String regex = stringRegex;
        String s = "";

        System.out.println(regola);
        s =  scanner.nextLine().trim();

        return StringMatch(regex,s);
    }


    //Restiuisce la data formattata
    public LocalDate dataFormatter(String data) {
        //Formattazione della data
        DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd-MM-yyyy",Locale.ITALIAN);
        LocalDate dataDiNascita =  LocalDate.parse(data,dataFormattata);

        return dataDiNascita;
    }


    //Legge la data di nascita inserita dall'utente e la restituisce formattata gg-mm-yyyy
    public LocalDate readDataDiNascita(String s) throws EtaException {
        String lettura = readString(s);

        //Controllo correttezza
        LocalDate data = dataFormatter(lettura);
        if(!Utils.checkDataDiNascita(data)){
            throw new EtaException("La data di nascita inserita non è valida!");
        }

        return data;
    }

    //Legge la data di assunzione
    public LocalDate readDataDiAssunzione(String s,LocalDate dataDiNascita) throws EtaException {
        String lettura = readString(s);
        LocalDate dataDiAssunzione = dataFormatter(lettura);

        //Controllo correttezza
        if(!Utils.checkDataDiAssunzione(dataDiAssunzione,dataDiNascita)){
            throw new EtaException("La data di assunzione inserita non è valida!");
        }

        return dataDiAssunzione;
    }


    //Legge un intero e lo restituisce
    public int readInteger(String s)
    {
       System.out.println(s);
       return Integer.parseInt(scanner.nextLine());
    }

    public double readDouble(String s)
    {
        System.out.println(s);
        return Double.parseDouble(scanner.nextLine());
    }


    //Inizializza il form di Persona
    public void initForm(Persona p) throws RegexStringException, EtaException {
        p.setName(readStringRegex("Insert the name"));
        p.setSurname(readStringRegex("Insert the surname"));
        p.setBirthday(readDataDiNascita("Insert the data di nascita: dd--MM-yyyy"));
        p.setFiscalCode(readStringRegex("Insert the codiceFiscale"));

        if(p instanceof Manager)
        {
            Manager m = (Manager) p;
            m.setSalary(readDouble("Inserisci lo stipendio"));
            m.setBonus(readDouble("Inserisci il bonus del Manager"));
            m.setHiringData(readDataDiAssunzione("Inserisci la data di assunzione",p.getBirthday()));
            m.setRoleType(roleManagerMenu("Inserisci il tipo di ruolo ricoperto "));
        }else if(p instanceof Dipendente)
        {
            Dipendente d = (Dipendente) p;
            d.setHiringData(readDataDiAssunzione("Inserisci la data di assunzione",p.getBirthday()));
            d.setSalary(readDouble("Inserisci lo stipendio"));
        }
    }


    //Stampa qualsiasi tipo
    public <E> void print(E s) {
        System.out.println(s);
    }


    public int menu(String s)
    {
        System.out.println("0 - ESCI");
        System.out.println("1 - Inserisci un' entità");
        System.out.println("2 - Visualizza tutte le entità");
        System.out.println("3 - Ricerca un' entità fornendo il suo codice fiscale");
        System.out.println("4 - Elimina un' entità fornendo il suo codice fiscale");
        System.out.println("5 - Effettua una modifica");

        return readInteger(s);
    }


    public Entities menuInserimento(String s)
    {
        System.out.println("PERSONA");
        System.out.println("DIPENDENTE");
        System.out.println("MANAGER");

        return switch (readString(s).toUpperCase()) {
            case "PERSONA" -> PERSONA;
            case "DIPENDENTE" -> DIPENDENTE;
            case "MANAGER" -> MANAGER;
            default -> NONVALIDO;
        };
    }

    public Role roleManagerMenu(String s)
    {
        System.out.println(PROJECT_MANAGER);
        System.out.println(TEAM_LEADER);
        System.out.println(TOP_MANAGER);

        return switch (readString(s).toUpperCase()) {
            case "PROJECT_MANAGER" -> PROJECT_MANAGER;
            case "TEAM_LEADER" -> TEAM_LEADER;
            case "TOP_MANAGER" -> TOP_MANAGER;
            default -> RUOLONONVALIDO;
        };
    }


    public void printAll(HashMap<Integer,Persona> entity)
    {
        if(entity.isEmpty())
        {
            System.out.println("Lista vuota");
            return;
        }
        for(Map.Entry<Integer,Persona> e : entity.entrySet())
        {

            System.out.println(Utils.getTypeOfEntity(e.getValue()) + " " +  e.getValue());
        }
    }


    /*
        Permette all'utente di modificare una qualsiasi entità.
        Le modifiche sono diverse in base al tipo di persona passato
        Per non modificare un campo l'utente preme invio. -> (field.isEmpty())
     */
    //TODO:MODIFICARE TUTTO
    public Persona formUpdate(Persona p,Persona newP) throws RegexStringException, EtaException {
        String field;
        LocalDate data;
        //Modifica Nome
        field = readString(" name: [ " + p.getName() + " ] ");
        newP.setName(field.isEmpty() ? p.getName() : StringMatch(stringRegex,field)); //Se il campo inserito dall' utente è vuoto -> mantengo il campo vecchio. Altrimenti sovrascrivo con il campo inserito

        //Modifica cognome
        field = readString(" surname: [ " + p.getSurname() + " ] ");
        newP.setSurname(field.isEmpty() ? p.getSurname() : StringMatch(stringRegex,field));

        //Modifica data di nascita
        field = readString(" birthday: [ " + Utils.formatter(p.getBirthday()) + " ] ");
        newP.setBirthday(field.isEmpty() ? p.getBirthday() : dataFormatter(field));

        //Modifica codice fiscale
        field = readString(" fiscal code: [ " + p.getFiscalCode() + " ] ");
        newP.setFiscalCode(field.isEmpty() ? p.getFiscalCode() : StringMatch(stringRegex,field));

        //Verifico il tipo di entità
        switch (Utils.getTypeOfEntity(newP))
        {
            case "MANAGER":
                print("Sezione Manager");
                //newM -> nuovo manager m -> vecchio manager
                Manager newM = (Manager) newP;
                Manager m = (Manager) p;

                //Modifica stipendio
                field = readString(" salary: [ " + m.getSalary() + " ] ");
                newM.setSalary(field.isEmpty() ? m.getSalary() : Double.parseDouble(field));

                //Modifica bonus
                field = readString(" bonus: [ " + m.getBonus() + " ] ");
                newM.setBonus(field.isEmpty() ? m.getBonus() : Double.parseDouble(field));

                //Modifica data di assunzione
                field = readString(" day of hiring: [ " + Utils.formatter(m.getHiringData()) + " ] ");
                //Assegnazione di data
                if(field.isEmpty()){data = m.getHiringData();}
                else{
                    data = dataFormatter(field);
                }
                //In qualsiasi caso devo verificare che la modifica sia corretta
                if(!checkDataDiAssunzione(data,newM.getBirthday())){ throw new EtaException("La data di assunzione inserita: " + data + " non è coerente con la data di nascita: " + newM.getBirthday());}
                newM.setHiringData(data);

                //Modifica Ruolo
                field = readString(" role type [ " + m.getRoleType() + " ] ");
                newM.setRoleType(field.isEmpty() ? m.getRoleType() : getRuolo(field));
                break;

            case "DIPENDENTE":
                print("Sezione Dipendente");
                //newD -> nuovo dipendente d -> vecchio dipendente
                Dipendente newD = (Manager) newP;
                Dipendente d = (Manager) p;

                //Modifica stipendio
                field = readString(" salary: [ " + d.getSalary() + " ] ");
                newD.setSalary(field.isEmpty() ? d.getSalary() : Double.parseDouble(field));

                //Modifica data di assunzione
                field = readString(" day of hiring: [ " + Utils.formatter(d.getHiringData()) + " ] ");
                //Assegnazione di data
                if(field.isEmpty()){data = d.getHiringData();}
                else{
                    data = dataFormatter(field);
                }
                //In qualsiasi caso devo verificare che la modifica sia corretta
                if(!checkDataDiAssunzione(data,newD.getBirthday())){ throw new EtaException("La data di assunzione inserita: " + data + " non è coerente con la data di nascita: " + newD.getBirthday());}
                newD.setHiringData(data);
                break;

        }

        //L'utente è sicuro di voler modificare l'entità?
        if(readString("Sicuro di voler rendere permanenti le modifiche? s/n").equals("s"))
        {
            return newP;
        }


        return null;
    }
}
