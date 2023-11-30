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
public class OrderList implements Serializable {
    private ArrayList<Order> ordList;
    private int MAX;
    
    public OrderList (int maxIn){
    ordList=new ArrayList<>();
    MAX= maxIn;
    }
    
     public Order Search(int idIn  ) {
       
      if(!ordList.isEmpty()){
         for (Order item:ordList){
             if (item.getId()==idIn )
                { 
                    return item ;
                }
            
         }    
      }
      
      
      
        
      return null;

             
     }
     public boolean addOrder(Order ordIn){
    
    if(ordList.size()< MAX){
    ordList.add(ordIn);
   
    System.out.print("order details"+ordIn);
    return true;
    }
    else
    return false;
    
    

     
     
    }
    public boolean deleteOrder(int idIn){
     Order delOrder = Search(idIn);
     
     if(delOrder!=null){
         
     ordList.remove(delOrder);
     return true;
     }
     else return false;
     
     
     
    
    }

    boolean isEmpty() {
        return ordList.isEmpty();
    }
     
    @Override
	public String toString()
   {
            return ordList.toString();
   }
    
}
