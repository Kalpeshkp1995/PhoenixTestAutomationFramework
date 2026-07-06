package com.api.tests;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import static com.api.constant.Role.*;

import static com.api.utils.AuthTokenProvider.*;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import static com.api.utils.ConfigManager.*;
public class UserDetailsAPITest {

	@Test
	public void userDetaisAPITest() throws IOException {
		
		
	Header authHeader = new Header("Authorization",getToken(FD));
		given()
		.baseUri(getProperty("BASE_URI"))
		.and()
		.header(authHeader)
		.and()
		.accept(ContentType.JSON)
		.log().uri()
		.log().method()
		.log().body()
		.log().headers()
		.when()
		.get("userdetails")
		.then()
		.log().all()
		.statusCode(200)
		.time(lessThan(1000L))
        .and()
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/UserDetaisResponseSchema.json"));

		
		
		
		
		
	}
}
