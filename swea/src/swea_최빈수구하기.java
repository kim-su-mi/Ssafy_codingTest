import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_최빈수구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			int k = Integer.parseInt(br.readLine());
		

			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// index = 점수 , 점수의 빈도수 저장
			int[] score = new int[101];
			
			for(int i=0; i<1000; i++) {
				score[Integer.parseInt(st.nextToken())]+=1;
			}
			
			// 빈도수가 같으면 큰 값 반환해야해서 뒤부터 탐색
			int max = 0;
			int frequency = 0;
			for(int i=score.length-1; i>=0; i--) {
				if(score[i] > max) {
					max = score[i];
					frequency = i;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(k).append(" ").append(frequency));
			
		}
		
		
		
	}

}
