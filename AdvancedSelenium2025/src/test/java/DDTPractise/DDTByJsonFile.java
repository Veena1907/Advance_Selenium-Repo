package DDTPractise;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTByJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser= new JSONParser();
		FileReader file= new FileReader("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\Data_E18.json");
		Object javaObj = parser.parse(file);
		
		JSONObject obj= (JSONObject) javaObj;
		String name= obj.get("name").toString();
		String id= obj.get("id").toString();
		Object id1 = obj.get("id");
		String branch= obj.get("branch").toString();
		String age= obj.get("Age").toString();
		String isStudent= obj.get("isStudent").toString();
		Object isStudent1 = obj.get("isStudent"); //we can print by using object also it will take the value as it as 
		Object backlog = obj.get("backlogs"); //it is a null value so we cannot convert it into string we need to use it as object only
		System.out.println(id);
		System.out.println(id1);
		System.out.println(branch);
		System.out.println(age);
		System.out.println(isStudent);
		System.out.println(isStudent1);
		System.out.println(backlog); 
	}

}
