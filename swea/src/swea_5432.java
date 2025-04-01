import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class swea_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			int result = 0;
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				// 여는 괄호일 때 
				//나오면 무조건 넣음
				if(ch == '(') {
					stack.push(ch);
				// 닫는 괄호 일때
				}else {
					if(str.charAt(i-1) == '(') { //레이저이면 스택에서 꺼내서 스택 사이즈만큼 잘린거니까 result에 더해줌
						stack.pop();
						result += stack.size();
					}else { //막대기가 끝나는 경우 스택에서 여는 괄호 하나 꺼내고 +1해줌
						stack.pop();
						result++;
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(result));
			
		}

	}

}
