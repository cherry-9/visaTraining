import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.visa.training.JDBC.ConnectionHelper;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		Connection c= ConnectionHelper.getConnection();
		DatabaseMetaData md=c.getMetaData();
		System.out.println(md.getDatabaseProductName());
		System.out.println(md.getDatabaseProductVersion());
	}

}
