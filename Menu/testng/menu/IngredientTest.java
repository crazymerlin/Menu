package menu;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class IngredientTest {
	@BeforeTest
	public void beforeTest() {
		Ingredient ing = new Ingredient(); // TODO: Initialize to an appropriate
	}
	
	@Test(groups = "group1")
	public void zeroPriceValue() {
		Ingredient ing = new Ingredient("car", 0, IngredientDimension.GR, true); // TODO: Initialize to an appropriate
		double expected = 0; // TODO: Initialize to an appropriate value
		double actual;
		actual = ing.getPrice();
		AssertJUnit.assertEquals(expected, actual);
	}
	
	@Test(groups = "group1")
	public void underZeroPriceValue() {
		Ingredient ing = new Ingredient("car", -1, IngredientDimension.GR, true); // TODO: Initialize to an appropriate
		double expected = 0; // TODO: Initialize to an appropriate value
		double actual;
		actual = ing.getPrice();
		AssertJUnit.assertEquals(expected, actual);
	}
	
	@Test(groups = "group1")
	public void validPriceValue() {
		Ingredient ing = new Ingredient("carrot", 0.0005, IngredientDimension.GR, true); // TODO: Initialize to an appropriate
		double expected = 0.0005; // TODO: Initialize to an appropriate value
		double actual;
		actual = ing.getPrice();
		AssertJUnit.assertEquals(expected, actual);
	}
	
	@Test(groups = "group2")
	public void setString() {
		Ingredient ing = new Ingredient(); // TODO: Initialize to an appropriate
		String expected = "carrot"; // TODO: Initialize to an appropriate value
		ing.setTitle("carrot");
		String actual = ing.getTitle();
		AssertJUnit.assertEquals(expected, actual);
		// throw new RuntimeException("Test not implemented");
	}
	
	@Test(groups = "group2")
	public void validTitleValue() {
		Ingredient ing = new Ingredient("carrot", 0.0005, IngredientDimension.GR, true); // TODO: Initialize to an appropriate
		String expected = "carrot"; // TODO: Initialize to an appropriate value
		String actual;
		actual = ing.getTitle();
		AssertJUnit.assertEquals(expected, actual);
	}
	
	@Test(groups = "group2")
	public void invalidTitleValue() {
		Ingredient ing = new Ingredient("≥‚‡", 0.0005, IngredientDimension.GR, true); // TODO: Initialize to an appropriate
		double expected = 0.0005; // TODO: Initialize to an appropriate value
		double actual;
		actual = ing.getPrice();
		AssertJUnit.assertEquals(expected, actual);
	}
	
	@Test(groups = "group2")
	public void validValue() {
		Ingredient ing = new Ingredient("carrot", 0.0005, IngredientDimension.GR, true); // TODO: Initialize to an appropriate
		double expected = 0.0005; // TODO: Initialize to an appropriate value
		double actual;
		actual = ing.getPrice();
		AssertJUnit.assertEquals(expected, actual);
	}
//
//	@Test(groups = "group2")
//	public void hello() {
//		Calc target = new Calc(); // TODO: Initialize to an appropriate
//		String s1 = "Petro"; // TODO: Initialize to an appropriate value
//		String expected = "Privet Petro"; // TODO: Initialize to an appropriate
//											// value
//		String actual;
//		actual = target.hello(s1);
//		AssertJUnit.assertEquals(expected, actual);
//		// throw new RuntimeException("Test not implemented");
//	}

//	@Test
//	public void f() {
//	}
	@AfterClass
	public void afterClass() {
	}

}
