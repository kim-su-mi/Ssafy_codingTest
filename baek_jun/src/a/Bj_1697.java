package a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_1697 {
	private static int N;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //나의 위치
		K = Integer.parseInt(st.nextToken()); //동생의 위치
		
		int[] time = new int[100001]; //해당 인덱스 위치까지 가는데 걸리는 시간
		Arrays.fill(time, -1);

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		time[N] = 0;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			if(curr == K) {
				System.out.println(time[curr]);
				break;
			}
			
			int[] next = {curr-1, curr+1, curr*2};
			
			for (int i = 0; i < 3; i++) {
				if(next[i] >= 0 && next[i] <=100000 && time[next[i]]==-1) {
					q.add(next[i]);
					time[next[i]] = time[curr]+1;
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		System.out.println(sb.toString());
		
	}

	

}
