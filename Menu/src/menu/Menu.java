package menu;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;
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
			 java.sql.Statement stmt = con.createStatement();
//			 String query = "CREATE TABLE ingredients (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, title CHAR(20)";
	         int rs = stmt.executeUpdate("CREATE TABLE ingredients (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, title CHAR(20), price DOUBLE, ingredientDimension CHAR(4), available BIT(1))");
	         
//	         , price DOUBLE(9), ingredientDimension CHAR(4), available BIT(1)
		} catch (SQLException e) {
			System.out.println("SQL exception occured" + e);
			
		}

		
		
		
		
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
