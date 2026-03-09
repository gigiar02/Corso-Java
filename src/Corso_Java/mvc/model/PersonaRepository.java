package Corso_Java.mvc.model;

import java.util.ArrayList;

public class PersonaRepository {
    ArrayList<Persona> Persone = new ArrayList<Persona>();

    public boolean  insert(Persona p)
    {
        return Persone.add(p);
    }

    public ArrayList<Persona> getAll()
    {
        return Persone;
    }
}
