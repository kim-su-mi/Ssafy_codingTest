import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class swea_1218 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int result = 1;
			
			
			Map<Character, Character> map = new HashMap<>();
			map.put('}', '{');
			map.put(']', '[');
			map.put(')', '(');
			map.put('>', '<');
			
			
			Stack<Character> stack = new Stack<>();
			
			for (int i = 0; i < str.length(); i++) {
				// 여는 괄호는 무조건 담음
				if(map.containsValue(str.charAt(i))) {
//					System.out.println(str.charAt(i)+"담음");
					stack.push(str.charAt(i));
				//닫는 괄호는 
				// 빈 스택인지 확인->빈 스택이 아니면 스택에서 하나 꺼내서 
				// 닫는 괄호랑 일치하는지 확인해서 일치하면 넘김
				// 일치하지 않으면 result = 1
				}else{
					if(stack.isEmpty()) { 
						result = 0;
						break;
					}else {
						char c = stack.pop();
						if(map.get(str.charAt(i)) != c) { //str.charAt(i) : 닫는 괄호, get하면 닫는 괄호랑 쌍인 여는 괄호가 나옴
							result = 0;
							break;
						}
					}
				}
			}
			
			if(result ==1 && stack.isEmpty()) { //result는 1이고 스택에 아무것도 없어야 쌍이 맞는거
				result = 1;
			}else {
				result = 0;
			}
			
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(result));
			
			
		}
		
		
		
	}

}
