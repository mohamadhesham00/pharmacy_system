/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro;

/**
 *
 * @author Dell
 */
public class billData {
    String id,customer_name,customer_number,date,medicine_id,amount,price;

    public billData(String id, String customer_name, String customer_number, String date, String medicine_id, String amount, String price) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_number = customer_number;
        this.date = date;
        this.medicine_id = medicine_id;
        this.amount = amount;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMedicine_id(String medicine_id) {
        this.medicine_id = medicine_id;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public String getDate() {
        return date;
    }

    public String getMedicine_id() {
        return medicine_id;
    }

    public String getAmount() {
        return amount;
    }

    public String getPrice() {
        return price;
    }
    
}
