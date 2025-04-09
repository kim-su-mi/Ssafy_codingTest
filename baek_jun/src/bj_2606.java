import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2606 {
	private static boolean[] visited;
	private static int V;
	private static int[][] adj;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		V = Integer.parseInt(br.readLine()); //정점의 개수 ,컴퓨터 수
		int E = Integer.parseInt(br.readLine()); // 간선의 수
		
		adj = new int[V+1][V+1];
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			adj[s][e] = 1;
			adj[e][s] = 1;
		}
		
		ans = 0;
		
		visited = new boolean[V+1];
		
		bfs(1);

		System.out.println(ans);
	}

	private static void bfs(int i) {
		visited[i] = true;
		
		for (int j = 1; j <=V ; j++) {
			if(adj[i][j]==1 && !visited[j]) {
				ans++;
				bfs(j);
			}
		}
	}

}
