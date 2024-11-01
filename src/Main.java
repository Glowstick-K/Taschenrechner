import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application{

    private TextField display;
    private TextField display2;
    @Override
    public void start(Stage primaryStage) {

        display = new TextField();
        display.setEditable(true);
        display.setPrefWidth(200);
        display.setPrefHeight(50);

        display2 = new TextField();
        display2.setEditable(true);
        display2.setPrefWidth(200);
        display2.setPrefHeight(50);



        Rechner calculator = new Rechner(display);

        GridPane grid = new GridPane();
        GridPane grid2 = new GridPane();


        grid.add(display, 0, 0, 4, 1);
        grid2.add(display2, 0, 0, 4, 1);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "+", "=",
                "C"
        };

        int row = 1;
        int col = 0;

        //benutzte den Synonym "fish" anstatt "text"//

        for (String fish : buttons) {
            Button button = new Button(fish);
            button.setPrefWidth(50);
            button.setPrefHeight(50);
            button.setOnAction(e -> calculator.buttonClick(fish));
            grid.add(button, col, row);
            col++;
            if (col == 4) {
                col = 0;
                row++;
            }
        }

        Scene scene = new Scene(grid, 220, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rechner");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Hello, JavaFX!");
        Scene scene = new Scene(label, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/

/*public class Main {
    public static void main(String[] args){
        System.out.println("hallo");
    }

}*/
