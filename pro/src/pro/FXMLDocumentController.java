/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package pro;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField usertf;

    @FXML
    private PasswordField passtf;

    @FXML
    private Button logbtn;

    Connection connect;
    PreparedStatement pst;
    ResultSet rs;
    
    @FXML
    void loginaction(ActionEvent event) throws SQLException, IOException {
        String uname=usertf.getText();
        String pass=passtf.getText();
        
        if(uname.equals("")||pass.equals(""))
            JOptionPane.showMessageDialog(null, "please enter a username or password");
        else{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connect=DriverManager.getConnection("jdbc:mysql://localhost/pharmacy","test","test");
                pst=connect.prepareStatement("select * from usernames where username=? and password=?");
                pst.setString(1, uname);
                pst.setString(2, pass);
                rs=pst.executeQuery();
                
                if(rs.next()){
                    logbtn.getScene().getWindow().hide();
                    FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("home.fxml"));
                    Parent root =(Parent) fxmlLoader.load() ;
                    Stage stage=new Stage();
                    Scene sc = new Scene(root);
                    stage.setScene(sc);
                    stage.show();
                           
                }
                else {
                    JOptionPane.showMessageDialog(null, "login failed");
                    usertf.setText("");
                    passtf.setText("");
                    
                }
            } catch (ClassNotFoundException ex) {
                  System.out.println("mistaaaake");
//                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
