package lk.ijse.gdse.computerParts.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.gdse.computerParts.IDgenaretor.IDGenarator;
import lk.ijse.gdse.computerParts.Proxy.ProxyHandeler;
import lk.ijse.gdse.computerParts.dto.ItemDTO;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.service.ServiceFactory;
import lk.ijse.gdse.computerParts.service.custom.ItemService;

import java.net.URL;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ItemController implements Initializable, Observer, Remote {



    @FXML
    private TableView<ItemDTO> tblItem;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TextField textItemCode;

    @FXML
    private TextField textItemName;

    @FXML
    private TextField textItemQty;

    @FXML
    private TextField textItemUnitPrice;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TextField textItemSearch;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private TextField textBrandName;

    @FXML
    private TextArea textDescription;

    @FXML
    private Label lblCode;

    @FXML
    private Label lblName;

    @FXML
    private Label lblBrand;

    @FXML
    private Label lblQty;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblSearch;





    private ItemService itemService;


    {
        try {
            itemService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.ITEM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            UnicastRemoteObject.exportObject(this,0);
            itemService.register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        clearTexFeild();
        loadItem();
        loadID();

    }

    private void loadID() {
        String Item_id;
        try {
            Item_id= IDGenarator.getNewID("item","iid","I");
            textItemCode.setText(Item_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadItem() {
        tblItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("iid"));
        tblItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("itemBrand"));
        tblItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("discription"));
        tblItem.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblItem.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        try {
            tblItem.setItems(FXCollections.observableArrayList(itemService.getAllItem()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearTexFeild() {
        textItemCode.clear();
        textItemName.clear();
        textBrandName.clear();
        textItemQty.clear();
        textItemUnitPrice.clear();
        textDescription.clear();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        textItemCode.requestFocus();

        ItemDTO itemDTO=new ItemDTO(textItemCode.getText(),textItemName.getText(),textBrandName.getText(),textDescription.getText(),Integer.parseInt(textItemQty.getText()),Double.parseDouble(textItemUnitPrice.getText()));
        try {
            boolean b = itemService.addItem(itemDTO);
            if (b){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Add", ButtonType.OK);
                alert.show();
                clearTexFeild();
                loadItem();
                loadID();


            }else {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"failed add", ButtonType.OK);
                alert.show();
            }

        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"Duplicate ID Pleas check the ID ", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        textItemCode.requestFocus();

        ItemDTO itemDTO=new ItemDTO(textItemCode.getText(),textItemName.getText(),textBrandName.getText(),textDescription.getText(),Integer.parseInt(textItemQty.getText()),Double.parseDouble(textItemUnitPrice.getText()));
        try {
            boolean b=itemService.deleteItem(itemDTO);
            if (b){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Delete Item",ButtonType.OK);
                alert.show();
                clearTexFeild();
                loadItem();
                loadID();


            }else {
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Delete Failed",ButtonType.OK);
                alert.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        textItemCode.requestFocus();
        try {
            ItemDTO itemDTO=itemService.searchItem(textItemSearch.getText());
            if (itemDTO!=null){
                textItemCode.setText(itemDTO.getIid());
                textItemName.setText(itemDTO.getItemName());
                textBrandName.setText(itemDTO.getItemBrand());
                textItemQty.setText(""+itemDTO.getQty());
                textItemUnitPrice.setText(""+itemDTO.getUnitPrice());
                textDescription.setText(itemDTO.getDiscription());
            }

        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.ERROR,"invalid Item id");
            alert.show();
            textItemSearch.clear();
        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
    ItemDTO itemDTO=new ItemDTO(textItemCode.getText(),textItemName.getText(),textBrandName.getText(),textDescription.getText(),Integer.parseInt(textItemQty.getText()),Double.parseDouble(textItemUnitPrice.getText()));
    try {
        boolean b=itemService.updateItem(itemDTO);
        if (b){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Update Item",ButtonType.OK);
            alert.show();
            clearTexFeild();
            textItemSearch.clear();
            loadItem();

        }else {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Update Failed",ButtonType.OK);
            alert.show();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }


    public void textItemCodeOnAction(ActionEvent actionEvent) {
        lblCode.setVisible(false);
        if (textItemCode.getText().matches("^[iI]{1}[0-9]{3}")) {
            textItemName.requestFocus();
        }else {
            textItemCode.clear();
            lblCode.setVisible(true);
            lblCode.setText("Wrong ID");
            textItemCode.requestFocus();
        }
    }

    public void textItemNameOnAction(ActionEvent actionEvent) {
        lblName.setVisible(false);
        if (textItemName.getText().matches("^[a-zA-Z]*$")) {
            textBrandName.requestFocus();
        }else {
            textItemName.clear();
            lblName.setVisible(true);
            lblName.setText("Wrong Name");
            textItemName.requestFocus();
        }
    }

    public void textItemQtyOnAction(ActionEvent actionEvent) {
        lblQty.setVisible(false);
        if (textItemQty.getText().matches("^[0-9]*$")){
            textItemUnitPrice.requestFocus();
        }else {
            textItemQty.clear();
            lblQty.setVisible(true);
            lblQty.setText("Wrong Input");
//            textItemQty.selectAll();
            textItemQty.requestFocus();
        }
    }

    public void textItemUnitPriceOnAction(ActionEvent actionEvent) {
        lblPrice.setVisible(false);
        if (textItemUnitPrice.getText().matches("^[0-9]*$")){
            textDescription.requestFocus();

        }else {
            textItemUnitPrice.clear();
            lblPrice.setVisible(true);
            lblPrice.setText("Wrong Input.");
            textItemUnitPrice.requestFocus();
        }
    }

    public void textItemSearchOnAction(ActionEvent actionEvent) {
        lblSearch.setVisible(false);
        if (textItemSearch.getText().matches("^[iI]{1}[0-9]{3}")) {
            btnSearch.requestFocus();
        }else{
            textItemSearch.clear();
            lblSearch.setVisible(true);
            lblSearch.setText("Invalid ID");
            textItemSearch.requestFocus();
        }
    }

    public void textDescriptionOnAction(MouseEvent mouseEvent) {
        btnAdd.requestFocus();
    }

    public void textBrandNameOnAction(ActionEvent actionEvent) {
        lblBrand.setVisible(false);
        if (textBrandName.getText().matches("^[A-Za-z]*$")) {
            textItemQty.requestFocus();
        }else {
            textBrandName.clear();
            lblBrand.setVisible(true);
            lblBrand.setText("Brand name Wrong");
            textBrandName.requestFocus();
        }
    }

    @Override
    public void update(String message) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(()->{

                });
            }
        }).start();
    }
}
