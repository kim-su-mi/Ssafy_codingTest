package aps2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Swea_10726 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			String result = "";
			int N = Integer.parseInt(st.nextToken()); //1인지 비교할 마지막 N개의 비트
			int M = Integer.parseInt(st.nextToken()); // 이진수로 표현할 10진수
			
			
			while(M > 0) {
				sb.append(M%2);
				M = M/2;
			}
			sb.append(M);
//			System.out.println(sb);
			String str = sb.reverse().toString();
			
			
			int idx = str.length()-1;
			if(idx < N) {
				result = "OFF";
				continue;
			}
			int binary = Integer.parseInt(str.substring(idx-N+1));
//			
			String binaryStr = "";
			
			
			System.out.println(str);
			

			
//			System.out.println( last );
			
			
			
//			System.out.println(sb.append("#").append(testCase).append(" ").append(" "));
			
			
		}
		
		
		
	}

}
