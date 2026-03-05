import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Collections.swap;

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
    public double leggiNumeroD(String s) {
        System.out.println(s);
        return Double.parseDouble(input.nextLine());
    }
    public int leggiNumero(String s) {
        System.out.println(s);
        return Integer.parseInt(input.nextLine());
    }

    public int leggiNumero(int i) {
        System.out.println("Inserisci il " + i + " valore ");
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
        System.out.println("6 Traduzione in ascii");
        System.out.println("7 Palindroma di una frase ricevuta come parametro");
        System.out.println("8 CalcolaMassimoAscii");
        System.out.println("9 Calcolatrice");
        System.out.println("10 Restituisci il numero piu piccolo divisibile tra uno e il max scelto");
        System.out.println("15 Data una matrice calcola il numero massimo per ogni riga e lo scambia con quello in posizione 0");



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
        }
        System.out.println("Somma di " + frase + " = " +  somma);
        return somma;

    }

    public void palindroma(String frase)
    {
        for (int i = 0,j = frase.length() - 1; i < frase.length()/2; i++,j--)
        {
            if(frase.charAt(i) != frase.charAt(j))
            {
                System.out.println(i  + " " + j);
                System.out.println("La frase non è palindroma");
                return;
            }
        }
        System.out.println("La frase è palindroma");
    }

    //Somma sottrazione e uguale (risultato finale)
    //1) Chiedo di inserire un numero
    //2) Scelgo un'operazione + - x /
    //3) Scelgo un numero
    //4) O digito uguale oppure sceglo un'altra operazione (Se scelgo un'altra operazione mi da il risultato e continuo)
    //5) Con l'uguale finisce
    public  void  calcolatrice()
    {
        boolean showResult = false;
        int i = 0;
        double scelta = 0;
        double scelta2;
        double risultato = 0;
        String operazione = "";
        boolean first = true;


        while (true) {
            //La calcolatrice parte con valore 0 che sarà sostituito dopo il primo valore immesso
            if(first)
            {
                first = false;
                scelta = leggiNumeroD("Scegli un valore");
                risultato = scelta;
                continue;
            }

            //Raccolta operazione e numero scelto
            operazione = leggiStringa("Scegli un' operazione: + - * / =");
            scelta = leggiNumeroD("Scegli un valore");

            //Scelgo l'operazione da effettuare
            switch (operazione){
                    case "+":
                        risultato += scelta;
                        break;
                    case "-":
                        risultato -= scelta;
                        break;
                    case "*":
                        risultato *= scelta;
                        break;

                    case "/":
                        risultato /= scelta;
                        break;
                    case "=":
                        System.out.println("Risultato = " + risultato);
                        System.out.println("Arrivederci");
                        return;
                    default:
                        System.out.println("Operazione inserita non valida");
                }

            //Mostro il risultato
            System.out.println("Risultato = " + risultato);

        }
    }

    public  int contaSequenza(String sequenza)
    {
        /*
        int somma = 0;
        for(int i = 0; i < sequenza.length(); i++)
        {
            if(sequenza.charAt(i) == '7')
            {
                somma++;
            }
        }

         */
        int somma = 0;
        String sequenzaModificata = sequenza.replaceAll("[^7]","");
        return sequenzaModificata.length();
    }

    public  void numeroDivisibile(long max)
    {
        boolean controllo = false;
        final long fine = max;

        while (true)
        {
            if(controllo)
            {
                System.out.println("Max = " + max);
                return;
            }
            max +=1;
            for(int i = 1; i <= fine; i++)
            {
                if(max % i != 0)
                {
                    controllo = false;
                    break;
                }
                controllo = true;
            }
        }
    }


    //Cerca all'interno dela frase la parola con codice ascii magggiore..restituirla
    public  void   maxASCII(String frase)
    {
        //Modifica della frase
        String fraseModificata = frase.replaceAll("[0-9\\p{Punct}]","");
        System.out.println(fraseModificata);

        int massimo = 0; int rimanenti = fraseModificata.length() - 1;
        int lettereMassime = 0;
        boolean continua = true;
        int i_min = 0;
        int i_max = 0;
        String parola = "";

        //Se il numero di caratteri rimanenti è minore della lunghezza della parola piu grande esci
        while (rimanenti >= lettereMassime && i_max < fraseModificata.length())
        {
            //Ultimo carattere
            if(i_max == fraseModificata.length()-1)
            {
                i_max+=1;
            }else if (fraseModificata.charAt(i_max) != ' '){
                //Finché trovo un carattere incremento l'indice
                i_max+=1;
                continue;
            }

            //Ho trovato uno spazio quindi considerto la sottostringa di fraseModifcata [i_min,i_max]
            String appoggio = fraseModificata.substring(i_min,i_max);
            //Aggiorno i caratteri rimanenti
            rimanenti = rimanenti -appoggio.length();

            //Confronto basato sul numero di caratteri
            if(appoggio.length() > lettereMassime)
            {
                parola = appoggio;
                lettereMassime = parola.length();
                massimo = calcolaASCII(parola);
            }

            //Aggiornamento i_min i_max
            i_min = i_max + 1;
            i_max = i_min;
        }

        //Debug Stampa parola + massimo
        System.out.println("Parola = " + parola + "Massimo = " + massimo);
    }

    /*
              sommamedia[0] = somma dei pari
              sommamedia[1] = media dei pari
              sommamedia[2] = somma dei dispari
              sommamedia[3] = meddia dei dispari
              sommamedia[4] = minimo pari
              sommamedia[5] = massimo pari
              sommamedia[6] = minimo dispari
              sommamedia[7] = massimo dispari
     */

    //tre metodi distinti
    //Lavoriamo con i vettori di interi
    //1) Metodo 1: Inizializza un vettore di n elementi
    public  int[] initVec(int n)
    {
        //Inizializza il vettore
        int[] vect = new  int[n];

        for(int i = 0; i < n; i++)
        {
            //Utilizzo metodo modificato di leggiNumero
            vect[i] = leggiNumero(i + 1);
        }

        return vect;
    }

    public  int[] aggiornamentoMinimoeMassimo(int min,int max,int number)
    {
        if(number < min)
        {
            min = number;
        }
        if(number > max)
        {
            max = number;
        }
        return new int[]{min,max};
    }
    //3)
    //2)Controllo i valori presenti nel vettore
    public double[] trovaValore(int[] vect)
    {
        double[] sommaMedia = new double[8];
        boolean[] minMax = new boolean[4];
        int sommaPari = 0;
        int sommaDispari = 0;
        double mediaPari = 0;
        double mediaDispari = 0;
        int minimoPari = Integer.MAX_VALUE;
        int massimoPari = Integer.MIN_VALUE;
        int minimoDispari = Integer.MAX_VALUE;
        int massimoDispari = Integer.MIN_VALUE;
        System.out.println(minMax[0]);
        int np = 0,nd = 0;

        for (int i = 0; i < vect.length; i++) {
            if (vect[i] % 2 == 0) {
                //Pari
                //Continuare
                aggiornamentoMinimoeMassimo(minimoPari,massimoPari,vect[i]);
                sommaPari += vect[i];
                np += 1;
            } else {
                //Dispari
                //Controllo minimo massimo
                if(vect[i] < minimoDispari){minimoDispari = vect[i];}
                if(vect[i] > massimoDispari){massimoDispari = vect[i];}
                sommaDispari += vect[i];
                nd += 1;
            }
        }
        if(np > 0){ mediaPari = (double) sommaPari / np;}

        if(nd > 0) {mediaDispari = (double) sommaDispari / nd;}

        sommaMedia = new double[]{np,nd,minimoDispari,massimoDispari,sommaDispari,mediaDispari,minimoPari,massimoPari,sommaPari,mediaPari};
        return sommaMedia;
    }

    public void printVet(double[] risultato)
    {
        int minimo;
        int massimo;
        String[] operazioni = new String[]{"Minimo","Massimo","Somma","Media"};

        //Dispari. Vedo se devo considerarli
        if(risultato[1] > 0){
            minimo = 2;
        }else
        {
            minimo = 6;
        }

        //Pari
        if(risultato[0] > 0){
            massimo = 8;
        }else{
            massimo = 6;
        }

        //I primi due valori dell'array li abbiamo già considerati
        for(int i = minimo; i <massimo; i+=4)
        {
            System.out.println(i);
            if(i == 2){System.out.println("Dispari: ");}
            if(i == 6){System.out.println("Pari: ");}
            for(int j = 0; j<4; j++)
            {
                System.out.println(operazioni[j] +  " = " + risultato[i + j]);
            }
        }
    }

    //Vettori di stringhe
    //Ad esempio nominativi Luigi Antonio Luca Mario

    public String[] initVectString(int n)
    {

        String[] nominativi = new String[n];

        for(int i = 0; i < n; i++)
        {
            nominativi[i] = leggiStringa("Inserisci la stringa " + (i+1) +  " nel vettore");
        }
        return nominativi;
    }

    //Metodo che permette di confrontare stringhe lessicograficamente
    public void ordinaNominativi(String[] nominativi,String tipoOrdinamento)
    {
        //Insertion Sort
        if(tipoOrdinamento.equals("decrescente"))
        {
            for(int i = 1; i < nominativi.length;i++)
            {
                int j = i - 1;
                String key = nominativi[i];
                while (j >=0 && key.compareTo(nominativi[j]) >= 0)
                {
                    nominativi[j + 1] = nominativi[j];
                    j--;
                }

                nominativi[j+1] = key;
                j = 0;

            }
        }else if(tipoOrdinamento.equals("crescente"))
        {
            for(int i = 1; i < nominativi.length;i++)
            {
                int j = i - 1;
                String key = nominativi[i];
                while (j >=0 && key.compareTo(nominativi[j]) < 0)
                {
                    nominativi[j + 1] = nominativi[j];
                    j--;
                }

                nominativi[j+1] = key;
                j = 0;

            }
        }


    }


    public  int findPivot(String[] nominativi,int s,int e)
    {
        int i = s - 1;
        int j = i;
        String pivot = nominativi[e];

        for(int r = 0; r < nominativi.length - 1; r++)
        {
            if(pivot.compareTo(nominativi[r]) >= 0)
            {
                //Porzione elementi ordinati
               i+=1;
               j+=1;
               String appoggio = nominativi[i];
               nominativi[i] = nominativi[j];
               nominativi[j] = appoggio;
            }else
            {
                i+=1;
            }
        }

        String appoggio = pivot;
        nominativi[e] = nominativi[j+1];
        nominativi[j+1] = appoggio;

        print(nominativi);
        System.out.println("j + 1 = " + j+1);
        return j + 1;
    }

    public void quickSort(String[] nominativi,int inizio, int fine)
    {
        if(inizio > fine)
        {
            //print(nominativi);
            return;
        }
        int p = findPivot(nominativi,inizio,fine);
        quickSort(nominativi,inizio,p - 1);
        quickSort(nominativi,p + 1,fine);
    }

    public  void print(String[] nominativi)
    {
        for (String nominativo : nominativi)
        {
            System.out.print(nominativo + " ");
        }
        System.out.println(" ");
    }


    public  int[][] initMat(int righe,int colonne)
    {
        int[][] mat = new int[righe][colonne];
        Random random = new Random();

        for(int i = 0; i < mat.length;i++)
        {
            for(int j = 0; j < mat[0].length;j++)
            {
                //[-30 + 60]
                mat[i][j] = random.nextInt(-30,61);
            }
        }

        return mat;
    }


    public void makeSwap(int[] arr,int i,int j)
    {
        int appoggio = arr[i];
        arr[i] = arr[j];
        arr[j] = appoggio;
    }
    //Per ogni riga voglio il massimo ed eseguire lo scambio se necessario con la prima posizione. Se si trova già nella prima pos. non fare lo scambio
    //Stampa la matrice
    public void valoreMaxMatrice(int[][] mat)
    {

        for(int i = 0; i < mat.length;i++)
        {
            int massimo = Integer.MIN_VALUE;
            int maxIndex = 0;
            for(int j = 0; j < mat[0].length;j++)
            {
                if(massimo < mat[i][j]){massimo = mat[i][j]; maxIndex = j;}
            }

            if(maxIndex != 0)
            {
                makeSwap(mat[i],0,maxIndex);
            }

        }


    }

    public void printMatrix(int[][] mat)
    {
        for(int i = 0; i < mat.length;i++)
        {
            for(int j = 0; j < mat[0].length;j++)
            {
                //[-30 + 60]
                System.out.print(mat[i][j] + " ");
            }
            System.out.println(" ");
        }
    }



}

