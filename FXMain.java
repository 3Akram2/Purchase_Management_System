/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package courseworkgui;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author akram
 */
public class FXMain extends Application {
    
     private Suppliers supList;
     //heading label
      private final Label headingLabel = new Label("Supplier Application");
    // WIDTH and HEIGHT of GUI stored as constants 
    private final int WIDTH = 1400;
    private final int HEIGHT = 900;
    // visual components
  //Supplier
    private final Label idLabel = new Label("Suplier ID");
    private TextField idField1 =  new TextField();
    private final Label supplerNameLabel = new Label("Supplier Name");
    private TextField nameField =  new TextField();
    private final Label PhoneLabel = new Label("Supplier phone number");
    private TextField phoneField =  new TextField();
    private final Button addSupplierButton = new Button("Add Supplier");
    private final Button displaySuppliersButton =  new  Button("Display Suppliers");
    private final Button removeSupplierButton  = new Button("Remove Supplier");
    private final Button dispalySupplier  = new Button("display a Supplier");
    private final Button saveAndQuitButton  = new Button("Save and Quit");
    private TextArea displayArea1  = new TextArea();
    


// Product 
    private final Label SupIdLabel= new Label("Suplier ID"); 
    private TextField idField2 =  new TextField();
    private final Label productNameLabel = new Label("Product Name");
    private TextField productNameField =  new TextField();
    private final Label productDescLabel= new Label("Product Describtion"); 
    private TextField productDescField =  new TextField();
    private final Label productPriceLabel = new Label("Product Price");
    private TextField productPriceField =  new TextField();
    private final Button addProductButton = new Button("Add Product");
    private final Button removeProductButton  = new Button("Remove Product");
    private TextArea displayArea2  = new TextArea();



    // Order 
    private final Label SupIdLabel2= new Label("Suplier ID"); 
    private TextField idField3 =  new TextField();
    private final Label orderIdLabel2= new Label("Order ID"); 
    private TextField orderIdField =  new TextField();
    private final Label orderNameLabel= new Label("product Name"); 
    private TextField orderNameField =  new TextField();
    private final Label orderQuantityLabel= new Label("Order Quantity"); 
    private TextField orderQuantityField =  new TextField();
    private final Button addOrderButton = new Button("Add Order");
    private final Button removeOrderButton  = new Button("Remove Order");
     private TextArea displayArea3  = new TextArea();
    

     
//payment
    private final Label supplierIdLabel2 = new Label("ID");
    private TextField supllierIdField2  = new TextField();
    private final Label amountLabel = new Label("Amount");
    private TextField amountField =  new TextField();
    private final Button paymentButton  = new Button("Make Payment");
    private final Button listButton  = new Button("List Payments"); 
    private TextArea displayArea4 =  new TextArea();
    
    @Override
    public void start(Stage primaryStage) {
       
        supList = new Suppliers();
        // reading the suppliers list from a file
        FileHandler.readList(supList);
//        creating HBox for suppliers 
        HBox supplierDetails = new HBox (10);
        supplierDetails.getChildren().addAll(idLabel,idField1,supplerNameLabel
                ,nameField,PhoneLabel,phoneField);
        
        //        creating HBox for suppliers  Buttons
        HBox supplierButtons = new HBox(10);
        supplierButtons.getChildren().addAll(addSupplierButton,displaySuppliersButton,removeSupplierButton,dispalySupplier);
        //        creating HBox for products
        HBox productDetails = new HBox (10);
        productDetails.getChildren().addAll(SupIdLabel,idField2,productNameLabel,productNameField
                ,productDescLabel,productDescField,productPriceLabel,productPriceField);
        //        creating HBox for products Buttons
        HBox productButtons = new HBox(10);
        productButtons.getChildren().addAll(addProductButton,removeProductButton);
        //        creating HBox for orders 
        HBox orderDetails = new HBox (10);
        orderDetails.getChildren().addAll(SupIdLabel2,idField3,orderIdLabel2,orderIdField,orderNameLabel
                ,orderNameField,orderQuantityLabel,orderQuantityField);
       //        creating HBox for order Buttons
         HBox orderButtons = new HBox(10);
        orderButtons.getChildren().addAll(addOrderButton,removeOrderButton);
        //        creating HBox for payments
        HBox paymentDetails = new HBox (10);
        paymentDetails.getChildren().addAll(supplierIdLabel2,supllierIdField2,amountLabel,amountField);
        //        creating HBox for suppliers ,orders , products payments and their Buttons
        HBox paymentButtons = new HBox(10);
        paymentButtons.getChildren().addAll(paymentButton,listButton);
       
        //creating VBox and adding the heading , hboxes and button for saving  
        VBox root = new VBox(10);
        root.getChildren().addAll(headingLabel,
                                supplierDetails,supplierButtons,displayArea1,
                                productDetails,productButtons,displayArea2,
                                orderDetails,orderButtons,displayArea3,
                                paymentDetails,paymentButtons,displayArea4,
                                saveAndQuitButton
                                );
        //creating scene with orange background color 
        Scene scene = new Scene(root);
        scene.setFill(Color.web("#FF8B13"));
        
       Font font = new Font("Helvetica", 40);
       
       headingLabel.setFont(font);
       supplierDetails.setAlignment(Pos.CENTER);
       supplierButtons.setAlignment(Pos.CENTER);
       productDetails.setAlignment(Pos.CENTER);
       productButtons.setAlignment(Pos.CENTER);
       orderDetails.setAlignment(Pos.CENTER);
       orderButtons.setAlignment(Pos.CENTER);
       paymentDetails.setAlignment(Pos.CENTER);
       paymentButtons.setAlignment(Pos.CENTER);
       root.setAlignment(Pos.CENTER);
       
       
       supplierDetails.setMinWidth(WIDTH);
       supplierButtons.setMaxWidth(WIDTH);
       
       productDetails.setMinWidth(WIDTH);
       productButtons.setMaxWidth(WIDTH);
       
       orderDetails.setMinWidth(WIDTH);
       orderButtons.setMaxWidth(WIDTH);
       
       paymentDetails.setMinWidth(WIDTH);
       paymentButtons.setMaxWidth(WIDTH);
       
       
       root.setMinSize(WIDTH, HEIGHT);
       root.setMaxSize(WIDTH, HEIGHT);
       
        
       displayArea1.setMaxSize(WIDTH - 120, HEIGHT/8);
       displayArea2.setMaxSize(WIDTH - 120, HEIGHT/8);
       displayArea3.setMaxSize(WIDTH - 120, HEIGHT/8);
       displayArea4.setMaxSize(WIDTH - 120, HEIGHT/8);
       
       
       
       primaryStage.setWidth(WIDTH);
       primaryStage.setHeight(HEIGHT);    

       // customise the visual components
        
       // customise the VBox border and background
       BorderStroke style = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, 
       new CornerRadii(0), new BorderWidths(2) );
       root.setBorder(new Border (style));
       root.setBackground(Background.EMPTY);
       
       
       // setting buttons shape and color
       addSupplierButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       displaySuppliersButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       dispalySupplier.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       removeSupplierButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       addProductButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       removeProductButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       addOrderButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       removeOrderButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       paymentButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       listButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, 
								new CornerRadii(10), Insets.EMPTY)));
       saveAndQuitButton.setBackground(new Background(new BackgroundFill(Color.RED, 
								new CornerRadii(10), Insets.EMPTY)));
       //setting buttons actions
       addSupplierButton.setOnAction(e -> addSupplierHandler());
       removeSupplierButton.setOnAction(e -> removeSupplierHandler());
       displaySuppliersButton.setOnAction(e -> displayAllSuppliersHandler());
       dispalySupplier.setOnAction(e -> displaySupplierHandler());
       addProductButton.setOnAction(e -> addProductHandler());
       removeProductButton.setOnAction(e -> removeProductHandler());
       addOrderButton.setOnAction(e -> addOrderHandler());
       removeOrderButton.setOnAction(e -> removeOrderHandler());
       paymentButton.setOnAction(e -> makePaymentHandler());
       listButton.setOnAction(e -> displayPaymentHandler());
       saveAndQuitButton.setOnAction(e -> SaveAndQuit());
       
        primaryStage.setTitle("Commerce System");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    
    }
    private void addSupplierHandler(){
      String supplierIdEnterd = idField1.getText();
      String supplierNameEnterd = nameField.getText();
      String supplierPhoneEnterd = phoneField.getText();
      //cheking if id ia empty
      if(supplierIdEnterd.length()==0 ){
      
      
                displayArea1.setText ("id must be enterd");
      }
      //cheking if name is empty
      else if(supplierNameEnterd.length()==0){
      
      
                displayArea1.setText ("supplier name must be enterd");
      }
      //cheking if phone number is empty
      else if(supplierPhoneEnterd.length()==0){
      
      
                displayArea1.setText ("supplier phone must be enterd");
      }
      else if(supList.Search(supplierIdEnterd)!=null){
      
      displayArea1.setText ("the id "+supplierIdEnterd+" already used by another supplier");
      }
      
      else{
          //checking id length to be 4 or more characters
      boolean  f =checkValidity(()->{
               return supplierIdEnterd.length() >=4;
               });
               if(f){
               
                
	//cheking if phone is excatly 11 charachters
                boolean  f2 =checkValidity(()->{
                   
                   
               return supplierPhoneEnterd.length()==11;
               });
                if(f2){
                 try{
                     //creating new spplier object with the entered data
		Supplier sub = new Supplier(supplierNameEnterd, supplierIdEnterd,supplierPhoneEnterd);
                
		// clearing the input fields
                 idField1.setText("");
                 nameField.setText("");
                 phoneField.setText("");
                 supList.add(sub); 
                 displayArea1.setText ("supplier added successfully");
             }
                 //catching if any uncounted for exception is thrown
                catch(Exception e){
                
                displayArea1.setText (e.getMessage());
               
                }
                 
                }
                else{
               displayArea1.setText("phone must be 11 numbers");
                
                }
               
               
                
                
               }
               else{
               displayArea1.setText("ID must be four or more charachters");
               
               }
      
      
      }
        
    }
    private void removeSupplierHandler(){
        String supplierIdEnterd = idField1.getText();
    
     try{
         //cheking if id is empty
         Supplier s = supList.Search(supplierIdEnterd);
        
            if(supplierIdEnterd.length()!=0 ){
                 if(s!=null){
                //confirmation alert to ensure user really wants to remove the supplier 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("DELETE");
            alert.setContentText("Are You Sure?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("NO", ButtonBar.ButtonData.NO);
            
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
                //heking if deleting is confirmed
        if (type == okButton) {
            boolean check = supList.deleteSupplier(supplierIdEnterd);
            idField1.setText("");
            nameField.setText("");
            phoneField.setText("");
            System.out.println(check);
           //cheking if supplier is deleted successfully
            if(check){
                
                displayArea1.setText("Supplier deleted successfully");
            
        }
            else{
                
                displayArea1.setText("Supplier hasnot been deleted   ");
            }
            System.out.println(type);
            //cheking if no is chosen
        } else if (type == noButton) {
            displayArea1.setText("Supplier hasnot been deleted \n confirmation denied  ");
        } else {
            
           
        }
});
                    }
                 else{
                  throw new WrongSpplierException ("Supplier does not exist");
                 }
            }
            else{
                displayArea1.setText("supplier id must be enterd  ");
            }
	}	 
     //catching wrong supplier expception as it will be thrown if supplier does not exists
                catch(WrongSpplierException e){
                    String message = e.getMessage();
                   displayArea1.setText(message);
              
                }
    
    }
    //displaying all suppliers in the list
    private void displayAllSuppliersHandler(){
     displayArea1.setText(supList.toString());
}
    //for displaying a specific supplier 
    private void displaySupplierHandler(){
    String supplierIdEnterd = idField1.getText();
    // checking if id field is empty
    if(supplierIdEnterd.length()!=0){  
        
    
     try{
		Supplier account = supList.Search(supplierIdEnterd);
                if(account!=null){
		//outputting the supplier if found
		displayArea1.setText(account.toString());
                idField1.setText("");
                 nameField.setText("");
                 phoneField.setText("");
                        }
                else{
                    throw new WrongSpplierException ("Supplier does not exist");
                }
     }
     
                 catch(WrongSpplierException e){
                    String message = e.getMessage();
                   displayArea1.setText(message);
               
                }
                catch(Exception exp){
               displayArea1.setText("somthing went wrong please try again!");
                
                }
    }
    else{
        displayArea1.setText("you must enter a supplier id ");
    }
    
    }
    private void addProductHandler(){
    try{
                String supplierIdEnterd = idField2.getText();
                String productNameEntered = productNameField.getText();
                String productDescription = productDescField.getText();
                String stringPrice = productPriceField.getText();
                double productPriceEnterd = Double.parseDouble(stringPrice);
                //checking if supplier id is empty
                if(supplierIdEnterd.length()==0){
                displayArea2.setText("supplier id must be entered");
                }
               // checking if product name field is empty 
                else if(productNameEntered.length()==0){
               displayArea2.setText("Product name must be entered");
                }
                // checking if product Description field is empty
                else if(productDescription.length()==0){
                displayArea2.setText("Product description must be entered");
                }
                // checking if product price field is empty
                else if(stringPrice.length()==0){
                  displayArea2.setText("Product price must be entered");  
                }
                else if(supList.Search(supplierIdEnterd)==null){
                throw new WrongSpplierException ("Supplier does not exist");
                
                }
                else{
                    Supplier s = supList.Search(supplierIdEnterd);
//                   creating and adding product to the supplier
               boolean f = supList.addProduct(supplierIdEnterd, productNameEntered
                        , productDescription, productPriceEnterd);
                
               if(f){
                    displayArea2.setText("product added successfully");
                    }
                else{
                    displayArea2.setText("supplier cannot take more products");
                    }
                
                
                
                // clearing the fields
                idField2.setText("");
                productNameField.setText("");
                productDescField.setText("");
                productPriceField.setText("");
                }
                
                }
                
              
              catch(WrongSpplierException e){
                displayArea2.setText(e.getMessage());
            }
    catch(NumberFormatException IMM){
                displayArea2.setText("price field has to be a number");
            }
    
    
    }
    
    private void removeProductHandler(){
    
    try{
              
                String supplierIdEnterd = idField2.getText();
               
		String productNameEnterd = productNameField.getText();
                
               // checking if  supplier id field is empty
                 if(supplierIdEnterd.length()==0 ){
                 displayArea2.setText("Supplier ID must be entered");
                 }
                 // checking if product name field is empty
                 else if(productNameEnterd.length()==0){
                      displayArea2.setText("Product name must be entered");
                 }
                 else if (supList.Search(supplierIdEnterd)==null){
                      throw new WrongSpplierException ("Supplier does not exist");
                 }
                 else{
                      Supplier s = supList.Search(supplierIdEnterd);
                     // creating alert for confirmation 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("DELETE");
            alert.setContentText("Are You Sure?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("NO", ButtonBar.ButtonData.NO);
            
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
                
        if (type == okButton) {
            boolean check = supList.delProduct(supplierIdEnterd, productNameEnterd);
                 
            //cheing if product is deleted 
            if(check){
                
                displayArea2.setText("Product deleted successfully");
                idField2.setText("");
                productNameField.setText("");
                productDescField.setText("");
                productPriceField.setText("");
            
        }
            else{
                
                displayArea2.setText("Product hasnot been deleted   ");
            }
           
        } else if (type == noButton) {
            displayArea2.setText("Product hasnot been deleted \n confirmation denied  ");
             idField2.setText("");
                productNameField.setText("");
                productDescField.setText("");
                productPriceField.setText("");
        } else {
            
            
        }
});
                    }
            
                
    }
                
               
              catch(WrongSpplierException e){
                displayArea2.setText( e.getMessage());
            }
    }
    private void addOrderHandler(){
    try{
        
              String supplierIdEnterd = idField3.getText();  

                
                 String ProductNameEnterd  = orderNameField.getText();
                String strQuanEnterd = orderQuantityField.getText();
		int quanEnterd = Integer.parseInt(strQuanEnterd);
                // checking if supplier id field is empty
                 if(supplierIdEnterd.length()==0 ){
                 displayArea3.setText("Supplier ID must be entered");
                 }
                 // checking if order name field is empty
                 else if(ProductNameEnterd.length()==0){
                 displayArea3.setText("product name must be entered");
                 }
                 // checking if quantity field is empty
                 else if(strQuanEnterd.length()==0){
                 displayArea3.setText("product quantity must be entered");
                 }
                 else if(supList.Search(supplierIdEnterd)==null){
                 throw new WrongSpplierException ("Supplier does not exist");
                 }
                 else{
                     Supplier s = supList.Search(supplierIdEnterd);
                     if(s.getProducts().isEmpty()){
               displayArea3.setText("this supplier has no products yet");
               } 
               else{
                     //searching for order item name in this supplier products ensure that supplier have it
               Product prod = s.getProducts().Search(ProductNameEnterd);
               if(prod!=null){
                LocalDate todayDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                
                
                String reqTime = todayDate.format(formatter);
                String dlevDate= todayDate.plusDays(5).format(formatter);
                // calculating total price
               double price = prod.getProductPrice()*quanEnterd;
               // adding order to orders in this supplier
              supList.addOrder(supplierIdEnterd,ProductNameEnterd,quanEnterd,price,reqTime,dlevDate);
                displayArea3.setText("order added successfully \n "+s.getSupplierOrders());
                // clearing input fields 
                idField3.setText("");  
                 orderNameField.setText("");
                 orderQuantityField.setText("");
             }
               else{
               displayArea3.setText("no products found by this name");
               }
            }
                 }
                 
    }
            catch(WrongSpplierException e){
             displayArea3.setText(e.getMessage());
            }
    catch(NumberFormatException IMM){
                displayArea3.setText("quantity field has to be an integer");
            }
		
    
    }
    private void removeOrderHandler(){
    try{
		// get details from user
                
		String supplierIdEnterd = idField3.getText();  
               
//                System.out.println(s.getSupplierOrders());
		String strOrderIdEnterd = orderIdField.getText();  
                int orderId = Integer.parseInt(strOrderIdEnterd);
		
                // checking if supplier id field is empty
                if(supplierIdEnterd.length()==0 ){
                displayArea3.setText("Supplier ID must be entered");
                }
                // checking if order id field is empty
                else if(strOrderIdEnterd.length()==0){
                displayArea3.setText("order ID must be entered");
                }
                else if( supList.Search(supplierIdEnterd)==null){
                throw new WrongSpplierException ("Supplier does not exist");
                }
                else{
                     Supplier s = supList.Search(supplierIdEnterd);
                    // confirming the order delete 
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("DELETE");
            alert.setContentText("Are You Sure?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("NO", ButtonBar.ButtonData.NO);
            
            alert.getButtonTypes().setAll(okButton, noButton);
            alert.showAndWait().ifPresent(type -> {
        if (type == okButton) {
            boolean check = supList.deleteOrder(supplierIdEnterd, orderId);
                 
            System.out.println(check);
            if(check){
                
                displayArea3.setText("Order deleted successfully");
                idField3.setText("");  
                 orderNameField.setText("");
                 orderQuantityField.setText("");
            
        }
            else{
                
                displayArea3.setText("Order hasnot been deleted   ");
            }
            System.out.println(type);
        } else if (type == noButton) {
            displayArea3.setText("Order hasnot been deleted \n confirmation denied  ");
        } else {
            
            System.out.println("something went wrong");
        }
});
                    }
          
            }
	
        catch(WrongSpplierException e){
           displayArea3.setText(e.getMessage());
            }
    catch(NumberFormatException IMM){
                displayArea3.setText("order id field has to be an integer");
            }
    
    }
    private void makePaymentHandler(){
    try{	// get details from user
		String supplierIdEnterd = supllierIdField2.getText();  
		
               String amountEnterd = amountField.getText();
               
               
               if(supplierIdEnterd.length()!=0 && amountEnterd.length()!=0){
               
               if(supList.Search(supplierIdEnterd)!=null){
               
               
                double amount = Double.parseDouble(amountEnterd);
                Supplier s = supList.Search(supplierIdEnterd);
                boolean f = s.getSupplierOrders().isEmpty();
                
                if(f){
                displayArea4.setText("supplier "+s.getSupplierName()+"has no orders yet ");
                
                }
                else{
                
                LocalDate localDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
                String date = localDate.format(formatter);
                supList.makePayment(supplierIdEnterd, date, amount);
                displayArea4.setText("payment added successfully");
                
                }
                
            }else{
                   throw new WrongSpplierException ("Supplier does not exist");
               
               }  
               }
               }
            catch(WrongSpplierException e){
           displayArea4.setText(e.getMessage());
            }    
    
    }
    private void displayPaymentHandler(){
    try{
                    // get details from user
		String supplierIdEnterd = supllierIdField2.getText();  
		if(supplierIdEnterd.length()==0){
                
                displayArea4.setText("supplier id must be entered");
                }
                else if(supList.Search(supplierIdEnterd)==null){
                
                 throw new WrongSpplierException ("Supplier does not exist");
                }
                else{
                Supplier s = supList.Search(supplierIdEnterd);
                PaymentList p  = s.getPayments();
                if(s.getPayments().getTotal() == 0)
            {
                displayArea4.setText("No payments made for this supplier");
            } 
            else
            {  
                
                NumberFormat nf =  NumberFormat.getCurrencyInstance();
                String str;
                displayArea4.setText("Month" +  "\t\t\t\t" +  "Amount" +  "\n");
                for(int i =  1; i <=  p.getTotal(); i++  )
                {
                    str =  nf.format(p.getPayment(i).getAmount());
                    displayArea4.appendText("" + p.getPayment(i).getMonth() +  "\t\t\t" + str + "\n");
                } 
                displayArea4.appendText("\n" + "Total paid so far :   " + 				
                nf.format(p.calculateTotalPaid()));
               
                supllierIdField2.setText("");
                }
    }}
                catch(WrongSpplierException e){
            displayArea4.setText("no supplier with this id");
            }    
    
    }
    
    
    private void SaveAndQuit(){
         
          FileHandler.writeList(supList);
          Platform.exit();
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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
