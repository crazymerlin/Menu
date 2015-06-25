package menu;

import java.util.ArrayList;
import java.util.List;

public class ComplexMeal {

	public List<Meal> mealList = new ArrayList<>();

	public ComplexMeal() {
		super();
		
	}

	public ComplexMeal(Meal firstMeal, Meal secondMeal, Meal drink) {
		super();
		this.mealList.add(firstMeal);
		this.mealList.add(secondMeal);
		this.mealList.add(drink);
	}

	public ComplexMeal(List<Meal> mealList) {
		this.mealList = mealList;
	}

	/**
	 * @return the complexMeals
	 */
	public List<Meal> getMealList() {
		return mealList;
	}

	/**
	 * @param mealList
	 *            the complexMeals to set
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
		return "MealList=" + mealList + "]\n";
	}
}
