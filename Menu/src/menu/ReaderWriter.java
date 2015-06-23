package menu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by skaraltc on 6/19/2015.
 */
public class ReaderWriter {

	private ObjectMapper mapper = new ObjectMapper();
	
	
	
	public void writeToFile(String path, PriceSort object) {
		try {
			
			
			// convert user object to json string, and save to a file
			mapper.writeValue(new File(path), object);
			
			

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PriceSort readFromFile(Class objectClass) {

		PriceSort sortFromFile = new PriceSort();
		
		ObjectMapper mapper = new ObjectMapper();

		try {

			// read from file, convert it to user class
			sortFromFile = mapper.readValue(new File("E:/Git/Menu/Menu/Files/PriceSortMeals.txt"), objectClass);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return sortFromFile;

	}
}
