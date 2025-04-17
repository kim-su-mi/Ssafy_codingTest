import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //색종이의 수
		
		
		
		
		int[][] map = new int[100][100];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //왼쪽에서 떨어진 위치
			int b = Integer.parseInt(st.nextToken()); //아래에서 떨어진 위치 
			for (int j = a; j < a+10; j++) {
				for (int j2 = 100-b-10; j2<100-b; j2++) {
					map[j][j2]++;
				}
			}
			
		}

		int result = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] != 0) result++;
			}
		}
		
		
		System.out.println(result);
		
	}

}
