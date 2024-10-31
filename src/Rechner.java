import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Rechner {
    TextField inputField;


    public Rechner(TextField inputField) {
        this.inputField = inputField;

    }
        //benutzte den Synonym "fish" anstast "text"//

        public void buttonClick(String fish) {
            String input = inputField.getText().trim();
            Double ergebniss = null;
            if (fish.equals("=")) {
                if (input.contains("+")) {
                    ergebniss = berechne(input, "\\+", '+');
                } else if (input.contains("-")) {
                    ergebniss = berechne(input, "\\-", '-');
                } else if (input.contains("*")) {
                    ergebniss = berechne(input, "\\*", '*');
                } else if (input.contains("/")) {
                    ergebniss = berechne(input, "\\/", '/');
                } else {
                    inputField.setText("Ungültiges Format! Bitte geben sie nur +*-/ ein.");
                }
                inputField.setText(ergebniss.toString());

            } else if (fish.equals("C")) {
                inputField.clear();
            } else {
                inputField.setText(input + fish);
                return;
            }

        }




    private double berechne(String input, String operator, char op) {
        String[] parts = input.split(operator);
        double zahl1 = Double.parseDouble(parts[0].trim());
        double zahl2 = Double.parseDouble(parts[1].trim());
        return op == '+' ? zahl1 + zahl2
                : op == '-' ? zahl1 - zahl2
                : op == '*' ? zahl1 * zahl2
                : op == '/' ? zahl1 / zahl2
                : Double.NaN;
    }
}

// zu erledigen sind Minuszahlen hinzuzufügen und nach dem ergebnis das textfeld leeren, benutzen des Numpads//
// layout anpassen //