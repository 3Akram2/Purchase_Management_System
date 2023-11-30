/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseworkgui;




import java.util.*;

/**
 *
 * @author akram
 */
public class Suppliers {
    // creating an array list of suppliers
   private List <Supplier> suppliersList = new  ArrayList<>();
   private int size = suppliersList.size();
   
    
   public List<Supplier> getSuppliers(){
   return suppliersList;
   }
   
   public int getSuppCount(){
   
   return size;
   }
   //searching for speicif supplier in supplier list with supplier id 
   public Supplier Search(String idIn  ) {
       
      if(!suppliersList.isEmpty()){
         for (Supplier item:suppliersList){
             if (item.getSupplierID().equals(idIn) )
                { 
                    return item ;
                }
            
         }    
      }

return null;

             
     }
   
   //adding supplier tho the list
   public void add(Supplier supIn){
   suppliersList.add(supIn);
   
   }
   
   //deleting supplier the list
   public boolean deleteSupplier(String id){
      Supplier delSupplier = Search(id);
      if(delSupplier!=null){
      suppliersList.remove(delSupplier);
      return true;  
     }
      else          
          throw new WrongSpplierException ("Supplier does not exist");
   }
   //adding product to a spicific spplier
   public boolean addProduct(String SuppIdIn,String ProductNameIn,String descriptionIn,double price){
    
       Supplier s= Search(SuppIdIn);
       if(s!=null){
       boolean f = s.addProd( ProductNameIn,descriptionIn, price);
    return f;
   
       }
       else 
           throw new WrongSpplierException ("Supplier does not exist");
   }
  
   //removing product from a spicific spplier
   public boolean delProduct(String SuppIdIn,String prodName){
       Supplier s =Search(SuppIdIn);
       if(s!=null){
 boolean f =  s.delProduct(prodName);
 return f;
       }
       else 
           throw new WrongSpplierException ("Supplier does not exist");

   }
   //adding order to a supplier
   public boolean addOrder(String idIn,String ordNameIn,int quan,double price,String reqDateIn,String dlevDateIn){
       Supplier s = Search(idIn);
       if(s!=null){
  boolean f = s.addOrder(ordNameIn,quan,price,reqDateIn,dlevDateIn);
  return f;
       }
       else throw new WrongSpplierException ("Supplier does not exist");
   }
   //deleting order from a supplier
   public boolean deleteOrder(String idIn,int orderIdIn){
   Supplier s= Search(idIn);
   if(s!=null){
   boolean f = s.deleteOrder(orderIdIn);
   return f;
   }
   else{           
        throw new WrongSpplierException ("Supplier does not exist");
        }
   }
   //making a payment to a supplier
   public void makePayment(String idIn,String date,double amount){
       Payment payIn = new Payment(date,amount);
   Supplier s = Search(idIn);
   if(s!=null){
          s.makePayment(payIn);
   }
   else{
        throw new WrongSpplierException ("Supplier does not exist");
   }
   
   }

   //getting all payments of a supplier
   public void getPayments(String IdIn){
   Supplier s =Search(IdIn);
   if(s!=null){
   System.out.println(s.getPayments());
   }
   else 
       throw new WrongSpplierException ("Suppler does not exist");
   }
   @Override
        public String toString(){
        return suppliersList.toString();
            
        }
   
   
    
}

