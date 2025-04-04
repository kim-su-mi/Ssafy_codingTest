package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1952_4 {
	private static int minFee;
	private static int[] use;
	static int depth = 0;
	private static int[] fee;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
//		System.out.println("T : "+T);
		for(int testCase=1; testCase<=T; testCase++) {
			
			// 요금 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			fee = new int[4];
			for (int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(fee));
			
			minFee = Integer.MAX_VALUE; // 최소 요금
			
			// 1년간 이용 계획 입력
			use = new int[12]; 
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(use));
			dfs(0,0);
			minFee = Math.min(fee[3], minFee);
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(minFee));

		}

	}
	//하루 -> 하루 -> 하루 -> 하루
	//하루 -> 하루 -> 하루 -> 달
	//하루 -> 하루 -> 하루 -> 3달
	private static void dfs(int cnt, int sum) {
		if(cnt>=12) {
			minFee = Math.min(minFee, sum);
			return;
		}
		
		if(use[cnt] == 0) {
			dfs(cnt+1, sum);
		}else {
			dfs(cnt+1, sum+(fee[0]*use[cnt]));
			dfs(cnt+1, sum+(fee[1]));
			dfs(cnt+3, sum+(fee[2]));
		}
		
	}

}

