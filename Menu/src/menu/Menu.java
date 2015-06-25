package menu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {

	public static final String driver = "com.mysql.jdbc.Driver";

	public static void main(String[] args) {

		try {

			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {

			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", "root");

			// String queryDrop = "DROP TABLE IF EXISTS Meals";
			// String queryCreate = "CREATE TABLE Meals "
			// + "(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, "
			// + "title VARCHAR(20), price DOUBLE, "
			// + "mealcategory VARCHAR(20), available BIT(1))";
			// java.sql.Statement stmt1 = con.createStatement();
			// int rs1 = stmt1.executeUpdate(queryCreate);

//			new JDBCStatement().IngredientReader();
			
			new JDBCStatement().portionOfIngredientsListReader();
			
			

	

			// Statement stmt = con.createStatement();
			//
			// ResultSet rs = stmt.executeQuery("SELECT id, title, price, "
			// + "mealcategory, available FROM meals");
			// while (rs.next())
			// {
			// Ingredient.lst.add(new
			// Ingredient(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getBoolean(5)));
			// }
			// System.out.println(Ingredient.lst);
			//
			// new PortionsOfMeals().initMenu();
			// System.out.println(PortionsOfMeals.mealList);
			//
			//
			// con.close();
			// stmt.close();
			// rs.close();

		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);

		}

	}

}

// String insertTableSQL2 = "INSERT INTO ingredients"
// + "(title, price, ingredientDimension, available) VALUES"
// + "(?, ?, ?, ?)";
//
// PreparedStatement pstmt = con.prepareStatement(insertTableSQL2);
//
// for (Ingredient ingred : PortionsOfMeals.ingredients)
// {
// pstmt.setString(1, ingred.getTitle());
// pstmt.setDouble(2, ingred.getPrice());
// pstmt.setString(3, ingred.getIngredientDimension().toString());
// pstmt.setBoolean(4, ingred.isAvailable());
// pstmt.executeUpdate();
//
// }
//new PortionsOfMeals().initMenu();
//String insertTableSQL2 = "INSERT INTO meals"
//		+ "(title, price, mealcategory, available) VALUES"
//		+ "(?, ?, ?, ?)";
//
//PreparedStatement pstmt = con.prepareStatement(insertTableSQL2);
//
//for (Meal meal : PortionsOfMeals.mealList) {
//	pstmt.setString(1, meal.getTitle());
//	pstmt.setDouble(2, meal.getPrice());
//	pstmt.setString(3, meal.getMealcategory().toString());
//	pstmt.setBoolean(4, meal.isAvailable());
//	pstmt.executeUpdate();
//
//}

// String queryDrop = "DROP TABLE IF EXISTS ingredients";
// String queryCreate = "CREATE TABLE ingredients "
// + "(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, "
// + "title VARCHAR(20), price DOUBLE, "
// + "ingredientDimension VARCHAR(4), available BIT(1))";
// String selectAllFromMenu = "SELECT * FROM ingredients"
// + "WHERE id= ? and title= ?";
// java.sql.Statement stmt = con.createStatement();

// ReaderWriter readerWriter = new ReaderWriter();
//
// PriceSort complexesMeals = new PriceSort(20);
// readerWriter.writeToFile(complexesMeals);
//
// PriceSort sortFromFile = new PriceSort();
// sortFromFile = readerWriter.readFromFile(PriceSort.class);
// System.out.println(sortFromFile.toString());
