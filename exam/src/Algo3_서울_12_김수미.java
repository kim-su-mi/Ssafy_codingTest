import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo3_서울_12_김수미 { // start class
	private static int V; // 간선
	static List<Integer>[] list;// list배열

	public static void main(String[] args) throws NumberFormatException, IOException { // main start
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// 입력
		int T = Integer.parseInt(br.readLine()); // testCase개수
		StringBuilder sb; // 출력을 위한 변수
		for (int tc = 1; tc <= T; tc++) { // testCase를 위한 for문
			StringTokenizer st = new StringTokenizer(br.readLine()); // 입력
			V = Integer.parseInt(st.nextToken()); // 노드의 수
			int E = Integer.parseInt(st.nextToken()); // 간선의 수
			int P = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			for (int i = 0; i <= V; i++) {
				list[i] = new ArrayList<>();
			} // end for
			for (int i = 0; i < E; i++) {
				st = st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list[s].add(e);
				list[e].add(s);
			} // end for
			int reusult = bfs(P);
			System.out.println("#" + tc + " " + (reusult + 2));
		} // end testCase
	}// end main

	private static int bfs(int start) {
		boolean[] visited = new boolean[V + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int a = q.poll();
			int size = list[a].size();
			for (int i = 0; i < size; i++) {
				cnt = 0;
				if (!visited[list[a].get(i)]) {
					visited[list[a].get(i)] = true;
					q.add(list[a].get(i));
					++cnt;
				}
			}
		}
		return cnt;
	}
}
