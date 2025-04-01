import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1954 {
	static int[] dr = {0,1,0,-1}; //우 하 좌 상
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 값이 채워져있거나 끝에 도달하면 꺽어라
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=t; testCase++) {
			int N = Integer.parseInt(br.readLine()); //달팽이크기 1~10
			
			int[][] m = new int[N][N];
			
			int r = 0; //행
			int c = 0; //열
			
			int dir = 0; //우 하 좌 상
			
			int num = 1; //저장할 숫자
			int target = N*N;
			
			
			while(num <= target) { //현재 방향으로 전진, 꺽는 조건 : 배열의 범위를 벗어나거나 다음 칸에 값이 있으면 
				m[r][c] = num++;
				
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				
				if (nr>=0 && nr<N && nc>=0 && nc<N && m[nr][nc]==0) {  //갈 수 있는 경우
					r=nr;
					c=nc;
				}else { //갈 수 없음
					dir = (dir+1)%4; //dr,dc의 위치 값 넘어가면 다시 앞으로 가서 반복
					
//					dir++;
//					if(dir == 4) dir =0; //위처럼하는 나머지 연산이 시간 오래 걸림 , 빠르게 하려면 이렇게 해라
					
					// 방향 꺽음,꺽은 좌표의 위치
					r += dr[dir];
					c += dc[dir];
				}
			}
			
			sb.append("#").append(testCase).append("\n");
			for(int i=0; i<m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					sb.append(m[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());
	
	}
	

}
