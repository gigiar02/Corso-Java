package Corso_Java.mvc.controller;

import Corso_Java.mvc.exception.EntityException;
import Corso_Java.mvc.exception.EtaException;
import Corso_Java.mvc.exception.RegexStringException;
import Corso_Java.mvc.utils.MakeEntity;
import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.service.Service;
import Corso_Java.mvc.view.View;

import java.time.format.DateTimeParseException;

public class Run {

     static void main() {
         Service serv = new Service();
         View view = new View();
         Persona p;

        while (true)
        {
            try {
                switch (view.menu("Scegli un'operazione")) {
                    //Esci
                    case 0:
                        return;

                    //Inserisci un' entità
                    case 1:
                        String msg = "";

                        //Viene avviato un menu attraverso il quale l'utente può scegliere il tipo di entità da aggiungere
                        //GetEntity restituisce il tipo di entità scelto
                        p = MakeEntity.GetEntity(view.menuInserimento("Inserisci il tipo di entità che vuoi aggiungere"));
                        if(p == null){throw new EntityException("Tipo di entità non valido");}

                        //L'utente deve riempire i campi dell'entità scelta
                        view.initForm(p);

                        //Verifica risultato operazione di inserimento
                        msg = serv.insert(p) ? "Persona inserita" : "Persona non inserita";
                        view.print(msg);
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
                        p = serv.search(view.readString("Inserisci il codice fiscale"));

                        if (p == null) {
                            view.print("Persona non esistente ");
                            break;
                        }
                        if (view.readString("Sicuro di voler eliminare la persona? s/n").equals("s")) {
                            serv.delete(p);
                            view.print("Persona eliminata " + p);
                        } else {
                            view.print("Operazione annullata!");
                        }
                        break;

                    //Modifica
                    case 5:
                        //Ricerco l' entità
                        p = serv.search(view.readString("Inserisci il codice fiscale dell' entità da modificare"));
                        if (p == null) {
                            view.print("Entità non trovata");
                            break;
                        }

                        //Form update riceve la vecchia copia di entità e quella nuova. Restituisce la nuova copia o null
                        Persona newP = MakeEntity.GetEntity(p);
                        newP = view.formUpdate(p, newP);

                        //formUpdate restiuisce null se l'utente annulla la modifica della persona
                        if (newP == null) {
                            view.print("Modifica annullata!");
                            break;
                        }
                        //Il metodo equals confronta due persone per vedere se sono identiche
                        if (newP.equals(p)) {
                            view.print("Nessun campo è stato modificato");
                            break;
                        }

                        //Effettua l'update in modo definitivo se gli altri controlli sono veri
                        String result = serv.update(p, newP) ? "Update andato a buon fine" : "Update non andato a buon fine";
                        view.print(result);
                        break;


                    default:
                        view.print("Scelta non valida");
                }
            }catch (NumberFormatException | RegexStringException | EtaException | EntityException E)
            {
                view.print("Errore: " + E.getMessage());
            }catch (DateTimeParseException E)
            {
                view.print("La data inserita non è corretta " + E.getMessage());
            }catch (Exception E)
            {
                view.print("Eccezione di altro tipo: " + E.getMessage());
            }
     }

}
}