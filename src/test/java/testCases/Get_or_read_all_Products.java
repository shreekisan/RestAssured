package testCases;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Get_or_read_all_Products {
	@Test
	public void read_all_Products()
	{
		Response response=
				given()
					.baseUri("https://techfios.com/api-prod/api/product")
					.header("Content-Type","application/json; charset=UTF-8")
				.when()
					.get("/read.php")
				.then()
					.extract().response();
		
//		response.prettyPrint();
		
		int statusCode = 200;
		Assert.assertEquals(statusCode, response.getStatusCode());
//		System.out.println("Response: "+ response.asString());
		System.out.println("status code matching");
		
//		System.out.println("status code is : "+ response.getStatusCode());
//		System.out.println("status code is : "+ response.getBody().prettyPrint());
		
	}

}








