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
public class PriceSort {

	private List<Meal> complexDinnerList = new ArrayList<>();

	public PriceSort() {
		super();
	}

	public PriceSort(int price) {
		complexDinner(price);
	}

	public void complexDinner(int price) {
		PortionsOfMeals meals = new PortionsOfMeals();
		for (int i = 0; i < meals.getMealList().size(); i++) {
			if ((meals.getMealList().get(i).isAvailable())
					&& (meals.getMealList().get(i).getMealcategory()
							.equals(MealCategory.FIRST))) {
				for (int j = 0; j < meals.getMealList().size(); j++) {
					if ((meals.getMealList().get(j).isAvailable())
							&& (meals.getMealList().get(j).getMealcategory()
									.equals(MealCategory.SECOND))) {
						for (int l = 0; l < meals.getMealList().size(); l++) {
							if ((meals.getMealList().get(l).isAvailable())
									&& (meals.getMealList().get(l)
											.getMealcategory()
											.equals(MealCategory.DRINK))) {
								if (meals.getMealList().get(i).getPrice()
										+ meals.getMealList().get(j).getPrice()
										+ meals.getMealList().get(l).getPrice() < price) {

									List<Meal> complexMeal = new ArrayList<>();

									complexMeal.add(meals.getMealList().get(i));
									complexMeal.add(meals.getMealList().get(j));
									complexMeal.add(meals.getMealList().get(l));

									complexDinnerList.addAll(new ArrayList<>(complexMeal));
								}
							}
						}
					}
				}
			}
		}
		// return complexesMealsList;
	}

	/**
	 * @return the complexDinnerList
	 */
	public List<Meal> getComplexDinnerList() {
		return complexDinnerList;
	}

	/**
	 * @param complexDinnerList
	 *            the complexDinnerList to set
	 */
	public void setComplexDinnerList(List<Meal> complexDinnerList) {
		this.complexDinnerList = complexDinnerList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PriceSort [complexDinnerList=" + complexDinnerList + "]";
	}

}
