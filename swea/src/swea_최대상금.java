import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea_최대상금 {
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            String num = sc.next();
            int K = sc.nextInt();

            // 한 자리 수이거나 교환 횟수가 0인 경우
            if(num.length() == 1 || K == 0) {
                System.out.println("#" + test_case + " " + num);
                continue;
            }

            max = 0;
            backtrack(num.toCharArray(), K, 0, 0);

            System.out.println("#" + test_case + " " + max);
        }
        sc.close();
    }

    static void backtrack(char[] numbers, int k, int depth, int startIdx) {
        // 현재 숫자 확인 및 최댓값 갱신
        int current = Integer.parseInt(new String(numbers));
        if(depth == k) {
            max = Math.max(max, current);
            return;
        }

        // 현재 숫자가 이미 최댓값 형태인지 확인
        boolean isMaxForm = true;
        for(int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] < numbers[i + 1]) {
                isMaxForm = false;
                break;
            }
        }

        // 남은 교환 횟수가 짝수이고 현재가 최댓값 형태라면 현재값 저장
        if(isMaxForm && (k - depth) % 2 == 0) {
            max = Math.max(max, current);
            return;
        }

        // 각 자리수별로 교환 시도
        for(int i = startIdx; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                // 교환
                char temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;

                backtrack(numbers, k, depth + 1, i);

                // 원상복구
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    }
}
