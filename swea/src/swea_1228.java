import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class swea_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //원본 암호문의 길이
			StringTokenizer st = new StringTokenizer(br.readLine());//원본 암호문
			int M = Integer.parseInt(br.readLine()); //명령어의 개수 , I삽입해야하는 갯수
			StringTokenizer st2 = new StringTokenizer(br.readLine()); //명령어
			
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 0; i < M; i++) {
				st2.nextToken(); //I버림
				int idx = Integer.parseInt(st2.nextToken());
				int num = Integer.parseInt(st2.nextToken());
				for (int j = idx; j < idx+num; j++) {
					list.add(j, Integer.parseInt(st2.nextToken()));
				}
			}
			
			sb.append("#").append(testCase).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.remove()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
