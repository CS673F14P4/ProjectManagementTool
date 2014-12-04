package bu.met.cs.cs673.pm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class EncryptionUtil {
	private static final String code = "_marvel_universe";

	public static String encrypt(String input) {
		String encryptedstr = null;
		/**
		 * code from: http://mustafacanturk.com/sha512-hashing-on-java/
		 */
		MessageDigest md;
		String message = input;
		try {
			md = MessageDigest.getInstance("SHA-512");

			md.update(message.getBytes());
			byte[] mb = md.digest();
			String out = "";
			for (int i = 0; i < mb.length; i++) {
				byte temp = mb[i];
				String s = Integer.toHexString(new Byte(temp));
				while (s.length() < 2) {
					s = "0" + s;
				}
				s = s.substring(s.length() - 2);
				out += s;
			}
			encryptedstr = out;

		} catch (NoSuchAlgorithmException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		return encryptedstr;
	}

	public static String decrypt(String input) {
		String decryptedstr = null;

		if (input == null || "".equals(input)) {
			return null;
		}

		try {
			SecretKeySpec skeySpec = new SecretKeySpec(code.getBytes("UTF-8"),
					"AES");

			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.DECRYPT_MODE, skeySpec);

			byte[] decrypted = cipher.doFinal(input.getBytes());

			decryptedstr = new String(decrypted, "UTF-8");
		} catch (Exception e) {
			System.out.println("error decrypting text");
			e.printStackTrace();
		}

		return decryptedstr;
	}
}
