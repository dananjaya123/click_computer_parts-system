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
import lk.ijse.gdse.computerParts.Other.PasswordUtil;
import lk.ijse.gdse.computerParts.Proxy.ProxyHandeler;
import lk.ijse.gdse.computerParts.dto.UserSettiongDTO;
import lk.ijse.gdse.computerParts.service.ServiceFactory;
import lk.ijse.gdse.computerParts.service.custom.UserSettingService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {

    @FXML
    private TextField textName;

    @FXML
    private PasswordField textPw;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private Label lblMassage;

    private UserSettingService userSettingService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            userSettingService= ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        lblMassage.setVisible(false);
        try {
            List<UserSettiongDTO>all=userSettingService.getAllUser();
            for (UserSettiongDTO a:all){
                boolean passwordMatch= PasswordUtil.verifyUserPassword(textPw.getText(),a.getPassword(),a.getSolt());
                if (passwordMatch && textName.getText().equals(a.getName())){

                    Parent parent= FXMLLoader.load(getClass().getResource("/lk/ijse/gdse/computerParts/views/AdminHome.fxml"));
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
