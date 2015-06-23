package menu;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private String title;
	private MealCategory mealcategory;
	private double price;
	private boolean available;
	private List<PortionOfIngredient> ingredientPortionsList = new ArrayList<>();

	
	
	
	public Meal() {
		super();
	}

	/**
	 * @param title
	 * @param mealcategory
	 * @param ingredientPortionsList
	 */
	public Meal(String title, String mealcategory,
			List<PortionOfIngredient> ingredientPortionsList) {
		super();
		this.available = true;
		this.title = title;
		this.mealcategory = MealCategory.valueOf(mealcategory);
		this.ingredientPortionsList = ingredientPortionsList;
		for (PortionOfIngredient portionOfIngredient : ingredientPortionsList) {
			this.price += portionOfIngredient.getPrice();
		}
		for (PortionOfIngredient portionOfIngredient : ingredientPortionsList) {
			if (!portionOfIngredient.getIngredient().isAvailable()) {
				this.available = false;
				break;
			}
		}
	}

	/**
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
	 * @return the mealcategory
	 */
	public MealCategory getMealcategory() {
		return mealcategory;
	}

	/**
	 * @param mealcategory
	 *            the mealcategory to set
	 */
	public void setMealcategory(MealCategory mealcategory) {
		this.mealcategory = mealcategory;
	}

	/**
	 * @return the ingredientPortionsList
	 */
	public List<PortionOfIngredient> getIngredientPortionsList() {
		return ingredientPortionsList;
	}

	/**
	 * @param ingredientPortionsList
	 *            the ingredientPortionsList to set
	 */
	public void setIngredientPortionsList(
			ArrayList<PortionOfIngredient> ingredientPortionsList) {
		this.ingredientPortionsList = ingredientPortionsList;
	}

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available
	 *            the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Meal " + title + " [title=" + title + ", mealcategory="
				+ mealcategory + ", priceForMeal=" + price + ", available="
				+ available + ", ingredientPortionsList="
				+ ingredientPortionsList + "]\n";
	}

}
