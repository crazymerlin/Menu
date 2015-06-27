package menu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCStatement {
	
	public static final String pass = "1111";

	public static void productListCreator() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", pass);
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

	public static void ingredientsListCreator() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", pass);
			String queryListCreator = "SELECT mi.quantity, i.id, i.title, i.price, "
					+ "i.ingredientDimension, i.available FROM meals m "
					+ "JOIN mealitem mi ON (m.id = mi.mealid) "
					+ "JOIN ingredients i ON (mi.ingredientid = i.id)";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(queryListCreator);
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

	public static void mealListCreator() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", pass);
			String queryIngredientList = "SELECT mi.quantity, i.id, i.title, i.price, "
					+ "i.ingredientDimension, i.available, m.id, "
					+ "m.title, m.mealcategory "
					+ "FROM meals m "
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
						"jdbc:mysql://localhost:3306/menu", "root", pass);
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
	public static void addProduct() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", pass);
			String addProduct = "INSERT INTO ingredients"
					+ "(title, price, ingredientDimension, available) VALUES"
					+ "('salo', 0.055, 'GR', TRUE)";
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(addProduct);
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
	
	public static void addProductToMeal(int mealId, int productId, int productQuantity) {
		
		double mealPrice = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", pass);
			String addProductToMeal = "INSERT INTO mealitem"
					+ "(mealid, ingredientid, quantity) VALUES"
					+ "(?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(addProductToMeal);
			pstmt.setInt(1, mealId);
			pstmt.setInt(2, productId);
			pstmt.setInt(3, productQuantity);
			int add = pstmt.executeUpdate();
			pstmt.close();
			
			String queryIngredientPrice = "SELECT i.price, m.price "
					+ "FROM ingredients i, meals m WHERE i.id= ? AND m.id= ?";
			PreparedStatement pstmt1 = con.prepareStatement(queryIngredientPrice);
			pstmt1.setInt(1, productId);
			pstmt1.setInt(2, mealId);
			ResultSet price = pstmt1.executeQuery();
			while (price.next()) {
				mealPrice= price.getDouble(2) + price.getDouble(1)*productQuantity;
			}
			price.close();
			pstmt1.close();
			
			String updateMealPrice = "UPDATE meals SET price= ? "
					+ "WHERE id= ?";
			PreparedStatement update = con.prepareStatement(updateMealPrice);
			update.setDouble(1, mealPrice);
			update.setInt(2, mealId);
			int updatePrice = update.executeUpdate();
			update.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
	
	public static void deleteProductFromMeal(int mealId, int ingredientId) {
		
		double mealPrice = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", pass);
			
			String queryIngredientPrice = "SELECT i.price, mi.quantity, m.price "
					+ "FROM meals m "
					+ "JOIN mealitem mi ON (m.id = mi.mealid) "
					+ "JOIN ingredients i ON (mi.ingredientid = i.id)"
					+ "WHERE i.id=? AND mi.mealId=? AND mi.ingredientId=?;";
			PreparedStatement pstmt1 = con.prepareStatement(queryIngredientPrice);
			pstmt1.setInt(1, ingredientId);
			pstmt1.setInt(2, mealId);
			pstmt1.setInt(3, ingredientId);
			ResultSet price = pstmt1.executeQuery();
			while (price.next()) {
				mealPrice = price.getDouble(3) - price.getDouble(1)*price.getDouble(2);
			}
			price.close();
			pstmt1.close();
			
			String deleteProductFromMeal = "DELETE FROM mealitem "
					+ "WHERE mealId = ? AND ingredientId = ?";
			
			PreparedStatement pstmt = con.prepareStatement(deleteProductFromMeal);
			pstmt.setInt(1, mealId);
			pstmt.setInt(2, ingredientId);
			int delete = pstmt.executeUpdate();
			pstmt.close();
			
			
			String updateMealPrice = "UPDATE meals SET price= ? "
					+ "WHERE id= ?";
			PreparedStatement update = con.prepareStatement(updateMealPrice);
			update.setDouble(1, mealPrice);
			update.setInt(2, mealId);
			int updatePrice = update.executeUpdate();
			update.close();
			
			con.close();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
}
