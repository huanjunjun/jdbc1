package jdbc;

import java.sql.*;

import org.junit.Test;

public class login_test{
	
	
	@Test
	public void login()
	{
		signup  user1=new signup();
	     
	     boolean flag=user1.login("ۨ��","123456");
	     
	     if(flag)
	     {
	    	 System.out.print("��½�ɹ���");
	     }
	     else {
			System.out.print("��½ʧ�ܣ�");
		}
	}
     
     
      
      
      
 }
