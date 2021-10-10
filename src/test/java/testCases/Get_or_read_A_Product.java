package testCases;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Get_or_read_A_Product {
	
	//@Test
	public void getData()
	{ 
		Response response = get("http://techfios.com/api-prod/api/product/read_one.php/?id=2015");
		//System.out.println(response.asString());
		response.prettyPrint();
	}
	
	
}
