import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());
//		
//		
//		for(int t=1; t<=T; t++) {
//			
//			int N = Integer.parseInt(br.readLine()); //LED의 갯수
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			
//			
//			int[] arr = new int[N+1];
//			arr[0] = 0;
//			for(int i=1; i<arr.length; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
//			}
//
//			int cnt =0;
//			
//			for(int i=1; i<arr.length; i++) {
//				if(arr[i] == 1) {
//					++cnt;
//					
//				}
//			}
//			
//			
//			
//			
//			StringBuilder sb = new StringBuilder();
//			System.out.println(sb.append("#").append(t).append(" ").append(cnt));
//			
//		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=TC; t++) {
			int N = Integer.parseInt(br.readLine()); //LED의 갯수
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N+1];
			
			for (int i = 1; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			
			for (int i = 1; i < arr.length; i++) {
				if(arr[i] == 1) {
					for (int j = i; j < arr.length; j+=i) { //i의 배수방을 탐색
						
						arr[j] = 1-arr[j];
					}
					cnt++;
				}
			}
			
//			스위치 꺼->켜, 켜->꺼 led[i] = 1-led[i]; (1은 두 값 더한 것, 더한값에서 내 값 빼면 다른 값으로 바꿀 수 있음)
//			int cnt =0;
//			배열 순회 : 좌 -> 우
//			목표치 -> 0000으로 바꿈
//			x번째가 1이면 변경
//				반복 x배수 번째 변경
//			cnt++
			
			
		
			System.out.println(sb.append("#").append(t).append(" ").append(cnt));
			

		}
		
		
		
	}//main

}
