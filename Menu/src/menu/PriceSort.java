/**
 * 
 */
package menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sviatoslav
 * 
 */
public class PriceSort {

	private PortionsOfMeals meals = new PortionsOfMeals();
	private List<PortionsOfMeals> complexDinnerList = new ArrayList<PortionsOfMeals>();

	public void addMeal(PortionsOfMeals meal) {
		complexDinnerList.add(meal);

	}

	public List<Meal> complexDinner(int price) {
		List<Meal> complexDinnerMeals = new ArrayList<>();
		for (int i = 0; i < meals.getMealList().size(); i++) {
			if ((meals.getMealList().get(i).isAvailable())
					&& (meals.getMealList().get(i).getMealcategory().equals(MealCategory.FIRST))) {
				for (int j = 0; j < meals.getMealList().size(); j++) {
					if ((meals.getMealList().get(j).isAvailable())
							&& (meals.getMealList().get(j).getMealcategory()
									.toString()) == "SECOND") {
						for (int l = 0; l < meals.getMealList().size(); l++) {
							if ((meals.getMealList().get(l).isAvailable())
									&& (meals.getMealList().get(l)
											.getMealcategory().toString()) == "DRINK") {
								if (meals.getMealList().get(i).getPrice()
										+ meals.getMealList().get(j).getPrice()
										+ meals.getMealList().get(l).getPrice() < price) {

									complexDinnerMeals.add(meals.getMealList()
											.get(i));
									complexDinnerMeals.add(meals.getMealList()
											.get(j));
									complexDinnerMeals.add(meals.getMealList()
											.get(l));
									

									System.out.println(meals.getMealList()
											.get(i).toString());
									System.out.println(meals.getMealList()
											.get(j).toString());
									System.out.println(meals.getMealList()
											.get(l).toString()
											+ "\n");
								}
							}
						}
					}
				}
			}
		}
		return complexDinnerMeals;
	}

	/**
	 * @return the meals
	 */
	public PortionsOfMeals getMeals() {
		return meals;
	}

	/**
	 * @param meals
	 *            the meals to set
	 */
	public void setMeals(PortionsOfMeals meals) {
		this.meals = meals;
	}

}
