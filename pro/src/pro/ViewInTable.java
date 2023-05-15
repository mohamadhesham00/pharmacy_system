/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dell
 */
public class ViewInTable {
    
    public static ObservableList<MedData> getData(String sql){
        ObservableList<MedData> list=FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/pharmacy","test","test");
            PreparedStatement pst=connect.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                list.add(new MedData(rs.getString("id"), rs.getString("name"), rs.getString("company"), rs.getString("arrival_date"), rs.getString("expire_date"), rs.getString("price"), rs.getString("quantity")));   
                
            }
           
        } catch (Exception e) {
            System.out.println("errrrrrrrrrrrrrror");
        }
        
        
        return list;
    }
    
    public static ObservableList<billData> getBill(String sql){
        ObservableList<billData> list=FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/pharmacy","test","test");
            PreparedStatement pst=connect.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                list.add(new billData(rs.getString("id"), rs.getString("customer_name"), rs.getString("customer_number"), rs.getString("date"), rs.getString("medicine_id"), rs.getString("amount"), rs.getString("price")));   
                
            }
           
        } catch (Exception e) {
            System.out.println("errrrrrrrrrrrrrror");
        }
        
        
        return list;
    }
    
    
}
