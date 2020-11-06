package com.reqres.in;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class End2End {

	@Test
	void testGet() {
		
		given()
			.param("", "")
			.header("", "")
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().all()
		    .body("data.id[2]", equalTo(9));

		
	}

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


	@Test
	public void testPut() {

		JSONObject request = new JSONObject();

		request.put("name", "Selenium");
		request.put("job", "Automation");

//		System.out.println(request);
		System.out.println(request.toJSONString());

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users").
		then().
			statusCode(200);


	}

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

	@Test
	public void testDelete() {

		given()
	    .when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
	}
}
