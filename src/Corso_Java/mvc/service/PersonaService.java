package Corso_Java.mvc.service;

import Corso_Java.mvc.exception.CfException;
import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.model.PersonaRepository;

import java.util.ArrayList;

public class PersonaService {
    //Gestore repository persona
    PersonaRepository personaRepository = new PersonaRepository();

    //Inserimento di una persona nel database
    public boolean insert(Persona p) {

        if(personaRepository.search(p.getCodiceFiscale()) != null)
        {
            System.out.println("Errore: Codice fiscale già esistente");
            throw  new CfException("Codice fiscale già esistente!");

        }

        personaRepository.insert(p);
        return true;
    }

    //Ricerca una persona nel database e la restituisce
    public Persona search(String cf) { return personaRepository.search(cf);}
    public int search(Persona p){return personaRepository.search(p);}
    public Persona getPersona(int index){return personaRepository.getPersona(index);}

    //Elimina una persona nel database
    public boolean delete(Persona p) { return personaRepository.delete(p);}

    public boolean update(Persona p,Persona pNew) {

        if(search(pNew.getCodiceFiscale()) != null && !p.getCodiceFiscale().equals(pNew.getCodiceFiscale()))
        {
            return false;
        }

        personaRepository.update(p,pNew);
        return true;
    }


    //Ottieni tutte le persone presenti nel database
    public ArrayList<Persona> getAll()
    {
        return personaRepository.getAll();
    }
}
