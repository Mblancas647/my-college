package com.mycollege.user.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HashingUtility {
	/*
	 * Generates a byte array with 32 bytes to be used in combination with hashing a password
	 */
	public static String generateUniqueSalt() {
		SecureRandom random = new SecureRandom();
		byte[] bytes = new byte[32];
		random.nextBytes(bytes);
		System.out.println();
		String hexString = convertToHex(bytes);
		return hexString;
	}
	
	public static String getHashValue(String data) throws NoSuchAlgorithmException {
		/*
		 * This message digest class provides applications the functionality of a message digest algorithm(SHA-1, SHA-256).
		 * Message digests are secure one-way hash functions that take data and output a fixed-length hash value.
		 */
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		/*
		 * md.update: Accepts a byte array representing the data/string and passes it to the MessageDigest object.
		 */
		md.update(data.getBytes());
		
		/*
		 *md.digest: returns an array of bytes.
		 *In this case, it returns an array of 32 bytes since the SHA-256 algorithm is used
		 */
		byte[] digest = md.digest();
		
		/*
		 * Converts the digest byte array to hex format
		 */
		String hexString = convertToHex(digest);
		
		/*
		 * returns the string format of the hash value
		 */
		return hexString.toString();
	}
	
	private static String convertToHex(byte[] bytes) {
		StringBuffer hexString = new StringBuffer();
		for(int i = 0; i<bytes.length; i++) {
			/*
			 * Converts each byte of data into its corresponding hexadecimal format
			 * and appends its hex value to the string buffer
			 */
			hexString.append(Integer.toHexString(0xFF & bytes[i]));
		}
		return hexString.toString();
	}
}
