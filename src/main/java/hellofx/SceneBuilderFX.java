package hellofx;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneBuilderFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {
    	stage.setTitle("Blue Marble");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("layout.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}