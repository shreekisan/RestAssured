package rough;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class GetAndPost {
	
	@Test
	public void testGet()
	{
		baseURI ="https://reqres.in/api";
		given().
		get("/users?page=2")
		.then()
		.statusCode(200)
		.body("data[4].first_name", equalTo("George"))
		.body("data.first_name",hasItems("George","Rachel"));	
		
	}
	@Test
	public void testPost()
	{
		//HashMap<String, Object>map = new HashMap<String, Object>();
//		map.put("name","sri");
//		map.put("job","teacher");
//		
//		System.out.println(map);
//		JSONObject request = new JSONObject(map);
//		System.out.println(request);
		
		JSONObject request = new JSONObject();
		request.put("name","sri");
		request.put("job","teacher");
		System.out.println(request.toJSONString());
		
		baseURI ="https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();	
		
	}
	@Test
	public void testGet1()
	{
		Response response =get("https://reqres.in/api/users/2");
		System.out.println(response.prettyPrint());		
		
		
}

}
