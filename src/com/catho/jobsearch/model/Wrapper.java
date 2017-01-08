package com.catho.jobsearch.model;

import java.util.List;

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
