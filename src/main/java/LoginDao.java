import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDao {

	private static Connection connection = null;

	public static String validate(String name, String pass) {
		// boolean status = false;
		System.out.println(name);
		System.out.println(pass);

		String dbUsername, dbPassword, query;
		boolean login = false;

		try {
			Connection connection = DBUtil.getConnection();
			Statement stmt = connection.createStatement();

			query = "SELECT username, password FROM employees;";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();

			while (rs.next()) {
				dbUsername = rs.getString("username");
				dbPassword = rs.getString("password");

				if (dbUsername.equals(name) && dbPassword.equals(pass)) {
					System.out.println("OK");
					login = true;
				}
				// System.out.println(name + pass + " " + dbUsername + dbPassword);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Employee> getAllEmployees() throws SQLException {

		connection = DBUtil.getConnection();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Statement statement = null;
		ResultSet rs = null;

		try {
			statement = connection.createStatement();
			rs = statement.executeQuery("SELECT * FROM EMPLOYEES LIMIT 100");

			while (rs.next()) {
				Employee empl = new Employee();
				empl.setEmployeeID(rs.getInt("EMPLOYEE_ID"));
				empl.setName(rs.getString("NAME"));
				empl.setPhone(rs.getString("PHONE_NUMBER"));
				empl.setSupervisor(rs.getString("SUPERVISORS"));
				empl.setUsername(rs.getString("USERNAME"));
				empl.setPassword(rs.getString("PASSWORD"));
				System.out.println(empl);
				employeeList.add(empl);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return employeeList;
	}

}