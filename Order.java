/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseworkgui;
import java.io.Serializable;

/**
 *
 * @author akram
 */
public class Order implements Serializable {
    private int itemQuan = 0;
    private String orderItem;
    private String orderTime;
    private String delvTime;
    private double orderPrice;
    private final int id;
    
    
//    public Order(String itemIn , int QuanIn ){
//     itemQuan = QuanIn;
//     orderItem = itemIn;
//     
//     orderPrice = itemQuan*itemPrice; 
//    }
     public Order(String itemIn , int itemQuanIn,double priceIn,String reqDateIn,String dlevDateIn,int idIn ){
    
     orderItem = itemIn;
     itemQuan=itemQuanIn;
     orderTime= reqDateIn;
     delvTime= dlevDateIn;
     orderPrice = priceIn;
    id=idIn;
    
//      = (int)(Math.random() * 100) + 1
    }
     public int getId(){
     return id;
     }
    public String getItemName(){
    
    return orderItem;
    }
    
public int getItemQuantity(){
    
    return itemQuan;
    }  

public double getOrderPrice(){
    
    return orderPrice;
    }
public void setQuantity(int quanIn){
    
itemQuan=quanIn;

}
public void setOrderPrice(double pIn){
orderPrice=pIn;
}

@Override
        public String toString(){
        
        return "( order id: "+id +" item name: "+orderItem+" , requsted quantity: "+itemQuan+" ,price: "+orderPrice+ " request date: "+orderTime+" delivery date:  "+delvTime+")\n";
        }
    
}
