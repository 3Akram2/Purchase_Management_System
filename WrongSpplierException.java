/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseworkgui;

/**
 *
 * @author akram
 */
public class WrongSpplierException extends RuntimeException{
    public  WrongSpplierException(){
    System.out.print("invaild Supplier details");
    }
    public WrongSpplierException (String message) // constructor with parameter
{
super (message);
}
}
