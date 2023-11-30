package courseworkgui;

import java.io.Serializable;

// This class is used to store details of a single payment in a hostel

public class Payment implements Serializable
{
	private String month;
	private double amount;
	
	public Payment(String monthIn, double amountIn)
	{
            month = monthIn;
            amount= amountIn;
	}
	
	public String getMonth()
	{
            return month;
	}
	
	public double getAmount()
	{
            return amount;
	}
        
   @Override
	public String toString()
   {
            return "("  + month + ", " + amount + ")";
   }

}

