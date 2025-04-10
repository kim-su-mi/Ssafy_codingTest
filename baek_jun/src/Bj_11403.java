import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_11403 {
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); //정점의 개수
		
		int[][] adj = new int[N][N];

		
		
		
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				boolean flag = bfs(i,j);
				if(flag) {
					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
	
		
		System.out.println(sb.toString());
		
	}

	private static boolean bfs(int start, int end) {
//		boolean[] visited = new boolean[N];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		int i=0;
		boolean flag = false;
		while(i<=N || !q.isEmpty()) {
			i++;
			int curr = q.poll();
			if(curr == end) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
