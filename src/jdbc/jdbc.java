package jdbc;

import java.sql.*;


public class jdbc {
    public static void main(String[] args) {
    	
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
           System.out.println("加载驱动错误！");
        }
        
        Connection conn=null;
        
        
        try{
        	 conn = DriverManager.getConnection("jdbc:mysql://localhost/db1?serverTimezone=GMT",
                    "root","123456");
        }catch(SQLException ex)
        {
        	System.out.println("获取连接错误！");
        	 System.out.println("SQLException: " + ex.getMessage());
        	 System.out.println("SQLState: " + ex.getSQLState());
        	 System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user");


            if (stmt.execute("SELECT * FROM user")) {
                rs = stmt.getResultSet();
            }
            
            while(rs.next())
            {
            	System.out.print(rs.getInt("id")+" ");
            	System.out.print(rs.getString("username")+" ");
            	System.out.print(rs.getString("password")+" ");
            	System.out.print(rs.getString("name")+" ");
            	System.out.println();
            }
            

        }
        catch (SQLException ex){
        	System.out.println("获取对象执行sql发生错误！");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore

                stmt = null;
            }
            if(conn!=null)
            {
            	try {
					conn.close();
				} catch (SQLException e) {}
            	
            	conn=null;
            }
    }
  }
}