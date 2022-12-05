package pro_20221108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpMgr4 {
	public static void main(String[] args) throws IOException {
		String line = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		List<String> ptnList = new ArrayList<String>();
		
		//br
		try {
			br = new BufferedReader(new FileReader("d:\\test.txt"));
			while ((line=br.readLine())!=null) {
				System.out.println(line);
				String data = line; 
				String regEx = "(?=.*김민재).*";
				if(data != null) {
					Pattern p = Pattern.compile(regEx);
					Matcher m = p.matcher(data);
					while(m.find()) {
						ptnList.add(m.group());
					}
				}
			}
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}finally {
			br.close();
		}
		
		// bw
		try {
			System.out.println("bw 실행");
			
			bw = new BufferedWriter(new FileWriter("d:\\test_write.txt"));
			for(String str :ptnList) {
				bw.write(str+"\n");
				System.out.println("str : " + str);
			}
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}finally {
			bw.close();
			System.out.println("bw 종료");
		}
		
	}
}
