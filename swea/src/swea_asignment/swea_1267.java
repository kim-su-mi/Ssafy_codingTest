package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1267 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken()); //정점의 개수
			int E = Integer.parseInt(st.nextToken()); //간선의 개수 
			
			st = new StringTokenizer(br.readLine());
			
			//인접 리스트
			List<Integer>[] list = new ArrayList[V+1]; //0은 버릴거임 
			for (int i = 0; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}
			//진입 차수 세는 배열
			int[] degree = new int[V+1];
			
			//간선 입력 & 진입 차수 업데이트 
			int size = st.countTokens()/2;
			for (int i = 0; i < size; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				list[from].add(to);
				degree[to]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			
			for (int i = 1; i < degree.length; i++) {
				if(degree[i] == 0) {
					q.add(i);
				}
			}
			
			sb.append("#").append(testCase).append(" ");
			
			while(!q.isEmpty()) {
				int curr = q.poll();
				
				sb.append(curr).append(" ");
				
				// 연결된 간선 -1
				for(int a : list[curr]) {
					degree[a]--;
					
					//만약 차수가 0이라면 큐에 넣음
					if(degree[a] == 0) {
						q.add(a);
					}
				}

			}
			
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
		
	}

}
