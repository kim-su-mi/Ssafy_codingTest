import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			
			int result = -1;
			
			StringBuilder sb = new StringBuilder();
			
			String original = br.readLine();
			sb.append(original);
			String revereStr = sb.reverse().toString();
			
			if(original.equals(revereStr)) {
//				System.out.println(original+","+reverse);
				result = 1;
			}else {
				result =0;
			}
			
			
			StringBuilder sb2 = new StringBuilder();
			System.out.println(sb2.append("#").append(testCase).append(" ").append(result));
			
			
		}
		
		
		
	}

}
