package Corso_Java.mvc.view;

import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.service.PersonaService;

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
        return Integer.parseInt(scanner.nextLine());
    }

    public void initForm(Persona p)
    {
        p.setName(readString("Insert the name"));
        p.setSurname(readString("Insert the surname"));
        p.setAge(readInteger("Insert the age"));

        System.out.println(p);
    }

    public void print(String s) {
        System.out.println(s);
    }

    public int menu(String s)
    {
        System.out.println("0 - ESCI");
        System.out.println("1 - Inserisci una persona");
        System.out.println("2 - Visualizza tutte le persone");

        return readInteger(s);
    }

    public void printAll(ArrayList<Persona> persone)
    {
        for(Persona p : persone)
        {
            System.out.println(p);
        }
    }
}
