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
                    return;


            }


    }
}
