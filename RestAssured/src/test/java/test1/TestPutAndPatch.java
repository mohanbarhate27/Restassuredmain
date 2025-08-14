package test1;

//sample programme1

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;

import static io.restassured.RestAssured.*;

import  static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestPutAndPatch {

	@Test
	
	public void testPut() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Raghav1");
		request.put("Job","Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			header("x-api-key","reqres-free-v1").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
		log().all();
		
		
	}
	
	@Test
	
	public void testPatch() {
		
	JSONObject request = new JSONObject();
	request.put("name", "Raghav1");
	request.put("Job","Teacher");
	
	System.out.println(request.toJSONString());
	
	baseURI="https://reqres.in/api";
	
	given().
		header("Content-Type","application/json").
		header("x-api-key","reqres-free-v1").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		patch("/users/2").
	then().
		statusCode(200).
	log().all();
	
}
	
	@Test
	
	public void testDelete() {
		
	baseURI="https://reqres.in/api";
	
	given().
		header("Content-Type","application/json").
		header("x-api-key","reqres-free-v1").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
	when().
		delete("/users/2").
	then().
		statusCode(204).
	log().all();
	
}	
	
	
}	
	
