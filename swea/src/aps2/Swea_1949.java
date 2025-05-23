package aps2;

import java.util.Scanner;
/**
 * 현재 높이를 들고 다니지 않을 떄
 */
public class Swea_1949 {
	static int N,K,maxH,ans; //N*N , K:최대 공사 가능 깊이, maxH:최대 높은 봉우리
	static int[][] mountain;
	static boolean[][] visited;
	
	// 4방탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			maxH = 0; //최대 봉우리의 높이가 1~20까지 라서 0을 초기화
			
			ans = 0; //등산로 길이
			
			mountain = new int[N][N];
			visited = new boolean[N][N];
			
			//1. 입력 & 최대 봉우리 찾기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mountain[i][j] = sc.nextInt();
					if(mountain[i][j] > maxH) {
						maxH = mountain[i][j];
					}
				}
			}
			// 2. 최대 봉우리 높이부터 등산로 조성을 시작하자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(mountain[i][j] == maxH) {
						// 공사 시작 
						work(i,j,1,false); //현재 좌표 값, 내가 dist(경로 길이), 공사할 수 있나?
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
//	r,c : 현재 좌표값, dist : 등산로 길이, flag:공사했는지 여부
	private static void work(int r, int c, int dist, boolean flag) {
		if(dist>ans) ans=dist; //갱신
		visited[r][c] = true; //경로에 포함
		
		//4방향 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			//범위를 벗어났느지 체크 + 방문햇니?체크 => 순서 중요!!!!visited[nr][nc]먼저 쓰면 ArrayIndexOutOfBoundsException바랭
			if(nr <0 || nr>=N ||nc<0||nc>=N || visited[nr][nc]) continue;
			
			//1. 다음 좌표가 내 현재 높이보가 작다면
			if(mountain[r][c] > mountain[nr][nc]) {
				work(nr,nc,dist+1,flag);
			//2. 다음 좌표가 현재 내 높이와 같거나 크다면
				// 2-1. 공사를 진행한 경우
				// 2-2. 공사를 진행하지 않은 경우
			}else if(!flag && mountain[r][c] > (mountain[nr][nc]-K)) {
				int tmp = mountain[nr][nc]; //공사하면서 원본 값 바꿈, 원복 위해 저장
				
				mountain[nr][nc] = mountain[r][c]-1;
				work(nr,nc,dist+1,true);
				// 원상복구
				mountain[nr][nc] = tmp;
			}
			
			
		}
		
		
		visited[r][c] = false; //걍로에서 뺌
		
	}

}
