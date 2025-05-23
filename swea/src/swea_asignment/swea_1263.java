package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1263 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		                                                                                           
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //사람 수, 인접 행렬 크기
			
			int[][] adj = new int[N+1][N+1]; //0번은 버릴거임
			
			for (int i = 0; i < adj.length; i++) {
				Arrays.fill(adj[i], 999999);
				
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <=N; j++) {
					adj[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && adj[i][j] != 1) adj[i][j] = 999999;
				}
			}
	
			for (int k = 1; k <= N; k++) { // 경유지
				for (int i = 1; i <= N; i++) {//출발지
					for (int j = 1; j <= N; j++) { //도착지
						adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
						
					}
					
				}
			}

			int min = Integer.MAX_VALUE;
			int sum;
			for (int i = 1; i <= N; i++) {
				sum=0;
				for (int j = 1; j <= N; j++) {
					sum+=adj[j][i];
				}
				min = Math.min(sum, min);
			}
			
			
			sb.append("#").append(testCase).append(" ").append(min).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
		
		
	}

}
