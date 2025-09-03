package GenericUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws Throwable
	{
		JSONParser parser= new JSONParser();
		FileReader file= new FileReader("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\Data_E18.json");
		Object javaObj = parser.parse(file);
		//Downcasting the super class object to JSONObject
		//JSONObject is exactly same as hashmap
		JSONObject obj= (JSONObject) javaObj;
		String data=(String) obj.get(key); //converting it into string
		return data;
		
		
	}
}
