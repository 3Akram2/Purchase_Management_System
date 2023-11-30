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
public class Supplier implements Comparable<Supplier>,Serializable{
    private final String supName;
    private final String supId;
    private final String supPhoneNum ;
    private final int MAX = 10; 
    private final OrderList orders;
    private final ProductList products;
    private PaymentList payments;
    private  int orderID = 1; 
    
    
    public Supplier(String nameIn,String idIn, String supPhoneNo){
    supName = nameIn;
    supId = idIn;
    supPhoneNum = supPhoneNo;
    orders = new OrderList(MAX);
    payments = new PaymentList(MAX);
    products= new ProductList(MAX);
    
    
    }

    public String getSupplierName(){
   return supName;
    }
    public String getSupplierID(){
 return supId;
    }
    public OrderList getSupplierOrders(){
    return orders;
    }
    public ProductList getProducts(){
    return products;
    }
    public boolean addOrder(String ordNameIn,int quanIn,double priceIn,String reqDateIn,String dlevDateIn){
        
    Order ord = new Order (ordNameIn,quanIn,priceIn,reqDateIn,dlevDateIn,orderID);
    orderID++;
    
    boolean f = orders.addOrder(ord);
    return f;
    }
    public boolean deleteOrder(int idIn){
        
    boolean f= orders.deleteOrder(idIn);
    return f;
    }
    public boolean addProd(String nameIn,String descriptionIn, double Price){
        Product prod = new Product(nameIn,descriptionIn,Price);
    boolean f =  products.addProduct(prod);
    return f;
    }
    public boolean delProduct(String prodName){
    boolean f = products.removeProduct(prodName);
    return f;
    }
    public PaymentList getPayments()
	{
            return payments;
	}
    public void makePayment(Payment paymentIn)
	{
            payments.addPayment(paymentIn); // call PaymentList method
	}
    
    
    @Override
     public int compareTo(Supplier supIn) {
       return supName.compareTo(supIn.supName);
    }
     @Override
        public String toString(){
        
        return "( Supplier Details \n supplier ID: "+supId+" , supplier name: "+supName+" , supplier phone number: "+supPhoneNum+" \n Supplier Products"+products+"\n Supplier Orders"+orders+"\n Supplier Payments"+payments+")\n";
        }
        
     
    
}
