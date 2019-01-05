package lk.ijse.gdse.computerParts.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.gdse.computerParts.Proxy.ProxyHandeler;
import lk.ijse.gdse.computerParts.dto.ReceptionDTO;
import lk.ijse.gdse.computerParts.service.ServiceFactory;
import lk.ijse.gdse.computerParts.service.custom.ReceptionService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReceptionLoginController implements Initializable {

    @FXML
    private TextField textName;

    @FXML
    private PasswordField textPw;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private Label lblMassage;

    ReceptionService receptionService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            receptionService= ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.RECEPTION);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        lblMassage.setVisible(false);
        try {
            List<ReceptionDTO>all=receptionService.getAllReception();
            for (ReceptionDTO a: all){
                String name=textName.getText();
                String pw=textPw.getText();
                if (name .equals(a.getName())&& pw.equals(a.getPasword())){

                    Parent parent= FXMLLoader.load(getClass().getResource("/lk/ijse/gdse/computerParts/views/Order.fxml"));
                    Node node=(Node)event.getSource();
                    Stage stage=(Stage)node.getScene().getWindow();

                    Scene scene=new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                    stage.centerOnScreen();

                    textName.clear();
                    textPw.clear();
                }else {
                    lblMassage.setVisible(true);
                    lblMassage.setText("Error in username password combination!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void textNameOnActin(ActionEvent event) {
        textPw.requestFocus();

    }

    @FXML
    void textPwOnAction(ActionEvent event) {
        btnLogin.requestFocus();

    }


}
