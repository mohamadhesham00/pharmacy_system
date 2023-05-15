/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pro;

/**
 *
 * @author Dell
 */
public class MedData {
    String id,name,company,arrival_date,expire_date,price,quantity;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public MedData(String id, String name, String company, String arrival_date, String expire_date, String price, String quantity) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.arrival_date = arrival_date;
        this.expire_date = expire_date;
        this.price = price;
        this.quantity = quantity;
    }
    
}
