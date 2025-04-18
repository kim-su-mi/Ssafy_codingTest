package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 그리디
 */
public class Swea_1970 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			//거스름돈이 서로 배수 관계라서 이렇게 풀이 가능
			int[] changes = {50000,10000,5000,1000,500,100,50,10};
			int[] result = new int[8]; // 동전이 몇개씩 필요한지 담을 배열
			
			int change = Integer.parseInt(br.readLine()); //거스름돈 
			
			for (int i = 0; i < changes.length; i++) {
				while(change>=changes[i]) {
					change-=changes[i];
					result[i]++;
				}
			}
			
			
			sb.append("#").append(testCase).append("\n");
			for (int i = 0; i < result.length; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
	}

}
