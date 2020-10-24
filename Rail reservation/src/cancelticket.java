import java.sql.*;
import javax.swing.*;
import java.io.*;
public class cancelticket {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	String pnr=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	cancelticket(String i)throws Exception
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
		        String disp2="\n\nConfirm Cancellation??";
		        int conf=JOptionPane.showConfirmDialog(null,disp+disp2,"Booking details",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        pst.close();
		        if(conf==1||conf==-1)
		        break;
		        else {
		        	con=Sqliteconnect.sqlite();
			    	pst=con.prepareStatement("delete  from ticketinfo where username=? and pnr=?");
			    	pst.setString(1, i);
			    	pst.setString(2, pnr);
			        pst.executeUpdate();
			        JOptionPane.showMessageDialog(null,"PNR :"+pnr+"\nTicket with the above PNR has been canceled");
			        pst.close();
			        break;
		        }
		         }
		    	catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
}
