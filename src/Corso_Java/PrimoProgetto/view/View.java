package Corso_Java.PrimoProgetto.view;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import Corso_Java.PrimoProgetto.exceptions.DateException;
import Corso_Java.PrimoProgetto.exceptions.RegexStringException;
import Corso_Java.PrimoProgetto.model.Persona;
import Corso_Java.PrimoProgetto.service.ServiceCrud;


public class View {


	Scanner input=new Scanner(System.in);


	public String leggiString(String s)
	{
		System.out.println(s);
		return input.nextLine();

	}



	public String leggiStringRegex(String s, boolean controllo) throws RegexStringException
	{
		String inputString = null;
		if(controllo) // inserimento
		{
			System.out.println(s);
			inputString=input.nextLine().trim();
		}
		else // modifica
			inputString=s;
		if(!inputString.matches("^[a-zA-Z0-9]{3,16}$")) 
			throw new RegexStringException("il campo deve contenere da 3 a 16 caratteri!");

		return inputString;
	}



	public int leggiInt(String s) 
	{
		System.out.println(s);	
		return Integer.parseInt(input.nextLine()); 

	}





	public LocalDate leggiData(String s, boolean controllo) throws DateException
	{
		String dataInput = null;
		LocalDate dataDiNascita;
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		if(controllo) // inserimento
		{	
			System.out.println(s);
			dataInput=input.nextLine().trim();
		}else //modifica
			dataInput=s;

		dataDiNascita=LocalDate.parse(dataInput, formatter);
		if(dataDiNascita.isAfter(LocalDate.now())) // controlla se viene inserita una data > della data odierna
			throw new DateException("Hai inserito una data maggiore della data odierna.");

		return dataDiNascita;

	}





	public void printAll(List<Persona> list)
	{
		if(list.isEmpty())
			System.out.println("Lista vuota!");
		else
			for (Persona p : list) 
				System.out.println(p);


	}




	public void print(Persona p)
	{

		System.out.println(p);
	}

	public void print(Persona p, String msg)
	{

		System.out.println(msg+" "+p);
	}


	public void msg(String s)
	{

		System.out.println(s);
	}



	public void formInit(Persona p) throws RegexStringException,DateException 
	{
		p.setNome(leggiStringRegex("Inserisci il nome: ",true));
		p.setCognome(leggiStringRegex("Inserisci il cognome: ",true));
		p.setDataDiNascita(leggiData("Inserisci una data di nascita nel seguente formato gg-mm-aaaa: ",true));
		p.setCf(leggiStringRegex("Inserisci il cf: ",true));

	}

	public Persona menuTipoDiRicerca(ServiceCrud service) throws SQLException {
		Persona p = null;
		int scelta = leggiInt("1 : Ricerca attraverso l' ID \n2: Ricerca attraverso codice fiscale");
		if(scelta == 1)
		{
			int id = leggiInt("Inserisci l'ID");
			return service.findByID(id);
		} else if (scelta == 2) {
			String cf = leggiString("Inserisci il codice fiscale ");
			return service.findByCf(cf);
		}else
		{
			msg("Scelta non valida");
			return null;
		}
	}





	public int menu(){

		System.out.println("MENU APP");
		System.out.println("1) Inserimento");
		System.out.println("2) Print All");
		System.out.println("3) Ricerca");
		System.out.println("4) Elimina");
		System.out.println("5) Modifica"); 

		System.out.println("0) ESCI");

		return leggiInt("Fai una scelta:");

	}





}
