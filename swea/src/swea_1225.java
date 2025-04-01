import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int testCase = 0; testCase < T; testCase++) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
//			System.out.println(queue);
			int num = 1;
			while (true) {
				// 첫 번째 숫자를 꺼내서 처리
				int current = queue.remove();

				// num만큼 감소시킨 새로운 값 계산
//				int newValue = current - num;
				current = current-num;
				++num;
				// 새로운 값이 0 이하면 0으로 설정하고 큐에 추가 후 종료
				if (current <= 0) {
					queue.add(0);
					break;
				}

				// 감소된 숫자를 큐의 뒤에 추가
				queue.add(current);
				if (num == 6) {
					num = 1;
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 8; i++) {
				
				sb.append(queue.remove()).append(" ");
			}
			StringBuilder sb2 = new StringBuilder();
			System.out.println(sb2.append("#").append(t).append(" ").append(sb));

		}

	}

}
