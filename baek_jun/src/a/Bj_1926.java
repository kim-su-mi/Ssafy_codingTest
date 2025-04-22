package a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_1926 {
	private static int[][] map;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int N;
	private static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int cnt = 0;
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] = a;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cnt++;
					max = Math.max(max,dfs(i,j,1));					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n").append(max);
		System.out.println(sb.toString());
		
	}

	private static int dfs(int r, int c,int sum) {
		map[r][c] = 0;
		
		for (int k = 0; k < 4; k++) {
			int nr =r+dr[k];
			int nc = c+dc[k];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc] == 0) continue;
			
			sum = dfs(nr,nc,sum+1);
		}
		
		return sum;
	}

}
