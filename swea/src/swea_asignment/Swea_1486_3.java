package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1486_3 {
	private static int[] heights;
	private static int B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //점원 수
			B = Integer.parseInt(st.nextToken()); //선반 높이
			
			heights = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int minDiff = finMinDiff(0,0);
			
			
			sb.append("#").append(testCase).append(" ").append(minDiff).append("\n");
			
			
		}
		System.out.println(sb.toString());
		
		
		
	}

	private static int finMinDiff(int idx, int sum) {
		if (idx == heights.length) {
			//선반 높이 이상인 경우만 고려
			if(sum >= B) {
				return sum-B;
			}else {
				return Integer.MAX_VALUE;
			}
		}
		//현재 점원 포함
		int include = finMinDiff(idx+1, sum+heights[idx]);
		//현재 점원 포함 x
		int exclude = finMinDiff(idx+1, sum);
		
		return Math.min(include, exclude);
	}

}
