package pro_20221018;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CipherExample {
	public static void main(String[] args) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = keyGenerator.generateKey();
		
		//이미지도 가능 어떤파일이든 관계없다!
		/*
		File plainFile = new File("D:/test/pText.txt");
		File encryptFile = new File("D:\\test\\encrypt.txt");
		File decryptFile = new File("D:\\test\\decrypt.txt");
		*/
		File plainFile = new File("D:/test/cat.jpg");
		File encryptFile = new File("D:\\test\\encrypt.jpg");
		File decryptFile = new File("D:\\test\\decrypt.jpg");
		
		// 암호화
		{
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			InputStream input = null;
			OutputStream output = null;
			
			try {
				input = new BufferedInputStream(new FileInputStream(plainFile));
				output = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(encryptFile)), cipher);
				int size = 0;
				byte[] buffer = new byte[1024];
				while((size = input.read(buffer)) != -1) {
					output.write(buffer, 0, size);
				}
			}
			catch(Exception e) {
				System.err.println("Exception[Encryption] : " + e.getLocalizedMessage());
			}
			finally {
				try {
					if(output != null) output.close();
					if(input != null) input.close();
				}
				catch(Exception e) {
					System.err.println("Exception[close] : " +  e.getLocalizedMessage());
				}
				System.out.println("파일 암호화 종료");
			}
		}
		
		// 복호화
		{
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			
			InputStream input = null;
			OutputStream output = null;
			
			try {
				input = new BufferedInputStream(new FileInputStream(encryptFile));
				output = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(decryptFile)), cipher);
				int size = 0;
				byte[] buffer = new byte[1024];
				while((size = input.read(buffer)) != -1) {
					output.write(buffer, 0, size);
				}
			}
			catch(Exception e) {
				System.err.println("Exception[Decryption] : " + e.getLocalizedMessage());
			}
			finally {
				try {
					if(output != null) output.close();
					if(input != null) input.close();
				}
				catch(Exception e) {
					System.err.println("Exception[close] : " +  e.getLocalizedMessage());
				}
				System.out.println("파일 복호화 종료");
			}
		}
	}	
}