package com.reqres.in;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class Post_request {

	@Test
	public void testPost() {


		JSONObject request = new JSONObject();

		request.put("name", "ChatBot");
		request.put("job", "AI/ML");

//		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);

		}



}
