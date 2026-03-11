package Corso_Java.mvc.utils;

import Corso_Java.mvc.Enumerazioni.Entities;
import Corso_Java.mvc.model.Dipendente;
import Corso_Java.mvc.model.Manager;
import Corso_Java.mvc.model.Persona;

public  class MakeEntity {

    //Fabbrica un'entità
    public static Persona GetEntity(Entities e)
    {
        return switch (e){
            case MANAGER -> new Manager();
            case DIPENDENTE -> new Dipendente();
            default -> null;
        };
    }

    public static Persona GetEntity(Persona p)
    {
        String type = Utils.getTypeOfEntity(p);

        return switch (type) {
            case "MANAGER" -> new Manager();
            case "DIPENDENTE" -> new Dipendente();
            default -> new Persona();
        };
    }
}
