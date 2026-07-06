package com.api.tests;

import static com.api.utils.ConfigManager.getProperty;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static com.api.constant.Role.*;
import com.api.utils.AuthTokenProvider;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class MasterAPITest {

	@Test
	public void masterAPITest() {
		
		given()
	    .baseUri(getProperty("BASE_URI"))
	    .and()
	    .header("Authorization", AuthTokenProvider.getToken(FD))
	    .and()
	    .contentType("")
	    .log().all()
	    .when()
	    .post("master")
	    .then()
	    .log().all()
        .statusCode(200)
        .time(lessThan(1000L))
        .body("message",equalTo("Success"))
        .body("data",notNullValue())
		.body(matchesJsonSchemaInClasspath("response-schema/MasterAPIResponseSchema.json"));
	   
	}
}
