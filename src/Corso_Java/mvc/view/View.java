package Corso_Java.mvc.view;

import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.service.PersonaService;

import javax.xml.transform.Templates;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);


    public String readString(String s)
    {
        System.out.println(s);
        return scanner.nextLine();
    }

    public int readInteger(String s)
    {
        System.out.println(s);
        boolean flag = false;
        int val = 0;

        do {
            try {
                val = Integer.parseInt(scanner.nextLine());
                flag = false;
            }catch (NumberFormatException e)
            {
                System.out.println(e.getMessage() + "Devi inserire un numero valido");
                System.out.println("Fai una scelta!");
                flag = true;
            }

        }while (flag);
        return val;
    }

    public void initForm(Persona p)
    {
        p.setName(readString("Insert the name"));
        p.setSurname(readString("Insert the surname"));
        p.setAge(readInteger("Insert the age"));
        p.setCodiceFiscale(readString("Inster the codiceFiscale"));

        System.out.println(p);
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

    public Persona formUpdate(Persona p,Persona newP) {
        //Preparazione dati
        String[] label = new String[]{"name ","surname","codice fiscale","age"};
        String[] data = new String[]{p.getName(),p.getSurname(),p.getCodiceFiscale(),Integer.toString(p.getAge())};

        int s = 0;

        //Scorro i dati
        for(String d : data)
        {
            //Se l'utente preme invio non modifica il dato
            String h = this.readString(label[s] + ": " +  "[" + d + "]");
            //Se ha apportato almeno una modifica allora sarà effettuata
            if(!h.isEmpty()){data[s] = h;}
            s+=1;
        }

        //Se almeno una tupla è stata modificata salva tutto
        if(this.readString("Sicuro di voler apportare la modifica? s/n").equals("s")){
            //Costruisco il nuovo oggetto da sostituire
            newP = new Persona(data[0],data[1],data[2],Integer.parseInt(data[3]));
            //Effettuo una ricerca sulla persona p che me ne restituisce l'indice
            return newP;
        }
        return null;
    }
}
