package pro_20221108;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpMrg2 {
	public static void main(String[] args) {
		
		String data = "Tom was born in 1997. in 2010, he died."; 
		String regEx = "\\d{4}";
		
		List<String> ptnList = new ArrayList<String>();
		
		if(data != null) {
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(data);
			while(m.find()) {
				ptnList.add(m.group());
			}
		} else {
			System.out.println("input Is Null");
		}
		
		for(String str :ptnList) {
			System.out.println(str);
		}
	}
}
