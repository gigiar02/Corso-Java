public class Run {
    static void main(String[] args) {
        Utility utils = new Utility();

        while (true)
            switch (utils.menu()) {
                case 1:
                    utils.stampaVerticale(utils.leggiNumero("Scegli il limite massimo"));
                    break;
                case 2:
                    utils.stampaOrizzontale(utils.leggiNumero("Scegli il limite massimo"));
                    break;
                case 3:
                    utils.saluta("Scegli il limite massimo");
                    break;
                case 4:
                    utils.saluta(utils.leggiStringa("Scegli il tuo nome"));
                    break;
                case 5:
                    utils.totalizzatore();
                    break;
                case 6:
                    int asciiVal = utils.calcolaASCII(utils.leggiStringa("Scrivi la frase da tradurre in ASCII"));
                    System.out.println("La frase in ASCII: " + asciiVal);
                    break;
                case 7:
                    utils.palindroma(utils.leggiStringa("Inserisci la frase "));
                    break;
                case 8:
                    utils.maxASCII(utils.leggiStringa("inserisci i nominativi "));
                    break;
                case 9:
                    utils.calcolatrice();
                    break;
                case 10:
                    utils.numeroDivisibile(utils.leggiNumero("Inserisci l'intervallo massimo"));
                    break;
                case 11:
                    return;
                case 12:
                    int[] vect = utils.initVec(utils.leggiNumero("Inserisci il numero di elementi del vettore"));
                    double[] result = utils.trovaValore(vect);
                    utils.printVet(result);
                    break;
                case 13:
                    String[] vettore = utils.initVectString(utils.leggiNumero("Inserisci la dimensione del vettore"));
                    utils.print(vettore);
                    utils.ordinaNominativi(vettore, utils.leggiStringa("Inserisci il tipo di ordinamento"));
                    utils.print(vettore);
                    break;
                case 14:
                    //QuickSort
                    String[] nominativi = utils.initVectString(utils.leggiNumero("Inserisci la dimensione del vettore"));
                    utils.print(nominativi);
                    utils.quickSort(nominativi,0,nominativi.length-1);
                    break;
                case 15:
                    int[][] mat = utils.initMat(utils.leggiNumero("Inserisci numero di righe"),utils.leggiNumero("Inserisci numero di colonne"));
                    System.out.println("Matrice generata: ");
                    utils.printMatrix(mat);
                    utils.valoreMaxMatrice(mat);
                    System.out.println("--------------");
                    System.out.println("Matrice modificata: ");
                    utils.printMatrix(mat);
                    break;

                case 16:
                    double[][] meteo = utils.initDMat();
                    utils.printMatrix(meteo);
                    int[] moda = utils.calcolaModa(meteo);
                    utils.stampaModa(moda);
                    break;
            }


    }
}
