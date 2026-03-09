package Corso_Java.mvc.service;

import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.model.PersonaRepository;

import java.util.ArrayList;

public class PersonaService {
    PersonaRepository personaRepository = new PersonaRepository();

    public boolean insert(Persona p)
    {
        return personaRepository.insert(p);
    }

    public ArrayList<Persona> getAll()
    {
        return personaRepository.getAll();
    }
}
