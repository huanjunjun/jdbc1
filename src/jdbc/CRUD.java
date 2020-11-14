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
    		   System.out.println("注册驱动出现错误");
    	   }
    	   
    	   try {
			  conn=DriverManager.getConnection("jdbc:mysql://localhost/db1?serverTimezone=GMT","root","123456");
			}catch(SQLException e) {
				System.out.println("获取连接出现错误！");
			}
    	   
    	   try {
			Statement  sttmt=conn.createStatement();
			int  num=sttmt.executeUpdate("insert into user values (2,'hj', '1234','郇骏' )");
			if(num>0)
			{
				System.out.print(" 更新成功！ ");
			}
		} catch (SQLException e) {
			System.out.print("执行sql出错！");
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
        	   //获得连接
        	   
        	   statement=connection.createStatement();
        	   //创建sql语句对象
        	   String sqlString="update user set username='郇骏' , name='郇骏' where id=1 ";
        	   
        	   int num= statement.executeUpdate(sqlString);
        	   
        	   if(num>0)
        	   {
        		   System.out.print("数据库更新成功！");
        	   }
		} catch (SQLException e) {
			System.out.print("出现错误");
		}
    	   
    	   
    	   
    	   
    	   
    	   
       }
}
