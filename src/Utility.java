import java.util.Scanner;

//Contiene esempi sviluppati durante la prima lezione del corso in java!
public class Utility {

    Scanner input = new Scanner(System.in);

    //Effettua la somma tra due numeri
    public void somma(int a,int b) {
        int somma = a + b;
        System.out.println("Somma = " + somma);
    }


    public void saluta() {
        String saluto = input.nextLine();
        System.out.println("Saluta ");
        System.out.println(saluto);
    }


    //Stampa la seguente sequenza: "1,2,3,4,5...,limiteMassimo."
    public  void stampaOrizzontale(int limiteMassimo) {
        if(limiteMassimo < 1) {

            System.out.println("Limite massimo non positivo");
            return;
        }

        for(int i = 1; i < limiteMassimo; i++)
                System.out.print(i + ",");

        System.out.print(limiteMassimo + ".");


    }

    //Legge un numero e lo restituisce
    public int leggiNumero(String s) {
        System.out.println(s);
        int scelta = input.nextInt();
        return scelta;

    }

    //Legge una stringa e la restituisce
    public  String leggiStringa(String s)
    {
        System.out.println(s);
        String scelta = input.nextLine();
        return scelta;
    }


    //Chiede n numeri scelti dall'utente e stampa a video somma e media
    public  void totalizzatore()
    {
        //Dati
        String scelta;
        int somma = 0;
        float media = 0;
        int numero = 0;

        do
        {
            int num = this.leggiNumero("Scegli un numero");
            numero++;
            somma += num;
            System.out.println("Vuoi continuare?");
            input.nextLine();
            scelta = input.nextLine();

        }while(scelta.equals("S") || scelta.equals("s"));

        media = (float) somma / numero;
        System.out.println("Il numero di elementi è " + numero + " La somma è " + somma  +  " La media è " + media);
    }

    //Verifica che due stringhe siano uguali
    public  boolean checkString(String s1,String s2)
    {
        return s1.equals(s2);
    }


    //Implementazione di un semaforo
    public  void semaforo(String colore)
    {
        switch (colore.toLowerCase())
        {
            case "verde":
                System.out.println("Vai");
                break;
            case "rosso":
                System.out.println("Fermati");
                break;
            case "giallo":
                System.out.println("Attenzione");
                break;
            default:
                System.out.println("non sei al semaforo");
        }
    }
}
