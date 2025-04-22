package a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_24444 {
	private static int[] visited;
	private static int N;
	private static List<Integer>[] list;

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
		
		visited = new int[N+1];
		
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
		
		
		bfs(R);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}

	private static void bfs(int r) {
		int order = 1;
		visited[r] = order;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(r);
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			
			for (int i = 0; i < list[curr].size(); i++) {
				int a = list[curr].get(i);
				if(visited[a]== 0) {
					++order;
					visited[a] = order;
					q.add(a);
				}
			}
		}
		
		
	}

}
