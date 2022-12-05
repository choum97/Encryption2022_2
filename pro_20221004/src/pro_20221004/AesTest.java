package pro_20221004;

import java.nio.charset.Charset;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
public class AesTest {

	public static void main(String[] args) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);

		SecretKey secretKey = keyGenerator.generateKey();
		Charset charset = Charset.forName("utf-8");

		// 암호화
		String pData = "안녕하세요~ 점심시간!";
		byte[] encryptText = encrypt(secretKey, pData.getBytes(charset));

		// 복호화
		byte[] decryptText = decrypt(secretKey, encryptText);

		System.out.println("키 값 : " + ByteUtils.toHexString(secretKey.toString().getBytes()));
		System.out.println("키 값[Base64] : " + Base64.encode(secretKey.toString().getBytes()));
		System.out.println("평문 : " + pData);
		System.out.println("암호문 : " + ByteUtils.toHexString(encryptText));
		System.out.println("암호문[Base64] : " + Base64.encode(encryptText));
		System.out.println("복호문 : " + new String(decryptText, charset));

	}

	private static byte[] encrypt(SecretKey secretKey, byte[] pData) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptText = cipher.doFinal(pData);

		return encryptText;
	}

	private static byte[] decrypt(SecretKey secretKey, byte[] encryptData) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(cipher.DECRYPT_MODE, secretKey);
		byte[] decryptText = cipher.doFinal(encryptData);

		// String coverted = new String(decryptText);
		// System.out.println("decrtpt : " + coverted);
		return decryptText;
	}

}
