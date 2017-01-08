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
	
	@Test
	public void testeFiltroTituloDescricao()
	{
		given()
		.when()
			.get("/vagas?filtro=TI")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagasTI.json"));
	}
	

	@Test
	public void testeFiltroCidade()
	{
		given()
		.when()
			.get("/vagas?cidade=florian")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagasFlorian.json"));
	}
	
	@Test
	public void testeFiltroCrescente()
	{
		given()
		.when()
			.get("/vagas?salario=CRES")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagasCRES.json"));
	}
	
	@Test
	public void testeFiltroDecrescente()
	{
		given()
		.when()
			.get("/vagas?salario=DESC")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagasDESC.json"));
	}
	
	@Test
	public void testeFiltroTituloDescricaoCidade()
	{
		given()
		.when()
			.get("/vagas?filtro=TI&cidade=florian")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagasTiFlorian.json"));
	}
	
	@Test
	public void testeFiltroTituloDescricaoCidadeCrescente()
	{
		given()
		.when()
			.get("/vagas?filtro=TI&cidade=florian&salario=CRES")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagasTiFlorianCRES.json"));
	}
	
	@Test
	public void testeFiltroTituloDescricaoCidadeDecrescente()
	{
		given()
		.when()
			.get("/vagas?filtro=TI&cidade=florian&salario=DESC")
		.then()
			.statusCode(200)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("com/catho/testes/json/vagasTiFlorianDESC.json"));
	}
	
	
	
	
	
}
