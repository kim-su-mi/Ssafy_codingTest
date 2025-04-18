package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_1251 {
	private static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //정점의 수, 사람 수 
			int M = Integer.parseInt(st.nextToken()); // 간선의 수, 사람의 관계 수 
			
			p = new int[N+1]; //0버림 
			for (int i = 0; i < p.length; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
//			System.out.println(Arrays.toString(p));
			
			Set<Integer> set = new HashSet<>();
			for (int i = 1; i < p.length; i++) {
				// 이어져 있지만 rank가 1이상인 애들 판단하기 위해
				set.add(findSet(i));
			}
			
			sb.append("#").append(testCase).append(" ").append(set.size()).append("\n");
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
