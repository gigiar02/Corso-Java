import java.util.Scanner;

//Contiene esempi sviluppati durante la prima lezione del corso in java!
public class Utility {
    enum COLOR
    {
        RED,
        YELLOW,
        BLUE,

    }

    Scanner input = new Scanner(System.in);

    //Effettua la somma tra due numeri
    public void somma(int a,int b) {
        int somma = a + b;
        System.out.println("Somma = " + somma);
    }


    public void saluta() {
        System.out.println("Ciao " + leggiStringa("Salutami"));
    }

    public void saluta(String message)
    {
        System.out.println("Ciao " + leggiStringa("Salutami" + message));
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

    public  void stampaVerticale(int limiteMassimo) {
        if(limiteMassimo < 1) {

            System.out.println("Limite massimo non positivo");
            return;
        }

        for(int i = 1; i < limiteMassimo; i++)
            System.out.println(i);
    }


    //Legge un numero e lo restituisce
    public int leggiNumero(String s) {
        System.out.println(s);
        return Integer.parseInt(input.nextLine());
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
        int minimo = (int) Double.POSITIVE_INFINITY;
        int massimo = (int) -Double.POSITIVE_INFINITY;
        String numeri = "";
        do
        {
            int num = this.leggiNumero("Scegli un numero");
            numero++;
            somma += num;
            numeri += Integer.toString(num) + " ";
            if(num < minimo) minimo = num;
            if(num > massimo) massimo = num;

        }while(this.leggiStringa("Vuoi continuare?").equals("s"));

        media = (float) somma / numero;
        System.out.println("Il numero di elementi è " + numero + " La somma è " + somma  +  " La media è " + media + "numeri inseriti: " + numeri);
        System.out.println("Il massimo è " + massimo + "il minimo è " + minimo);
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

    public  void occorrenzeVocaliConsonanti(String frase)
    {
        System.out.println(frase.charAt(0));

        int vocali = 0; int consonanti = 0;
        frase = frase.toLowerCase();

        for(int i = 0; i < frase.length(); i++)
        {
            if(frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' || frase.charAt(i) == 'u')
            {
                vocali+=1;
            }else if(frase.charAt(i) > 'a' && frase.charAt(i) <= 'z')
            {
                consonanti+=1;
            }
        }

        System.out.println("Vocali = " + vocali + "Consonanti = " + consonanti);
    }

    public  int menu()
    {
        System.out.println("Avvio");
        System.out.println("1 StampaVerticale");
        System.out.println("2 StampaOrizzontale");
        System.out.println("3 saluta");
        System.out.println("4 Semaforo");
        System.out.println("5 Totalizzatore");
        System.out.println("6 esci");

        int leggi = leggiNumero("Fai la tua scelta");
        return  leggi;
    }

    //Restituisce il valore totale in ASCII della frase
    public int calcolaASCII(String frase)
    {
        int somma = 0;
        for(int i = 0; i < frase.length(); i++)
        {
            somma += frase.charAt(i);
            System.out.println((int) frase.charAt(i));
        }
        return somma;

    }
}
