package at.ac.hcw.fhplay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("main-view.fxml"));
        Scene scene = new Scene(loader.load(), 1000, 650);
        scene.getStylesheets().add(App.class.getResource("style.css").toExternalForm());

        stage.setTitle("fh-play");
        stage.setMinWidth(700);
        stage.setMinHeight(450);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
