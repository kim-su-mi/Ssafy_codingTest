package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2105 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //배열의 크기 
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[][] map = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			
			//우하, 좌하, 좌상, 우상 
			int[] dr = {1,1,-1,-1};
			int[] dc = {1,-1,-1,1};
			
			int cnt = 0;
			
			// 배열에 담음
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0,1);
			
			//그만두는 조건
			// 같은 숫자를 만나면, map에 담아서 있는지 확인?
			// 범위 벗어나면 
			// 이미 방문한 곳이면 
			
			
			// 탈출 조건 : 원래 자리로 돌아오면
			// 
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(" "));
			
			
		}
		
		
		
	}

	private static void dfs(int r, int c) {
//		if(r == nr && c == nc) {
//			
//		}
		
		
		
		
		
	}

}
