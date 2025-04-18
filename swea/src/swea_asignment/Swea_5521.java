package swea_asignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_5521 {
	private static int N;
	static List<Integer>[] adj;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 
			
			N = Integer.parseInt(st.nextToken()); // 정점, N명
			int M = Integer.parseInt(st.nextToken()); // 간선, 친한 친구 관계 수 
			
			adj = new ArrayList[N+1];  //0은 버림
			for (int i = 0; i < adj.length; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}

			int cnt = bfs(1);
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}

	private static int bfs(int start) {
		int cnt = 0;
		int level = 0;
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];

		q.add(start);
		visited[start] = true;
		
		
		while(!q.isEmpty() && level<2) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int curr = q.poll();
				
				for(int b : adj[curr]) {
					if(!visited[b]) {
						visited[b] = true;
						q.add(b);
						cnt++;
					}
				}
			}
			level++;
			
//			if(level == 2) break;
		}
		
		return cnt;

	}

}
