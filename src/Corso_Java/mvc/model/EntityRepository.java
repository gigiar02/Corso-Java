package Corso_Java.mvc.model;

import java.util.*;

public class EntityRepository implements Repository {
     HashMap<Integer,Persona> entity = new HashMap<Integer,Persona>();

     public EntityRepository(){}
    //Inserisce una persona nel database
    public boolean insert(Persona p)
    {
        if(entity.put(p.getID(),p) != null) {return true;}
        return false;
    }

    //Ricerca una persona nel database
    public Persona search(String cf)
    {
        for(Map.Entry<Integer,Persona> e : entity.entrySet())
        {
            if(e.getValue().getFiscalCode().equals(cf)) {return e.getValue();}
        }

        return null;
    }


    //Ricerca una persona con il codice fiscale passato e se lo trova lo elimina
    public boolean delete(Persona p)
    {
        if(p == null) {return false;}
        return entity.remove(p.getID()) != null;
    }


    public void update(Persona p,Persona pNew) {
        entity.put(p.getID(),pNew);
    }

    public HashMap<Integer, Persona> getAll()
    {
        return entity;
    }
}
