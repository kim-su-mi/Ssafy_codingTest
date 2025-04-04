package swea_asignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_14510 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc<= T; tc++) {
			int N = Integer.parseInt(br.readLine()); //나무의 개수
			int[] tree = new int[N];
	
			int maxHeight = Integer.MIN_VALUE;
			// 배열에 나무 담고 최대 높이 구함 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, tree[i]);
			}
			
			int oddCount = 0; //홀수 날짜의 갯수
			int evenCount = 0; //짝수 날짜의 갯수
			for(int i = 0; i < N; i++) {
				tree[i] = maxHeight - tree[i];
				
				oddCount += tree[i] % 2;
				evenCount += tree[i] / 2;
			}
			
			int result = oddCount + evenCount;
			if(oddCount < evenCount) { //짝수 일자는 홀수 일자로 압축할 수 있음
				int gap = (evenCount - oddCount) * 2; //쉬는 날을 포함한 짝수 날짜의 수 
				int remain = (gap / 3) * 2; //짝수 날짜를 홀수 날짜로 압축한다.
				
				if(gap % 3 == 2) { //압축하고 남은 나머지가 짝수 날짜라면
					remain += 2; //홀수 날짜도 함께 쉰다. (∅ + 2)
				} else if (gap % 3 == 1) remain += 1; //그렇지 않으면 홀수 날짜만 더한다.
				
				result = (oddCount * 2) + remain;
			} else if (oddCount - evenCount > 1){ //홀수가 더 많을 경우 : 1 ∅ 1 ∅ 1 ... => ∅의 개수를 더한다.
				result += (oddCount - evenCount - 1);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.print(sb);
		
	}

}
