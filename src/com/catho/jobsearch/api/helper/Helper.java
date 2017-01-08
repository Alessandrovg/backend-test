package com.catho.jobsearch.api.helper;

import java.util.regex.Pattern;
/*
 * Classe utilizada como auxiliar para algumas fun��es, evitando repeti��es no c�digo e deixando f�cil para manuten��o e entendimento*/
public class Helper {

	/**
	 * Verifica se a String � nula ou vazia.
	 * Para compara��es de String, precisamos verificar se a string foi instanciada e ent�o verificar se
	 * est� vazia, no Controller, estava dificil de entender o fonte, por isso separei para facilitar o debug
	 * @param texto
	 * @return boolean informando se a string � nula ou vazia
	 */
	public static boolean isNullOrEmpty(String texto)
	{
		return texto == null || texto.isEmpty();
	}
	
	/**
	 * Como a massa de dados pode ser maior do que a informada, utilizei o Patter Compile, que otimiza a compara��o 
	 * e conseguimos tirar o case sensitive da compara��o, por�m mantemos a diferen�a de acentua��o
	 * @param s1 Primeira String a ser comparadas
	 * @param s2 String a qual a primeira ser� comparada
	 * @return Bolleando informando se a cont�m a String 1 na String 2
	 */
	public static boolean comparaString(String s1, String s2)
	{
		if(Helper.isNullOrEmpty(s1) || Helper.isNullOrEmpty(s2))
			return true;
		
		return Pattern.compile(Pattern.quote(s1), Pattern.CASE_INSENSITIVE).matcher(s2).find();
	}

}
