package testCases;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post_or_Create {

		SoftAssert sofAssert = new SoftAssert();

		@Test
		public void create_A_Product() {

//			https://techfios.com/api-prod/api/product/create.php
			HashMap<String, String> payload = new HashMap<String, String>();
			payload.put("name", "HP_pavillion 23");
			payload.put("description", "all in one");
			payload.put("price", "1199");
			payload.put("category_name", "Electronics");
			payload.put("category_id", "2");
			Response response = 
					given()
						.baseUri("https://techfios.com/api-prod/api/product")
						.header("Content-Type", "application/json; charset=UTF-8")
						.body(payload)
					.when().log().all()
						.post("/create.php")
					.then()
						.extract().response();

			String responseBody = response.getBody().asString(); 
			System.out.println("responseBody:  " + responseBody);			
			
			JsonPath js = new JsonPath(responseBody);
			String message = js.getString("message");
			
			sofAssert.assertEquals(message, "Product was created","Not matching the assertions!!!");
}
}