import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int[][] m;
	private static int[][] memo;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  =new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=TC; testCase++) {
			N = Integer.parseInt(br.readLine());
			
			m = new int[N][N];
			memo = new int[N][N]; //길 저장
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					
					m[i][i] = Integer.parseInt(st.nextToken()); //0~500;
				}
			}
			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
//					r,c에서 출발해서 갈 수 있는 거리?
					max = Math.max(max, go(r,c));
					
				}
			}
			sb.append("#").append(testCase).append(" ").append(" ");
		}
		System.out.println(sb.toString());
		
	}
	/** r,c거리에서 출발해서 갈 수 있는 거리 */
	private static int go(int r, int c) {
		if(memo[r][c] > 0) {
			return memo[r][c];
		}
//		r,c사방 탐색 , 현재 나(m[r][c])보다 낮은 위치중 가장 낮은 값 찾아서 이동 => 한군데로만 갈 수 있음
		int min = m[r][c]; //나보다 작은 값으로 가야하니가 초기값을 내 위치로 둠
		int minR=-1; //최솟값의 행 좌표
		int minC=-1; //최솟값의 열 좌표
		
		for (int i = 0; i < dc.length; i++) {
			int nr = r+dr[i];
			int nc = r+dc[i];
			
			if(0<=nr && nr<N && 0<=nc && nc<N &&min > m[nr][nc]) {//배열 범위 내,최솟값 업데이트
				min = m[nr][nc];
				minR=nr;
				minC=nc;
			}
			
			if(minR==-1) { //나보다 낮은 곳이 없으면, 내가 마지막 칸
				return memo[r][c] = 1;
			}else { //나보다 낮은 곳이 있으면, 그쪽으로 이동
				return memo[r][c] = go(minR,minC)+1;
			}
		}
		
		
		return 0;
	
	}

}
