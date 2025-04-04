package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1861 {
	private static int[][] map;
	private static int[] dr;
	private static int[] dc;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine()); // 배열의 크기 
			StringTokenizer st;
			map = new int[N][N];
			
			dr = new int[]{-1,1,0,0};
			dc = new int[]{0,0,-1,1};
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int depth = 0;
			int firstRoom = Integer.MAX_VALUE;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					int currDepth = bfs(i,j);
					
					if (currDepth > depth) {
						depth = currDepth;
			            firstRoom = map[i][j];
			        } else if (currDepth == depth && map[i][j] < firstRoom) {
			            firstRoom = map[i][j];
			        }
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(firstRoom).append(" ").append(depth).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
		
		
	}

	private static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		
		int currVal = map[i][j];
		
	
		int cnt = 1;
		
		a :while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			
			for (int d = 0; d <4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr<0 || nc < 0 || nr>=N ||nc>=N) continue;
				if(map[nr][nc] != currVal+1) continue;
				
				currVal = map[nr][nc];
				q.add(new int[] {nr,nc});
				cnt++;
				continue a;
			}
		}
		return cnt;
	}

}
