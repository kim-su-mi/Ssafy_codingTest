package a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj_24479 {
	private static int[] visited;
	private static int N;
	private static List<Integer>[] list;
	private static int order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //정점의 수
		int M = Integer.parseInt(st.nextToken()); //간선의 수
		int R = Integer.parseInt(st.nextToken()); //시작 정점
		
		list = new ArrayList[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		for (int i = 0; i < list.length; i++) {
			Collections.sort(list[i]);
		}
		
		visited = new int[N+1];
		order = 1;
		dfs(R);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int curr) {
		visited[curr] = order++;
		
		for(int next : list[curr]) {
			if(visited[next] == 0) {
				dfs(next);
			}
		}
		
	}

}
