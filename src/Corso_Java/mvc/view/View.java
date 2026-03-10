package Corso_Java.mvc.view;

import Corso_Java.mvc.exception.EtaException;
import Corso_Java.mvc.exception.RegexStringException;
import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.service.PersonaService;
import Corso_Java.mvc.utils.Constants;
import Corso_Java.mvc.utils.Utils;
import Corso_Java.mvc.utils.Constants.Regex;

import javax.xml.transform.Templates;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

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
    public boolean StringMatch(String regex,String s) throws RegexStringException {
        if(!s.matches(regex))
        {
            throw new RegexStringException("La stringa deve contenere da 3 a 16 caratteri");
        }

        return true;
    }


    //Legge una stringa e verifica che rispetti. Se la rispetta è restituita la stringa altrimenti viene lanciata un'eccezione
    public String readStringRegex(String regola) throws RegexStringException {
        String regex = Regex.stringRegex;
        String s = "";

        System.out.println(regola);
        s =  scanner.nextLine().trim();

        if (StringMatch(regex,s)) {
            return s;
        }
        return "";
    }


    //Restiuisce la data formattata e lancia un'eccezione se la data inserita non ha senso in relazione a quella attuale
    public LocalDate dataFormatter(String data) throws EtaException {
        //Formattazione della data
        DateTimeFormatter dataFormattata = DateTimeFormatter.ofPattern("dd-MM-yyyy",Locale.ITALIAN);
        LocalDate dataDiNascita =  LocalDate.parse(data,dataFormattata);

        //Controllo correttezza
        if(Utils.calcolaEta(dataDiNascita) < 18 || Utils.calcolaEta(dataDiNascita) >= 100){
            throw new EtaException("Data non valida");
        }

        return dataDiNascita;
    }


    //Legge la data di nascita inserita dall'utente e la restituisce formattata gg-mm-yyyy
    public LocalDate readDataDiNascita(String s) throws EtaException {
        String lettura = readString(s);
        return dataFormatter(lettura);
    }


    //Legge un intero e lo restituisce
    public int readInteger(String s)
    {
       System.out.println(s);
       return Integer.parseInt(scanner.nextLine());
    }


    //Inizializza il form di Persona
    public void initForm(Persona p) throws RegexStringException, EtaException {
        p.setName(readStringRegex("Insert the name"));
        p.setSurname(readStringRegex("Insert the surname"));
        p.setDataDiNascita(readDataDiNascita("Insert the data di nascita: dd--MM-yyyy"));
        p.setCodiceFiscale(readStringRegex("Insert the codiceFiscale"));
    }


    //Stampa qualsiasi tipo
    public <E> void print(E s) {
        System.out.println(s);
    }


    public int menu(String s)
    {
        System.out.println("0 - ESCI");
        System.out.println("1 - Inserisci una persona");
        System.out.println("2 - Visualizza tutte le persone");
        System.out.println("3 - Ricerca una persona fornendo il suo codice fiscale");
        System.out.println("4 - Elimina una persona fornendo il suo codice fiscale");
        System.out.println("5 - Effettua una modifica");

        return readInteger(s);
    }


    public void printAll(ArrayList<Persona> persone)
    {
        if(persone.isEmpty())
        {
            System.out.println("Lista vuota");
            return;
        }
        for(Persona p : persone)
        {
            System.out.println(p);
        }
    }


    //Permette all'utente di modificare uno piu campi della persona "p" restiuendo la nuova persona modificata "newP"
    public Persona formUpdate(Persona p,Persona newP) throws RegexStringException, EtaException {
        //Preparazione dati
        String[] label = new String[]{"name ","surname","codice fiscale","data di nascita"};
        String[] data = new String[]{p.getName(),p.getSurname(), p.getCodiceFiscale()};
        LocalDate dataDiNascita = p.getDataDiNascita();

        int s = 0;

        //Scorro i dati
        for(Object d : data)
        {
            //L'utente inserisce la modifica
            String h = this.readString(label[s] + ": " +  "[" + d + "]");
            //Se la modifica inserita non è vuota allora il campo viene modificato
            if(!h.isEmpty() && StringMatch("^[a-zA-Z0-9]{3,16}$",h)){
                data[s] = h;
            }

            //Passo al dato successivo
            s+=1;
        }

        //data di nascita
        String h = this.readString(label[3] + ": " +  "[" + Utils.formatter(dataDiNascita) + "]");
        if(!h.isEmpty()){
            dataDiNascita = dataFormatter(h);
        }

        //L'utente può decidere di non rendere le modifiche permanenti
        if(this.readString("Sicuro di voler apportare la modifica? s/n").equals("s")){
            //Costruisco il nuovo oggetto da sostituire
            newP = new Persona((String) data[0],(String)data[1],(String) data[2],dataDiNascita);
            //Effettuo una ricerca sulla persona p che me ne restituisce l'indice
            return newP;
        }
        return null;
    }
}
