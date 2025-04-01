import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int num = 666;
		while(cnt != N) {
			num++;
			// int형인 num을 String으로 변환한 뒤, "666"이란 문자열이 있는지 검사
			if(String.valueOf(num).contains("666")) { 
				cnt++;
			}
			
		}
		System.out.println(num);

	}

}
