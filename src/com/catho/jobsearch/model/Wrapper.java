package com.catho.jobsearch.model;

import java.util.List;

/**
 * Classe Utilizada apenas para criação do Docs, no arquivo jSON
 * @author Alessandro Vieira Grammelsbacher
 *
 */
public class Wrapper {

	public Wrapper(List<Vagas> vagas) {
		this.setDocs(vagas);
	}
	public Wrapper() {
		
	}
	private List<Vagas> docs;

	public List<Vagas> getDocs() {
		return docs;
	}

	public void setDocs(List<Vagas> docs) {
		this.docs = docs;
	}
}
