package proSecurity;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

public class BCWithApplicationTest {

	public static void main(String[] args) {
		Security.addProvider(new BouncyCastlePQCProvider());
		Provider provider = Security.getProvider("BC");

		if (provider != null) {
			System.out.println("Bouncy Castle Provider is available");
			System.out.println(provider.getInfo());
		} else {
			System.out.println("Bouncy Castle Provider is NOT available");
		}
		
	}
}
