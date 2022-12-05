package proSecurity;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

public class MessageDigestExample {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Charset charset = Charset.forName("utf-8");
		
		String plainTest = "hello World";
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(plainTest.getBytes(charset));
		
		 byte [] hash = md.digest();
		 System.out.println("Md : " + ByteUtils.toHexString(hash)); //16
		 System.out.println("Md : " + ByteUtils.toBinaryString(hash)); //2진수
	}
}
