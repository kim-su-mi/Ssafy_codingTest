import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_18352 {
	private static int N;
	private static int[] dist;
	private static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점, 도시의 개수
		int M = Integer.parseInt(st.nextToken()); //간선, 도로의 개수
		int K = Integer.parseInt(st.nextToken()); //거리의 정보, 최단 거리가 K인 값 구하기 
		int X = Integer.parseInt(st.nextToken()); //출발도시의 번호
		
		adj = new ArrayList[N+1];
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		dist = new int[N+1];
		Arrays.fill(dist, 987654321);
		
		
		dijkstra(X);
		
		
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
//		System.out.println(Arrays.toString(dist));
		for (int i = 0; i < dist.length; i++) {
			if(dist[i] == K) {
				flag = true;
				sb.append(i).append("\n");
			}
		}
		if(!flag) sb.append(-1).append("\n");
		
//		
		System.out.println(sb.toString());
		
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		
		dist[start] = 0;
		
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			
			for (int j = 1; j <= N; j++) {
				if(!visited[j] && dist[j]<min) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break;
			
			visited[idx] = true;
			
			for(int a:adj[idx]) {
				int cost = dist[idx] + 1;
				
				if(!visited[a] && cost<dist[a]) {
					dist[a] = cost;
				}
			}
		}
		
		
	}

}
