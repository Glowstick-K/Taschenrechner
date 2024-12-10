import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Test {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //erstellt die ArrayList und könnte für den taschenrechner benutzt werden//
        ArrayList<Double> zahlenList = new ArrayList<>();
        ArrayList<Double> ergebnisList = new ArrayList<>();
        ArrayList<Character> operatorenList = new ArrayList<>();


        //eine Schleife um die Arraylisten zu lernen und sachen hinzuzufügen//
        while (true) {
            String input = scanner.nextLine();

            // versuch die inputs in die arraylist zu stecken //
            Pattern zahlenregex = Pattern.compile("[0-9]");
            Pattern opregex = Pattern.compile("[+*/-]");

            Matcher zahlenmatcher = zahlenregex.matcher(input);
            Matcher opmatcher = opregex.matcher(input);

            boolean opFound = opmatcher.find();
            boolean numberFound = zahlenmatcher.find();


            //neue if Statement was dierekt die berechnung mit beinhaltet//


            //fügt nachdem die zahlen erkannt werden diese in die arraylist "rechenlist" hinzu//



            if (opFound || numberFound || input.equals("=")) {

                if (input.equals("=")) {

                    // erschafft eine Double aus der rechenlist dessen variable name "ergebnis" ist//
                    Double ergebnis = zahlenList.get(0);
                    for (int i = 0; i < operatorenList.size(); i++) {
                        Character operator = operatorenList.get(i);
                        Double zahl = zahlenList.get(i + 1);

                        switch (operator) {
                            case '+':
                                ergebnis += zahl;
                                ergebnisList.add(ergebnis);
                                break;
                            case '-':
                                ergebnis -= zahl;
                                ergebnisList.add(ergebnis);
                                break;
                            case '*':
                                ergebnis *= zahl;
                                ergebnisList.add(ergebnis);
                                break;
                            case '/':
                                if (zahl != 0) {
                                    ergebnis /= zahl;
                                    ergebnisList.add(ergebnis);
                                } else {
                                    System.out.println("Keine Division durhc null!");
                                }
                                break;
                            default:
                                System.out.println("Unbekannter operator");
                                break;
                        }
                    }
                }  else if (opFound) {
                    Character opAdd = input.charAt(0);
                    operatorenList.add(opAdd);
                    System.out.println(opAdd);
                }  else if (numberFound) {
                    Double numberAdd = Double.parseDouble(input);
                    zahlenList.add(numberAdd);
                }  else {
                    System.out.println("Fehler");
                }

            } else if (input.equalsIgnoreCase("C")) {
                zahlenList.clear();
                operatorenList.clear();
                ergebnisList.clear();
            } else if (input.equalsIgnoreCase("A")) {
                System.out.println(zahlenList + " Fish1");
                System.out.println(operatorenList + " Fish2");
            } else if (input.equalsIgnoreCase("E")) {
                System.out.println(ergebnisList);
            } else if (input.equalsIgnoreCase("Q")) {
                break;
            }
            //filtert die falschen Ausgaben raus und zeigt "falsche eingabe" an//
            else {
                System.out.println("falsche eingabe");
            }
        }
        scanner.close();

        }
}


