package Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBCUtil {
	public static Connection getConnection() {
	    Connection conn = null;
	    try {
	       String url = "jdbc:sqlserver://localhost:1433;databaseName=QLCafe;"
	            + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
	        String user = "sa"; 
	        String passWord = "123";
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        conn = DriverManager.getConnection(url, user, passWord);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return conn;
	}
	public static void closeConnection(Connection conn) {
	    try {
	        if (conn != null && !conn.isClosed()) {
	            conn.close();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}