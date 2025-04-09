package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1486_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //점원 수
			int B = Integer.parseInt(st.nextToken()); // 선반 높이 
			
			int minDiff = Integer.MAX_VALUE;
			
			int[] heights = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i < (1<<N); i++) {
				int sum=0;
				for (int j = 0; j < N; j++) {
					if((i & (1<<j)) != 0) {
						sum+=heights[j];
					}
				}
				if(sum>=B && sum-B < minDiff) {
					minDiff = sum-B;
				}
			}
			
			
		
			sb.append("#").append(testCase).append(" ").append(minDiff).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
		
		
	}

}
