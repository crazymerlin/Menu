package menu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCStatement {

	public static void ProductListCreator() {
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
				Product.productList.add(new Product(rs.getInt(1), rs
						.getString(2), rs.getDouble(3), rs.getString(4), rs
						.getBoolean(5)));
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
					"jdbc:mysql://localhost:3306/menu", "root", "1111");
			String queryIngredientList = "SELECT mi.quantity, i.id, i.title, i.price, "
					+ "i.ingredientDimension, i.available, m.id, "
					+ "m.title, m.mealcategory FROM"
					+ " meals m "
					+ "JOIN mealitem mi ON (m.id = mi.mealid) "
					+ "JOIN ingredients i ON (mi.ingredientid = i.id) ORDER BY m.id";
			
			for (int i = 1; i <= 6; i++) {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(queryIngredientList);
				List<Ingredient> ingredientsList = new ArrayList<>();
				while (rs.next()) {
					if (rs.getInt(7) == i) {
						Product product = new Product();
						product.setId(rs.getInt(2));
						product.setTitle(rs.getString(3));
						product.setPrice(rs.getDouble(4));
						product.setProductDimension(rs.getString(5));
						product.setAvailable(rs.getBoolean(6));
						Ingredient ingredient = new Ingredient(rs.getInt(1),
								product);
						ingredientsList.add(ingredient);
					}
				}rs.close();
				
				java.sql.Connection con1 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/menu", "root", "1111");
				String queryMeal = "SELECT id, title, "
						+ "mealcategory FROM meals WHERE  id= ?";
				PreparedStatement pstmt = con1.prepareStatement(queryMeal);
				pstmt.setInt(1, i);
				ResultSet rs1 = pstmt.executeQuery();
				while (rs1.next()) {
				Meal meal = new Meal(rs1.getInt(1), 
						rs1.getString(2),
						rs1.getString(3), 
						ingredientsList);
				Meal.mealList.add(meal);
				}
			}
			System.out.println(Meal.mealList);
			// rs1.close();
			// stmt.close();
			// con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
}
