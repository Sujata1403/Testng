package common_utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream fileInputStream=new FileInputStream("src\\test\\resources\\login_credential.properties");
		
		Properties properties=new Properties();
		
		properties.load(fileInputStream);
		
		String name=properties.getProperty(key);
		
		return name;
	}
}
