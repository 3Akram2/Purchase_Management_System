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
public class Product implements Serializable{
    String name;
    double price;
    String description;
    public Product(String nameIn, String descriptionIn,double priceIn){
        this.name = nameIn;
        this.price =  priceIn;
        this. description= descriptionIn;
    
    }
    
    public String getProductName(){
    
    return name;
    }
    public String getProductdetails(){
    
    return description;
    }
    public double getProductPrice(){
    
    return price;
    }
    
    @Override
        public String toString(){
        
        return " product name: "+name+" ,product description: "+description+ " price: "+price+"\n";
        }
    
    
    
}
