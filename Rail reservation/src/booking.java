import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import javax.swing.*;
import java.io.*;
public class booking {
	Connection con=null;
	PreparedStatement pst=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	booking(String i)throws Exception
	{ 
	while(true)
	{
		try {
			con=Sqliteconnect.sqlite();
		System.out.println("****************************************");
		System.out.println("Passenger Details");
		System.out.println("Name :");
		  String n=br.readLine();
		boolean bn=Pattern.matches("[a-zA-Z]*", n);   //NAME validation using REGULAR EXPRESSION
		System.out.println("Age :");
		  int a=Integer.parseInt(br.readLine());
		System.out.println("From Destination:");
		  String f=br.readLine();
		boolean bf=Pattern.matches("[a-zA-Z]*", f);   //FROM DESTINATION validation using REGULAR EXPRESSION
		System.out.println("To Destination:");
		  String t=br.readLine();
		boolean bt=Pattern.matches("[a-zA-Z]*", t);   //TO DESTINATION validation using REGULAR EXPRESSION
		System.out.println("Date Of Journey (DD/MM/YYYY) :");
		  String doj=br.readLine();
		boolean bd=Pattern.matches("^([12][0-9]|3[0-1]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}", doj);  //DATE validation using REGULAR EXPRESSION
		  if(bd==false) {
			  JOptionPane.showMessageDialog(null,"Enter Valid DATE in the given format (ex:09/05/2020)","VALIDATION",JOptionPane.ERROR_MESSAGE);
			  continue;
		  }
		int ra=ThreadLocalRandom.current().nextInt(100000000, 999999999); // Function to input random number within specified range
		  String pnr=String.valueOf(ra);
		java.util.Date date=new java.util.Date();     //Object that gives the CURRENT System DATE and TIME
		  String d=date.toString();
		  if(n.isBlank()||f.isBlank()||t.||a==0) {
			  JOptionPane.showMessageDialog(null, "ALL FIELDS ARE MANDATORY","VALIDATION",JOptionPane.ERROR_MESSAGE);
			  continue;
		  }
		if(bn && bf && bt && a!=0)
		{
		    if(f.equalsIgnoreCase(t)) 
			   JOptionPane.showMessageDialog(null,"From and To destinations Cannot be same ","ERROR",JOptionPane.ERROR_MESSAGE);
		    else {
			      String q="Name :"+n+"\nAge :"+a+"\nFrom :"+f+"\nTo :"+t+"\nDate Of Journey :"+doj+"\n\nConfirm Booking?";
			      int conf=JOptionPane.showConfirmDialog(null,q,"confirmation",JOptionPane.OK_CANCEL_OPTION);
			      if(conf==2||conf==-1)
				      break;
			      else {
		                String sq="insert into ticketinfo(username,name,age,fromd,tod,pnr,datee,dateob) values(?,?,?,?,?,?,?,?)";        //SQL command tp insert into database
		                pst=con.prepareStatement(sq); 
		                // Assigning each placeholder(i.e.?) with the value entered by user
		                pst.setString(1, i);             
		                pst.setString(2, n);
		                pst.setInt(3, a);
		                pst.setString(4, f);
		                pst.setString(5, t);
		                pst.setString(6,pnr);
		                pst.setString(7, d);
		                pst.setString(8,doj);
		                pst.executeUpdate();
		                String q1="\n\nNOTE: PLEASE RECORD PNR FOR FURTHER TICKET INTERACTIONS ";
		                JOptionPane.showMessageDialog(null,"Booking successfull At "+d+"\nPNR :"+ra+q1,"Important",JOptionPane.INFORMATION_MESSAGE);
		                pst.close();
		                break;
			           }
		          }
		}
		   else {
			   String po="* NAME CANNOT contain DIGIT or SPECIAL CHARACTERS\n* From Destination CANNOT contain DIGIT or SPECIAL CHARACTERS\n* To Destination CANNOT contain DIGIT or SPECIAL CHARACTERS\n* AGE CANNOT be 0";
			   JOptionPane.showMessageDialog(null, po,"VALIDATION",JOptionPane.ERROR_MESSAGE);
		   }
		
		    
		}catch(Exception e) {  
				 JOptionPane.showMessageDialog(null,"Enter Valid Age","ERROR",JOptionPane.ERROR_MESSAGE);
		 }
		 
		
		}
	}
}