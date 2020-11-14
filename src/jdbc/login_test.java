package jdbc;

import java.sql.*;

import org.junit.Test;

public class login_test{
	
	
	@Test
	public void login()
	{
		signup  user1=new signup();
	     
	     boolean flag=user1.login("Û¨¿¥","123456");
	     
	     if(flag)
	     {
	    	 System.out.print("µÇÂ½³É¹¦£¡");
	     }
	     else {
			System.out.print("µÇÂ½Ê§°Ü£¡");
		}
	}
     
     
      
      
      
 }
