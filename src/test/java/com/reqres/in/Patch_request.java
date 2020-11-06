package com.reqres.in;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Patch_request {
	
	@Test
	public void testPatch() {

		JSONObject request = new JSONObject();

		request.put("name", "Selenium");
		request.put("job", "Automation");

		System.out.println(request.toJSONString());

		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users").
		then().
			statusCode(200).
			log().all();

	}

}
