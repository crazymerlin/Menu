/**
 * 
 */

package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * This public class creates an Ingredient object with followed parameters:
 * (String) title, (double) price, (Dimension (enum)) dimension, (boolean)
 * availability.
 * 
 * @author Sviatoslav
 * 
 * @version 1.0
 * @since 1.0
 */
public class Ingredient {
	
	private int id;

	public static List  <Ingredient> lst = new ArrayList  <Ingredient> ();
	/** This private String value consist the title of dish ingredient. */
	private String title;

	/** This private double value consist the price of dish ingredient. */
	private double price;

	/** This private enum value consist the type of ingredient dimension. */
	private IngredientDimension ingredientDimension;

	/**
	 * This private boolean value consist the availability of dish ingredient.
	 */
	private boolean available;

	
	public Ingredient() {
		super();
	}
	/**
	 * This public constructor set up all parameters. title, price, dimension,
	 * available.
	 * 
	 * @param title
	 *            String type
	 * @param price
	 *            double type
	 * @param dimension
	 *            String type
	 * @param available
	 *            boolean type
	 */
	public Ingredient(int id, String title, double price, String ingredientDimension,
			boolean available) {
		super();
		this.id = id;
		this.title = title;
		
		if (price <= 0) {
			System.out.println("Your price must be above 0");
		} else {
			this.price = price;
		}
		this.ingredientDimension = IngredientDimension.valueOf(ingredientDimension);
		this.available = available;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ingredient " + title + " [id=" + id + ", title=" + title + ", price=" + price
				+ ", ingredientDimension=" + ingredientDimension
				+ ", available=" + available + "]";
	}
	/**
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the dimension
	 */
	public IngredientDimension getIngredientDimension() {
		return ingredientDimension;
	}

	/**
	 * @param ingredientDimension
	 *            the dimension to set
	 */
	public void setIngredientDimension(String ingredientDimension) {
		this.ingredientDimension = IngredientDimension
				.valueOf(ingredientDimension);
	}

	/**
	 * @return the availability
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param availability
	 *            the availability to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	

}
