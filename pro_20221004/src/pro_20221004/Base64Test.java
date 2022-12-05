package pro_20221004;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

public class Base64Test {

	public static void main(String[] args) throws Base64DecodingException {
		String pText1 = "AI";
		String pText2 = "Date";

		//1번) 01000001 01001001 ->  010000 010100 100100 → 뒤에 비는곳은(패딩) 00으로
		//     16 20 36이 됨 
		System.out.println(Base64.encode(pText1.getBytes())); //QUk=  : Base64로 변환한 것
		System.out.println(Base64.encode(pText2.getBytes())); // RGF0YQ==
		
		String encodeData = Base64.encode(pText1.getBytes());
		byte[] decodeData = Base64.decode(encodeData);
		
		System.out.println("encode : " + encodeData);
		System.out.println("decode : " + new String(decodeData));
		
	}

}
