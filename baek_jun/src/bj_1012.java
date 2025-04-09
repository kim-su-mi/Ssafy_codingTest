import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1012 {
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static int[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static int M;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테케 수
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 배추 밭 가로 길이
			N = Integer.parseInt(st.nextToken()); // 배추 밭 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 배추의 위치

			int ans = 0;

			map = new int[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						ans++;
						bfs(i, j);
					}
				}
			}
			sb.append(ans).append("\n");

		} // end Tc
		System.out.println(sb.toString());
	}

	private static void bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c));
		map[r][c] = 0;

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0)
					continue;

				q.add(new Pos(nr, nc));
				map[nr][nc] = 0;
			}
		}

	}

}
