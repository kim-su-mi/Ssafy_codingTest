import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2178_2 {
	static class Pos{
		int r;
		int c;
		int dist;
		public Pos(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
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
		
		visited = new boolean[N][M];
		ans = bfs(0,0);
		System.out.println(ans);
	}

	private static int bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r,c,1));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Pos curr = q.poll();
			
			if(curr.r == N-1 && curr.c == M-1) {
				return curr.dist;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r+dr[i];
				int nc = curr.c+dc[i];
				
				if(nr<0 || nr>=N || nc<0||nc>=M||visited[nr][nc] == true||maze[nr][nc] == 0) continue;
				
				q.add(new Pos(nr,nc,curr.dist+1));
				visited[nr][nc] = true;
			}
		}
		return -1;
	}
}
