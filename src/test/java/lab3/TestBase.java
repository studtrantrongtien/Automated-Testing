package lab3;

import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	public RequestSpecification request;
	
	public TestBase() {
		try {
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
			RestAssured.baseURI = props.getProperty("api.uri");
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		request = RestAssured.given().contentType(ContentType.JSON);
	}
}
