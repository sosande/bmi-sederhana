package bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // 1. Muat tampilan dari file bmi.fxml (file ini diedit di Scene Builder)
        Parent root = FXMLLoader.load(getClass().getResource("bmi.fxml"));

        // 2. Tampilkan di jendela
        stage.setTitle("Kalkulator BMI");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
