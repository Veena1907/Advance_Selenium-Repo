package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

public String readingDataFromPropertiesFile(String Key) throws IOException
{
	FileInputStream fis=new FileInputStream("C:\\QA-23_M32\\ AdvanceSelenium\\src\\test\\resources\\Commondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String data= prop.getProperty(Key);
	return data;
}

}
