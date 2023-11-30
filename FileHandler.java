/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseworkgui;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.List;

/**
 *
 * @author akram
 */
public class FileHandler {
    public static void writeList(Suppliers suppListIn)
	{
       // use try-with-resources to ensure file is closed safely
	try(
   FileOutputStream suppFile = new FileOutputStream("Suppliers.obf");
    ObjectOutputStream suppStream = new ObjectOutputStream(suppFile);
)
		   
		{
                    List<Supplier> Supp = suppListIn.getSuppliers();

			// write each element of the list to the file 
			for(Supplier item : Supp)
                            
			{
			   suppStream.writeObject(item);
		   }
		}
		// handle the exception thrown by the FileWriter methods
		catch(IOException e)
		{
//			System.out.println("There was a problem writing the file");
                    System.out.print(e);
		}
	}
	
	// method for reading the file
	static void readList(Suppliers suppListIn)
{
boolean endOfFile = false;
Supplier tempSupp;
try(
// create a FileInputStream object, carFile
FileInputStream suppFile = new FileInputStream("Suppliers.obf");

ObjectInputStream suppStream = new ObjectInputStream(suppFile);
)
{
// reading the first  object with the readObject method
tempSupp = (Supplier) suppStream.readObject();
while(!endOfFile)
{
try
{
suppListIn.add(tempSupp);
// read the next (whole) object
tempSupp = (Supplier) suppStream.readObject();
}

catch(EOFException e)
{
endOfFile = true;
}
}
}
catch(FileNotFoundException e)
{
System.out.println("\nNo file was read");
}
catch(ClassNotFoundException e) // thrown by readObject
{
System.out.println("\nTrying to read an object of an unknown class");
}
catch(StreamCorruptedException e) // thrown by the constructor
{
System.out.println("\nUnreadable file format");
}
catch(IOException e)
{
//System.out.println("There was a problem reading the file");
     System.out.print(e);
}
}
}
