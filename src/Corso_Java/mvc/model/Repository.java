package Corso_Java.mvc.model;

import java.util.HashMap;
import java.util.HashSet;

public interface Repository {
    boolean insert(Persona p);
    Persona search(String cf);
    boolean delete(Persona p);
    void update(Persona p,Persona pNew);

    HashMap<Integer,Persona> getAll();
}
