package com.catho.jobsearch.model;

public enum Global {
		   JSONPath("C:/Catho/json/vagas.json");

		   private final String value;

		   private Global(String value) {
		     this.value = value;
		   }

		   public String getValue() {
		     return value;
		   }
}
