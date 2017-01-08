package com.catho.testes.api;

import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

import com.catho.jobsearch.model.Global;

public class TestesApi {

	public TestesApi(){
        baseURI = "http://localhost:8080/backend-test/api";
    }
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testeRestAPI()
	{
		given()
		.when()
			.get("/verify")
		.then()
			.statusCode(200)
			.body(containsString(Global.ApiWorkingMessage.getValue()));
	}
	
	@Test
	public void testeBuscaVaga()
	{
		given()
		.when()
			.get("/vagas")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagas.json"));
	}
}
