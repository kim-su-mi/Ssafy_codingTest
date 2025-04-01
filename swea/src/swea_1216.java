import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class swea_1216 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int testCase=0; testCase<10; testCase++) {
			int t = Integer.parseInt(br.readLine());
//			StringTokenizer st;
			
			
			char[][] arr = new char[100][100];
			
			for (int i = 0; i < arr.length; i++) {
				String str =  br.readLine();
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = str.charAt(j);
					
				}
			}
			
//			System.out.println(Arrays.deepToString(arr));
			
			int max = 0;
			
			// 가로에서 검사
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					
					int turn = 99;
					
					// 현 위치에서 한칸씩 줄여가면서 비교
					while(true) {
						StringBuilder sb = new StringBuilder();
						for(int a=j; a<turn; a++) {
							sb.append(arr[i][a]);
						}
						if(sb.length() < max) {
							break;
						}
						turn--;
						String origin = sb.toString();
						String rev = sb.reverse().toString();
						if(origin.equals(rev)) {
							max = Math.max(max, origin.length());
							break;
						}
					}

					
					
				}
			}
			
			//세로에서 검사
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {

					int turn = 99;
					
					// 현 위치에서 한칸씩 줄여가면서 비교
					while(true) {
						StringBuilder sb = new StringBuilder();
						for(int a=j; a<turn; a++) {
							sb.append(arr[a][i]);
						}
						if(sb.length() < max) {
							break;
						}
						turn--;
						String origin = sb.toString();
						String rev = sb.reverse().toString();
						if(origin.equals(rev)) {
							max = Math.max(max, origin.length());
							break;
						}
					}

					
					
				}
			}

			
			StringBuilder sb2 = new StringBuilder();
			System.out.println(sb2.append("#").append(t).append(" ").append(max));
			
			
		}
		
		
		
	}

}
