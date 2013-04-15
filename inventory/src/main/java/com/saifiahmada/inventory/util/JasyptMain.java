package com.saifiahmada.inventory.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author glassfish | Saipi Ramli Ahmada
 *
 * Oct 30, 2012
 */
public class JasyptMain {
	
	public static void main(String[] args) {
        String passwordEnkriptor = "newWMS";
        BasicTextEncryptor chiper = new BasicTextEncryptor();
        chiper.setPassword(passwordEnkriptor);
        String plainText = "honda";
        System.out.println("String "+plainText+" diencrypt menjadi : "+chiper.encrypt(plainText));
    }

}
