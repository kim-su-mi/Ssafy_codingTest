import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test_4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //딸기 케이크 크기
			
			int[][] arr =new int[N][N];
			
			int result = 1;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					sum+=arr[i][j];
				}
			}
			if(sum%4 != 0) {
				result = 0;
				sb.append("#").append(testCase).append(" ").append(result);
				break;
			}
			else {
			
				A:for (int i = 1; i < N; i++) {
					for (int j = 1; j < N; j++) {
						int leftUp = 0;
						int leftDown = 0;
						int rightUp = 0;
						int rightDown = 0;
						
						for (int k = 0; k <i ; k++) {
							for (int k2 = 0; k2 < j; k2++) {
								leftUp+=arr[k][k2];
							}
						}
						for (int k = i; k <N ; k++) {
							for (int k2 = 0; k2 < j; k2++) {
								leftDown+=arr[k][k2];
							}
						}
					
							
						for (int k = 0; k <i ; k++) {
							for (int k2 = j; k2 < N; k2++) {
								rightUp+=arr[k][k2];
							}
						}
						
						
						for (int k = i; k <N; k++) {
							for (int k2 = j; k2 < N; k2++) {
								rightDown+=arr[k][k2];
							}
						}
						
						if (leftUp == leftDown && leftDown == rightUp && rightUp == rightDown) {
							result = 1;
						    break A;
						}else {
							result = 0;
						}
					}
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
			
			
			
		}
		System.out.println(sb.toString());
		
		
		
	}

}
