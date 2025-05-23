import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj_1197 {
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int cost;
		public Edge(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}
		@Override
		public int compareTo(bj_1197.Edge o) {
			return this.cost - o.cost;
		}
		
	}

	private static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int V = Integer.parseInt(st.nextToken()); //정점
		int E = Integer.parseInt(st.nextToken()); // 간선
		
		List<Edge> list = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));

		}
		Collections.sort(list);
		
		p = new int[V+1];
		
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}
		
		int result = 0;
		int pick = 0;
		for (int i = 0; i < E; i++) {
//			int s = edges[i].s;
//			int e = edges[i].e;
			
			
			int px = findSet(list.get(i).a);
			int py = findSet(list.get(i).b);
			
			// 사이클 검사 
//			if(findSet(s) != findSet(e)) {
			if(px != py) {
				// 사이클이 없으면 합쳐 = 해당 간선을 뽑음
				union(px,py);
				pick++;
				result += list.get(i).cost;
			}
			
			if(pick == V-1) {
				break;
			}
			
		}
		
		System.out.println(result);
		
		
	}
	private static void union(int x, int y) {
		// rank를 고려하고 있진 않음
//		p[findSet(y)] = findSet(x);
		
		//위에서 무조건 대표만 내려보내서 이게 가능 
		p[y] = x;
	}

	private static int findSet(int x) {
		// 정석 코드 
//		if(x == p[x]) return x;
//		return findSet(p[x]);
		
		// 경로 압축
		if(x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

}
