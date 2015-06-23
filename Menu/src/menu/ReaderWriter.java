package menu;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by skaraltc on 6/19/2015.
 */
public class ReaderWriter {

	private ObjectMapper mapper = new ObjectMapper();
	
	PortionsOfMeals meals = new PortionsOfMeals();
	
	public void writeToFile(String path, Class classObject) {
		try {

			// convert user object to json string, and save to a file
			mapper.writeValue(new File(path), classObject);
			
			

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	@SuppressWarnings("unchecked")
	public PortionsOfMeals readFromFile(String path,
			@SuppressWarnings("rawtypes") Class objectClass) {

		PortionsOfMeals portionsOfMeals = null;
		
		ObjectMapper mapper = new ObjectMapper();

		try {

			// read from file, convert it to user class
			portionsOfMeals = mapper.readValue(new File(path), objectClass);

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		
		return portionsOfMeals;

	}
}
