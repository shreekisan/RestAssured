package testCases;

import java.util.HashMap;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class Put_Or_Update {

	SoftAssert sofAssert = new SoftAssert();
	
	@Test
	public void update_A_Product()
	{
		HashMap<String, String>payload = new HashMap<String, String>();
		
		      payload.put("id", "2014");
		      payload.put("name", "HP_pavillion 27");
		      payload.put("description", "all in one");
		      payload.put("price", "1200");
		      payload.put("category_id", "2");
		      payload.put("category_name", "Electronics");
		 Response response =
				 given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type", "application/json; charset=UTF-8")
					.header("Authorization","Bearer Token LKJFKJLK544BLJLKBM4")
					.body(payload)
				.when().log().all()
					.put("/update.php")
				.then()
					.extract().response();

		String responseBody = response.getBody().asString();
		System.out.println("Update Response Body:  " + responseBody);
		      

	
}
}