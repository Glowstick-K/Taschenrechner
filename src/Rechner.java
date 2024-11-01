import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Rechner {
    TextField inputField1;


    public Rechner(TextField inputField) {
        this.inputField1 = inputField;

        String ersteEingabe = inputField.getText();
    }
        //benutzte den Synonym "fish" anstast "text"//

        public void buttonClick(String fish) {
            String inputNum = inputField1.getText().trim();
            //String inputtransfer = inputField2.getText();//

            // String input = inputField.getText(); //

            Double ergebniss = null;

            //while (fish.)//

            if (fish.equals("=")) {
                if (inputNum.equals("+")) {
                    /*inputField1.clear();
                    inputField2.setText(inputNum);*/
                    ergebniss = berechne(inputNum, "\\+", '+');
                } else if (inputNum.contains("-")) {
                    ergebniss = berechne(inputNum, "\\-", '-');
                } else if (inputNum.contains("*")) {
                    ergebniss = berechne(inputNum, "\\*", '*');
                } else if (inputNum.contains("/")) {
                    ergebniss = berechne(inputNum, "\\/", '/');

                } else {
                    inputField1.setText("Ungültiges Format! Bitte geben sie nur +*-/ ein.");
                }
                inputField1.setText(ergebniss.toString());

            } /*else if (fish.equals("+")) {
                inputField1.clear();
                inputField2.setText(inputNum);

            }*/ else if (fish.equals("C")) {
                inputField1.clear();
            } else {
                inputField1.setText(inputNum + fish);
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