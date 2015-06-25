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

	/** This is private array list of Meals objects */
	public static List<Meal> mealList = new ArrayList<Meal>();

	public PortionsOfMeals() {
		super();
	}
	
	public void addMeal(Meal meal) {
		if (meal.isAvailable()) {
			mealList.add(meal);
		}
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
		return "PortionsOfMeals [ingredientsList=" + Ingredient.ingredientList
				+ ", portionOfIngredientsList=" + PortionOfIngredient.portionOfIngredientsList
				+ "]";
	}
}
