package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_3289 {
	private static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 집합의 개수
			int M = Integer.parseInt(st.nextToken()); // 연산의 개수
			
			p = new int[N+1]; //0은 버림 
			
			// make-set 본인이 대표가 되도록 
			for (int i = 0; i <= N; i++) {
				p[i] = i;
			}

//			System.out.println(Arrays.toString(p));
			
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				// union할지 find-set할지 결정 
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				// 합집합 
				if (a == 0) {
					union(b,c);
				// 같은 집합인지 비교 
				}else {
					if(findSet(b) == findSet(c)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
					
				}
				
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString());

		
	}

	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
		
	}

	private static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

}

