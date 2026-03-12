package Corso_Java.mvc.service;

import Corso_Java.mvc.exception.CfException;
import Corso_Java.mvc.model.Persona;
import Corso_Java.mvc.model.EntityRepository;
import Corso_Java.mvc.model.Repository;

import java.util.HashMap;

public class Service {
    //Gestore repository persona
    Repository entityRepository = new EntityRepository();

    //Inserimento di una persona nel database
    public boolean insert(Persona p) {

        if(entityRepository.search(p.getFiscalCode()) != null)
        {
            throw  new CfException("Codice fiscale già esistente!");
        }

        entityRepository.insert(p);
        return true;
    }

    //Ricerca una persona nel database e la restituisce
    public Persona search(String cf) { return entityRepository.search(cf);}

    //Elimina una persona nel database
    public boolean delete(Persona p) { return entityRepository.delete(p);}

    public boolean update(Persona p,Persona pNew) {

        if(search(pNew.getFiscalCode()) != null && !p.getFiscalCode().equals(pNew.getFiscalCode()))
        {
            return false;
        }

        entityRepository.update(p,pNew);
        return true;
    }


    //Ottieni tutte le persone presenti nel database
    public HashMap<Integer, Persona> getAll()
    {
        return entityRepository.getAll();
    }
}
