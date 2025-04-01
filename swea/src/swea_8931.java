import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_8931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			int k = Integer.parseInt(br.readLine());

			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < k; i++) {
				int input =Integer.parseInt( br.readLine());
				
				if(input == 0) {
					stack.pop();
				}else {
					stack.push(input);
				}
			}
			
			int sum = 0;
			int size = stack.size();
			for(int i=0; i<size; i++) {
				int a = stack.pop();
				sum+=a;
			}
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(sum));
			
			
		}
		
		
		
	}

}