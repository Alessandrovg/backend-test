package com.catho.jobsearch.controle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.naming.NamingException;

import org.json.JSONException;

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

public class VagasController {
	private Wrapper vagasJson; 
	public VagasController() throws JsonParseException, JsonMappingException, NamingException, IOException {
		mapJSON();
	}
	
	public void mapJSON() throws JsonParseException, JsonMappingException, IOException  
	{
		vagasJson = new ObjectMapper().readValue(new File(Global.JSONPath.getValue()) , Wrapper.class);
	}
	
	public String filtrarVagasPorTexto(String filtroTexto, String filtroCidade, String ordenacao) throws JSONException
	{
		
		// Crinado filtro que será utilizando na lista.
		//Poderia usar o equals.toUpperCase para comparar as queries, porém a quantidade de vagas pode ser muito grande, o operador Upper ou Lower pode causar grande perda de perfomance.
		Predicate<Vagas> filtro 
			= vagas -> ( 
						 (  Helper.comparaString(filtroTexto, vagas.getTitle()) 
						 || Helper.comparaString(filtroTexto, vagas.getDescription())
					     )
					    )
					 && (vagas.getCidade().stream().filter(
							 itemCidade -> Helper.comparaString(filtroCidade, itemCidade)
					     ).findFirst().isPresent()
			           );
        List<Vagas> vagasFiltradas = FluentIterable.from(vagasJson.getDocs())
									                .filter(filtro)
									                .toList();
        List<Vagas> retorno = new ArrayList<Vagas>(vagasFiltradas);
        
        Comparator<Vagas> comp = new Comparator<Vagas>(){
    	    public int compare(Vagas s1, Vagas s2) {
    	        return 1;
    	    }
    	};
		if(!Helper.isNullOrEmpty(ordenacao))
        {
			comp = new Comparator<Vagas>(){
            	    public int compare(Vagas s1, Vagas s2) {
            	        return Float.compare(s1.getSalario(), s2.getSalario());
            	    }
            	};
        	 	
        	if(ordenacao.toUpperCase().equals("DESC"))
        	{
        		comp = comp.reversed();
        	}
        }
		Collections.sort(retorno, comp);
		
		return new Gson().toJson(new Wrapper(retorno));
	}
	
	
}
