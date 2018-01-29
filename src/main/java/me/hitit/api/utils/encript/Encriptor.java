package me.hitit.api.utils.encript;

import java.security.MessageDigest;

/**
 * Encriptor.class
 * 
 * @author seungki
 *
 */
public class Encriptor {
	
	private static String ALOGRITHM = "SHA-256";
	
	public static String generateEncript(String password) {
		StringBuffer sb = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance(ALOGRITHM);
			md.update(password.getBytes());
			for(byte b : md.digest()) {
				sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		}catch(Exception e) {
			return null;
		}
	}
	
}
