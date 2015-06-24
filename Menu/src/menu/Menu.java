package menu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {
	public static final String driver = "com.mysql.jdbc.Driver";

	public static void main(String[] args) {

		
		
//		new PortionsOfMeals().initializeMealList();
		
		
		try {

			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", "root");

			
			
//			String insertTableSQL = "INSERT INTO ingredients"
//					+ "(title, price, ingredientDimension, available) " + "VALUES"
//					+ "('carrot', '0.0052', 'GR', TRUE)";
			
//			String insertTableSQL2 = "INSERT INTO ingredients"
//					+ "(title, price, ingredientDimension, available) VALUES"
//					+ "(?, ?, ?, ?)";
//			
//			PreparedStatement pstmt = con.prepareStatement(insertTableSQL2);
//			
//			for (Ingredient ingred : PortionsOfMeals.ingredients)
//			{
//				pstmt.setString(1, ingred.getTitle());
//				pstmt.setDouble(2, ingred.getPrice());
//				pstmt.setString(3, ingred.getIngredientDimension().toString());
//				pstmt.setBoolean(4, ingred.isAvailable());
//				pstmt.executeUpdate();
//				
//			}
			
			Statement stmt = con.createStatement();
			
			
			ResultSet rs = stmt.executeQuery("SELECT id, title, price, "
			+ "ingredientDimension, available FROM ingredients");
			while (rs.next())
			{
			Ingredient.lst.add(new Ingredient(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getBoolean(5)));
			}
			System.out.println(Ingredient.lst);
			
			new PortionsOfMeals().initMenu();
			System.out.println(PortionsOfMeals.mealList);
			
			
			// pstmt.setInt(1, 1);
			// pstmt.setString(2, "carrot");
			// ResultSet prs = pstmt.executeQuery();

//			 stmt.execute(queryDrop);
//			 stmt.execute(queryCreate);


//			ResultSet rs = stmt.executeQuery("select * from ingredients");
//			Ingredient carrot = new Ingredient(rs);

//			ResultSet rs = stmt.executeQuery("SELECT id, title, price, "
//					+ "ingredientDimension, available FROM ingredients");
//
//			while (rs.next()) {
//				System.out.println(rs.getRow());
//				System.out.println(rs.getString(2) + ":");
//				System.out.println(rs.getDouble("price"));
//				System.out.println(rs.getCharacterStream(4));
//				System.out.println(rs.getBoolean(5));
//			}
//			con.close();
//			stmt.close();
//			pstmt.close();
//			rs.close();

		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);

		}

//		String queryDrop = "DROP TABLE IF EXISTS ingredients";
//		String queryCreate = "CREATE TABLE ingredients "
//				+ "(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, "
//				+ "title VARCHAR(20), price DOUBLE, "
//				+ "ingredientDimension VARCHAR(4), available BIT(1))";
//		String selectAllFromMenu = "SELECT * FROM ingredients"
//				+ "WHERE id= ? and title= ?";
//		java.sql.Statement stmt = con.createStatement();
		
		// Ingredient ing = new Ingredient("≥‚‡", 0.0005,
		// IngredientDimension.GR, true); // TODO: Initialize to an appropriate
		// System.out.println(ing);

		// ReaderWriter readerWriter = new ReaderWriter();
		//
		// PriceSort complexesMeals = new PriceSort(20);
		// readerWriter.writeToFile(complexesMeals);
		//
		// PriceSort sortFromFile = new PriceSort();
		// sortFromFile = readerWriter.readFromFile(PriceSort.class);
		// System.out.println(sortFromFile.toString());

	}
	
}
