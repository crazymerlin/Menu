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
public class Product {
	
	private int id;

	public static List  <Product> productList = new ArrayList  <Product> ();
	
	/** This private String value consist the title of dish ingredient. */
	private String title;

	/** This private double value consist the price of dish ingredient. */
	private double price;

	/** This private enum value consist the type of ingredient dimension. */
	private ProductDimension productDimension;

	/**
	 * This private boolean value consist the availability of meal product.
	 */
	private boolean available;

	
	public Product() {
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
	public Product(int id, String title, double price, String productDimension,
			boolean available) {
		super();
		this.id = id;
		this.title = title;
		if (price <= 0) {
			System.out.println("Your price must be above 0");
		} else {
			this.price = price;
		}
		this.productDimension = ProductDimension.valueOf(productDimension);
		this.available = available;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ingredient " + title + " [id=" + id + ", title=" + title + ", price=" + price
				+ ", productDimension=" + productDimension
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
	public ProductDimension getProductDimension() {
		return productDimension;
	}

	/**
	 * @param productDimension
	 *            the dimension to set
	 */
	public void setProductDimension(String productDimension) {
		this.productDimension = ProductDimension
				.valueOf(productDimension);
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
