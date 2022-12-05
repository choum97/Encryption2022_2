package pro_20221108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegExpMgr3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("d:\\test.txt"));
			String line = null;
			while ((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}finally {
			br.close();
		}
		
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("d:\\test_write.txt"));
			bw.write("GoGo! \n");
			bw.write("김민재 화이팅");
			
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}finally {
			bw.close();
		}
		
	}
	
/* test.txt
 맨유 결단 내렸다, 텐 하흐 체제 4분 '5000만 파운드 수비수' 내보낸다
2분데스리가 MVP, 최소 830억 원에 첼시행...구두 계약 완료
3아내와 바람피운 前 동료와 같은 호텔에서 숙박→기막힌 재회?
4김민재 뚫을 수 있을까…‘부상’ 포그바, 나폴리전 복귀 정조준
5[월드컵] '먼저 갑니다' 16강 진출-탈락 확정 팀들은?
6'Here We Go!' 은쿤쿠, 첼시와 구두 계약 완료...840억+내년 여름 합류
7김민재 강력하게 원하는 맨유... '샀다 하면 대박' 텐하흐가 찍었다
8[오피셜] FA컵 64강 대진표 확정...맨시티vs첼시-토트넘vs포츠머스
9'이천수 전 소속팀' 호날두에 3010억 제시... 끊임없는 관심
10부스케츠, 바르사와 재계약 불투명…유력한 행선지는 마이애미
 */
}
