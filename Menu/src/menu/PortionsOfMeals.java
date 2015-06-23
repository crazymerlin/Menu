/**
 * 
 */
package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sviatoslav
 * 
 */
public class PortionsOfMeals {

	/** This is private array list of Ingredients objects */
	private static List<Ingredient> ingredients = new ArrayList<Ingredient>();

	/** This is private array list of PortionOfIngredient objects */
	private static List<PortionOfIngredient> portionOfIngredientsList = new ArrayList<>();

	/** This is private array list of Meals objects */
	private List<Meal> mealList = new ArrayList<Meal>();

	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
	}

	public void addPortionOfIngredient(
			ArrayList<PortionOfIngredient> portionOfIngredient) {
		portionOfIngredientsList.addAll(portionOfIngredient);
	}

	public void addMeal(Meal meal) {
		// check Avelable
		mealList.add(meal);

	}

	// public PortionsOfMeals() {
	// super();
	// }

	/**
	 * @param mealList
	 */
	public PortionsOfMeals() {
		initializeMealList();
		initMenu();
	}

	public void initializeMealList() {
		Ingredient carrot = new Ingredient("carrot", 0.0052, "GR", true);
		Ingredient potato = new Ingredient("potato", 0.0084, "GR", true);
		Ingredient oil = new Ingredient("oil", 0.015, "ML", true);
		Ingredient water = new Ingredient("water", 0.0005, "ML", true);
		Ingredient onion = new Ingredient("onion", 0.004, "GR", true);
		Ingredient pasta = new Ingredient("pasta", 0.0205, "GR", true);
		Ingredient blackTea = new Ingredient("blackTea", 0.40, "GR", true);
		Ingredient greenTea = new Ingredient("greenTea", 0.60, "GR", true);
		Ingredient meat = new Ingredient("meat", 0.099, "GR", true);
		ingredients.add(carrot);
		ingredients.add(potato);
		ingredients.add(oil);
		ingredients.add(water);
		ingredients.add(onion);
		ingredients.add(pasta);
		ingredients.add(blackTea);
		ingredients.add(greenTea);
		ingredients.add(meat);
	}

	public Ingredient getByTitle(String title) {
		for (Ingredient ingredient : ingredients) {
			if (ingredient.getTitle().equals(title)) {
				return ingredient;
			}
		}
		return null;
	}

	public void initMenu() {

		addMeal(new Meal("fryPotato", MealCategory.SECOND.toString(),
				new ArrayList<PortionOfIngredient>(Arrays.asList(
						new PortionOfIngredient(300, getByTitle("potato")),
						new PortionOfIngredient(50, getByTitle("onion")),
						new PortionOfIngredient(50, getByTitle("oil"))))));

		addMeal(new Meal("potatoPastaSoup", MealCategory.FIRST.toString(),
				new ArrayList<PortionOfIngredient>(Arrays.asList(
						new PortionOfIngredient(200, getByTitle("potato")),
						new PortionOfIngredient(200, getByTitle("pasta")),
						new PortionOfIngredient(50, getByTitle("onion")),
						new PortionOfIngredient(300, getByTitle("water"))))));

		addMeal(new Meal("fryPotatoWithMeat", MealCategory.SECOND.toString(),
				new ArrayList<PortionOfIngredient>(Arrays.asList(
						new PortionOfIngredient(300, getByTitle("potato")),
						new PortionOfIngredient(300, getByTitle("meat")),
						new PortionOfIngredient(50, getByTitle("onion")),
						new PortionOfIngredient(50, getByTitle("oil"))))));

		addMeal(new Meal("bigBlackTea", MealCategory.DRINK.toString(),
				new ArrayList<PortionOfIngredient>(Arrays.asList(
						new PortionOfIngredient(20,getByTitle("blackTea")), 
						new PortionOfIngredient(300,getByTitle("water"))))));
		
		addMeal(new Meal("bigGreenTea", MealCategory.DRINK.toString(),
				new ArrayList<PortionOfIngredient>(Arrays.asList(
						new PortionOfIngredient(20, getByTitle("greenTea")), 
						new PortionOfIngredient(300,getByTitle("water"))))));
		
		addMeal(new Meal("carrotPastaWaterSoup", MealCategory.FIRST.toString(),
				new ArrayList<PortionOfIngredient>(Arrays.asList(
						new PortionOfIngredient(200, getByTitle("carrot")),
						new PortionOfIngredient(200, getByTitle("pasta")),
						new PortionOfIngredient(300, getByTitle("water"))))));
	}

	/**
	 * @return the ingredientsList
	 */
	public List<Ingredient> getIngredientsList() {
		return ingredients;
	}

	/**
	 * @param ingredientsList
	 *            the ingredientsList to set
	 */
	public void setIngredientsList(List<Ingredient> ingredientsList) {
		this.ingredients = ingredientsList;
	}

	/**
	 * @return the portionOfIngredientsList
	 */
	public List<PortionOfIngredient> getPortionOfIngredientsList() {
		return portionOfIngredientsList;
	}

	/**
	 * @param portionOfIngredientsList
	 *            the portionOfIngredientsList to set
	 */
	public void setPortionOfIngredientsList(
			List<PortionOfIngredient> portionOfIngredientsList) {
		this.portionOfIngredientsList = portionOfIngredientsList;
	}

	/**
	 * @return the mealList
	 */
	public List<Meal> getMealList() {
		return mealList;
	}

	/**
	 * @param mealList
	 *            the mealList to set
	 */
	public void setMealList(List<Meal> mealList) {
		this.mealList = mealList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PortionsOfMeals [ingredientsList=" + ingredients
				+ ", portionOfIngredientsList=" + portionOfIngredientsList
				+ "]";
	}

}
