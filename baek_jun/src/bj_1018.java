import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1018 {
	private static char[][] map;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		////////////////////////////////////////////////////
//		// 원하는 테스트 케이스 선택
//        String input = input1; // input1, input2, input3 중 선택
//        
//        // String을 InputStream으로 변환
//        InputStream is = new ByteArrayInputStream(input.getBytes());
//        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//////////////////////////////////////////////////////////////////////
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		
		// 현재 위치에서 8개씩 봄
		// 만약에 같은게 2번 연속 나오면 그 뒤부터 다시 8*8탐색
		// 현재 위치가 N-현재 위치가 M-현재위치가 8보다 작으면 넘김, or 탐색 범위를 여기로 한정 
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				int cnt = check(i,j);
				min = Math.min(cnt, min);
			}
		}
		
		System.out.println(min);
		
		
	}
	private static int check(int r, int c) {
		int cnt1 = 0;
		int cnt2 = 0;
		String wStart = "WBWBWBWB";
		String bStart = "BWBWBWBW";
			for (int i = 0; i < 8; i++) { //행
				for (int j = 0; j < 8; j++) {//열
					
					if(i%2 !=0) {
						if(map[r+i][c+j] != bStart.charAt(j)) cnt1++;
					}else {
						if(map[r+i][c+j] != wStart.charAt(j)) cnt1++;
					}
				}
			}
			for (int i = 0; i < 8; i++) { //행
				for (int j = 0; j < 8; j++) {//열
					
					if(i%2 !=0) {
						if(map[r+i][c+j] != wStart.charAt(j)) cnt2++;
					}else {
						if(map[r+i][c+j] != bStart.charAt(j)) cnt2++;
					}
				}
			}
		return Math.min(cnt1, cnt2);
		
	}
	static String input1 = "8 8\r\n"
			+ "WBWBWBWB\r\n"
			+ "BWBWBWBW\r\n"
			+ "WBWBWBWB\r\n"
			+ "BWBBBWBW\r\n"
			+ "WBWBWBWB\r\n"
			+ "BWBWBWBW\r\n"
			+ "WBWBWBWB\r\n"
			+ "BWBWBWBW";
	
	static String input2 = "10 13\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "BBBBBBBBWBWBW\r\n"
			+ "BBBBBBBBBWBWB\r\n"
			+ "WWWWWWWWWWBWB\r\n"
			+ "WWWWWWWWWWBWB\r\n"
			+ "";
	static String input3 = "9 23\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBB\r\n"
			+ "BBBBBBBBBBBBBBBBBBBBBBW";
	

}



