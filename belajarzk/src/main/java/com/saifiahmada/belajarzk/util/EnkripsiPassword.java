package com.saifiahmada.belajarzk.util;

import com.saifiahmada.belajarzk.base.TrioBasePage;

public class EnkripsiPassword extends TrioBasePage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String EnkripsiPass(String userName, String password){

		String usr = userName;
		String pwd = password;

		String susunan = pwd + usr;
		String hasil = "";

		int length = susunan.length();

		int n = 0 ;

		if (length % 2 == 1){
			for(int i = 1 ; i <= length/2 ; i ++){

				n = i * 2 ;
				hasil = substringBaru(susunan, 1-1 , n-1) + substringBaru(susunan, (n+1)-1, 1) + substringBaru(susunan, (n-1), 1)
						+ substringBaru(susunan, (n+2)-1 , length-n-1);
				susunan=hasil;
			}
		}else{
			for(int i = 1 ; i < length/2 ; i ++){
				n = i * 2 ;
				hasil = substringBaru(susunan, 1-1 , n-1) + substringBaru(susunan, (n+1)-1, 1) + substringBaru(susunan, (n-1), 1)
						+ substringBaru(susunan, (n+2)-1 , length-n-1);
				susunan=hasil;
			}
		}

		return susunan;
	}



	public String substringBaru (String name, int x, int y) {

		String str = name;
		String str1 = str.substring(x);
		String strBaru = str1.substring(0,y);
		return strBaru;
	}
}
