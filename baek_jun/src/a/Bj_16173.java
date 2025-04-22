package a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_16173 {
	static class Pos{ 
		int r;
		int c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
	}
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	private static int[][] map;
	private static int N;
	private static StringBuilder sb;
	private static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //맵의 크기
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		flag = false;
		sb = new StringBuilder();
		bfs(0,0); //왼쪽 위 0,0에서 부터 시작
		
		if(flag) {
			sb.append("HaruHaru");
		}else {
			sb.append("Hing");
		}
		
		System.out.println(sb.toString());
		
	}

	private static void bfs(int r, int c) {
		Queue<Pos> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Pos(r, c));
		visited[r][c] = true;
		
		A:while(!q.isEmpty()) {
			Pos curr = q.poll();
			
			int step = map[curr.r][curr.c];
			for (int i = 0; i < 2; i++) {
				int nr = curr.r + (dr[i]*step);
				int nc = curr.c + (dc[i]*step);
				
				if(nr<0 || nr>=N ||nc<0 ||nc>=N || visited[nr][nc])continue;
				if(nr == N-1 && nc == N-1) {
					flag = true;
					break A;
				}
				visited[nr][nc] = true;
				q.add(new Pos(nr,nc));
			}
		}
		
	}

}
