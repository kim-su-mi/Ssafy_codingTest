package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1238 {
	
	
	private static boolean[] visited;
	private static int finalMax;
	private static List<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //입력으로 들어오는 데이터의 길이 
			int start = Integer.parseInt(st.nextToken()); //시작 정점 
			
			st = new StringTokenizer(br.readLine());
			int E = st.countTokens()/2;
			list = new ArrayList[101];
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			
			while(st.hasMoreTokens()) {
				list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			visited = new boolean[101];
			finalMax = 0;
			bfs(start);
			
			sb.append("#").append(testCase).append(" ").append(finalMax).append("\n");
			
		}
		System.out.println(sb.toString());
		
		
		
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = true;

		while(!q.isEmpty()) {

			int size = q.size(); //현재 레벨의 노드 개수를 저장
			int levelMax = 0;
			
			for (int i = 0; i < size; i++) {
				int curr = q.poll();
				
				//현재 레벨의 최대값 갱신
				levelMax = Math.max(curr, levelMax);
				
				for(int w : list[curr]) {

					if(!visited[w]) {
						q.add(w);
						visited[w] = true;

					}
				}
			}
			// 현재 레벨의 최대값으로 finalMax 갱신
			finalMax = levelMax;

		}
		
	}

}
