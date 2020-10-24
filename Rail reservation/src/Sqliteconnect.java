import java.sql.*;
import javax.swing.*;
public class Sqliteconnect {
	static Connection con=null;
	public static Connection sqlite() {
		try {
		con=DriverManager.getConnection("jdbc:sqlite:reservation.db");
		//JOptionPane.showMessageDialog(null,"Welcome");
		return con;
	}catch(Exception e) {
	   	JOptionPane.showMessageDialog(null,e);
	   	return null;
	}
	}
}
