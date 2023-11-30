/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package courseworkgui;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;  
/**
 *
 * @author akram
 */
public class MainMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   int choice;
    
		// create Bank object
		Suppliers mySuppliers = new Suppliers();
		FileHandler.readList(mySuppliers);
                
		// offer menu
		do
		{
			System.out.println();
			System.out.println("1. Create new supplier");
			System.out.println("2. Remove a supplier");
			System.out.println("3. Create order");
			System.out.println("4. Remove order");
			System.out.println("5. Check account details");
                        System.out.println("6. Make a payment");
                        System.out.println("7. List Payments");
                        System.out.println("8. Display all Suppliers");
                        System.out.println("9. Create product");
                        System.out.println("10. Delete product");
			System.out.println("11. Save & Quit");
			System.out.println();
			System.out.print("Enter choice [1-11]: ");
			
			// get choice
			choice = EasyScanner.nextInt();
			System.out.println();
			
			// process menu options
			switch (choice)
			{
				case 1: option1(mySuppliers);
				break;
				case 2: option2(mySuppliers);
				break;
				case 3: option3(mySuppliers);
				break;
				case 4: option4(mySuppliers);
				break;
				case 5: option5(mySuppliers);
				break;
                                case 6: option6(mySuppliers);
				break;
                                case 7: option7(mySuppliers);
				break;
                                case 8: option8(mySuppliers);
				break;
				case 9: option9(mySuppliers);
                                break;
                                case 10: option10(mySuppliers);
                                break;
                                case 11: SaveAndQuit(mySuppliers);
                                break;
                                
				default: System.out.println("Invalid entry");
			}
		}
		while (choice != 11);
	}
	
    
    
    
	// add supplier 
	static void option1( Suppliers s)
	{
		// get details from user
             try{
		System.out.print("Enter supplier name: ");
		String name = EasyScanner.nextString();
		
                System.out.print("Enter supplier Id: ");
		String id = EasyScanner.nextString();
                Supplier sear = s.Search(id);
                
                if(sear !=null){
                System.out.println("supplier with this id "+id+" already exists");
                
                }
                else{
                    if (name.length()==0){
                    System.out.println("supplier name cannot be empty");
                    }
               //checking if id is 4 charachters or more
               boolean  f =checkValidity(()->{
               return id.length() >=4;
               });
               
               if(f){
               
                System.out.print("Enter supplier phone no: ");
		String phone = EasyScanner.nextString();
               //checking if phone is excatly 11 characters 
                boolean  f2 =checkValidity(()->{
                return phone.length()==11;
               });
                if(f2){
                
                     //creating new supplier object
		Supplier sup = new Supplier(name, id,phone);
                System.out.println("Supplier created successfully");
		// adding the supplier to list
                 s.add(sup); 
             }
                
                 
                
                else{
                System.out.println("phone must be 11 numbers");
                
                }
               
               
               } else{
                System.out.println("ID must be four or more charachters");
               
               }   
                
               }
             }
                          
               catch(WrongSpplierException e){
               
               
                }
	}
	
	// remove supplier
	static void option2(Suppliers supIn)
	{
		// get account id of supplier to remove
		
                System.out.print("Enter supplier ID: ");
		String id = EasyScanner.nextString();
               
                try{
                    //confirming to ensure user want to delete the supplier
                    System.out.println("Are you sure? \n y:yes N:No");
                    String choice = EasyScanner.nextString();
                    // converting choice to upper case 
                    choice= choice.toUpperCase(); 
                if("Y".equals(choice)){
                    // in case user confirmed by entering y delete item if it exists
		 boolean check = supIn.deleteSupplier(id);
                 if(check){
                 System.out.println("supplier deleted successfully");
                 
                 
                 }
                 else{
//                 System.out.println("supplier is not deleted ");
                 
                 }
                }
                 else{
                 System.out.println("supplier is not deleted \n confirmation denied");
                 
                 }
		
                
             }
                catch(WrongSpplierException e){
                    String message = e.getMessage();
                    System.out.println(message);
               
                }
		
		
	}
	
	
	static void option3(Suppliers supIn)
	{
	// get details from user
            try{
            System.out.print("Enter supplier id: ");
		String id = EasyScanner.nextString();
                Supplier s = supIn.Search(id);
                
                // outputting the supplier products so that user can choose from them
                if(s!=null){
               if(s.getProducts().isEmpty()){
               System.out.println("this supplier has no products yet");
               } 
               else{
                System.out.println(s.getProducts());
		System.out.print("Enter item name ");
		String itemName = EasyScanner.nextString();
                System.out.print("Enter quantity ");
		int quan = EasyScanner.nextInt();
                // making sure that product is provided by the supplier
               Product prod = s.getProducts().Search(itemName);
               
               if(prod!=null){
                LocalDate todayDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                
                
                String reqTime = todayDate.format(formatter);
                int range = (10 - 2) + 1;
                  
                int days  =(int)(Math. random() * range) + 2;
                String dlevDate= todayDate.plusDays(days).format(formatter);
                
               double price = prod.getProductPrice()*quan;
              boolean f =  supIn.addOrder(id,itemName,quan,price,reqTime,dlevDate);
                        if(f){
                              System.out.println("order added successfully");
                              }
                        else{
                             System.out.println("this supplier cannot take more orders ");
                            }
             }
               
               else{
               System.out.println("no products found by this name");
               }
               }
            }
                 else{
                     throw new WrongSpplierException ("Supplier does not exist");
                    }
                }
           
            catch(WrongSpplierException e){
            System.out.println("no supplier with this id");
            }
            catch(InputMismatchException IMM){
                System.out.println("quantity field has to be an integer");
            }
		
		
	}
        
        
	
//delete order 
	static void option4(Suppliers supIn )
	{
            try{
		// get details from user
		System.out.print("Enter supplier ID: ");
		String id = EasyScanner.nextString();
                Supplier s = supIn.Search(id);
                if(s!=null){
                System.out.println(s.getSupplierOrders());
		System.out.print("Enter order ID ");
		int orderId = EasyScanner.nextInt();
                 System.out.println("Are you sure? \n y:yes N:No");
                    String choice = EasyScanner.nextString();
                    // converting choice to upper case
                    choice= choice.toUpperCase(); 
                    // confirming the  delete action
                if("Y".equals(choice)){
//                    delete order if it exists  
		boolean check = supIn.deleteOrder(id, orderId);
                if(check){
                 System.out.println("order deleted successfully");
                 
                 
                 }
                 else{
                 System.out.println("order is not deleted ");
                 
                 }
                }
                else{
                System.out.println("order is not deleted ");
                }
            }else{
                throw new WrongSpplierException ("Supplier does not exist");
                }
            }
	
        catch(WrongSpplierException e){
            System.out.println("no supplier with this id");
            }
        }

// check account details
	static void option5(Suppliers supIn)
	{
		// get details from user
            
		System.out.print("Enter supplier ID: ");
		String id = EasyScanner.nextString();
               
                try{
		Supplier account = supIn.Search(id);
                if (account!=null){
			// outputting the supplier by its id
			System.out.println(account);}
                else{
                 throw new WrongSpplierException ("Supplier does not exist");
                }
                        }
                 catch(WrongSpplierException e){
                    String message = e.getMessage();
                    System.out.println(message);
               
                }
                catch(Exception exp){
                System.out.print("somthing went wrong please try again!");
                
                }
                        
    }
//        make a payment to a supplier
        static void option6(Suppliers supIn)
	{
            
	try{	// get details from user
		System.out.print("Enter supplier ID: ");
		String id = EasyScanner.nextString();
                System.out.print("Enter payment amount: ");
                double amount = EasyScanner.nextDouble();
                Supplier s = supIn.Search(id);
                if(s!=null){
                
                boolean f = s.getSupplierOrders().isEmpty();
                //  if the supplier has no orders no payment can be made
                if(f){
                System.out.println("supplier "+s.getSupplierName()+"has no orders yet ");
                
                }
                else{
                // creating and adding payment to the supplier
                LocalDate localDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String date = localDate.format(formatter);
                supIn.makePayment(id, date, amount);
                }
                }
                else{
                throw new WrongSpplierException ("Supplier does not exist");
                }
                
            }    
            catch(WrongSpplierException e){
            System.out.println("no supplier with this id");
            }    
                                        
    }
//        list all payments of a specific supplier
         static void option7(Suppliers supIn)
	{
		try{
                    // get details from user
		System.out.print("Enter supplier ID: ");
		String id = EasyScanner.nextString();
                Supplier s = supIn.Search(id);
                PaymentList p  = s.getPayments();
                if(s.getPayments().getTotal() == 0)
            {
                System.out.println("No payments made for this supplier");
            } 
            else
            {  
                
                NumberFormat nf =  NumberFormat.getCurrencyInstance();
                String str;
                System.out.println("Month" +  "\t\t" +  "Amount" +  "\n");
                for(int i =  1; i <=  p.getTotal(); i++  )
                {
                    str =  nf.format(p.getPayment(i).getAmount());
                    System.out.println("" + p.getPayment(i).getMonth() +  "\t" + str);
                } 
                System.out.println("\n" + "Total paid so far :   " + 	nf.format(p.calculateTotalPaid()));
             }
                }
                catch(WrongSpplierException e){
            System.out.println("no supplier with this id");
            }    
                     
                                        
    }
//       list all suppliers
        static void option8(Suppliers sup)
	{
                System.out.print(sup);
                
                        
    }
        // creating product object in a spicif supplier 
         static void option9(Suppliers sup)
	{
              try{
               
                System.out.println("Enter supplier id: ");
		String id = EasyScanner.nextString();
                System.out.println("Enter product name ");
                String prodName = EasyScanner.nextString();
                System.out.println("Enter product description ");
		String prodDescription = EasyScanner.nextString();
                System.out.println("Enter product price ");
		double prodPrice = EasyScanner.nextDouble();
                if(id.length()==0){
                System.out.println(" you must enter a supplier id \n try again! ");
                
                }
                 
                else if(prodName.length()==0){
                        System.out.println(" you must enter a product name must be entered \n try again! ");
                        }
                else if (prodDescription.length()==0){
                System.out.println(" you muat enter a product description must be entered \n try again! ");
                }
                else if (prodPrice==0 ){
                System.out.println(" product price cannot be 0 \n try again! ");
                }
                else{
                Supplier s = sup.Search(id);
               
		
                
                
               boolean  f =  sup.addProduct(id, prodName, prodDescription, prodPrice);
               if(f){
                    System.out.println("product added successfully");
                    }
                else{
                System.out.println("supplier cannot take more products");
                    }
                }
                }
                
              
              catch(WrongSpplierException e){
            System.out.println("no supplier with this id");
            }
              catch(InputMismatchException IMM){
                System.out.println("Price field has to be a number");
            }
                        
    }
//         deleting product 
          static void option10(Suppliers sup)
	{
              try{
              
                System.out.println("Enter supplier id: ");
		String id = EasyScanner.nextString();
                Supplier s = sup.Search(id);
                if(s!=null){
                System.out.println(s.getProducts());
                System.out.println("Enter product name ");
		String prodName = EasyScanner.nextString();
                // confirming if user sure about the delete
                System.out.println("Are you sure? \n y:yes N:No");
                String choice = EasyScanner.nextString();
                choice= choice.toUpperCase(); 
                if("Y".equals(choice)){
                    // deleting product if exists
                 boolean check = sup.delProduct(id, prodName);
                 
                 if(check){
                 System.out.println("Product deleted successfully");
                 
                 
                 }
                 else{
                 System.out.println("product is not deleted ");
                 
                 }
              }
                else{
                 System.out.println("product is not deleted ");
                 
                 }
                }else{
                throw new WrongSpplierException ("Supplier does not exist");
                }
                    }
              catch(WrongSpplierException e){
            System.out.println("no supplier with this id");
            }
             
                
                        
    }
       
        




//save to the file 
         static void SaveAndQuit(Suppliers sup){
         
          FileHandler.writeList(sup);
         }
         
       private static boolean checkValidity(Checkable objectIn)
    {
        if(objectIn.check())
        {
            return true;
        }
        else
        {
           
            
            return false;
        }
    }
    
}
