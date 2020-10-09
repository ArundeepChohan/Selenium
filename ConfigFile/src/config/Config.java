package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Config {
	Properties property;
	FileInputStream fs;

	@Test
	public void UseFile() {
		
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
			property = new Properties();
			try {
				property.load(fs);
				System.out.println(property.getProperty("name"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
