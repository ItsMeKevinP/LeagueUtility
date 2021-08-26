package kmpleague.com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;


public class SummonerStatsController extends Application {

    public static void showJFX(){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        URL fxmlLocation = Main.class.getResource("/summonerStats.fxml");
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        loader.setLocation(fxmlLocation);

        VBox vbox = loader.load();
        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.show();
    }
}
