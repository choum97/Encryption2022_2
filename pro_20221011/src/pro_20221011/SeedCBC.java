package pro_20221011;

import java.nio.charset.Charset;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
public class SeedCBC {

	public static void main(String[] args) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("SEED");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		Charset charset = Charset.forName("utf-8");
		
		System.out.println("secretKey : "+ ByteUtils.toBinaryString(secretKey.toString().getBytes()));
		
		
		SecureRandom random = new SecureRandom();
		byte[] ivData = new byte[16];
		random.nextBytes(ivData);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(ivData);
		
		// 암호화
		String pData = "안녕하세요~ 점심시간!";
		byte[] encryptText = encrypt(secretKey, ivParameterSpec, pData.getBytes(charset));

		// 복호화
		byte[] decryptText = decrypt(secretKey, ivParameterSpec, encryptText);

		System.out.println("키 값 : " + ByteUtils.toHexString(secretKey.toString().getBytes()));
		System.out.println("평문 : " + pData);
		System.out.println("암호문 : " + ByteUtils.toHexString(encryptText).toString().getBytes());
		System.out.println("복호문 : " + new String(decryptText, charset));
		
	}
	
	private static byte[] encrypt(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] pData) throws Exception {
		Cipher cipher = Cipher.getInstance("SEED/CBC/PKCS5Padding");
		cipher.init(cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
		byte[] encryptText = cipher.doFinal(pData);

		return encryptText;
	}


	private static byte[] decrypt(SecretKey secretKey, IvParameterSpec ivParameterSpec, byte[] encryptData) throws Exception {
		Cipher cipher = Cipher.getInstance("SEED/CBC/PKCS5Padding");
		cipher.init(cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] decryptText = cipher.doFinal(encryptData);

		return decryptText;
	}
}
