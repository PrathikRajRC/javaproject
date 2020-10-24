import java.sql.*;
import javax.swing.*;
import java.io.*;
public class viewticket {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String pnr=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	viewticket(String i)throws Exception
	{
		while(true)
		{
			 pnr=JOptionPane.showInputDialog(null,"PNR :");
		       if(pnr==null) 
		    	break;
		       else if(pnr.isBlank()) {
			    	JOptionPane.showMessageDialog(null,"Enter PNR");
			    	continue;
		       }
		    else try{
		    	con=Sqliteconnect.sqlite();
		    	pst=con.prepareStatement("select * from ticketinfo where username=? and pnr=?");
		    	pst.setString(1, i);
		    	pst.setString(2, pnr);
		        rs=pst.executeQuery();
		        String disp="Name :"+rs.getString(2)+"\nAge : "+rs.getInt(3)+"\nFrom :"+rs.getString(4)+"\nTo :  "+rs.getString(5)+"\nTime of Booking : "+rs.getString(7);
		        JOptionPane.showMessageDialog(null,disp,"Booking details",JOptionPane.INFORMATION_MESSAGE);
		        pst.close();
		        break;
		         }
		    	catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Enter Valid PNR","NOT FOUND",JOptionPane.ERROR_MESSAGE);
		}
	}
}
}