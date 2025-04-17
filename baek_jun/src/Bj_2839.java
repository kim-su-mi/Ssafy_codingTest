import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //배달하는 설탕 무게

		int result = 0;

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= 1666; i++) {
			for (int j = 0; j <= 1000; j++) {
				if ((3*i) + (5*j) == N) {
					result = i+j;
					min = Math.min(min, result);
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

}
