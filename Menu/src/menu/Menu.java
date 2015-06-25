package menu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/menu", "root", "root");
//			new JDBCStatement().IngredientCreater();
//			new JDBCStatement().portionOfIngredientsListCreater();
			new JDBCStatement().MealListCreater();
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
		}
	}
}
// ReaderWriter readerWriter = new ReaderWriter();
//
// PriceSort complexesMeals = new PriceSort(20);
// readerWriter.writeToFile(complexesMeals);
//
// PriceSort sortFromFile = new PriceSort();
// sortFromFile = readerWriter.readFromFile(PriceSort.class);
// System.out.println(sortFromFile.toString());
