package com.catho.jobsearch.api.helper;

import java.util.regex.Pattern;

public class Helper {

	public static boolean isNullOrEmpty(String texto)
	{
		return texto == null || texto.isEmpty();
	}
	
	public static boolean comparaString(String s1, String s2)
	{
		if(Helper.isNullOrEmpty(s1) || Helper.isNullOrEmpty(s2))
			return true;
		
		return Pattern.compile(Pattern.quote(s1), Pattern.CASE_INSENSITIVE).matcher(s2).find();
	}

}
