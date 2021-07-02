package testCases;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Get_or_read_one_Products {
	@Test
	public void read_all_Products() {
		Response response = given()
				.baseUri("http://techfios.com/api-prod/api/product")
				.header("Content-Type", "application/json; charset=UTF-8")
				.queryParam("id", "1685")
				.when()
				.get("/read_one.php")
				.then().extract().response();

		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);

		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response Time: " + "\n" + responseTime);

		if (responseTime <= 2000) {
			System.out.println("Response time is within range.");
		} else {
			System.out.println("Response time not acceptable!");
		}

		String responseBody = response.getBody().asString();
		System.out.println("response body is :" + responseBody);

	}

}













