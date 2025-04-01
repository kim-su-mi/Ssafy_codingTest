package im;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_21936 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String result = "";
			int N = Integer.parseInt(st.nextToken()); //문자열 길이
			int M = Integer.parseInt(st.nextToken()); //회문 길이
			int a = (int)(Math.ceil(M/2.0)); // 회문인지 판단할 때 비교해야하는 횟수
			
			boolean isSame = true;
			String str = br.readLine();
			
			for (int i = 0; i < N-M+1; i++) {
				int b = i+M-1;
					
					for (int j = 0; j <a ; j++) {
						if(str.charAt(i+j) != str.charAt(b)) {
							isSame = false;
							break;
						}else {
							isSame = true;
							result+=str.charAt(i+j);
						}
						b--;
					}
					if(isSame == true) {
						break;
					}
				
			}
			if(isSame == true) {
				for (int i = result.length()-2; i>=0; i--) {
					result+=result.charAt(i);
				}
				
				
			}else {
				result = "NONE";
			}
			
			
			System.out.println(sb.append("#").append(testCase).append(" ").append(result));
			
			
		}
		
		
		
	}

}
