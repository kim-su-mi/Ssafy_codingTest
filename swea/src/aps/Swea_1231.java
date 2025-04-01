package aps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_1231 {
	private static int N;
	private static String[] tree;
	private static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb2 = new StringBuilder();
		int T = 10;
		
		for(int testCase=1; testCase<=T; testCase++) {
			sb = new StringBuilder();
			N = Integer.parseInt(br.readLine()); //정점의 수
			
		    tree = new String[N+1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				tree[i] = st.nextToken();
			}
			
			inOrder(1);
			
			sb2.append("#").append(testCase).append(" ").append(sb.toString()).append("\n");
			
		}
		System.out.println(sb2.toString());
		
		
	}

	private static void inOrder(int i) {
		if(i<=N) {
			inOrder(2*i);
			if(!(tree[i].equals(null))) {
				sb.append(tree[i]);
			}
			inOrder(2*i+1);
		}
		
	}

}
