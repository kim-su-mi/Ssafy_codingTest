package im;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Swea_11315 {
	private static char[][] arr;
	private static int cnt;//o의 개수를 세는 변수
	private static int N;
	private static boolean isFive;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		c:for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine()); //오목 크기 N*N
			
			arr = new char[N][N];
			String result = "";
			sb.append("#").append(testCase).append(" ");
			//배열에 담음
			for (int i = 0; i < N; i++) {
				cnt = 0; //o의 개수를 세는 변수
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
				
			}
			
			isFive = false; // 초기화 추가
			
			A:for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j] != 'o') {
						continue;
					}
					isFive = horizon(i, j);
					if(isFive) {
						break A;
					}
					isFive = vertical(i, j);
					if(isFive) {
						break A;
					}
					isFive = leftDown(i, j);
					if(isFive) {
						break A;
					}
					isFive = rightDown(i,j);
					if(isFive) {
						break A;
					}
					
				}
			}
			if(!isFive) {
				sb.append("NO").append("\n");
			}else {
				sb.append("YES").append("\n");
			}
			
		}
		System.out.println(sb);
		
	}
	
	// 수평(가로) 방향 체크
	private static boolean horizon(int i, int j) {
		int cnt = 1;
		
		while(j + 1 < N) {
			if(arr[i][++j] == 'o') {
				cnt++;
			} else {
				break;
			}
		}
		
		if(cnt >= 5) { // 5개 이상이면 오목 성립
			return true;
		}
		return false;
	}
	
	// 오른쪽 아래 대각선 체크
	private static boolean rightDown(int i, int j) {
		int cnt = 1;
		
		while(i + 1 < N && j + 1 < N) {
			if(arr[++i][++j] == 'o') {
				cnt++;
			} else {
				break;
			}
		}
		
		if(cnt >= 5) { // 5개 이상이면 오목 성립
			return true;
		}
		return false;
	}
	
	// 왼쪽 아래 대각선 체크
	private static boolean leftDown(int i, int j) {
		int cnt = 1;
		
		while(i + 1 < N && j - 1 >= 0) {
			if(arr[++i][--j] == 'o') {
				cnt++;
			} else {
				break;
			}
		}
		
		if(cnt >= 5) { // 5개 이상이면 오목 성립
			return true;
		}
		return false;
	}
	
	// 수직(세로) 방향 체크
	private static boolean vertical(int i, int j) {
		int cnt = 1;
		
		while(i + 1 < N) {
			if(arr[++i][j] == 'o') {
				cnt++;
			} else {
				break;
			}
		}
		
		if(cnt >= 5) { // 5개 이상이면 오목 성립
			return true;
		}
		return false;
	}
}