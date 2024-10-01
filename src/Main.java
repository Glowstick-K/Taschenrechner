import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Willkommen beim einem Guten Taschenrechner.");

        System.out.println("Gib deine Berechnung ein (z.B. 1+2).");
        String eingabe = scanner.nextLine();

        double zahl1 = 0, zahl2 = 0;
        char operator = ' ';
        double ergebnis = 0;

        if (eingabe.contains("+")) {
            operator = '+';
        } else if (eingabe.contains("-")) {
            operator = '-';
        } else if (eingabe.contains("*")) {
            operator = '*';
        } else if (eingabe.contains("/")) {
            operator = '/';
        } else {
            System.out.println("Ungultige Eingabe!");
            scanner.close();
            return;
        }


    }
}