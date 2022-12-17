package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {

	public static Properties p;
//consector line
	
	public Configuration_Reader() throws Throwable{


		File f = new File(
				"C:\\Gamil_Project\\src\\main\\java\\com\\properties\\Configuration.properties");
		FileInputStream fis = new FileInputStream(f);
		 p = new Properties();
		p.load(fis);
	}
	
	public String getUrl()  {


		String url = p.getProperty("url");
		System.out.println(url);
		return url;

	}

	public String getusername()  {

		
		String username = p.getProperty("username");
		System.out.println(username);
		return username;

	}

	public String getpasswword()  {

		
		 
		String password = p.getProperty("password");
		System.out.println(password);
		 return password;
	}

	

}
