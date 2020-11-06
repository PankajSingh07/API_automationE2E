package com.api.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;


public class GET_request {

	@Test
	public void testGET()
	{
	
	/*
	public void testResponseCode()
	{
		Response resp = RestAssured.get("http://localhost:3030/products/48530");
		int code = resp.getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code,200);
	}

	@Test
	public void testResponseBody()
	{
		
		Response resp = RestAssured.get("http://localhost:3030/products/48530");
		String data = resp.asString();
		System.out.println("Data is : "+data);
		System.out.println("response Time is : "+resp.getTime());
		
		//show name and price only
		Response resp1 = RestAssured.get("http://localhost:3030/products/48530?$select[]=name&$select[]=price");
		String data1 = resp1.asString();
		System.out.println("Data is : "+data1);
	}
	*/
	
	given()
	.when()
		.get("http://localhost:3030/products/48530")
	.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.and()
		.assertThat().body("type", equalTo("HardGood"))
		.header("Content-Type", "application/json; charset=utf-8");
	
	}
}
