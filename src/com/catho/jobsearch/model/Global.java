package com.catho.jobsearch.model;

/**
 * Classe de Enum para variavéis fixas, facilitando a manutenção dessas informações
 * @author Alessandro Vieira Grammelsbache
 *
 */
public enum Global {
		   JSONPath("C:/Catho/json/vagas.json")
		   , ApiWorkingMessage("API de Busca de Vagas iniciado com sucesso!");
		   
		   private final String value;

		   private Global(String value) {
		     this.value = value;
		   }

		   public String getValue() {
		     return value;
		   }
		   
		   
}
