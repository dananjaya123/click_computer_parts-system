package lk.ijse.gdse.computerParts.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeController implements Initializable {

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private ImageView imageDashboard;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnEmploy;

    @FXML
    private JFXButton btnSetting;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private JFXButton btnReport;

    @FXML
    private Label lblDate;

    @FXML
    private AnchorPane pnlMain;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void btnDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmployOnAction(ActionEvent event) throws IOException {
        AnchorPane pane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/computerParts/views/Employ.fxml"));
        pnlMain.getChildren().setAll(pane);

    }

    @FXML
    void btnItemOnAction(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/computerParts/views/Item.fxml"));
        pnlMain.getChildren().setAll(pane);

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

    }

    @FXML
    void btnReportOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    void btnSettingOnAction(ActionEvent event) throws IOException {

    }


    public void btnSettingOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane=FXMLLoader.load(this.getClass().getResource("/lk/ijse/gdse/computerParts/views/UserSeting.fxml"));
        popup.modalset(pane,mouseEvent);
    }

    //        ==============Customer Popup================
    public static class popup {

        public  static void modalset(Parent modalWindow, MouseEvent event) throws IOException {
            Window theStage = ((Node) event.getSource()).getScene().getWindow();
            FadeTransition ft = new FadeTransition(Duration.millis(500), modalWindow);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            Stage dialog = new Stage();
            Scene scene = new Scene(modalWindow);

            dialog.setScene(scene);
            dialog.initOwner(theStage);
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.centerOnScreen();
            dialog.showAndWait();
        }


    }

}
