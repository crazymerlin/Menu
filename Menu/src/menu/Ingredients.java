/**
 * 
 */
package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skaraltc
 * 
 */
public class Ingredients {

	/** This is private array list of Ingredients objects */
	private List<Ingredient> ingredientsList = new ArrayList<Ingredient>();

	public Ingredients() {
		super();
	}

	public void initializeIngredientsList() {
		PortionsOfMeals meals = new PortionsOfMeals();
		this.ingredientsList = meals.getIngredientsList();
	}
	
	public List<Ingredient> getIngredientsList() {
		return ingredientsList;
	}

	public void setIngredientsList(List<Ingredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}

}
