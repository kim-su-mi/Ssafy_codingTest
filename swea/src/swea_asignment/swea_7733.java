package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7733 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static boolean[][] visited;
	private static int N;
	private static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine()); //치즈 덩어리의 한변의 길이 
			int[][] cheese = new int[N][N]; 
			
			StringTokenizer st;
			int maxTaste = 0; //가장 맛있는 날 저장, 완탐할 횟수
			// 치즈 입력 받음
			for (int i = 0; i < cheese.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < cheese.length; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
					maxTaste = Math.max(maxTaste, cheese[i][j]); // 최대값 갱신
				}
			}
			
			// 1일째의 덩어리수 ,,,, maxTaste일째의 덩어리수 구함 
			int max = 1; // 덩어리의 최소 갑 = 1
		
			for (int k = 1; k <= maxTaste; k++) {
				
				visited = new boolean[N][N];
				// 당일 먹히는 치즈 위치 표시
				for (int i = 0; i < cheese.length; i++) {
					for (int j = 0; j < cheese.length; j++) {
						if( cheese[i][j] <= k) {
							visited[i][j] = true;// 먹힌 치즈는 방문한 것으로 표시
						}
					}
				}
				
				bfs(0,0);
				max = Math.max(max, cnt);	
				
			}
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(max));
			
		}
		

	}
	private static void bfs(int r, int c) {
		cnt = 0;
		// 남아있는 치즈의 시작 정점 찾기 
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				if (!visited[i][j]) {
				
					r=i; 
					c=j;
					
					Queue<int[]> q = new LinkedList<>();
					
					q.add(new int[] {r,c}); //시작 정점 넣음 
					
					visited[r][c] = true; 
					
					while(!q.isEmpty()) {
						int[] curr = q.poll(); //값을 하나 꺼내, curr[0] : 행, curr[1] : 열
						
						// 4방향 탐색
						for (int d = 0; d < 4; d++) {
							int nr = curr[0] + dr[d];
							int nc = curr[1] + dc[d];
							
							// 1. 범위 체크
							if(nr<0 || nc < 0 || nr>=N ||nc>=N) continue;
							
							if(visited[nr][nc]) continue;
							
							visited[nr][nc] = true;
							
							q.add(new int[] {nr,nc});
						}
						
					}
					cnt++;

					
				}
				
			}
		}
		
		
		
	}

}
