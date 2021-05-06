package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //The FXML loader loads in the graphical elements such as panes and buttons via FXML. Those then have a corrensponding controller and
        // an instance of that is then created. The controller handles modyfying the view(FXML) and contain an instance of model(data).
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root2 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TestFX");
        Scene scene = new Scene(root, 920, 600);
        Scene scene2 = new Scene(root2, 920, 600);
        scene.getStylesheets().add("sample/stylesheet.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
