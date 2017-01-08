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
 * Classe para controle entre a utilização dos Serviços de API e as Classes modelos
 * Nessa classe estão as regras de negócios utilizadas para o filtro e abertura dos arquivos
 * @author Alessandro Vieira Grammelsbacher
 *
 */
public class VagasController {
	/*No JSON temos um nó Docs, onde retorna informações sobre todas as vagas, para 
	 * fazer a leitura dessas informações e retornar diretamente em uma lista, utilzo uma classe Weapper,
	 * para juntar informações de todas as vagas*/
	private Wrapper vagasJson; 
	
	//Construtor
	public VagasController() throws JsonParseException, JsonMappingException, NamingException, IOException {
		mapJSON();
	}
	
	/**
	 * Realiza a leitura do arquivo JSON e reinderiza em um objeto java
	 * Para isso utilizamos a lib Jackson pelo seu desempenho na criação de Maps entre arquvios (JSON e XML) para Objetos java
	 * Como a massa de dados pode ser grande, a criação de um mapeamento na mão poderia causar impacto no desempenho da API
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public void mapJSON() throws JsonParseException, JsonMappingException, IOException  
	{
		vagasJson = new ObjectMapper().readValue(new File(Global.JSONPath.getValue()) , Wrapper.class);
	}
	
	/**
	 * Filtra as vagas peas informações contidas em Texto e Cidade, o parametro ordenação é informado para
	 * ordenar a lista em ordem CRES = Crescente ou DESC = Decrescente
	 * @param filtroTexto, texto com informações contidas na descrição ou no título da vaga
	 * @param filtroCidade, texto com informações contidas na cidade
	 * @param ordenacao, CRES / DESC, Informa se a lsita irá retornar em ordem crescente ou decrescente
	 * @return retorna uma String em JSON, com a lista filtrada e ordenada
	 * @throws JSONException
	 */
	public String filtrarVagasPorTexto(String filtroTexto, String filtroCidade, String ordenacao) 
	{
		
		// Crinado filtro que será utilizando na lista.
		//Poderia usar o equals.toUpperCase para comparar as queries, porém a quantidade de vagas pode ser muito grande, o operador Upper ou Lower pode causar grande perda de perfomance.
		// Como estamos utilizando o Java 8, é uma opção interessante e de rápido desempenho a utilização de Predicates para filtrar listas
		Predicate<Vagas> filtro 
			= vagas -> ( 
						// Aqui utilizamos a classe Helper, para facilitar o entendimento dos filtros
						 (  Helper.comparaString(filtroTexto, vagas.getTitle()) 
						 || Helper.comparaString(filtroTexto, vagas.getDescription())
					     )
						 //Compara o filtro texto com Título e Descrição
					    )
						//Verificando a lista de cidades...
					 && (vagas.getCidade().stream().filter(
							 itemCidade -> Helper.comparaString(filtroCidade, itemCidade)
					     ).findFirst().isPresent()
			           );
		//Aqui utilizo a lib GUAVA do google pois o desempenho em grandes listas é muito bom
        List<Vagas> vagasFiltradas = FluentIterable.from(vagasJson.getDocs())
									                .filter(filtro)
									                .toList();
        //Com a utilização do MAP, do Google GUAVA, nãp podemos fazer alterações nas listas, por isso preciso instanciar uma nova lista para realizar a ordenação
        
        List<Vagas> retorno = new ArrayList<Vagas>(vagasFiltradas);
        
        //Aqui utilizamos a ordenação padrão do arquivo, caso não tenham informado nenhum parametro de ordenação na utilização do REST
        Comparator<Vagas> comp = new Comparator<Vagas>(){
    	    public int compare(Vagas s1, Vagas s2) {
    	        return 1;
    	    }
    	};
    	//Verifica as opções de filtro para saber se informaram a ordenação
		if(!Helper.isNullOrEmpty(ordenacao))
        {
			// Cria regra para ordenação padrão
			comp = new Comparator<Vagas>(){
            	    public int compare(Vagas s1, Vagas s2) {
            	        return Float.compare(s1.getSalario(), s2.getSalario());
            	    }
            	};
        	// Caso tenha informado a oredem decrescente, então ele inverte a lista
        	if(ordenacao.toUpperCase().equals("DESC"))
        	{
        		comp = comp.reversed();
        	}
        }
		//Utiliza o metódo padrão do Java 8 para ordenação de Grandes Collections, como listas
		Collections.sort(retorno, comp);
		
		//Realiza a conversão de objeto para JSON, utilizando a Lib Gson do google
		return new Gson().toJson(new Wrapper(retorno));
	}
	
	
}
