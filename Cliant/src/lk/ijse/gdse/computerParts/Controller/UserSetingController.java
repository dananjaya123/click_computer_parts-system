package lk.ijse.gdse.computerParts.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.computerParts.Other.PasswordUtil;
import lk.ijse.gdse.computerParts.Proxy.ProxyHandeler;
import lk.ijse.gdse.computerParts.dto.UserSettiongDTO;
import lk.ijse.gdse.computerParts.service.ServiceFactory;
import lk.ijse.gdse.computerParts.service.custom.UserSettingService;

import java.net.URL;

import java.util.ResourceBundle;

public class UserSetingController implements Initializable {

    @FXML
    private AnchorPane pnlSetting;

    @FXML
    private Label lblMassage;

    @FXML
    private TextField textUserName;

    @FXML
    private PasswordField textPW;

    @FXML
    private JFXButton btnAdd;

    private UserSettingService userSettingService;
    {
        try {
            userSettingService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.USER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    @FXML
    void btnAddOnaction(ActionEvent event) {


        String usarname=textUserName.getText();
        String password=textPW.getText();
        String slt=PasswordUtil.getSalt(30);

        try {
            String pw=PasswordUtil.generateSecurePassword(password,slt);
            UserSettiongDTO userSettiongDTO=new UserSettiongDTO(usarname,pw,slt);

            boolean b=userSettingService.addUser(userSettiongDTO);
            if (b){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION," add", ButtonType.OK);
                alert.show();
                textUserName.clear();
                textPW.clear();
            }else {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION," not added", ButtonType.OK);
                alert.show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void textUserNameOnAction(ActionEvent event) {
        textPW.requestFocus();

    }

    @FXML
    void textpwOnAction(ActionEvent event) {
        btnAdd.requestFocus();

    }


}
