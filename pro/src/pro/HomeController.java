/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pro;

import java.io.IOException;
import java.sql.*;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class HomeController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private TableView<MedData> table_medicines;

    @FXML
    private TableColumn<MedData, String> co_id;
    
    @FXML
    private TableColumn<MedData, String> co_name;

    @FXML
    private TableColumn<MedData, String> co_company;
    

    @FXML
    private TableColumn<MedData, String> co_arrival;
    
    @FXML
    private TableColumn<MedData, String> co_expire;

    
    @FXML
    private TableColumn<MedData, String> co_price;


    @FXML
    private TableColumn<MedData, String> co_quantity;


    @FXML
    private TextField hidtxt;


    @FXML
    private Button searchbtn;

     
    @FXML
    private Button viewbtn;

    @FXML
    private Button medhome;

    
    @FXML
    private Button viewbills;
    
    @FXML
    private Button logoutbtn;

    
    @FXML
    void medaction(ActionEvent event) {
        try {
            medhome.getScene().getWindow().hide();
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("MedicineHome.fxml"));
            Parent root =(Parent) fxmlLoader.load() ;
            Stage stage=new Stage();
            Scene sc = new Scene(root);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
        }

    }

    @FXML
    void VIewBillsAction(ActionEvent event) {
        try {
             viewbtn.getScene().getWindow().hide();
             FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("ViewBills.fxml"));
             Parent root =(Parent) fxmlLoader.load() ;
             Stage stage=new Stage();
             Scene sc = new Scene(root);
             stage.setScene(sc);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(MedicineHomeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @FXML
    void searchaction(ActionEvent event) {
        ObservableList<MedData> ListM;
        co_id.setCellValueFactory(new PropertyValueFactory<MedData,String>("id"));
        co_name.setCellValueFactory(new PropertyValueFactory<MedData,String>("name"));
        co_company.setCellValueFactory(new PropertyValueFactory<MedData,String>("company"));
        co_arrival.setCellValueFactory(new PropertyValueFactory<MedData,String>("arrival_date"));
        co_expire.setCellValueFactory(new PropertyValueFactory<MedData,String>("expire_date"));
        co_price.setCellValueFactory(new PropertyValueFactory<MedData,String>("price"));
        co_quantity.setCellValueFactory(new PropertyValueFactory<MedData,String>("quantity"));
        ListM=ViewInTable.getData("SELECT * FROM `medicine` where id='"+hidtxt.getText()+"'");        
        table_medicines.setItems(ListM);
    }
    @FXML
    void viewaction(ActionEvent event) {
        ObservableList<MedData> ListM;
        co_id.setCellValueFactory(new PropertyValueFactory<MedData,String>("id"));
        co_name.setCellValueFactory(new PropertyValueFactory<MedData,String>("name"));
        co_company.setCellValueFactory(new PropertyValueFactory<MedData,String>("company"));
        co_arrival.setCellValueFactory(new PropertyValueFactory<MedData,String>("arrival_date"));
        co_expire.setCellValueFactory(new PropertyValueFactory<MedData,String>("expire_date"));
        co_price.setCellValueFactory(new PropertyValueFactory<MedData,String>("price"));
        co_quantity.setCellValueFactory(new PropertyValueFactory<MedData,String>("quantity"));
        ListM=ViewInTable.getData("SELECT * FROM `medicine`");        
        table_medicines.setItems(ListM);

    }

    @FXML
    void logout(ActionEvent event) {
        try {
            logoutbtn.getScene().getWindow().hide();
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root =(Parent) fxmlLoader.load() ;
            Stage stage=new Stage();
            Scene sc = new Scene(root);
            stage.setScene(sc);
            stage.show();
        } catch (Exception e) {
        }
    }

    


    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }    
    
}
