package menu;

import java.util.ArrayList;
import java.util.List;

public class ComplexesMeals {

	List<Meal> complexMeals = new ArrayList<>();

	public ComplexesMeals() {
		super();
	}

	public ComplexesMeals(List<Meal> complexMeals) {
		this.complexMeals = complexMeals;
	}

	/**
	 * @return the complexMeals
	 */
	public List<Meal> getComplexMeals() {
		return complexMeals;
	}

	/**
	 * @param complexMeals
	 *            the complexMeals to set
	 */
	public void setComplexMeals(List<Meal> complexMeals) {
		this.complexMeals = complexMeals;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "complexMeals=" + complexMeals + "]\n";
	}
}
