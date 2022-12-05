package pro_20221108;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpMrg1 {
	public static void main(String[] args) {
		
		String data = "3:a5 hello~ 314:BUS2 go"; // 3:A5 314:BUS2
		String regEx = "\\d{1,}:\\D{1,}\\d";
		StringBuffer buffer = new StringBuffer();
		
		
		if(data != null) {
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(data);
			if(m.find()) {
				buffer.append("Valid Input : " + data);
				buffer.append("\nUpdate Iput : " + m.replaceAll(""));
			}else {
				buffer.append("Valid Input : " + data);
			}
		} else {
			buffer.append("Input Is Null");
		}
		
		System.out.println(buffer);
		
	}
}
