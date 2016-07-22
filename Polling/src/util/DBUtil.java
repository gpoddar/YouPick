package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private Connection conn;

	public Connection get() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String DB_URL = "jdbc:mysql://LocalHost:3306/poller";
		String USER = "root";
		String PASS = "040492";
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}

	public void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

}
