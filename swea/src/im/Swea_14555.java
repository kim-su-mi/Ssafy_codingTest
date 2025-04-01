package im;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_14555 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			int cnt = 0;
			
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(' && str.charAt(i+1) == ')') { // 잡초에 방해받지 않은 공 처리
					i+=1; // 갯수 세면 안되니까 온전한 공이면 그 다음으로 넘어가게 처리
					cnt++;
				}else if(str.charAt(i) == '(' || str.charAt(i) == ')') { //잡초에 가려진 공 계산
					cnt++;
				}
			}
			
			System.out.println(sb.append("#").append(testCase).append(" ").append(cnt));

		}

	}

}
