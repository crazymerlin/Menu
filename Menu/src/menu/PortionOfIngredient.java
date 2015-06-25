/**
 * Copyright SoftServe.inc
 */

package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sviatoslav
 * 
 */
public class PortionOfIngredient {

	private double quantity;
	private Ingredient ingredient;
	private double price;

	/** This is private array list of PortionOfIngredient objects */
	public static List<PortionOfIngredient> portionOfIngredientsList = new ArrayList<>();

	public PortionOfIngredient() {
		super();
	}

	/**
	 * @param quantity
	 * @param ingredient
	 * @param price
	 * @param availability
	 */
	public PortionOfIngredient(double quantity, Ingredient ingredient) {
		super();
		this.quantity = quantity;
		this.ingredient = ingredient;
		double tmpPrice = Math.round(quantity * ingredient.getPrice() * 100.0);
		this.price = tmpPrice / 100;
	}
	
	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the ingredient
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}

	/**
	 * @param ingredient
	 *            the ingredient to set
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the portionOfIngredientsList
	 */
	public static List<PortionOfIngredient> getPortionOfIngredientsList() {
		return portionOfIngredientsList;
	}

	/**
	 * @param portionOfIngredientsList
	 *            the portionOfIngredientsList to set
	 */
	public static void setPortionOfIngredientsList(
			List<PortionOfIngredient> portionOfIngredientsList) {
		PortionOfIngredient.portionOfIngredientsList = portionOfIngredientsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PortionOfIngredient " + ingredient.getTitle() + " [quantity="
				+ quantity + ", ingredient=" + ingredient + ", price=" + price
				+ "]";
	}

}
