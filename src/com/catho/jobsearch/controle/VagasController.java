package com.catho.jobsearch.controle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.naming.NamingException;

import com.catho.jobsearch.api.helper.Helper;
import com.catho.jobsearch.model.Global;
import com.catho.jobsearch.model.Vagas;
import com.catho.jobsearch.model.Wrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.gson.Gson;

/**
 * Classe para controle entre a utiliza��o dos Servi�os de API e as Classes modelos
 * Nessa classe est�o as regras de neg�cios utilizadas para o filtro e abertura dos arquivos
 * @author Alessandro Vieira Grammelsbacher
 *
 */
public class VagasController {
	/*No JSON temos um n� Docs, onde retorna informa��es sobre todas as vagas, para 
	 * fazer a leitura dessas informa��es e retornar diretamente em uma lista, utilzo uma classe Weapper,
	 * para juntar informa��es de todas as vagas*/
	private Wrapper vagasJson; 
	
	//Construtor
	public VagasController() throws JsonParseException, JsonMappingException, NamingException, IOException {
		mapJSON();
	}
	
	/**
	 * Realiza a leitura do arquivo JSON e reinderiza em um objeto java
	 * Para isso utilizamos a lib Jackson pelo seu desempenho na cria��o de Maps entre arquvios (JSON e XML) para Objetos java
	 * Como a massa de dados pode ser grande, a cria��o de um mapeamento na m�o poderia causar impacto no desempenho da API
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void mapJSON() throws JsonParseException, JsonMappingException, IOException  
	{
		vagasJson = new ObjectMapper().readValue(new File(Global.JSONPath.getValue()) , Wrapper.class);
	}
	
	/**
	 * Filtra as vagas peas informa��es contidas em Texto e Cidade, o parametro ordena��o � informado para
	 * ordenar a lista em ordem CRES = Crescente ou DESC = Decrescente
	 * @param filtroTexto, texto com informa��es contidas na descri��o ou no t�tulo da vaga
	 * @param filtroCidade, texto com informa��es contidas na cidade
	 * @param ordenacao, CRES / DESC, Informa se a lsita ir� retornar em ordem crescente ou decrescente
	 * @return retorna uma String em JSON, com a lista filtrada e ordenada
	 * @throws JSONException
	 */
	public String filtrarVagasPorTexto(String filtroTexto, String filtroCidade, String ordenacao) 
	{
		
		// Crinado filtro que ser� utilizando na lista.
		//Poderia usar o equals.toUpperCase para comparar as queries, por�m a quantidade de vagas pode ser muito grande, o operador Upper ou Lower pode causar grande perda de perfomance.
		// Como estamos utilizando o Java 8, � uma op��o interessante e de r�pido desempenho a utiliza��o de Predicates para filtrar listas
		Predicate<Vagas> filtro 
			= vagas -> ( 
						// Aqui utilizamos a classe Helper, para facilitar o entendimento dos filtros
						 (  Helper.comparaString(filtroTexto, vagas.getTitle()) 
						 || Helper.comparaString(filtroTexto, vagas.getDescription())
					     )
						 //Compara o filtro texto com T�tulo e Descri��o
					    )
						//Verificando a lista de cidades...
					 && (vagas.getCidade().stream().filter(
							 itemCidade -> Helper.comparaString(filtroCidade, itemCidade)
					     ).findFirst().isPresent()
			           );
		//Aqui utilizo a lib GUAVA do google pois o desempenho em grandes listas � muito bom
        List<Vagas> vagasFiltradas = FluentIterable.from(vagasJson.getDocs())
									                .filter(filtro)
									                .toList();
        //Com a utiliza��o do MAP, do Google GUAVA, n�p podemos fazer altera��es nas listas, por isso preciso instanciar uma nova lista para realizar a ordena��o
        
        List<Vagas> retorno = new ArrayList<Vagas>(vagasFiltradas);
        
        //Aqui utilizamos a ordena��o padr�o do arquivo, caso n�o tenham informado nenhum parametro de ordena��o na utiliza��o do REST
        Comparator<Vagas> comp = new Comparator<Vagas>(){
    	    public int compare(Vagas s1, Vagas s2) {
    	        return 1;
    	    }
    	};
    	//Verifica as op��es de filtro para saber se informaram a ordena��o
		if(!Helper.isNullOrEmpty(ordenacao))
        {
			// Cria regra para ordena��o padr�o
			comp = new Comparator<Vagas>(){
            	    public int compare(Vagas s1, Vagas s2) {
            	        return Float.compare(s1.getSalario(), s2.getSalario());
            	    }
            	};
        	// Caso tenha informado a oredem decrescente, ent�o ele inverte a lista
        	if(ordenacao.toUpperCase().equals("DESC"))
        	{
        		comp = comp.reversed();
        	}
        }
		//Utiliza o met�do padr�o do Java 8 para ordena��o de Grandes Collections, como listas
		Collections.sort(retorno, comp);
		
		//Realiza a convers�o de objeto para JSON, utilizando a Lib Gson do google
		return new Gson().toJson(new Wrapper(retorno));
	}
	
	
}
