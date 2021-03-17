package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class UserInterface  extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        URL url= new File("src/main/java/view/sample.fxml").toURI().toURL();
        Parent root= FXMLLoader.load(url);
        primaryStage.setTitle("Polynomial Calculator");
        primaryStage.setScene(new Scene(root, 380, 500));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
        public static void handleButtonAction() {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Message");
            alert.setHeaderText("Please enter a valid polynomial!");
            alert.show();
        }
    public static void showAlertForEmptyTextfields() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message");
        alert.setHeaderText("For the following operation, you need to enter two polynomials!");
        alert.show();
    }
    public static void showAlertForTextField1() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message");
        alert.setHeaderText("Please enter a polynomial in the first text field!");
        alert.show();
    }
    public static void showAlertForDivision() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Message");
        alert.setHeaderText("Division can't be performed because degree (polynomial 1) < degree (polynomial 2)!");
        alert.show();
    }

}