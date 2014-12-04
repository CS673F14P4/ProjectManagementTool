package bu.met.cs.cs673.pm.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class EncryptionUtil 
{
	private static final String code = "_marvel_universe";

	public static String encrypt(String input)
	{
		String encryptedstr = null;

		if (input == null || "".equals(input))
		{
			return null;
		}
		
		try
		{
			SecretKeySpec skeySpec = new SecretKeySpec(code.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES");
			
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

			byte[] encrypted = cipher.doFinal(input.getBytes("UTF-8"));
			       
			encryptedstr = new String(encrypted);
		}
		catch (Exception e)
		{
			System.out.println("error encrypting text");
			e.printStackTrace();
		}

		return encryptedstr;
	}
	
	public static String decrypt(String input)
	{
		String decryptedstr = null;

		if (input == null || "".equals(input))
		{
			return null;
		}
		
		try
		{
			SecretKeySpec skeySpec = new SecretKeySpec(code.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(Cipher.DECRYPT_MODE, skeySpec);

			byte[] decrypted = cipher.doFinal(input.getBytes());

			decryptedstr = new String(decrypted, "UTF-8");
		}
		catch (Exception e)
		{
			System.out.println("error decrypting text");
			e.printStackTrace();
		}

		return decryptedstr;
	}
}
