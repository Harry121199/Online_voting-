import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	public Connection getConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineVotingDB","root","Hkay1234@");
		return conn;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}catch(SQLException e) {
			return null;
		}
	}
}
