import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * dfs풀이
 */
public class bj_2178 {
	static int[] dr = { 1, 0, -1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	private static int N;
	private static int M;
	private static int[][] maze;
	private static boolean[][] visited;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		maze = new int[N][M];
		
		
		for (int i = 0; i < maze.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j)-'0';
			}
		}
		
//		for(int[] a : maze) {
//			System.out.println(Arrays.toString(a));
//		}
		
		visited = new boolean[N][M];
		ans = Integer.MAX_VALUE;
		dfs(0,0,1);
		System.out.println(ans);
		
	}

	private static void dfs(int r, int c,int dist) {
		if(dist >= ans) {
			return;
		}
		
		
		 if (r == N - 1 && c == M - 1) {
	            ans = Math.min(ans, dist);
	            return;
	     }
		 
		 
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr<0 ||nr>=N || nc<0 || nc>=M || maze[nr][nc]==0 || visited[nr][nc]) continue;
			
			visited[r][c] = true;
			dfs(nr,nc,dist+1);
			visited[r][c] = false;
		}
		
	}

}
