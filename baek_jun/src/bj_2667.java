import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class bj_2667 {
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	private static int N;
	private static int[][] map;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // N*N, 지도의 크기

		map = new int[N][N];

		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map.length; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0; // 단지수
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1) {
					cnt++;
					ans = 1;
					count(i, j);
					list.add(ans);
				}
			}
		}

		Collections.sort(list); //오름차순 정렬
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for (int a : list) {
			sb.append(a + "\n");
		}
		System.out.println(sb.toString());

	}

	private static void count(int i, int j) {

		map[i][j] = 0;

		for (int k = 0; k < 4; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0)
				continue;
			ans++;
			count(nr, nc);
		}

	}

}
