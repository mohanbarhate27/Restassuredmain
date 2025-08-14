package test1;
//sample programme

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import static io.restassured.RestAssured.*;

import  static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetandPostExample {

//	@Test
//	public void test_1() {
//		
//		baseURI="https://reqres.in/api";
//	
//		given().
//		   get("/users?page=2").
//		then().   
//			statusCode(200).
//	    body("data[1].id", equalTo(8)).
//	    body("data[3].first_name", equalTo("Byron")).
//	    body("data.first_name", hasItems("George","Rachel"));
//			
//	}
//	
	@Test
	public void test_post() {
		
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("Name","John");
//		map.put("Job","Teacher");
//		System.out.println(map);
		
		
		JSONObject request = new JSONObject();
		request.put("Name","Raghav");
		request.put("Job","Teacher");
		
//		System.out.println(request);
		System.out.println(request.toJSONString());
		
		
		baseURI="https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			header("x-api-key","reqres-free-v1").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
		log().
			all();
				
		
	}
}
