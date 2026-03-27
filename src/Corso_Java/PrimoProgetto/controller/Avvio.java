package Corso_Java.PrimoProgetto.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Corso_Java.PrimoProgetto.exceptions.DateException;
import Corso_Java.PrimoProgetto.exceptions.RegexStringException;
import Corso_Java.PrimoProgetto.model.Persona;
import Corso_Java.PrimoProgetto.service.ServiceCrud;
import Corso_Java.PrimoProgetto.utils.Connessione;
import Corso_Java.PrimoProgetto.view.View;

public class Avvio {

	public static void main(String[] args) throws SQLException, RegexStringException, DateException {

		boolean flag=true;
		View v=new View();
		Persona p;
		ServiceCrud service=new ServiceCrud();
		List<Persona> list=null;

		do {
			switch (v.menu()) {
				case 1:
					//Inserimento
					try {
					p=new Persona();
					v.formInit(p);
					if(service.insert(p)>0)
						v.msg("Inserimento OK");
					else
						v.msg("Errore nell'inserimento");

					} catch (RegexStringException | DateException e) {

						v.msg("Inserimento non avvenuto!"+e.getMessage());
					}

					break;

				case 2:
					//Stampa tutto select *

						v.printAll(service.selectAll());

					break;

				case 3:

					//L'utente sceglie come vuole ricercare
					p = v.menuTipoDiRicerca(service);
					//Verifica se la ricerca è andata a buon fine
					if(p == null){v.msg("Ricerca non andata a buon fine"); break;}
					v.print(p);
					break;

				case 4:
					p = v.menuTipoDiRicerca(service);
					if(p == null){v.msg("Ricerca non andata a buon fine"); break;}
					if(v.leggiString("Sicuro di voler eliminare la persona? s/n" + p).equals("s"))
					{
						service.delete(p);
					}
					//Elimina
					break;

				case 5:
					//Modifica
					p = null;
					Persona pNew = new Persona();

					p = v.menuTipoDiRicerca(service);
					if(p == null){v.msg("ricerca non andata a buon fine");}
					v.formInit(pNew);
					service.update(p,pNew);
					break;
				case 0:
					//ESCI
					flag=false;
					break;


				default:
					v.msg("Scelta non valida");
					break;
				}


		} while (flag);








	}

}
