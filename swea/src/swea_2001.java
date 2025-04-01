import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2001 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 배열의 크기
			int M = Integer.parseInt(st.nextToken()); //파리채의 크기
			
			int[][] arr = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = -1;

			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) { // 배열 크기-파리채의 크기 좌표까지만 보면됌
					int sum = 0; // 여기서 sum 초기화
					// 현재 위치에서 잡은 파리 수 구하는 for문
					for(int x=i; x<i+M; x++) {
						for(int y=j; y<j+M; y++) {
							sum+=arr[x][y];
						}
						
					}
					 max = Math.max(max, sum);
				}
			}
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(max));
			
		}
		
		
		
	}

}
