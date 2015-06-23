package menu;

public class Menu {

	public static void main(String[] args) {

//		Ingredient ing = new Ingredient("car", -1, "GR", true);
//		System.out.println(ing.toString());
		
		
//		PriceSort sort = new PriceSort();
//		sort.complexDinner(100);
		
		ReaderWriter readerWriter = new ReaderWriter();
		PortionsOfMeals meals = new PortionsOfMeals();
//		
		readerWriter.writeToFile(
				 "D:/fedechko/Menu/Files/meals.txt", PortionsOfMeals.class);
//		System.out.println(meals.toString());
				 
//		PortionsOfMeals meals = readerWriter.readFromFile(
//				 "D:/fedechko/Menu/Files/meals.txt", PortionsOfMeals.class);
//				 System.out.println(meals.toString());
	}

}
