package pro_20220927;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

public class CheckExmaple {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\apache-tomcat-9.0.67-windows-x64.zip");
		String sha512 = "1cd0cae910d890941c0b89cdcb295c449237789e67f383683d7a6a3c336f4bfdcaee3bee77287650dd3531486b2b2dcec42dc8852c627a2726dd8b7dc04f7136";
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		InputStream input = new BufferedInputStream(new FileInputStream(file));

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
		
		if(ByteUtils.toHexString(hash).equals(sha512)) {
			System.out.println("해쉬값 일치");
			System.out.println("해쉬값 : " + ByteUtils.toHexString(hash));
		}else {
			System.out.println("불일치");
			System.out.println("현재 파일 값 : " + ByteUtils.toHexString(hash));
			System.out.println("sha512 값 : " + sha512);
		}
	}

}
