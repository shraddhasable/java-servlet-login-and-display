import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection connection = null;

	{
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://18.221.112.173:5432/denmark", "roger", "roger");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
	{
		if(connection==null)
		{
			try {
				Class.forName("org.postgresql.Driver");
				connection  = DriverManager.getConnection("jdbc:postgresql://18.221.112.173:5432/denmark", "roger", "roger");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	
		}
	}

