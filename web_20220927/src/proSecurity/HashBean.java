package proSecurity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

public class HashBean {
	public boolean CheckHash(String fileName, String algorithm, String getHash) throws Exception {
		File file = new File(fileName);
		MessageDigest md = MessageDigest.getInstance(algorithm);
		InputStream input = new BufferedInputStream(new FileInputStream(file));
		boolean res;
		
		try {
			byte [] buffer = new byte[1024];
			int read;
			
			while ((read = input.read(buffer)) != -1) {
				md.update(buffer, 0, read);
			}
		}catch (Exception e) {
			System.out.println("에러 :" + e.getMessage());
		}finally {
			input.close();
		}
		byte [] hash = md.digest();
		
		if(ByteUtils.toHexString(hash).equals(getHash)) {
			res = true;
			System.out.println("해쉬값 일치");
			System.out.println("해쉬값 : " + ByteUtils.toHexString(hash));
			System.out.println(algorithm +" 값 : " + getHash);
		}else {
			res = false;
			System.out.println("불일치");
			System.out.println("현재 파일 값 : " + ByteUtils.toHexString(hash));
			System.out.println(algorithm +" 값 : " + getHash);
		}
		
		return res;
	}
}
