package rough;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class Test1 {
	@Test
	public void test_1() {
		
	Response response=get("https://reqres.in/api/users?page=2");
	
	System.out.println(response.getTime());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	
}
	@Test
	public void test_2() {	
		
	baseURI ="https://reqres.in/api";
	given().get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[1].id", equalTo(8))
		.body("data.first_name", hasItems("Michael"))
		.body("data[0].last_name", is("Lawson"))
		.log().all();

		
		
}
}
	
	
	
	
	
	