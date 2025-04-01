import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1213 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int testCase = 1; testCase <= T; testCase++) {
			br.readLine(); // 테스트 케이스 번호 버림

			String pattern = br.readLine();
			String text = br.readLine();

			int N = text.length();
			int M = pattern.length();
			int cnt = 0;

			for (int i = 0; i <= N - M; i++) {
				boolean isOk = true;
				for (int j = 0; j < M; j++) {
					if (text.charAt(i + j) != pattern.charAt(j)) {
						isOk = false;
						break;
					}
				}
				if (isOk) {
					++cnt;
				}
			}

			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(cnt));

		}

	}

}
