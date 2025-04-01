
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2805 {

	public static void main(String[] args) throws NumberFormatException, IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        
//        for(int testCase=1; testCase<=T; testCase++) {
//            int N = Integer.parseInt(br.readLine()); // 농장의 크기 N*N
//            int mid = N/2; // 중간 행 인덱스
//            int sum = 0; // 총 수확량
//            
//            for (int i = 0; i < N; i++) {
//                String str = br.readLine();
//                Deque<Integer> deque = new ArrayDeque<>();
//                
//                // 현재 행의 모든 값을 덱에 추가
//                for (int j = 0; j < N; j++) {
//                    deque.add(str.charAt(j) - '0');
//                }
//                
//                // 현재 행에서 수확하지 않을 부분 개수 계산
//                int skipCount = Math.abs(i - mid);
//                
//                // 수확하지 않을 부분을 덱에서 제거
//                for (int k = 0; k < skipCount; k++) {
//                    deque.removeFirst(); // 왼쪽에서 제거
//                    deque.removeLast();  // 오른쪽에서 제거
//                }
//                
//                // 남은 요소들(수확할 부분)의 합을 계산
//                while (!deque.isEmpty()) {
//                    sum += deque.remove();
//                }
//            }
//            
//            StringBuilder sb = new StringBuilder();
//            System.out.println(sb.append("#").append(testCase).append(" ").append(sum));
//	}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 농장의 크기 N, 1 <= N <= 49, 홀수
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				int x = Math.abs(N / 2 - i); // i행에서 합산을 시작할 열좌표
				for (int j = x; j < N - x; j++) { // 마름모 영역
					sum += s.charAt(j) - '0';
				}
			}
			sb.append("#").append(testCase).append(" ").append(sum).append("\n");
		} // end of for testCase
		System.out.print(sb);

	}
}