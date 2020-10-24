import java.io.*;
import javax.swing.*;

public class logreg {
	String manage()throws Exception
	{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	register r=new register();
	login l=new login();
	String i=null;
	while(i==null) 
	{
    System.out.println("****************************************");
	System.out.println("1=>>Register New User");
	System.out.println("2=>>Login");
	System.out.println("3=>>EXIT");
	int a=Integer.parseInt(br.readLine());
	switch(a)
	{
	case 1: r.reg();
	        break;
	case 2:  i=l.log();
	        break;
	case 3: System.exit(0);
	 default:JOptionPane.showMessageDialog(null,"enter valid choice");
	         break;
	}
	
	}
	return i;

	}
}
