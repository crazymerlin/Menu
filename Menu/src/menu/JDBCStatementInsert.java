package menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementInsert {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/menu";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public static void main(String[] argv) {

		try {

			insertRecordIntoDbUserTable();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

	}

	private static void insertRecordIntoDbUserTable() throws SQLException {

		Connection dbConnection = null;
		Statement statement = null;
		PreparedStatement selectAll = null;

		String insertTableSQL = "INSERT INTO ingredients"
				+ "(title, price, ingredientDimension, available) " + "VALUES"
				+ "('carrot', '0.0052', 'GR', TRUE)";

		String selectAllFromMenu = "SELECT * FROM ingredients"
				+ "WHERE id= ? and title= ?";

		try {
			dbConnection = getDBConnection();
			statement = dbConnection.createStatement();
			
			selectAll = dbConnection.prepareStatement(selectAllFromMenu);
			selectAll.setInt(1, 1);
			selectAll.setString(2, "carrot");

//			System.out.println(insertTableSQL);

			// execute insert SQL stetement
//			statement.executeUpdate(insertTableSQL);

			ResultSetMetaData rsmd = rs.
			
			ResultSet rs = statement.executeQuery("SELECT title, price FROM ingredients");
//			Ingredient carrot = new Ingredient();
			System.out.println(rs.getType());

//			System.out.println("Record is inserted into MENU table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}

	private static Connection getDBConnection() {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
}
