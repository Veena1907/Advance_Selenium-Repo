package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

public String readingDataFromPropertiesFile(String Key) throws IOException
{
	FileInputStream fis=new FileInputStream("C:\\Users\\Guru\\git\\E18_batch\\AdvancedSelenium2025\\src\\test\\resources\\Commondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	String data= prop.getProperty(Key);
	return data;
}

}
