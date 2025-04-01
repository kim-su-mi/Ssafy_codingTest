package aps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1230 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //암호문의 개수
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//암호문 담기
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine()); //명령어의 개수
			st = new StringTokenizer(br.readLine());
			
			for (int k = 0; k <M; k++) {
				String order =  st.nextToken(); // 행할 명령어
				
				if(order.equals("I")) { //삽입 x번째 암호문 뒤어 y개의 암호문 삽입 s는 삽입할 암호문 들
					int idx = Integer.parseInt(st.nextToken());
					int insertNum = Integer.parseInt(st.nextToken());
					
					for (int i = 0; i < insertNum; i++) {
						list.add(idx++,Integer.parseInt(st.nextToken()));
					}
				}else if(order.equals("D")) { //삭제 x번째 암호문 뒤에 바로 y개의 암호문 삭제
					int idx = Integer.parseInt(st.nextToken());
					int removeNum = Integer.parseInt(st.nextToken());
					for (int i = 0; i < removeNum; i++) {
						list.remove(idx++);
					}
				}else { //추가 맨 뒤에 y개의 암호문 붙임, s는 붙일 암호문
					int addNum = Integer.parseInt(st.nextToken());
					for (int i = 0; i < addNum; i++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.remove(0)).append(" ");
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

}
