package test;

import java.util.Scanner;

/**
 * 미로찾기 0이면 길 , 1이면 벽 (0,0)에서 시작해서 N-1,N-1로 가는데 미로를 탈출할 수 있는지 알아내는 문제
 */
public class Dfs_미로찾기 {
	static int[] dr = { 1, 0, -1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	private static boolean[][] visited;
	private static int N;
	private static int[][] maze;
	private static boolean ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		N = sc.nextInt();
		ans = false;

		maze = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze.length; j++) {
				maze[i][j] = sc.nextInt();
			}
		}

		dfs(0, 0);
		System.out.println(ans);

	}

	private static void dfs(int r, int c) {
		if(r == N-1 && c == N-1 && maze[r][c] == 0) {
			ans = true;
			return;
		}
		
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || maze[nr][nc] == 1)
				continue;

			dfs(nr,nc);
		}

	}

	static String input = "8\r\n" + "0 0 1 1 1 1 1 1\r\n" + "1 0 0 0 0 0 0 1\r\n" + "1 1 1 0 1 1 1 1\r\n"
			+ "1 1 1 0 1 1 1 1\r\n" + "1 0 0 0 0 0 0 1\r\n" + "1 0 1 1 1 1 1 1\r\n" + "1 0 0 0 0 0 0 0\r\n"
			+ "1 1 1 1 1 1 1 1";
}
