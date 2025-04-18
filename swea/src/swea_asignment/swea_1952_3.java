package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1952_3 {
	private static int minFee;
	private static int[] use;
	private static int day;
	private static int monthFee;
	private static int threeMonth;
	private static int year;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase=1; testCase<=T; testCase++) {
			
			// 요금 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			monthFee = Integer.parseInt(st.nextToken());
			threeMonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			
			// 1년간 이용 계획 입력
			use = new int[13]; 
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 12; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}
			
			minFee = year; // 최소 요금, 초기화를 1년치 금액으로 
			
			dfs(1,0); 
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(minFee));

		}

	}
	/** month : 체크할 달 
	 *  val : 이전 달까지 사용한 이용권 금액의합 
	 * */
	public static void dfs(int month,int val) {
		if(minFee <= val ) return; //가지치기
		
		//종료 조건
		if(month > 12) {
			// 최소값 업데이트 
			if(minFee > val) {
				minFee = val;
			}
			return;
		}
		
		//재귀 파트
		// 1일 이용권
//		dfs(month+1,val+use[month]*day);
		// 1달 이용권
//		dfs(month+1,val+monthFee);
		
		dfs(month+1,val+Math.min(use[month]*day, monthFee)); //1일치와 1달치 중 싼값을 선택
		// 3달 이용권 고려
		dfs(month+3, val+threeMonth);
		
	}


}

