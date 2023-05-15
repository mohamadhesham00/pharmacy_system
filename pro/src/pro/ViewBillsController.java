/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pro;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class ViewBillsController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TableColumn<billData,String> co_price;

    @FXML
    private TableView<billData> table_bills;

    @FXML
    private Button backbtn;

    @FXML
    private TableColumn<billData,String> co_id;

    @FXML
    private TableColumn<billData,String> co_amount;

    @FXML
    private Button view_bdata;

    @FXML
    private TableColumn<billData,String> co_medicineid;

    @FXML
    private TableColumn<billData,String> co_date;

    @FXML
    private TableColumn<billData,String> co_number;

    @FXML
    private TableColumn<billData,String> co_name;

    @FXML
    void ViewBDataAction(ActionEvent event) {
        ObservableList<billData> ListM;
        co_id.setCellValueFactory(new PropertyValueFactory<billData,String>("id"));
        co_name.setCellValueFactory(new PropertyValueFactory<billData,String>("customer_name"));
        co_number.setCellValueFactory(new PropertyValueFactory<billData,String>("customer_number"));
        co_date.setCellValueFactory(new PropertyValueFactory<billData,String>("date"));
        co_medicineid.setCellValueFactory(new PropertyValueFactory<billData,String>("medicine_id"));
        co_amount.setCellValueFactory(new PropertyValueFactory<billData,String>("amount"));
        co_price.setCellValueFactory(new PropertyValueFactory<billData,String>("price"));
        ListM=ViewInTable.getBill("SELECT * FROM `bill`");
        
       table_bills.setItems(ListM);
    
    }

    @FXML
    void backaction(ActionEvent event) {
        try {
             backbtn.getScene().getWindow().hide();
             FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("home.fxml"));
             Parent root =(Parent) fxmlLoader.load() ;
             Stage stage=new Stage();
             Scene sc = new Scene(root);
             stage.setScene(sc);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(MedicineHomeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
