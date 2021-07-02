package testCases;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class DeleteProduct {
	
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void Delete_A_Product()
	{
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("id","2013");
		Response response =
			given().log().all()
				.baseUri("https://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.body(payload)
			.when()
				.delete("/delete.php")
			.then()
				.extract().response();
		
		String responseBody = response.getBody().asString();
		System.out.println("responseBody:  " + responseBody);
		
	}

}
