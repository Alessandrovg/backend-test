package com.catho.jobsearch.model;

import java.util.List;

/*
 * Casse utilizada para o Objeto vagas, com as mesmas informações do JSON, essa classe será utilizada para o Mapping entre JSON e Classe Java*/
public class Vagas {
	
	private String title;
	private String description;
	private float  salario;
	private List<String> cidade;
	private List<String> cidadeFormated;
	
	public Vagas() {	}
	
	/**
	 * Obtem o título da vaga 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Retorna o titulo da vafa
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Obtem a descrição da vaga
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Informa sobre a descrição da vaga
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Obtem o salário da vaga em decimial;
	 * @return
	 */
	public float getSalario() {
		return salario;
	}

	/**
	 * Informa o valor do Salário em Decimal
	 * @param salario
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}

	/**
	 * Lista de Cidades onde a vaga está disponível, o retorno é uma lista com o nome de cidades
	 * @return
	 */
	public List<String> getCidade() {
		return cidade;
	}

	/**
	 * Informa a lista de cidades
	 * @param cidade
	 */
	public void setCidade(List<String> cidade) {
		this.cidade = cidade;
	}

	/**
	 * Retorna as informações das cidades, com informações adicionais
	 * @return
	 */
	public List<String> getCidadeFormated() {
		return cidadeFormated;
	}

	/**
	 * Informações adicionais sobre a cidade
	 * @param cidadeFormated
	 */
	public void setCidadeFormated(List<String> cidadeFormated) {
		this.cidadeFormated = cidadeFormated;
	}
	
}
