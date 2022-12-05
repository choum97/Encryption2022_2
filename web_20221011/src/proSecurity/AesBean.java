package proSecurity;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

public class AesBean {
	
	private static AesBean instance = new AesBean();
	private SecretKey secretKey = null;
	
	private AesBean() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			secretKey = keyGenerator.generateKey();
			Charset charset = Charset.forName("utf-8");
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
	
	public static AesBean getInstance() {
		
		return instance;
	}
	
	public String encrypt(String plainText) throws Exception {
		System.out.println("secretkey[encrypt] : " + ByteUtils.toHexString(secretKey.toString().getBytes()));
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptText = cipher.doFinal(plainText.getBytes());
		byte[] encodedData = Base64.encodeBase64(encryptText);

		return new String(encodedData);
		
		//return ByteUtils.toHexString(encryptText);
		//return new String(encryptText);
	}
	
	public String decrypt(String encryptText) throws Exception {
		System.out.println("secretkey[decrypt] : " + ByteUtils.toHexString(secretKey.toString().getBytes()));
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(cipher.DECRYPT_MODE, secretKey);
		byte[] decodedData = Base64.decodeBase64(encryptText.getBytes());
		byte[] decryptText = cipher.doFinal(decodedData);

		return new String(decryptText);
		//return ByteUtils.toHexString(decryptText);
		//return new String(decryptText);
	}
}