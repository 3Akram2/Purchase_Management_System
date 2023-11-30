/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseworkgui;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author akram
 */
public class ProductList implements Serializable {
    private ArrayList<Product> prodList;
    private int MAX;
    public ProductList(int maxIn)
	{  
            prodList = new ArrayList<>();	
            MAX = maxIn;
	}
    public boolean isFull()
	{
            return prodList.size()== MAX;
        }
    public boolean isEmpty(){
    return prodList.isEmpty();
    
    }
    public Product Search(String ProdName){
    for(Product item:prodList){
    if(item.getProductName().equals(ProdName)){
    return item;
    }
    
    }
    return null;
    
    }
    public boolean addProduct(Product prodIn){
    if(prodList.size()<MAX){
    prodList.add(prodIn);
    return true;
    }
    else 
        return false;
    } 
    
    public boolean removeProduct(String prodName){
    Product delProd = Search(prodName);
    if(delProd!=null){
         
    prodList.remove(delProd);
    return true;
    }
     else return false;
    
    
    }
     @Override
	public String toString()
   {
            return prodList.toString();
   }
}

