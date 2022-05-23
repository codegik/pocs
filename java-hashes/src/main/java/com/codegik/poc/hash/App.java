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

			// Object -> json string

			String entryJson1 = "{\"host\": \"demo-host\",\"site\": \"us\",\"app\": {\"scm_branch\": \"develop\",\"mutualTLS\": \"Not Set\",\"profile\": \"demo\",\"subProfile\": \"default\",\"groupId\": \"UNKNOWN\",\"version\": \"265.0-SNAPSHOT\",\"buildTime\": \"Mon Apr 04 17:12:53 UTC 2022\",\"allHttpPorts\": []}}";
			String entryJson2 = "{\"post\": \"demo-host\",\"site\": \"us\",\"app\": {\"scm_branch\": \"develop\",\"mutualTLS\": \"Not Set\",\"profile\": \"demo\",\"subProfile\": \"default\",\"groupId\": \"UNKNOWN\",\"version\": \"265.0-SNAPSHOT\",\"buildTime\": \"Mon Apr 04 17:12:53 UTC 2022\",\"allHttpPorts\": []}}";

		    String hash1ForEntryJson1 = app.createMD5Hash(entryJson1);
			System.out.println("MD5Hash " + hash1ForEntryJson1 + " " + hash1ForEntryJson1.length());

		    String hash2ForEntryJson1 = app.createMD5Hash(entryJson1);
			System.out.println("MD5Hash " + hash2ForEntryJson1 + " " + hash2ForEntryJson1.length());

		    String hash3ForEntryJson2 = app.createMD5Hash(entryJson2);
			System.out.println("MD5Hash " + hash3ForEntryJson2 + " " + hash3ForEntryJson2.length());

			System.out.println("entryJson1 == entryJson2 -> " + entryJson1.equals(entryJson2));
			System.out.println("hash1ForEntryJson1 == hash2ForEntryJson1 -> " + hash1ForEntryJson1.equals(hash2ForEntryJson1));
			System.out.println("hash1ForEntryJson1 == hash3ForEntryJson2 -> " + hash1ForEntryJson1.equals(hash3ForEntryJson2));
	}

}
