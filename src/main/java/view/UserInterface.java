package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class UserInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL url= new File("src/main/java/view/sample.fxml").toURI().toURL();
        Parent root=FXMLLoader.load(url);
        primaryStage.setTitle("Polynomial Calculator");
        primaryStage.setScene(new Scene (root, 380, 500));
        primaryStage.show();
    }
        /*
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();

         */

    public static void main(String[] args) {
        launch();
    }

}