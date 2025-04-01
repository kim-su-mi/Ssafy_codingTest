package aps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Swea_2930 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine()); // 연산하는 수
			// 1이 들어오면 삽입
			// 2가 들어오면 삭제
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				if(Integer.parseInt(st.nextToken()) == 1) {
					pq.add(-Integer.parseInt(st.nextToken())); //우선순위큐는 최소힙 기준이라 최대힙으로 바꿔주려고 음수로 넣음
				}else {
					if(pq.size()<=0) {
						sb.append("-1").append(" ");
					}else {
						sb.append(-pq.remove()).append(" "); //음수로 넣어서 다시 출력시 -해줌
					}
				}
				
			}
			
			StringBuilder sb2 = new StringBuilder();
			System.out.println(sb2.append("#").append(testCase).append(" ").append(sb));
			
			
		}
		
		
		
	}

}
