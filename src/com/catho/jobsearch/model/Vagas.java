package com.catho.jobsearch.model;

import java.util.List;

/*
 * Casse utilizada para o Objeto vagas, com as mesmas informa��es do JSON, essa classe ser� utilizada para o Mapping entre JSON e Classe Java*/
public class Vagas {
	
	private String title;
	private String description;
	private float  salario;
	private List<String> cidade;
	private List<String> cidadeFormated;
	
	public Vagas() {	}
	
	/**
	 * Obtem o t�tulo da vaga 
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
	 * Obtem a descri��o da vaga
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Informa sobre a descri��o da vaga
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Obtem o sal�rio da vaga em decimial;
	 * @return
	 */
	public float getSalario() {
		return salario;
	}

	/**
	 * Informa o valor do Sal�rio em Decimal
	 * @param salario
	 */
	public void setSalario(float salario) {
		this.salario = salario;
	}

	/**
	 * Lista de Cidades onde a vaga est� dispon�vel, o retorno � uma lista com o nome de cidades
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
	 * Retorna as informa��es das cidades, com informa��es adicionais
	 * @return
	 */
	public List<String> getCidadeFormated() {
		return cidadeFormated;
	}

	/**
	 * Informa��es adicionais sobre a cidade
	 * @param cidadeFormated
	 */
	public void setCidadeFormated(List<String> cidadeFormated) {
		this.cidadeFormated = cidadeFormated;
	}
	
}
