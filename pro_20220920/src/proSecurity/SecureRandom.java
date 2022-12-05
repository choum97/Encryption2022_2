package proSecurity;

import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

public class SecureRandom {

	public static void main(String[] args) {
		java.security.SecureRandom random = new java.security.SecureRandom();
		byte keys [] = new byte[16];
		random.nextBytes(keys);
		System.out.println("step 1");
		System.out.println("key :" + keys);
		System.out.println("key :" + ByteUtils.toHexString(keys));
	}

}
