package com.codegik.poc.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class App {

	public String createMD5Hash(final String input) throws NoSuchAlgorithmException{
        byte[] messageDigest = MessageDigest.getInstance("MD5").digest(input.getBytes());

 		return convertToHex(messageDigest);
	}

	private String convertToHex(final byte[] messageDigest) {
		BigInteger bigint = new BigInteger(1, messageDigest);
        String hexText = bigint.toString(16);
        while (hexText.length() < 32) {
        	hexText = "0".concat(hexText);
        }
		return hexText;
	}


	public static void main(String[] args) throws NoSuchAlgorithmException {
		    App app = new App();

			String json1 = "{\"host\": \"demo-host\",\"site\": \"us\",\"app\": {\"scm_branch\": \"develop\",\"mutualTLS\": \"Not Set\",\"profile\": \"demo\",\"subProfile\": \"default\",\"groupId\": \"UNKNOWN\",\"version\": \"265.0-SNAPSHOT\",\"buildTime\": \"Mon Apr 04 17:12:53 UTC 2022\",\"allHttpPorts\": []}}";
			String json2 = "{\"post\": \"demo-host\",\"site\": \"us\",\"app\": {\"scm_branch\": \"develop\",\"mutualTLS\": \"Not Set\",\"profile\": \"demo\",\"subProfile\": \"default\",\"groupId\": \"UNKNOWN\",\"version\": \"265.0-SNAPSHOT\",\"buildTime\": \"Mon Apr 04 17:12:53 UTC 2022\",\"allHttpPorts\": []}}";

		    String hash1 = app.createMD5Hash(json1);
			System.out.println("MD5Hash " + hash1 + " " + hash1.length());

		    String hash2 = app.createMD5Hash(json1);
			System.out.println("MD5Hash " + hash2 + " " + hash2.length());

		    String hash3 = app.createMD5Hash(json2);
			System.out.println("MD5Hash " + hash3 + " " + hash3.length());

			System.out.println("hash1 == hash2 -> " + hash1.equals(hash2));
			System.out.println("hash1 == hash3 -> " + hash1.equals(hash3));
			System.out.println("json1 == json2 -> " + json1.equals(json2));
	}

}
