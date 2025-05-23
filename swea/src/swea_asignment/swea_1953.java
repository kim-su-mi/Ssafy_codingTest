package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1953 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 지하터널 지도의 세로 크기 
			int M = Integer.parseInt(st.nextToken());// 지하터널 지도의 가로 크기
			int R = Integer.parseInt(st.nextToken()); //맨홀 뚜껑의 행
			int C = Integer.parseInt(st.nextToken()); // 맨홀 뚜껑의 열
			int L = Integer.parseInt(st.nextToken()); // 소요 시간
			
			int[][] under = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					under[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int[] a : under) {
				System.out.println(Arrays.toString(a));
			}
			
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(" "));
			
			
		}
		
		
		
	}

}
