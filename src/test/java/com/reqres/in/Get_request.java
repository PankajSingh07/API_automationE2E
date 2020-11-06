package com.reqres.in;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Get_request {

	@Test
	void getUserList() {
		
		
		RestAssured.baseURI = "https://reqres.in/api/users";

		Response response = null;
		response = RestAssured.given().when().get("?page=2");

		System.out.println("Response is :\n" + response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		int statusCode = response.getStatusCode();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(statusCode, 200);
		
//		String responseBody1 = response.jsonPath().get("page");
		
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println("Additional Response...................................................");
		System.out.println(jsonpath.get("page"));
		System.out.println(jsonpath.get("per_page"));
//		Assert.assertEquals(responseBody1, "2");
		
		
		Assert.assertTrue(jsonpath.get("page").equals(2));
		Assert.assertEquals(jsonpath.get("page"), 2);
		
//		Assert.assertTrue(responseBody1.contains("amazonaws"));

	}

//	@Test
	void testGet_01() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");

		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
	}

//	 With BDD

//	@Test
	void testGet_02() {
		baseURI = "https://reqres.in/api/users";

		get("?page=2").then().body("data.id[0]", equalTo(7));
	}

//	@Test
	void testGet_03() {
//		baseURI = "https://reqres.in/api/users";

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

}
