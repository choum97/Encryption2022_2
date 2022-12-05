package pro_20221018;

import java.nio.charset.Charset;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

public class PBEExample {
	public static void main(String[] args) throws Exception {
		char[] password = "test123".toCharArray();
		String pText = "이 밤을 다시 한번";
		Charset charset = Charset.forName("utf-8");
		
		byte[] salt = new byte[8];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);
		int iterationCount = 1000;
		
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterationCount, 128);
		SecretKey secretKey = new SecretKeySpec(keyFactory.generateSecret(keySpec).getEncoded(), "AES");
		
		byte[] encryptData = encrypt(secretKey, pText.getBytes());
		byte[] decryptData = decrypt(secretKey, encryptData);
		
		System.out.println(ByteUtils.toHexString(encryptData));
		System.out.println(new String(decryptData));
	}
	
	public static byte[] encrypt(SecretKey secretKey, byte[] pData) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptText = cipher.doFinal(pData);

		return encryptText;
	}


	public static byte[] decrypt(SecretKey secretKey, byte[] encryptData) throws Exception {
		
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(cipher.DECRYPT_MODE, secretKey); 
		byte[] decryptText = cipher.doFinal(encryptData);
		 

		return decryptText;
	}
}