import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int frequency1 = 1+N;
			int frequency2 = 1+M;

			StringBuilder sb = new StringBuilder();
			for(int i=Math.min(frequency1, frequency2); i<=Math.max(frequency1, frequency2); i++) {
				sb.append(i).append(" ");
			}
			
			StringBuilder sb2 = new StringBuilder();

			System.out.println(sb2.append("#").append(testCase).append(" ").append(sb));

		}

	}

}
