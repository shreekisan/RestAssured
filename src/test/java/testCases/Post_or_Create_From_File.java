package testCases;

import static io.restassured.RestAssured.get;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post_or_Create_From_File {
	
	@Test
	public void create_A_Product()
	{
		String payloadPath ="./src/main/java/data/payload.json";
		
		Response response = 
			given()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.body(new File(payloadPath))
			.when()
				.post("/create.php")
			.then()
				.extract().response();
		
		String responseBody = response.getBody().asString(); 
		System.out.println("responseBody:  " + responseBody);			
		
		JsonPath js = new JsonPath(responseBody);
		String message = js.getString("message");
	}

}
