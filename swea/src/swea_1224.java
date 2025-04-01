import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class swea_1224 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb = new StringBuilder();
			int length = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			Map<Character,Integer> map = new HashMap<>();
			map.put('(', 0);
			map.put('+', 1);
			map.put('-', 1);
			map.put('*', 2);
			map.put('/', 2);
			
			Stack<Character> stack = new Stack<>();
//			중위 표현 -> 후위표현
//			1. 피연산자(숫자)면 무조건 출력
//			2. ( 여는 괄호는 무조건 넣음
//			3. 닫는 괄호 만나면 여는 괄호 만날 때까지 연산자 다 꺼냄
//			4. 처음에 스택이 비어있으면 무조건 넣음
//			5. 스택에 있는게 나보다 높거나 같은 연산자면 pop 내거 push
//			6. 스택에 있는게 나보다 낮으면 그냥 바로 push
//			7. 스택이 비어있지 않으면 있는거 다 pop
			for (int i = 0; i < length; i++) {
				char ch = str.charAt(i);
				if(ch>='0' && ch<='9') {
					sb.append(ch);
				}else if(ch == '('){
					stack.push(ch);
				}else if(ch == ')') {
					while(stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.pop(); //여는 괄호 버림
				}else {
					// 연산자 우선순위에 따라 처리
					if(stack.isEmpty()) {
						stack.push(ch);
					}else {
						// 연산자 우선순위에 따라 처리
					    while(!stack.isEmpty() && map.get(stack.peek()) >= map.get(ch)) {
					        sb.append(stack.pop());
					    }
					    stack.push(ch);
					}// 연산자 처리 else문
				
				}//else문
				
			}// str도는 for문
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			
//			sb.append("#").append(testCase).append(" ").append(" ");
			
			// 후위 표현식 계산
//			1. 숫자면 무조건 넣음
//			2. 연산자 만나면 연산해서 다시 push A->B->C 순서로 들어잇으면 C,B꺼내와서 B+C순서로 계산
//			3. 수식이 끝나면 마지막 스택의 값 출력
			Stack<Integer> calc = new Stack<>();
			
			for (int i = 0; i < sb.length(); i++) {
				char ch = sb.charAt(i);
				if(ch >= '0' && ch<='9') {
					calc.push(ch-'0'); //char를 정수로 변환
				}else {
					int B = calc.pop();
					int A = calc.pop();
					
					switch (ch) {
					case '+': 
						calc.push(A+B);
						break;
					case '*': 
						calc.push(A*B);
						break;
					case '-': 
						calc.push(A-B);
						break;
					case '/': 
						calc.push(A/B);
						break;
					}// 스위치문
					
					
				}//if문
				
			}//계산 for문
			sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(calc.pop()));
			
		}// testCase
		
		
	}// main 

}
