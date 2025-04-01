import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //카드의 개수
		int M = Integer.parseInt(st.nextToken()); //만들어야하는 수
		
		int[] card = new int[N];
		int minDiff = Integer.MAX_VALUE; //만들어야하는 수와 현재 3장의 카드의 차이
		// 배열에 담음
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		A : for (int i = 0; i < card.length; i++) {
			for (int j = i+1; j < card.length; j++) {
				for (int k = j+1; k < card.length; k++) {
					int sum = 0; //각 시도마다 합을 저장할 변수
					sum+=card[i]+card[j]+card[k];
					if((M-sum)<0) { //M을 넘지 않지만 가장 가까워야해서 큰 값은 제외
						continue;
					}else if ((M-sum) == 0) {
						minDiff = 0;
						break A;
					}else if (minDiff > (M-sum)) {
						minDiff = M-sum;
					}
				}
			}
		}
		System.out.println(M-minDiff);
	}

}
