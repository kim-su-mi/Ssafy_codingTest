import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class test_5 {
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
		
			int[] weight = new int[N];
			
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(weight);
			int[] desc =new int[N+1];
//			System.out.println(Arrays.toString(weight));
			
			for(int i=weight.length-1,j=1; i>=0; i--,j++) {
				desc[j] = weight[i];
//				System.out.println(desc[j]+","+weight[i]);
			}
//			Integer[] arr = new Integer[N];
//			Arrays.sort(arr, Collections.reverseOrder()); // 오름차순 정렬
			
//			System.out.println(Arrays.toString(desc));
			
			int sum = 0;
			
			
			int larger=Math.max(M1, M2);
			int smaller = (M1+M2)-larger;
			
			System.out.println(larger +"," + smaller);
			
			for (int i = 0,j=1; j<=smaller; i++,j++) {
				i++;
				sum+=desc[i]*j;
//				System.out.println("smaller");
			}
			for(int i=1,j=1; j<=larger; i++,j++) {
				if(i<=(2*smaller)) {
					i++;					
				}
				sum+=desc[i]*j;
//				System.out.print(" "+i);
			}
			
			
			// 둘 중 더 작은 값만큼 퐁당퐁당 뽑음
			// 그 뒤로는 쭉 뽑음
		
			
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(sum));
			
			
		}
		
		
		
	}

}
