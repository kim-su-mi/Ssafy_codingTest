import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int mid = (int)Math.ceil(t / 2.0);
			
			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<String>();
			
			for (int i = 0; i < t; i++) {
				if(i<mid) {
					queue1.add(st.nextToken());
				}else {
					queue2.add(st.nextToken());
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < t; i++) {
				if(!(queue1.isEmpty())) {
					
					sb.append(queue1.remove()).append(" ");
				}
				if(!(queue2.isEmpty())) {
				sb.append(queue2.remove()).append(" ");
				}
			}

			StringBuilder sb2 = new StringBuilder();
			System.out.println(sb2.append("#").append(testCase).append(" ").append(sb));

		}
	}
}
