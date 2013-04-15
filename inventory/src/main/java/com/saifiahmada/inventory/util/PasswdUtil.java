package com.saifiahmada.inventory.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** @author Saifi Ahmada Feb 11, 2013 8:38:10 PM  **/

public class PasswdUtil {
	
	public static String getMD5DigestFromString(String plain){
		MessageDigest md;
		StringBuffer sb = null; 
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(plain.getBytes());
			
			byte byteDate [] = md.digest();
			sb = new StringBuffer();
			for (int i=0; i < byteDate.length; i++){
				sb.append(Integer.toString((byteDate[i] & 0xff) + 0x100,16).substring(1));
			}
			
		} catch (NoSuchAlgorithmException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}

