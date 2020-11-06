package com.api.automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class POST_request {

	public static HashMap map = new HashMap();
	
	@BeforeTest
	public void postData()
	{
		
		map.put("name", "Test Create");
		map.put("type", "Hard Good");
		map.put("upc", "12345676");
		map.put("price", "99.99");
		map.put("description", "This is a placeholder request for creating a new product.");
		map.put("model", "NP12345");
		
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;
		RestAssured.basePath = "/products";
	}
	
	@Test
	public void testPostData()
	{
		
		/*
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json; charset=utf-8");
		
		JSONObject json = new JSONObject();
				
		json.put("name", "Test Create");
		json.put("type", "Hard Good");
		json.put("upc", "12345676");
		json.put("price", "99.99");
		json.put("description", "This is a placeholder request for creating a new product.");
		json.put("model", "NP12345");
		
//		json.put("email", "abcs@gmail.com");
//		json.put("password", "Resource");
		
		request.body(json.toJSONString());
	
//		Response resp = request.request(Method.POST,"http://localhost:3030/products");
		Response resp = request.post("http://localhost:3030/products");
		int code = resp.getStatusCode();
		System.out.println("Status code is: "+code);
		Assert.assertEquals(code,201);
		
		String data = resp.asString();
		System.out.println("Data is : "+data);
		*/
		
		given()
			.contentType("application/json; charset=utf-8")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
//			.statusLine("HTTP/1.1 201 Created")
			.assertThat().body("name", equalTo("Test Create"));
			
		
		
		
	}
}
