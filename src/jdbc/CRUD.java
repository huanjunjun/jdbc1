package jdbc;

import java.sql.*;

import javax.print.DocFlavor.STRING;



public class CRUD {
	public static void main(String arg[])
	{
		CRUD crud=new CRUD();
		
		crud.CRUD_update();
		crud.CRUD_update2();
	}
	
	
       public void CRUD_update() 

       {
    	   Connection conn=null;
    	   Statement statement=null;
    	   
    	   try{
    		   Class.forName("com.mysql.cj.jdbc.Driver");
    	   }catch(Exception ex)
    	   {
    		   System.out.println("ע���������ִ���");
    	   }
    	   
    	   try {
			  conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?serverTimezone=GMT","root","123456");
			}catch(SQLException e) {
				System.out.println("��ȡ���ӳ��ִ���");
			}
    	   
    	   try {
			Statement  sttmt=conn.createStatement();
			int  num=sttmt.executeUpdate("insert into user values (2,'hj', '1234','ۨ��' )");
			if(num>0)
			{
				System.out.print(" ���³ɹ��� ");
			}
		} catch (SQLException e) {
			System.out.print("ִ��sql����");
		}
    	   finally{
    		   
    	   }
       }

       public void CRUD_update2()
       {
    	   Connection connection=null;
    	   Statement  statement=null;
    	   
    	   try {
    		   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	   
        	   connection=DriverManager.getConnection("jdbc:mysql://localhost/db1?serverTimezone=GMT","root","123456");
        	   //�������
        	   
        	   statement=connection.createStatement();
        	   //����sql������
        	   String sqlString="update user set username='ۨ��' , name='ۨ��' where id=1 ";
        	   
        	   int num= statement.executeUpdate(sqlString);
        	   
        	   if(num>0)
        	   {
        		   System.out.print("���ݿ���³ɹ���");
        	   }
		} catch (SQLException e) {
			System.out.print("���ִ���");
		}
    	   
    	   
    	   
    	   
    	   
    	   
       }
}
