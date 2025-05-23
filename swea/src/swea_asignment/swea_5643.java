package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5643 {
	static List<Integer>[] tallerList;
	static List<Integer>[] smallerList;
	private static int V;
	private static int E;
	private static int cnt;
	private static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			V = Integer.parseInt(br.readLine()); //학생들의 수 (정점)
			E = Integer.parseInt(br.readLine()); //학생들의 키 비교 횟수 (간선)
			
			tallerList = new ArrayList[V+1];
			smallerList = new ArrayList[V+1];
			for (int i = 0; i < tallerList.length; i++) {
				tallerList[i] = new ArrayList<>();
				smallerList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				tallerList[a].add(b);
				smallerList[b].add(a);
			}
			
//			for(List a : list) {
//				System.out.println(a);
//			}
			
			// 나랑 연결된 애들 중에 내 뒤에 있는 애들 세고 내 앞에 있는 애들 세서 이게 V이면 자기 순서를 알 수 있는 것
			int totalCnt = 0;
			for (int i = 1; i <= V; i++) {
				cnt = 1; //현재 나 셈 
				
				visited = new boolean[V+1];
				dfs(i,tallerList); //나보다 큰 애들 수 셈
				dfs(i,smallerList); //나보다 작은 애들 수 셈

				if(cnt == V) {
					totalCnt++;
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(totalCnt).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
		
		
	}
	 // DFS로 연결된 학생 수 계산
    private static void dfs(int start, List<Integer>[] graph) {
        visited[start] = true;
        
        for (int next : graph[start]) {
            if (!visited[next]) {
                cnt++;
                dfs(next, graph);
            }
        }
    }
}
