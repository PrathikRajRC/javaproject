import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.util.regex.*;
public class register {
	Connection con=null;
	PreparedStatement pst=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Console cs=System.console();
   void reg()throws Exception
   {   while(true) {
	   try {
		   con=Sqliteconnect.sqlite();                                   //establish connection
		   System.out.println("****************************************");
		   System.out.println("Create Username");
		   String s=br.readLine();
		   Pattern p=Pattern.compile("^[a-zA-z][\\w]{2,30}");          //USERNAME validation using Regular Expression 
		   Matcher m=p.matcher(s);
		   System.out.println("Create password");
		    String p1=br.readLine();
		   System.out.println("re-enter password");
		   String p2=br.readLine();
		 if( p1.isBlank() ||p2.isBlank()) {
			   JOptionPane.showMessageDialog(null,"ALL FIELDS ARE MANDATORY","Warning",JOptionPane.ERROR_MESSAGE);
			   continue;
		   }
		 if(m.matches()) {
		     if(p1.equals(p2)) {
			         pst=con.prepareStatement("insert into logininfo(username,password) values(?,?)");
			         pst.setString(1,s);
			         pst.setString(2,p1);
			         pst.executeUpdate();
			         JOptionPane.showMessageDialog(null,"Registration Successful");
			         pst.close();
			         break;
		              }
		      else 
			      JOptionPane.showMessageDialog(null,"Password doesnt match","Warning",JOptionPane.WARNING_MESSAGE);
		          pst.close();        //close connection
		 }
		 else {
			 String po="USERNAME:\n* MUST contain MINIMUM 3 characters\n* CANNOT start with a DIGIT or SPECIAL CHARACTER\n* CANNOT contain special characters other than UNDERSCORE(_)\n* CANNOT contain space \n* DOES NOT exceed 30 characters";
			 JOptionPane.showMessageDialog(null, po,"Rules",JOptionPane.ERROR_MESSAGE);
			 continue;
		 }
	       }catch(Exception e) {
	    	   JOptionPane.showMessageDialog(null,e);
	          }
   }
   }
}
