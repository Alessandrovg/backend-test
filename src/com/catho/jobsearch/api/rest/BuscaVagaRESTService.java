package com.catho.jobsearch.api.rest;

import java.io.InputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.catho.jobsearch.controle.VagasController;

/**
 * Classe Rest, para obtem as informa��es das vagas
 */
@Path("/")
public class BuscaVagaRESTService {
	
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	/**
	 * Verifica se o servidor est� no ar
	 * @param incomingData
	 * @return retorna String com mensagem sobre o servidor no ar
	 */
	public Response verifyRESTService(InputStream incomingData) {
		String result = "API de Busca de Vagas iniciado com sucesso!";
 
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/vagas")	
	@Produces( MediaType.APPLICATION_JSON )
	/**
	 * Busca as vagas dispon�veis no arquivo JSON
	 * Utilizei o Parametro Query, para facilitar a utiliza��o da API, por�m podemos facilmente alterar para o uso de barras
	 * 
	 * @param filtro, filtro de Texto que vai filtrar as informa��es de T�tulo e Descri��o da Vaga
	 * @param cidade, filtro de Texto que verificar� as cidades onde a vaga es� dispon�vel
	 * @param salario, Informa para Ordena��o do Sal�rio, op��es: DESC para Decrescente e CRES para Crescente
	 * @return retorna JSON com informa��es sobre as vagas filtradas
	 */
	public Response verificaVagasComTexto(@QueryParam("filtro") String filtro, @QueryParam("cidade") String cidade, @QueryParam("salario") String salario) {
		String result;
		try{
			/*Aqui instacio o Controller para fazer a Leitura do JSON (caso tenha sido alterado, busca sempre por novas informa��es*/
			VagasController vagas = new VagasController();
			result = vagas.filtrarVagasPorTexto(filtro, cidade, salario);
		}
		catch(Exception error)
		{
			
			result = error.getMessage();
		}
		/*Resposta com Status 200 que a fun��o foi executada com sucesso*/
		return Response.status(200).entity(result).build();
	}
	
	
}
