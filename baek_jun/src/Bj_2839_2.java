import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_2839_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); //배달하는 설탕 무게

		int result = solve(N);

		System.out.println(result);
	}

	private static int solve(int N) {
		int fiveCnt = N/5;
		
		while(fiveCnt>=0) {
			int remain = N-(5*fiveCnt);
			
			if (remain %3 ==0) {
				int threeCnt = remain/3;
				return fiveCnt+ threeCnt;
			}
			fiveCnt--;
		}
		return -1; 
	}

}
