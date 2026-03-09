package Corso_Java.mvc.controller;

import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.service.PersonaService;
import Corso_Java.mvc.view.View;

public class Run {

     static void main() {
        PersonaService serv = new PersonaService();
        View view = new View();

        while (true)
        {
            switch (view.menu("Scegli un'operazione"))
            {
                //Esci
                case 0:
                    return;

                //Inserisci una persona
                case 1:
                    Persona p = new Persona();
                    view.initForm(p);
                    view.print(serv.insert(p) ? "Persona inserita" + p:"Persona non inserita");
                    break;

                //Visualizza tutte le persone inserite
                case 2:
                    view.printAll(serv.getAll());
                    break;

                default:
                    view.print("Scelta non valida");



            }
        }
    }
}
