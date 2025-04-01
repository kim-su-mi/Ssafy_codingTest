import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test_5_sol {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M1 = Integer.parseInt(st.nextToken()); //행
			int M2 = Integer.parseInt(st.nextToken()); //열
			
			String a = br.readLine();
			st = new StringTokenizer(a);
		
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//무조건 M1이 M2보다 작게
			if(M1 > M2) {
				int temp = M1;
				M1 = M2;
				M2 = temp;
			}
			Arrays.sort(arr); // 오름차순 정렬
		
			int cost = 0;
			int index = N-1; //뒤쪽 인덱스부터 가져오기 내림차순으로 큰거부터 빼려고
			int floor;
			for ( floor = 0; floor <= M1; floor++, index-=2) {
				cost = arr[index]*floor;
				cost = arr[index-1]*floor;
			}
			for (int i = M1+1; i <= M2; i++,index--) {
				cost = arr[index]*floor;
			}
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(cost));
			
			
		}
		
		
		
	}

}
