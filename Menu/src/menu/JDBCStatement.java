package menu;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCStatement {

	public static void IngredientCreator() {
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
				Product.productList.add(new Product(
						rs.getInt(1), 
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

	public static void IngredientsListCreator() {
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
				Ingredient ingredient = new Ingredient();
				Product product = new Product();
				product.setId(rs.getInt(2));
				product.setTitle(rs.getString(3));
				product.setPrice(rs.getDouble(4));
				product.setProductDimension(rs.getString(5));
				product.setAvailable(rs.getBoolean(6));
				ingredient.setQuantity(rs.getInt(1));
				ingredient.setIngredient(product);
				Ingredient.ingredientsList.add(ingredient);
			}
			System.out.println(Ingredient.ingredientsList);
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}

	public static void MealListCreator() {
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
							+ "i.ingredientDimension, i.available, m.id, "
							+ "m.title, m.mealcategory FROM" 
							+ " meals m "
							+ "JOIN mealitem mi ON (m.id = mi.mealid) "
							+ "JOIN ingredients i ON (mi.ingredientid = i.id)");
			while (rs.next()) {
				for (int i = 1; i <= rs.getInt(7); i++) {
					List<Ingredient> ingredientList = new ArrayList<>();
					if (rs.getInt(7) == i) {
						
						Product product = new Product();
						product.setId(rs.getInt(2));
						product.setTitle(rs.getString(3));
						product.setPrice(rs.getDouble(4));
						product.setProductDimension(rs.getString(5));
						product.setAvailable(rs.getBoolean(6));
						Ingredient ingredient = new Ingredient(
								rs.getInt(1), product);
						ingredientList.add(ingredient);
					}
					Meal meal = new Meal(
							rs.getInt(7), 
							rs.getString(8),
							rs.getString(9), 
							ingredientList);
					
					Meal.mealList.add(meal);
				}
			}
			System.out.println(Meal.mealList);
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
}
