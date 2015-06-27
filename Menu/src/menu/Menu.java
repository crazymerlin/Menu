package menu;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Menu {
	public static void main(String[] args) {

		new JDBCStatement().mealListCreator();
		
//		new JDBCStatement().addProductToMeal(1, 10, 200);
//		new JDBCStatement().deleteProductFromMeal(1, 10);

		// ReaderWriter readerWriter = new ReaderWriter();
		//
		// complexDinner complexesMeals = new complexDinner(20);
		// readerWriter.writeToFile(complexesMeals);
		//
		// complexDinner sortFromFile = new complexDinner();
		// sortFromFile = readerWriter.readFromFile(complexDinner.class);
		// System.out.println(sortFromFile.toString());

	}
}
