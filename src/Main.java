import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen beim einem Taschenrechner.");
        while (true) {
            System.out.println("Gib deine Berechnung ein (z.B. 1+2, 4-3, 4*5, 8/2).");
            String eingabe = scanner.nextLine();

            if (eingabe.equalsIgnoreCase("exit")) {
                System.out.println("Taschenrechner wird Beendet");
                break;
            }
            eingabe = eingabe.toLowerCase().replace(',', '.').replace('x', '*').replace(':', '/');

            try {
                double ergebnis = berechne(eingabe);
                System.out.println("Das Ergebnis ist: " + ergebnis);
            } catch (Exception e) {
                System.out.println("Fehler: " + e.getMessage());
            }
        }
        scanner.close();
    }
    private static double berechne(String eingabe) throws Exception{

        while (eingabe.contains("(")) {
            int start = eingabe.lastIndexOf("(");
            int ende = eingabe.indexOf(")", start);
            if (ende == -1 ) {
                throw new Exception("Fehlende schließende Klammer.");
            }

            String teilAusdruck = eingabe.substring(start + 1, ende);
            double teilErgebnis = berechne(teilAusdruck);

            eingabe = eingabe.substring(0, start) + teilErgebnis + eingabe.substring(ende + 1);
        }
    return berechneOhneKlammern (eingabe);
    }



    private static double berechneOhneKlammern(String eingabe) throws Exception {

        double ergebnis = 0;
        char aktuellerOperator = '+';
        String[] teile = eingabe.split("(?=[-+*/])|(?<=[-+*/])");

        for (String teil : teile) {
            teil = teil.trim();

            if (teil.matches("[-+]?\\d*\\.?\\d+")) {
                double zahl = Double.parseDouble(teil);
                switch (aktuellerOperator) {
                    case '+':
                        ergebnis += zahl;
                        break;
                    case '-':
                        ergebnis -= zahl;
                        break;
                    case '*':
                        ergebnis *= zahl;
                        break;
                    case '/':
                        if (zahl == 0) {
                            throw new Exception("Division durch 0 ist nicht erlaubt in diesem Programm");
                        }
                        ergebnis /= zahl;
                        break;
                }

            } else if (teil.matches("[-+*/]")) {
                aktuellerOperator =teil.charAt(0);
            } else {
                throw new Exception("Ungültige Eingabe! Bitte überprüfen Sie ihre Eingabe");
            }

            }
        return ergebnis;
    }
}
