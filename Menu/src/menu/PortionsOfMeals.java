/**
 * 
 */
package menu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * @author Sviatoslav
 * 
 */
public class PortionsOfMeals {


	/** This is private array list of PortionOfIngredient objects */
	private static List<PortionOfIngredient> portionOfIngredientsList = new ArrayList<>();

	/** This is private array list of Meals objects */
	public static List<Meal> mealList = new ArrayList<Meal>();

	// public void addIngredient(Ingredient ingredient) {
	// ingredients.add(ingredient);
	// }

	public void addPortionOfIngredient(
			ArrayList<PortionOfIngredient> portionOfIngredient) {
		portionOfIngredientsList.addAll(portionOfIngredient);
	}

	public void addMeal(Meal meal) {
		// check Avelable
		if (meal.isAvailable()) {
			mealList.add(meal);
		}
	}

	public PortionsOfMeals() {
		super();
	}


	public Ingredient getByTitle(String title) {
		for (Ingredient ingredient : Ingredient.lst) {
			if (ingredient.getTitle().equals(title)) {
				return ingredient;
			}
		}
		return null;
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
		return "PortionsOfMeals [ingredientsList=" + Ingredient.lst
				+ ", portionOfIngredientsList=" + portionOfIngredientsList
				+ "]";
	}
}
