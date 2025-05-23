package aps2;

import java.util.Arrays;
import java.util.Scanner;

public class Swea_2112_2 {
	static int D, W, K; // 두께, 크기,통과기준
	static int[][] film; // 보호필름 저장
	static int ans; // 정답: 최소 투여횟수
	static int[] A, B;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			D = sc.nextInt(); // 3~13
			W = sc.nextInt(); // 1~20
			K = sc.nextInt();// 1~D

			film = new int[D][W];
			A = new int[W]; // 0으로 가득차있는 상태
			B = new int[W]; // 1로 가득차있는 상태
			Arrays.fill(A, 0);
			Arrays.fill(B, 1);

			// 필름 입력 완료
			for (int i = 0; i < D; i++) {
				for (int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			ans = K; // K번 쏘면 답을 구할수는 있어서 K로 초기화

			makeFilm(0, 0); // 행,약품 사용 횟수

			System.out.println("#" + testCase + " " + ans);

		}

	}

	// idx : 어떤 행에
	// cnt : 몇번 약품 사용했는지
	private static void makeFilm(int idx, int cnt) {
		// 종료
		// 탈출조건
		if (test()) {
			ans = Math.min(ans, cnt);
			return;
		}

		if (ans <= cnt)
			return; // 의미 없다.

		if (idx == D) {
			return;
		}

		// 재귀
		// 1. 주입 x
		makeFilm(idx + 1, cnt);

		int[] tmp = film[idx]; // 원복을 위한 주소 저장 

		// 2. 주입 A (idx해으이 값을 전부 0으로 바꿔라)
		film[idx] = A; //주소바꿈
		makeFilm(idx + 1, cnt + 1);

		// 2. 주입 B(idx행의 값을 전부 1으로 바꿔라)
		film[idx] = B;
		makeFilm(idx + 1, cnt + 1);

//		4. 원상복구
		film[idx] = tmp;

	}

	private static boolean test() {
		// 열을 고정시킨 채로 행을 확인, 1행부터 봐서 내 이전 값이 나랑 같은지 확인
		for (int c = 0; c < W; c++) {
			int cnt = 1; // 연속된 값
			boolean flag = false;
			for (int r = 1; r < D; r++) {
				if (film[r][c] == film[r - 1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}

				if (cnt >= K) {
					flag = true;
					break;
				}
			} // 해당 열은 통과함
			if (!flag) { // 해당 열은 기준을 통과하지 못함
				return false;
			}
		}

		return true;
	}

}
