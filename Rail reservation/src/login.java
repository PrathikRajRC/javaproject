import java.sql.*;
import javax.swing.*;
import java.io.*;
public class login {
	Connection con=null;
	PreparedStatement pst=null;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	String log()throws Exception
	{
		while(true)
		{
		try {
			con=Sqliteconnect.sqlite();
			    System.out.println("****************************************");
				System.out.println("Username :");
			    String s=br.readLine();
			 pst=con.prepareStatement("select * from logininfo where username=?");
			pst.setString(1, s);
		  ResultSet rs=pst.executeQuery();
		  System.out.println("Password :");
			String p=br.readLine();
		  if(rs.getString("password").contentEquals(p)) {
			  JOptionPane.showMessageDialog(null,"Login Successfull");
			  JOptionPane.showMessageDialog(null,"Welcome "+s,"welcome",JOptionPane.PLAIN_MESSAGE);
			  pst.close();
			  return s;
		  }
		  else {
			  JOptionPane.showMessageDialog(null,"wrong password","WARNING",JOptionPane.WARNING_MESSAGE);
		  }
		  pst.close();
		  rs.close();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"This username doesnt exists","NOT FOUND",JOptionPane.ERROR_MESSAGE);
		}
		} 
	}

}
