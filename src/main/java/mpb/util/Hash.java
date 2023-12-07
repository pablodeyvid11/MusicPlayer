package mpb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Hash {
	public static String hashPassword(String password) {
		String generatedHash = null;
		try {
			String seed = "146574474675";
			byte[] salt = seed.getBytes();

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt);

			byte[] hashedPassword = md.digest(password.getBytes());

			byte[] combined = new byte[hashedPassword.length + salt.length];
			System.arraycopy(salt, 0, combined, 0, salt.length);
			System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);
			generatedHash = Base64.getEncoder().encodeToString(combined);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedHash;
	}
}
