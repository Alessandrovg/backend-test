package com.catho.jobsearch.api.rest;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.catho.jobsearch.controle.VagasController;

@Path("/")
public class BuscaVagaRESTService {
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	/*Verifica se o servidor está no ar*/
	public Response verifyRESTService(InputStream incomingData) {
		String result = "API de Busca de Vagas iniciado com sucesso!";
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/vagas")	
	@Produces( MediaType.APPLICATION_JSON )
	/*Busca as vagas disponíveis*/
	public Response verificaVagasComTexto(@QueryParam("filtro") String filtro, @QueryParam("cidade") String cidade, @QueryParam("salario") String salario) {
		String result;
		try{
			VagasController vagas = new VagasController();
			result = vagas.filtrarVagasPorTexto(filtro, cidade, salario);
		}
		catch(Exception error)
		{
			result = error.getMessage();
		}
		return Response.status(200).entity(result).build();
	}
	
	
}
