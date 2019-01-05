package lk.ijse.gdse.computerParts.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.gdse.computerParts.IDgenaretor.IDGenarator;
import lk.ijse.gdse.computerParts.Proxy.ProxyHandeler;
import lk.ijse.gdse.computerParts.dto.ReceptionDTO;
import lk.ijse.gdse.computerParts.service.ServiceFactory;
import lk.ijse.gdse.computerParts.service.custom.ReceptionService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeController implements Initializable {

    @FXML
    private AnchorPane pnlEmploy;

    @FXML
    private TextField textSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private Label lblSearch;

    @FXML
    private TextField textID;

    @FXML
    private TextField textName;

    @FXML
    private TextField textNIC;

    @FXML
    private TextField textAddress;

    @FXML
    private TextField textPhoneNum;

    @FXML
    private PasswordField textPassword;

    @FXML
    private TableView<ReceptionDTO> tblReception;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private Label lblID;

    @FXML
    private Label lblName;

    @FXML
    private Label lblNIC;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblNum;

    @FXML
    private Label lblPassword;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;



  private   ReceptionService receptionService;

    {

        try {
            receptionService= ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.RECEPTION);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        texFealdClear();
        tblLoad();
        loadID();
    }

    private void loadID() {
        String reception_id;
        try {
            reception_id= IDGenarator.getNewID("reception","rid","R");
            textID.setText(reception_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void tblLoad() {
        tblReception.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("rid"));
        tblReception.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblReception.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblReception.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblReception.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("phoneNum"));
        tblReception.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("pasword"));

        try {
            tblReception.setItems(FXCollections.observableArrayList(receptionService.getAllReception()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void texFealdClear() {
        textID.clear();
        textName.clear();
        textAddress.clear();
        textNIC.clear();
        textPhoneNum.clear();
        textPassword.clear();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        ReceptionDTO receptionDTO=new ReceptionDTO(textID.getText(),textName.getText(),textAddress.getText(),Integer.parseInt(textPhoneNum.getText()),textNIC.getText(),textPassword.getText());
        try {
            boolean b=receptionService.addReception(receptionDTO);
            if (b){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Success",ButtonType.OK);
                alert.show();
                texFealdClear();
                tblLoad();
                loadID();


            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Added Success",ButtonType.OK);
                alert.show();
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"not Added",ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        ReceptionDTO receptionDTO=new ReceptionDTO(textID.getText(),textName.getText(),textAddress.getText(),Integer.parseInt(textPhoneNum.getText()),textNIC.getText(),textPassword.getText());
        try {
            boolean b=receptionService.deleteReception(receptionDTO);
          if (b) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION, "Delete  Success", ButtonType.OK);
              alert.show();
              texFealdClear();
              textSearch.clear();
              tblLoad();
              loadID();


          }else {
              Alert alert=new Alert(Alert.AlertType.INFORMATION,"not Success",ButtonType.OK);
              alert.show();
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        try {
            ReceptionDTO receptionDTO=receptionService.searchReception(textSearch.getText());
            if (receptionDTO!=null){
                textID.setText(receptionDTO.getRid());
                textName.setText(receptionDTO.getName());
                textNIC.setText(receptionDTO.getNic());
                textAddress.setText(receptionDTO.getAddress());
                textPhoneNum.setText(""+receptionDTO.getPhoneNum());
                textPassword.setText(receptionDTO.getPasword());
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"invalid Item id");
            alert.show();
            textSearch.clear();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ReceptionDTO receptionDTO=new ReceptionDTO(textID.getText(),textName.getText(),textAddress.getText(),Integer.parseInt(textPhoneNum.getText()),textNIC.getText(),textPassword.getText());
        try {
        boolean b = receptionService.updateReception(receptionDTO);
        if (b){
            Alert alert=new Alert(Alert.AlertType.ERROR,"Update Success");
            alert.show();
            texFealdClear();
            textSearch.clear();
            tblLoad();

        }else {
            Alert alert=new Alert(Alert.AlertType.ERROR," Update Not Success");
            alert.show();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void textAddressOnAction(ActionEvent event) {
        textPhoneNum.requestFocus();
    }

    @FXML
    void textIDOnAction(ActionEvent event) {
        lblID.setVisible(false);
        if (textID.getText().matches("^[rR]{1}[0-9]{3}$")) {
            textName.requestFocus();
        }else {
            textID.clear();
            lblID.setVisible(true);
            lblID.setText("Wrong ID");
            textID.requestFocus();
        }
    }

    @FXML
    void textNICOnAction(ActionEvent event) {
        lblNIC.setVisible(false);
        if (textNIC.getText().matches("^[0-9]{9}[vV]{1}$")){
            textAddress.requestFocus();
        }else{
            textNIC.clear();
            lblNIC.setVisible(true);
            lblNIC.setText("InCorrect NIC");
            textNIC.requestFocus();
        }

    }

    @FXML
    void textNameOnAction(ActionEvent event) {
        lblName.setVisible(false);
        if (textName.getText().matches("^[A-Za-z]*$")){
            textNIC.requestFocus();
        }else{
            textName.clear();
            lblName.setVisible(true);
            lblName.setText("InCorrect Name");
            textName.requestFocus();
        }

    }

    @FXML
    void textPasswordOnAction(ActionEvent event) {
        lblPassword.setVisible(false);
        if (textPassword.getText().matches("^([A-Za-z]*)[0-9]{5}$")){
            btnAdd.requestFocus();

        }else {
            lblPassword.setVisible(true);
            textPassword.clear();
            lblPassword.setText("Wrong Password");
            textPassword.requestFocus();
        }
    }

    @FXML
    void textPhoneNumOnAction(ActionEvent event) {
        lblNum.setVisible(false);
        if (textPhoneNum.getText().matches("^[0-9]{10}$")){
            textPassword.requestFocus();

        }else {
            lblNum.setVisible(true);
            textPhoneNum.clear();
            lblNum.setText("Wrong Number");
            textPhoneNum.requestFocus();
        }
    }

    @FXML
    void textSearchOnAction(ActionEvent event) {
        lblSearch.setVisible(false);
        if (textSearch.getText().matches("^[rR]{1}[0-9]{3}$")){
        btnSearch.requestFocus();
        }else{
            textSearch.clear();
            lblSearch.setVisible(true);
            lblSearch.setText("InCorrect Reception Id");
            textSearch.requestFocus();

        }
    }

}
