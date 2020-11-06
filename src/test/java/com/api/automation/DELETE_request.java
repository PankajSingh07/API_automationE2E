package com.api.automation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE_request {

	@Test
	public void deleteRecord()
	{
		RestAssured.baseURI = "http://localhost:3030";
		RestAssured.basePath = "/products/150115";
		
		
		/*
		RequestSpecification request = RestAssured.given();
		
		Response resp = request.delete("https://reqres.in/api/users/2");
		int code = resp.getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code,200);
		
		String data = resp.asString();
		System.out.println("Data is : "+data);
		*/
		
		given()
			
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all();
			
	
	}
}
