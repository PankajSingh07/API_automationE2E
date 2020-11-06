package com.api.automation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_request {

	@Test
	public void updateRecord()
	{
	RequestSpecification request = RestAssured.given();
	
	request.header("Content-Type", "apllication/json");
	
	JSONObject json = new JSONObject();
	json.put("name", "abcs");
	json.put("job", "resident");
	
	request.body(json.toJSONString());

	Response resp = request.put("https://reqres.in/api/users/2");
	int code = resp.getStatusCode();
	System.out.println("Status code is: "+code);
	Assert.assertEquals(code,200);
	
	String data = resp.asString();
	System.out.println("Data is : "+data);
	}
}
