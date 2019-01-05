package lk.ijse.gdse.computerParts.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Admin extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/computerParts/views/AdminLgin.fxml"));
        Scene scene=new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
