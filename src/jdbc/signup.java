package jdbc;

import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.*;

import com.mysql.cj.exceptions.RSAException;

public class signup {
    
	
//	boolean login( String username ,String password)
//	{
//		boolean flag=false;
//		Connection connection=null;
//		Statement statement=null;
//		connection= model.getconnection();
//		
//		try {
//			statement=connection.createStatement();
//		} catch (SQLException e) {	
//			e.printStackTrace();
//		}
//		
//		String sqlString="select * from user where username='"+username+"' and password ='"+password+"'";
//		ResultSet rSet=null;
//		
//		 try {
//			rSet= statement.executeQuery(sqlString);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			if(rSet.next() )
//			{
//				flag=true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		return flag;
//		
//		
//	}

    boolean login(String username,String password)
    {
    	boolean flag=false;
    	Connection connection=null;
    	PreparedStatement preparedStatement=null;
    	ResultSet resultSet=null;
    	
    	
    	connection=model.getconnection();
    	String sql="select * from user where username= ? and password = ?";
    	
    	try {
			preparedStatement=connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			if(resultSet.next())
			{
				flag=true;
			}
			else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	return flag;
    }

}
