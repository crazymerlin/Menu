package menu;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {

	public static final String driver = "com.mysql.jdbc.Driver";

	public static void IngredientReader() {

		try {

			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", "root");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT id, title, price, "
					+ "ingredientDimension, available FROM ingredients");
			while (rs.next()) {
				Ingredient.lst.add(new Ingredient(rs.getInt(1),
						rs.getString(2), rs.getDouble(3), rs.getString(4), rs
								.getBoolean(5)));
			}
			con.close();
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);

		}
	}

	public static void MealReader() {
		try {

			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", "root");

			Statement stmt = con.createStatement();

//			ResultSet rs = stmt.executeQuery("SELECT id, title, price, "
//					+ "mealcategory, available FROM meals");
//			while (rs.next()) {
//				PortionsOfMeals.mealList.add(new Meal(rs.getInt(1), rs
//						.getString(2), rs.getString(3), rs.getDouble(4), rs
//						.getString(5), rs.getBoolean(6)));
//			}
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
}
