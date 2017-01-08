package com.catho.jobsearch.api.helper;

import java.util.regex.Pattern;
/*
 * Classe utilizada como auxiliar para algumas funções, evitando repetições no código e deixando fácil para manutenção e entendimento*/
public class Helper {

	/**
	 * Verifica se a String é nula ou vazia.
	 * Para comparações de String, precisamos verificar se a string foi instanciada e então verificar se
	 * está vazia, no Controller, estava dificil de entender o fonte, por isso separei para facilitar o debug
	 * @param texto
	 * @return boolean informando se a string é nula ou vazia
	 */
	public static boolean isNullOrEmpty(String texto)
	{
		return texto == null || texto.isEmpty();
	}
	
	/**
	 * Como a massa de dados pode ser maior do que a informada, utilizei o Patter Compile, que otimiza a comparação 
	 * e conseguimos tirar o case sensitive da comparação, porém mantemos a diferença de acentuação
	 * @param s1 Primeira String a ser comparadas
	 * @param s2 String a qual a primeira será comparada
	 * @return Bolleando informando se a contém a String 1 na String 2
	 */
	public static boolean comparaString(String s1, String s2)
	{
		if(Helper.isNullOrEmpty(s1) || Helper.isNullOrEmpty(s2))
			return true;
		
		return Pattern.compile(Pattern.quote(s1), Pattern.CASE_INSENSITIVE).matcher(s2).find();
	}

}
