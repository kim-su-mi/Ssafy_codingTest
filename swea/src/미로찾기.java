import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로찾기 {
	private static boolean[][] visited;
//	private static boolean[][] path;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static String[][] map;

	public static void main(String[] args) {

		String input = " G R R G T G G R G X\r\n" + " G R R G T R G G G G\r\n" + " G R R G R R R G R R\r\n"
				+ " F A G G G G G G G G\r\n" + " G R T T R G R G E1 G\r\n" + " G G T T R G G G G G\r\n"
				+ " R G G G G G E2 R G R\r\n" + " G G R W W W G G G G\r\n" + " G G R W W W R R R G\r\n"
				+ " H G G G A1 G G G G G";
		Scanner sc = new Scanner(input);

		map = new String[10][10];

		visited = new boolean[10][10];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = sc.next();
			}
		}

//		for(String[] a : map) {
//			System.out.println(Arrays.toString(a));
//		}

		bfs(8, 0);

		for (boolean[] a : visited) {
			for(boolean b : a) {
				System.out.print(b +"\t");
			}
			System.out.println();
		}

	}

	static class Pos {
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

	private static void bfs(int r, int c) {

		Queue<Pos> q = new LinkedList<>();
		visited[r][c] = true;
		q.add(new Pos(r, c));

		while (!q.isEmpty()) {

			Pos curr = q.poll();
			if (map[curr.r][curr.c].equals("T")) {
				System.out.println("Found target at: " + curr);
				continue; // Continue searching for other possible targets
			}

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				if (nr < 0 || nc < 0 || nr >= 10 || nc >= 10 || visited[nr][nc])
					continue;

				// Check if the position is a valid path (G or T)
				if (map[nr][nc].equals("G") || map[nr][nc].equals("T")) {
					visited[nr][nc] = true; // Mark as visited when adding to queue
					q.add(new Pos(nr, nc));
				}
			}

		}

	}

}
