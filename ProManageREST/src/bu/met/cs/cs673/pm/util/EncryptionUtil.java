package bu.met.cs.cs673.pm.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class EncryptionUtil 
{
	//private static final String code = "_marvel_universe";

	/**
	 * encrypt()
	 * 
	 * Hashing function obtained from this website:
	 * http://www.mkyong.com/java/java-sha-hashing-example/
	 * 
	 * @param password
	 * @return
	 */
	public static String encrypt(String password) 
	{
		String encryptedPassword = null;
		
        MessageDigest md = null; 

        try 
        {
        	md = MessageDigest.getInstance("SHA-512");
        	md.update(password.getBytes());
        }
        catch (NoSuchAlgorithmException nsa)
        {
        	nsa.printStackTrace();
        }
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) 
        {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        System.out.println("Hex format : " + sb.toString());
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) 
    	{
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	
    		if(hex.length()==1) 
    			hexString.append('0');
   	     		
    		hexString.append(hex);
    	}
    	
    	encryptedPassword = hexString.toString();
    	
    	return encryptedPassword;
	}

}
