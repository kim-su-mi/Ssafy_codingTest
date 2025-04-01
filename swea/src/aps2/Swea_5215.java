package aps2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_5215 {
	private static int[] star;
	private static int[] caloArr;
	private static int N;
	private static int calo;
	private static boolean[] isCheck;
	private static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			calo = Integer.parseInt(st.nextToken()); // 제한 칼로리
			max = 0;
			
			star = new int[N]; // 평점
			caloArr = new int[N]; //칼로리
			
			isCheck = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				star[i] = Integer.parseInt(st.nextToken());
				caloArr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			powerSet(0);

			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(max));

		}

	}

	private static void powerSet(int idx) {

		int score = 0;
		int calSum = 0; 
		//정지
		if(idx == N) {
			for (int i = 0; i < N; i++) {
				if(isCheck[i]) {
					score += star[i];
					calSum += caloArr[i];
					if(calSum<=calo && score>max) {
						max = score;
					}
				}
			}
			return;
		}
		
		//재귀
		isCheck[idx] = false;
		powerSet(idx+1);
		
		isCheck[idx] = true;
		powerSet(idx+1);
		
	}

}
