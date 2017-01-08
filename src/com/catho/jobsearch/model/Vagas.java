package com.catho.jobsearch.model;

import java.util.List;

public class Vagas {

	private String title;
	private String description;
	private float  salario;
	private List<String> cidade;
	private List<String> cidadeFormated;
	
	public Vagas() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public List<String> getCidade() {
		return cidade;
	}

	public void setCidade(List<String> cidade) {
		this.cidade = cidade;
	}

	public List<String> getCidadeFormated() {
		return cidadeFormated;
	}

	public void setCidadeFormated(List<String> cidadeFormated) {
		this.cidadeFormated = cidadeFormated;
	}
	
}
