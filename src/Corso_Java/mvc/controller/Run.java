package Corso_Java.mvc.controller;

import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.service.PersonaService;
import Corso_Java.mvc.view.View;

import java.util.ArrayList;

public class Run {

     static void main() {
        PersonaService serv = new PersonaService();
        View view = new View();
        Persona p;

        while (true)
        {
            switch (view.menu("Scegli un'operazione"))
            {
                //Esci
                case 0:
                    return;

                //Inserisci una persona
                case 1:
                     p = new Persona();
                    view.initForm(p);
                    view.print(serv.insert(p) ? "Persona inserita" + p:"Persona non inserita");
                    break;

                //Visualizza tutte le persone inserite
                case 2:
                    view.printAll(serv.getAll());
                    break;

                //Ricerca una persona attraverso il codice fiscale
                case 3:
                    p = serv.search(view.readString("Inserisci il codice fiscale da ricercare"));
                    view.print(p != null ? "Persona trovata: " + p : " Persona non trovata");
                    break;

                //Elimina una persona attraverso il suo codice fiscaele
                case 4:
                      p = serv.search(view.readString("Inserisci il codice fiscale da leggere"));

                      if(p == null){view.print("Persona non esistente "); break;}
                      if(view.readString("Sicuro di voler eliminare la persona? s/n").equals("s")){
                          serv.delete(p);
                          view.print("Persona eliminata " + p);
                      }else
                      {
                          view.print("Operazione annullata!");
                      }
                     break;

                //Modifica
                case 5:
                    //Ricerco la persona
                    p = serv.search(view.readString("Inserisci il codice fiscale della persona da modificare"));
                    if(p == null){view.print("Persona non trovata"); break;}

                    Persona newP = new Persona();
                    newP = view.formUpdate(p,newP);

                    if(newP == null){view.print("Modifica annullata!"); break;}
                    if(newP.equals(p)){view.print("Nessun campo è stato modificato"); break;}

                    serv.update(p,newP);

                    break;






                default:
                    view.print("Scelta non valida");
            }
        }
    }
}
