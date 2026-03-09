package Corso_Java.mvc.service;

import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.model.PersonaRepository;

import java.util.ArrayList;

public class PersonaService {
    //Gestore repository persona
    PersonaRepository personaRepository = new PersonaRepository();

    //Inserimento di una persona nel database
    public boolean insert(Persona p)
    {
        return personaRepository.insert(p);
    }

    //Ottieni tutte le persone presenti nel database
    public ArrayList<Persona> getAll()
    {
        return personaRepository.getAll();
    }
}
