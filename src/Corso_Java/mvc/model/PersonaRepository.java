package Corso_Java.mvc.model;

import java.util.ArrayList;

public class PersonaRepository {
    ArrayList<Persona> persone = new ArrayList<Persona>();

    //Inserisce una persona nel database
    public boolean  insert(Persona p)
    {
        return persone.add(p);
    }

    //Ricerca una persona nel database
    public Persona search(String cf)
    {
        for(Persona p : persone)
        {
            if(p.getCodiceFiscale().equals(cf)) {return p;}
        }

        return null;
    }

    public int search(Persona p){
        int index = -1;
        for(Persona h : persone)
        {
            index += 1;
            if(h.getCodiceFiscale().equals(p.getCodiceFiscale())) {return index;}
        }
        return index;
    }

    public Persona getPersona(int i){
        return persone.get(i);
    }


    //Ricerca una persona con il codice fiscale passato e se lo trova lo elimina
    public boolean delete(Persona p)
    {
        if(p != null)
        {
            persone.remove(p);
            return  true;
        }

        return false;
    }


    public void update(Persona p,Persona pNew) {

        persone.set(persone.indexOf(p),pNew);
    }

    public ArrayList<Persona> getAll()
    {
        return persone;
    }
}
