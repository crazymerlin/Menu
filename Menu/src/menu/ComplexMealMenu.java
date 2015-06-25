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
public class ComplexMealMenu {

	public static List<ComplexMeal> complexMealList = new ArrayList<>();

	public ComplexMealMenu() {
		super();
	}

	public void addComplexMeal(ComplexMeal complexMeal) {
		ComplexMealMenu.complexMealList.add(complexMeal);
	}

	public List<ComplexMeal> complexDinner(int price) {
		for (int i = 0; i < Meal.mealList.size(); i++) {
			if ((Meal.mealList.get(i).isAvailable())
					&& (Meal.mealList.get(i).getMealcategory()
							.equals(MealCategory.FIRST))) {
				for (int j = 0; j < Meal.mealList.size(); j++) {
					if ((Meal.mealList.get(j).isAvailable())
							&& (Meal.mealList.get(j).getMealcategory()
									.equals(MealCategory.SECOND))) {
						for (int l = 0; l < Meal.mealList.size(); l++) {
							if ((Meal.mealList.get(l).isAvailable())
									&& (Meal.mealList.get(l).getMealcategory()
											.equals(MealCategory.DRINK))) {
								if (Meal.mealList.get(i).getPrice()
										+ Meal.mealList.get(j).getPrice()
										+ Meal.mealList.get(l).getPrice() < price) {

									ComplexMealMenu.complexMealList
											.add(new ComplexMeal(Meal.mealList
													.get(i), Meal.mealList
													.get(j), Meal.mealList
													.get(l)));
								}
							}
						}
					}
				}
			}
		}
		return ComplexMealMenu.complexMealList;
	}

	/**
	 * @return the complexDinnerList
	 */
	public List<ComplexMeal> getComplexMealList() {
		return complexMealList;
	}

	/**
	 * @param complexDinnerList
	 *            the complexDinnerList to set
	 */
	public void setComplexMealList(List<ComplexMeal> complexMealList) {
		ComplexMealMenu.complexMealList = complexMealList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComplexMealMenu [complexMealList="
				+ ComplexMealMenu.complexMealList + "]";
	}

}
