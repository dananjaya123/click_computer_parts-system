package lk.ijse.gdse.computerParts.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import lk.ijse.gdse.computerParts.IDgenaretor.IDGenarator;
import lk.ijse.gdse.computerParts.Proxy.ProxyHandeler;
import lk.ijse.gdse.computerParts.css.OtherMethord;
import lk.ijse.gdse.computerParts.dto.*;
import lk.ijse.gdse.computerParts.observer.Observer;
import lk.ijse.gdse.computerParts.service.ServiceFactory;
import lk.ijse.gdse.computerParts.service.custom.*;

import java.io.IOException;
import java.net.URL;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class OrderController implements Initializable, Observer, Remote {

    @FXML
    private JFXButton btnCustomerCall;

    @FXML
    private ImageView imgeCaller;

    @FXML
    private TextField textPaymentId;

    @FXML
    private TextField textSearch;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblReceptionId;

    @FXML
    private TextField textCustomerID;

    @FXML
    private TextField textCustomerName;

    @FXML
    private TextField textCustomerAddress;

    @FXML
    private TextField textPhoneNum;

    @FXML
    private ComboBox<String> comboItemName;
    @FXML
    private TextField textItemCode;

    @FXML
    private TextField textItemBrand;

    @FXML
    private TextArea textDescription;

    @FXML
    private TextField textItemqty;

    @FXML
    private TextField textUnitPrice;

    @FXML
    private TextField textTotal;

    @FXML
    private TextField textOid;

    @FXML
    private TableView<OrderDetailsDTO> tblSelectItem;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnCloseOrder;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableView<ItemDTO> tblComputerParts;

    @FXML
    private JFXButton btnPay;
    @FXML
    private TableView<OrdersDTO> tblOder;

    @FXML
    private TextField textPayment;

    @FXML
    private TextField textBalance;


    @FXML
    private JFXComboBox<String> comboReceptionID;

    @FXML
    private Label lblCustID;

    @FXML
    private Label lblCustName;


    @FXML
    private Label lblPhoneNumber;

    @FXML
    private Label lblQTY;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblOID;

    @FXML
    private Label lblPID;

    @FXML
    private Label lblPayment;


    double unitPrice=0;
    double total=0;

    private CustomerService customerService;
    private ItemService itemService;
    private PaymentService paymentService;
    private OrderDetailsService orderDetailsService;
    private OrderService orderService;
    private ReceptionService receptionService;



    {
        try {
            customerService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.CUSTOMER);
            itemService = ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.ITEM);
            paymentService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.PAYMENT);
            orderDetailsService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.ORDERdETAILS);
            orderService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.ODER);
            receptionService=ProxyHandeler.getInstance().getSuperService(ServiceFactory.ServiceTypes.RECEPTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            UnicastRemoteObject.exportObject(this,0);
            itemService.register(this);
            receptionService.register(this);
            orderService.register(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
            loadCombo();
            loadItemTable();
            loadDate();
            loadOrderTable();
            receptionComboLoad();
            loadId();

    }

    private void loadId() {
        String cid;
        String oid;
        String pid;


        try {
            cid= IDGenarator.getNewID("customer","cid","C");
            oid=IDGenarator.getNewID("orders","oid","O");
            pid=IDGenarator.getNewID("payment","pid","P");

            textCustomerID.setText(cid);
            textOid.setText(oid);
            textPaymentId.setText(pid);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void loadOrderTable() {
        tblOder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("oid"));
        tblOder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblOder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblOder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("pid"));
        tblOder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("rid"));
        tblOder.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("status"));

        try {
            tblOder.setItems(FXCollections.observableArrayList(orderService.getAllOder()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void loadItemTable() {
        tblComputerParts.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("iid"));
        tblComputerParts.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("itemName"));
        tblComputerParts.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblComputerParts.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        try {
            tblComputerParts.setItems(FXCollections.observableArrayList(itemService.getAllItem()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void receptionComboLoad() {
        try {
            List<ReceptionDTO> receptionDTOS = receptionService.getAllReception();
            ArrayList<String> reception = new ArrayList<>();
            for (ReceptionDTO receptionDTO : receptionDTOS) {
                reception.add(receptionDTO.getRid());
            }
            for (String s : reception) {
                comboReceptionID.getItems().add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadCombo()  {

        try {
            List<ItemDTO>itemDTOS=itemService.getAllItem();
            ArrayList<String>item=new ArrayList<>();
            for (ItemDTO itemDTO :itemDTOS) {
                item.add(itemDTO.getItemName());
            }
            for (String f:item){
                comboItemName.getItems().add(f);
                comboItemName.getSelectionModel().clearSelection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        textPayment.requestFocus();
        OrderDetailsDTO orderDetailsDTO=new OrderDetailsDTO(textOid.getText(),textItemCode.getText(),Integer.parseInt(textItemqty.getText()),Double.parseDouble(textUnitPrice.getText()));

        tblSelectItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("oid"));
        tblSelectItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("iid"));
        tblSelectItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblSelectItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblSelectItem.getItems().addAll(orderDetailsDTO);

        total+=unitPrice;
        textTotal.setText(total+"");



        textItemCode.clear();
        textItemBrand.clear();
        textItemqty.clear();
        textDescription.clear();
        textUnitPrice.clear();
        textSearch.clear();
      //  comboItemName.getSelectionModel().clearSelection();

    }

    @FXML
    void btnCustomerCallEntered(MouseEvent event) {

    }

    @FXML
    void btnCustomerCallExited(MouseEvent event) {
        OtherMethord.imageDashboard(imgeCaller,1.0);

    }

    @FXML
    void btnCustomerCallExntered(MouseEvent event) {
        OtherMethord.imageDashboard(imgeCaller,1.3);
    }

    @FXML
    void btnCustomerCallOnActin(ActionEvent event) {
        try {
            CustomerDTO customerDTO=customerService.searshCustomer(textSearch.getText());
            if (customerDTO!=null){
                textCustomerID.setText(customerDTO.getCid());
                textCustomerName.setText(customerDTO.getCustName());
                textCustomerAddress.setText(customerDTO.getCustAddress());
                textPhoneNum.setText(""+customerDTO.getPhoneNum());
                comboItemName.requestFocus();
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Pleas enter Customer ID ", ButtonType.OK);
            alert.show();
        }
    }

    @FXML
    void btnCloseOrderOnAction(ActionEvent event) {
        CustomerDTO customerDTO=new CustomerDTO(textCustomerID.getText(),textCustomerName.getText(),textCustomerAddress.getText(),Integer.parseInt(textPhoneNum.getText()));
        try {
            boolean b = customerService.deleteCustomer(customerDTO);
            if (b){
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Close Oder",ButtonType.OK);
                alert.show();

            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"Close Oder",ButtonType.OK);
                alert.show();
                textCustomerName.clear();
                textCustomerAddress.clear();
                textPhoneNum.clear();

                textItemCode.clear();
                textItemqty.clear();
                textItemBrand.clear();
                textDescription.clear();
                textUnitPrice.clear();
                textPayment.clear();
                textBalance.clear();
                textTotal.clear();

                tblSelectItem.getItems().clear();
                textCustomerName.requestFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    String status="Payment Success";
    @FXML
    void btnPayOnAction(ActionEvent event) {
        PaymentDTO paymentDTO=new PaymentDTO(textPaymentId.getText(),Double.parseDouble(textTotal.getText()),new Date());
        OrdersDTO ordersDTO=new OrdersDTO(textOid.getText(),new Date(),status,textCustomerID.getText(),textPaymentId.getText(),lblReceptionId.getText());

        List<OrderDetailsDTO>orderDetailsDTOS=new ArrayList<>();
        for (int i=0;i<tblSelectItem.getItems().size();i++){
            String orderId=(String)tblSelectItem.getColumns().get(0).getCellObservableValue(i).getValue();
            String itemId=(String)tblSelectItem.getColumns().get(1).getCellObservableValue(i).getValue();
            int qty=(Integer)tblSelectItem.getColumns().get(2).getCellObservableValue(i).getValue();
            double unitPrice=(Double)tblSelectItem.getColumns().get(3).getCellObservableValue(i).getValue();

            orderDetailsDTOS.add(new OrderDetailsDTO(orderId,itemId,qty,unitPrice,Double.parseDouble(textTotal.getText())));
        }
        CommenDTO commenDTO=new CommenDTO(ordersDTO,paymentDTO,orderDetailsDTOS);
        try {
            boolean b=orderService.addOder(commenDTO);
            if (b){
                loadId();
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"added Success",ButtonType.OK);
                alert.show();
                loadOrderTable();
                loadItemTable();
                textCustomerName.requestFocus();


                textPayment.clear();
                textBalance.clear();
                textTotal.clear();



                textCustomerName.clear();
                textCustomerAddress.clear();
                textPhoneNum.clear();

                tblSelectItem.getItems().clear();

            }else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION,"not Added",ButtonType.OK);
                alert.show();
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.INFORMATION,"Pleas check ",ButtonType.OK);
            alert.show();

        }
    }

    @FXML
    void btnUpdateOnActiojn(ActionEvent event) {

    }

    int qty=0;

    @FXML
     void comboItemNameOnAction(ActionEvent event) {
        textItemqty.requestFocus();

        String id=comboItemName.getSelectionModel().getSelectedItem();
        try {
            List<ItemDTO>all=itemService.getAllItem();
            for (ItemDTO itemDTO:all){
                if (id.equalsIgnoreCase(itemDTO.getItemName())){
                    textItemCode.setText(itemDTO.getIid());
                    textItemBrand.setText(itemDTO.getItemBrand());
                    textDescription.setText(itemDTO.getDiscription());
                    textUnitPrice.setText(""+itemDTO.getUnitPrice());
                    qty=itemDTO.getQty();

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void comboReceptionIDOnAction(ActionEvent actionEvent) {
        textCustomerName.requestFocus();
        String id=comboReceptionID.getSelectionModel().getSelectedItem();
        try {
            List<ReceptionDTO>all=receptionService.getAllReception();
            for (ReceptionDTO receptionDTO:all){
                if(id.equalsIgnoreCase(receptionDTO.getRid())){
                    lblReceptionId.setText(receptionDTO.getRid());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void lblDateOnAction(MouseEvent event) {

    }

    @FXML
    void textCustomerAddressOnaction(ActionEvent event) {
        textPhoneNum.requestFocus();
    }

    @FXML
    void textCustomerIDOnAction(ActionEvent event) {
        lblCustID.setVisible(false);
        if (textCustomerID.getText().matches("^[cC]{1}[0-9]{3}")) {
//            textCustomerName.requestFocus();
        }else{
            textCustomerID.clear();
            lblCustID.setVisible(true);
            lblCustID.setText("Invalid ID");
            textCustomerID.requestFocus();
        }

    }

    @FXML
    void textCustomerNameOnAction(ActionEvent event) {
        String selectedItem = comboReceptionID.getSelectionModel().getSelectedItem();
        if (selectedItem==null){
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION,"Enter Reception ID");
            alert.show();
        }else {
            lblCustName.setVisible(false);
            if (textCustomerName.getText().matches("^[a-zA-Z]*$")) {
                textCustomerAddress.requestFocus();
            }else {
                textCustomerName.clear();
                lblCustName.setVisible(true);
                lblCustName.setText("Invalid name");
                textCustomerName.requestFocus();
            }
        }
    }

    @FXML
    void textDescriptionOnAction(MouseEvent event) {

    }

    @FXML
    void textItemBrandOnAction(ActionEvent event) {

    }

    @FXML
    void textItemCodeOnActon(ActionEvent event) {

    }

    @FXML
    void textItemqtyOnAction(ActionEvent event) {
        lblQTY.setVisible(false);
        int textQty= Integer.parseInt(textItemqty.getText());
       if (qty<=2 ||textQty>qty){
           Alert alert=new Alert(Alert.AlertType.ERROR,qty +"  "+"item count is low! Pleas add item",ButtonType.OK);
           alert.show();
       }else {
           if (textItemqty.getText().matches("^[0-9]*$")) {
               double amunt = Double.parseDouble(textUnitPrice.getText()) * Integer.parseInt(textItemqty.getText());
               unitPrice = amunt;
               textUnitPrice.setText(unitPrice + "");

               btnAdd.requestFocus();

           }else {
               textItemqty.clear();
               lblQTY.setVisible(true);
               lblQTY.setText("Wrong Input");
               textItemqty.requestFocus();
           }
       }
    }

    @FXML
    void textPhoneNumOnActon(ActionEvent event) {
        lblPhoneNumber.setVisible(false);
        if (textPhoneNum.getText().matches("^[0-9]{10}$")) {
            comboItemName.requestFocus();
            CustomerDTO customerDTO = new CustomerDTO(textCustomerID.getText(), textCustomerName.getText(), textCustomerAddress.getText(), Integer.parseInt(textPhoneNum.getText()));
            try {
                boolean b = customerService.addCustomer(customerDTO);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Customer ID Duplicate ", ButtonType.OK);
                alert.show();
            }
        }else {
            textPhoneNum.clear();
            lblPhoneNumber.setVisible(true);
            lblPhoneNumber.setText("Invalid Number");
            textPhoneNum.requestFocus();
        }
    }

    @FXML
    void textSearchOnAction(ActionEvent event) {
        try {
            CustomerDTO customerDTO=customerService.searshCustomer(textSearch.getText());
            if (customerDTO!=null){
                textCustomerID.setText(customerDTO.getCid());
                textCustomerName.setText(customerDTO.getCustName());
                textCustomerAddress.setText(customerDTO.getCustAddress());
                textPhoneNum.setText(""+customerDTO.getPhoneNum());
            }
        } catch (Exception e) {
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Pleas enter Customer ID ", ButtonType.OK);
            alert.show();
        }

    }

    @FXML
    void textTotalOnAction(ActionEvent event) {

    }

    @FXML
    void textUnitPriceOnAction(ActionEvent event) {

    }
    private void loadDate() {
        Timeline time = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lblDate.setText(new SimpleDateFormat("YYYY-MM-dd").format(new Date()));
            }
        }), new KeyFrame(Duration.seconds(1)));
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void textPaymentOnAction(ActionEvent actionEvent) {
        lblPayment.setVisible(false);
        if (textPayment.getText().matches("^[0-9]*$")) {
            btnPay.requestFocus();


            double payment = 0;
            double balance = 0;

            payment = Double.parseDouble(textPayment.getText());

            balance = payment - total;

            if (total <= payment) {
                textBalance.setText("" + balance);
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Payment is insufficient");
                alert.show();
            }
        }else {
            textPayment.clear();
            lblPayment.setVisible(true);
            lblPayment.setText("Invalid");
            textPayment.requestFocus();
        }
    }

    public void textBalanceOnAction(ActionEvent actionEvent) {
    }

    public void textOidOnAction(ActionEvent actionEvent) {
        lblOID.setVisible(false);
        if (textOid.getText().matches("^[oO]{1}[0-9]{3}")){
//            textPaymentId.requestFocus();

        }else {
            textOid.clear();
            lblOID.setVisible(true);
            lblOID.setText("Invalid ID");
            textOid.requestFocus();
        }
    }

    public void textPaymentIdOnAction(ActionEvent actionEvent) {
        lblPID.setVisible(false);
        if (textPaymentId.getText().matches("^[pP]{1}[0-9]{3}")){
//            textCustomerID.requestFocus();

        }else {
            textPaymentId.clear();
            lblPID.setVisible(true);
            lblPID.setText("Invalid id");
            textPaymentId.requestFocus();
        }
    }


    @Override
    public void update(String message) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    loadCombo();
                    receptionComboLoad();
                    loadItemTable();
                    loadOrderTable();

                });
            }
        }).start();
    }



}
