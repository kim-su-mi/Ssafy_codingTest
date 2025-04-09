import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1260 {
	private static boolean[] visited;
	private static StringBuilder sb;
	private static int V;
	private static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int N = Integer.parseInt(st.nextToken()); // 시작 정점

		adj = new ArrayList[V + 1];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adj[s].add(e);
			adj[e].add(s);
		}
		
		// 간선 정보 입력 후 정렬
		for (int i = 1; i <= V; i++) {
		    Collections.sort(adj[i]);
		}
		
		sb = new StringBuilder();

		visited = new boolean[V + 1];
		dfs(N);
		sb.append("\n");
		visited = new boolean[V + 1];
		bfs(N);

		System.out.println(sb.toString());

	}

	private static void dfs(int start) {
		visited[start] = true;
		sb.append(start + " ");

		for (int a : adj[start]) {
			if (!visited[a]) {
				dfs(a);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		visited[start] = true;
		sb.append(start + " ");

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int a : adj[curr]) {
				if (!visited[a]) {
					q.add(a);
					visited[a] = true;
					sb.append(a + " ");
				}
			}
		}

	}

}
