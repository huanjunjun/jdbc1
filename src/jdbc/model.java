package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class model {
	     
	private static final String driverclassname;
	private static final String url;
	private static final String username;
	private static final String password;
	static{
		//获取属性文件内容：
		Properties properties=new Properties();
		
		try {
			properties.load(new FileInputStream("src/db.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		driverclassname=properties.getProperty("driverclassname");;
		url=properties.getProperty("url");
		username=properties.getProperty("username");
		password=properties.getProperty("password");
	}
	
          public static void main(String arg[])
          {
        	  model mdl=new model();
          }
          
          
         public static void loaddriver()
          {
        	  try {
				Class.forName(driverclassname);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
         public static Connection getconnection()
         {
        	 
        	 Connection connection=null;
        	 try {
        		loaddriver();
				connection= DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 
			return connection;
        	  
         }
         
         public static void release(Statement statement ,Connection connection)
         {
        	 if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException sqlEx) { } // ignore

                 statement = null;
             }
             if(connection!=null)
             {
             	try {
 					connection.close();
 				} catch (SQLException e) {}
             	
             	connection=null;
             }
         }
         public static void release(ResultSet resultSet,Statement statement ,Connection connection)
         {
        	 if (resultSet != null) {
                 try {
                     resultSet.close();
                 } catch (SQLException sqlEx) { } // ignore

                 resultSet = null;
             }
        	 if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException sqlEx) { } // ignore

                 statement = null;
             }
             if(connection!=null)
             {
             	try {
 					connection.close();
 				} catch (SQLException e) {}
             	
             	connection=null;
             }
         }
         
}
