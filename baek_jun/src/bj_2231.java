import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String M = br.readLine(); 
		int length = M.length();
		int n = Integer.parseInt(M);
		int sum;
		int result = 0;
		
		//M의 최소생성자는 M-(9*M의 자리수)보다 작을 수 없음 
		for (int i = n-(9* length); i < n; i++) {
			sum = 0;
			sum+=i;
			int a = i;

			while(a>0) {
				sum += a%10;
				a = a/10;
			}

			if(sum == n) {
				result = i;
				break;
			}
			
		}
		
		System.out.println(result);

	}

}
