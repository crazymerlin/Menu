package menu;

import java.util.ArrayList;
import java.util.List;

public class Meal {

	private int id;
	private String title;
	private MealCategory mealcategory;
	private double price;
	private boolean available;
	private List<Ingredient> ingredientList = new ArrayList<>();
	
	/** This is private array list of Meals objects */
	public static List<Meal> mealList = new ArrayList<Meal>();

	public Meal() {
		super();
	}

	/**
	 * @param title
	 * @param mealcategory
	 * @param ingredientList
	 */
	public Meal(int id, String title, String mealcategory,
			List<Ingredient> ingredientList) {
		super();
		this.id = id;
		this.available = true;
		this.title = title;
		this.mealcategory = MealCategory.valueOf(mealcategory);
		this.ingredientList = ingredientList;
		for (Ingredient ingredient : ingredientList) {
			this.price += ingredient.getPrice();
		}
		for (Ingredient ingredient : Ingredient.ingredientsList) {
			if (!ingredient.getIngredient().isAvailable()) {
				this.available = false;
				break;
			}
		}
	}
	
	/**
	 * @return the mealList
	 */
	public static List<Meal> getMealList() {
		return mealList;
	}

	/**
	 * @param mealList the mealList to set
	 */
	public static void setMealList(List<Meal> mealList) {
		Meal.mealList = mealList;
	}

	public void addMeal(Meal meal) {
		if (meal.isAvailable()) {
			mealList.add(meal);
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
	public void setMealcategory(String mealcategory) {
		this.mealcategory = MealCategory.valueOf(mealcategory);
	}

	/**
	 * @return the ingredientPortionsList
	 */
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	/**
	 * @param ingredientList
	 *            the ingredientPortionsList to set
	 */
	public void setIngredientList(
			ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
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
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Meal " + title + " [id=" + id + ", title=" + title + ", mealcategory="
				+ mealcategory + ", price=" + price + ", available="
				+ available + ", ingredientList= \n "
				+ ingredientList + "\n" + "]";
	}



}
