import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_1018 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int t = scanner.nextInt();

		for (int tc = 0; tc < t; tc++) {

			// 입력 받기
			int N = scanner.nextInt();
			int[] numbers = new int[N];

			for (int i = 0; i < N; i++) {
				numbers[i] = scanner.nextInt();
			}

			int K = scanner.nextInt();

			// 부분집합의 합이 K가 되는지 확인
			boolean result = false;
			List<Integer> subset = new ArrayList<>();

			// 완전 탐색으로 모든 부분집합 확인
			for (int i = 1; i < (1 << N); i++) { // 공집합 제외 (1부터 시작)
				int sum = 0;
				List<Integer> currentSubset = new ArrayList<>();

				// i의 이진 표현에서 1인 비트 위치의 원소를 선택
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) > 0) {
						sum += numbers[j];
						currentSubset.add(numbers[j]);
					}
				}

				// 합이 K와 같은지 확인
				if (sum == K) {
					result = true;
					subset = currentSubset;
					break;
				}
			}

			// 결과 출력
			if (result) {
				System.out.println("YES");
				System.out.println(subset);
			} else {
				System.out.println("NO");
			}
		}

		scanner.close();
	}

}


//3
//6 
//3 34 4 12 5 2 
//9
//5 
//7 3 2 5 8 
//14
//5 
//1 2 3 4 5 
//20

