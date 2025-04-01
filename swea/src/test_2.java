import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_2 {
	private static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		
//		
//		for(int t=1; t<=T; t++) {
//			
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int N = Integer.parseInt(st.nextToken());  //행
//			int M = Integer.parseInt(st.nextToken()); //열
//			int K = Integer.parseInt(st.nextToken()); //페인트 칠하는 횟수
//			
//			int[][] arr = new int[N][M];
//			
//			for (int i = 0; i < K; i++) { // 페인트 칠하는 횟수만큼 반복
//				st = new StringTokenizer(br.readLine());
//
//				int lefR = Integer.parseInt(st.nextToken()); //왼쪽 위 행의 좌표
//				int leftC = Integer.parseInt(st.nextToken());//왼쪽 위 열의 좌표
//				int rightR = Integer.parseInt(st.nextToken()); //오른 아래 행의 좌표
//				int rightC = Integer.parseInt(st.nextToken());//오른 아래 열의 좌표
//				
//				int color = Integer.parseInt(st.nextToken()); //칠할 페인트의 명도
//
//				// 내가 칠할 영역에 내가 칠할 색보다 높은 숫자가 있나 확인 
//				boolean isOk = true; 
//				
//				A:for(int r=lefR; r<=rightR; r++) { // 좌표위치까지 포함
//					for (int c = leftC; c <=rightC; c++) {
//						if(arr[r][c] > color) { // 영역에 하나라도 내가 칠할명도 보다 높은데 있으면 false로 바꾸고 탐색 종료
//							isOk = false;
//							break A;
//						}
//					}
//				}
//				//색칠
//				if(isOk) { 
//					for(int r=lefR; r<=rightR; r++) {
//						for (int c = leftC; c <= rightC; c++) {
//							arr[r][c] = color;
//						}
//					}
//				}
//
//			}
//			
//			int[] result = new int[11]; //색상별로 몇개 칠해졌나 담고 있는 배열 , 배열 인덱스 = 색상 명도
//			// 배열 돌면서 칠해진 색상 +1
//			for (int i = 0; i < arr.length; i++) {
//				for (int j = 0; j < arr.length; j++) {
//					++result[arr[i][j]];
//				}
//			}
//			
//			// 최댓값 구함
//			int max = 0;
//			for (int i = 0; i < result.length; i++) {
//				if(result[i] > max) {
//					max = result[i];
//				}
//			}
//			
//
//			StringBuilder sb = new StringBuilder();
//			System.out.println(sb.append("#").append(t).append(" ").append(max));
//			
//		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <=TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
		
			for (int i = 0; i <K; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int sr = Integer.parseInt(st.nextToken());
				int sc = Integer.parseInt(st.nextToken());
				int er = Integer.parseInt(st.nextToken());
				int ec = Integer.parseInt(st.nextToken());
				
				int gc = Integer.parseInt(st.nextToken());
				
				if(check(sr,sc,er,ec,gc)) {
					paint(sr,sc,er,ec,gc);
				}
			}
			int[] cnt = new int[11];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					cnt[map[i][j]]++;
				}
			}
			
			int maxCnt =0;
			for (int i = 0; i < cnt.length; i++) {
				if(cnt[i]>maxCnt) {
					maxCnt = cnt[i];
				}
			}
			
			sb.append("#").append(t).append(" ").append(maxCnt);
		}
		System.out.println(sb.toString());
		
	}//main

	private static void paint(int sr, int sc, int er, int ec, int gc) {
		for (int i = sr; i <=er; i++) {
			for (int j = sc; j <= ec; j++) {
				map[i][j] = gc;
			}
		}
		
	}
	/* map위의  sr,  sc,  er,  ec 영역에 색칠해도 되니?*/
	private static boolean check(int sr, int sc, int er, int ec, int gc) {
		for (int i = sr; i <=er; i++) {
			for (int j = sc; j <= ec; j++) {
				if(map[i][j]>gc) {
					return false;
				}
			}
		}
		
		return true;
		
		
	}

}
