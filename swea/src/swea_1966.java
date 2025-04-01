import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //숫자
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//삽입정렬
			for (int i = 1; i < N; i++) { // 0번 인덱스는 이미 정렬됐다고 가정해서 1부터 시작
				int num = arr[i];
				int j;
				
				for (j = i-1; j >=0 && num<arr[j]; j--) {
					arr[j+1] = arr[j];
				}
				
				arr[j+1] = num;
				
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(testCase).append(" ");
			
			for (int i = 0; i < arr.length; i++) {
				sb.append(arr[i]).append(" ");
			}
			
			System.out.println(sb);
			
			
		}
		
		
		
	}

}
