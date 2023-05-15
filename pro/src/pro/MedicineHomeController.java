/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pro;


import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MedicineHomeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField name_txt;
    
    @FXML
    private TextField price_txt;
    
    @FXML
    private TextField expire_txt;

    @FXML
    private TextField id_txt;

    @FXML
    private TextField quantity_txt;
    
    @FXML
    private TextField company_txt;
    
    @FXML
    private TextField arrival_txt;

      
     @FXML
    private TableColumn<MedData, String> co_expire;

    @FXML
    private TableColumn<MedData, String> co_price;

    @FXML
    private TableColumn<MedData, String> co_company;
    
     @FXML
    private Button clearbtn;
    
    @FXML
    private Button backbtn;

    @FXML
    private TableColumn<MedData, String> co_id;

    @FXML
    private TableColumn<MedData, String> co_quantity;

    @FXML
    private Button update;

    @FXML
    private TableColumn<MedData, String> co_arrival;

    @FXML
    private TableView<MedData> table_medicine;

    @FXML
    private Button v_btn;
    
    @FXML
    private Button addbtn;

    @FXML
    private Button deletebtn;

    @FXML
    private TableColumn<MedData, String> co_name;
    
    public void updated(){
        ObservableList<MedData> ListM;
        co_id.setCellValueFactory(new PropertyValueFactory<MedData,String>("id"));
        co_name.setCellValueFactory(new PropertyValueFactory<MedData,String>("name"));
        co_company.setCellValueFactory(new PropertyValueFactory<MedData,String>("company"));
        co_arrival.setCellValueFactory(new PropertyValueFactory<MedData,String>("arrival_date"));
        co_expire.setCellValueFactory(new PropertyValueFactory<MedData,String>("expire_date"));
        co_price.setCellValueFactory(new PropertyValueFactory<MedData,String>("price"));
        co_quantity.setCellValueFactory(new PropertyValueFactory<MedData,String>("quantity"));
        ListM=ViewInTable.getData("SELECT * FROM `medicine`");
        
       table_medicine.setItems(ListM);
    }
    @FXML
    void v_btn(ActionEvent event) {
        updated();
    }
    
    public void clearData(){
        id_txt.setText("");
        name_txt.setText("");
        company_txt.setText("");
        arrival_txt.setText("");
        expire_txt.setText("");
        price_txt.setText("");
        quantity_txt.setText("");
    }
    @FXML
    void clear(ActionEvent event) {
        clearData();
    }

    @FXML
    void addaction(ActionEvent event) throws SQLException {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/pharmacy","test","test");
             PreparedStatement test=connect.prepareStatement("select * from medicine where id='"+id_txt.getText()+"'");
             ResultSet rstest=test.executeQuery();
             if(rstest.next()){
                 JOptionPane.showMessageDialog(null, "Please enter a valid id");
             }
             else{
                 PreparedStatement pst=connect.prepareStatement("insert into medicine (id,name,company,arrival_date,expire_date,price,quantity)values (?,?,?,?,?,?,?)");
                 pst.setString(1, id_txt.getText());
                 pst.setString(2, name_txt.getText());
                 pst.setString(3, company_txt.getText());
                 pst.setString(4, arrival_txt.getText());
                 pst.setString(5, expire_txt.getText());
                 pst.setString(6, price_txt.getText());
                 pst.setString(7, quantity_txt.getText());
                 boolean rs=pst.execute();
                 JOptionPane.showMessageDialog(null, "successfully added");
                 clearData();
                 updated();
                 
             }
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(MedicineHomeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @FXML
    void updateaction(ActionEvent event) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/pharmacy","test","test");
            PreparedStatement pst=connect.prepareStatement("update medicine set name='"+name_txt.getText()+"',company='"+company_txt.getText()+"',arrival_date='"+arrival_txt.getText()+"',expire_date='"+expire_txt.getText()+"',price='"+price_txt.getText()+"',quantity='"+quantity_txt.getText()+"'where id='"+id_txt.getText()+"'");
            boolean rs=pst.execute();
            updated();
            clearData();
            JOptionPane.showMessageDialog(null, "successfully updated");
            
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicineHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }

    @FXML
    void deleteaction(ActionEvent event) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/pharmacy","test","test");
            PreparedStatement pst=connect.prepareStatement("delete from medicine where id='"+id_txt.getText()+"'");
            boolean rs=pst.execute();
            updated();
            clearData();
            JOptionPane.showMessageDialog(null, "successfully deleted");
            
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MedicineHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    int index=-1;

    @FXML
    void get_selected(MouseEvent event) {
        index=table_medicine.getSelectionModel().getSelectedIndex();
        if(index<=-1){
            
            return;
        }
        id_txt.setText(co_id.getCellData(index));
        name_txt.setText(co_name.getCellData(index));
        company_txt.setText(co_company.getCellData(index));
        arrival_txt.setText(co_arrival.getCellData(index));
        expire_txt.setText(co_expire.getCellData(index));
        price_txt.setText(co_price.getCellData(index));
        quantity_txt.setText(co_quantity.getCellData(index));
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
