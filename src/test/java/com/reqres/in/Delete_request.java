package com.reqres.in;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Delete_request {
	
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
