import java.io.*;

import javax.swing.JOptionPane;

public class mainclass {
	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		logreg lr=new logreg();
		String i=lr.manage();
		while(true)
		{
			//if(count==1)
				//i=lr.manage();
	      System.out.println("****************************************");
		  System.out.println("1=>>Book Ticket");
		  System.out.println("2=>>View Ticket");
		  System.out.println("3=>>Cancel Booking");
		  System.out.println("4=>>Logout");
		  int c=Integer.parseInt(br.readLine());
		  switch(c)
		  {
		  case 1:booking b=new booking(i);
		         break;
		  case 2:viewticket v=new viewticket(i);
		         break;
		  case 3:cancelticket ca=new cancelticket(i);
		         break;
		  case 4:
		         i=lr.manage();
		         break;
		  }
		}
		}
	}


