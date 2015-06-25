package menu;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatement {

	public static void IngredientReader() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
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
				Ingredient.ingredientList.add(
						new Ingredient(rs.getInt(1),
										rs.getString(2), 
										rs.getDouble(3),
										rs.getString(4), 
										rs.getBoolean(5)));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}

	public static void portionOfIngredientsListReader() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT mi.quantity, i.id, i.title, i.price, "
							+ "i.ingredientDimension, i.available FROM meals m "
							+ "JOIN mealitem mi ON (m.id = mi.mealid) "
							+ "JOIN ingredients i ON (mi.ingredientid = i.id)");
			while (rs.next()) {
				PortionOfIngredient pi = new PortionOfIngredient();
				Ingredient ingredient = new Ingredient();
				ingredient.setId(rs.getInt(2));
				ingredient.setTitle(rs.getString(3));
				ingredient.setPrice(rs.getDouble(4));
				ingredient.setIngredientDimension(rs.getString(5));
				ingredient.setAvailable(rs.getBoolean(6));
				pi.setQuantity(rs.getInt(1));
				pi.setIngredient(ingredient);
				PortionOfIngredient.portionOfIngredientsList.add(pi);
			}
			System.out.println(PortionOfIngredient.portionOfIngredientsList);
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
}
