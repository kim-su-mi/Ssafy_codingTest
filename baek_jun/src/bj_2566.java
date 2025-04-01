import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int max = Integer.MIN_VALUE;
		int row=-1;
		int col=-1;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int a = Integer.parseInt(st.nextToken());
				
				if(a == 100) {
					row = i+1;
					col = j+1;
					max = 100;
					break;
				}else if(a > max) {
					row = i+1;
					col = j+1;
					max = a;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(row+" "+col);
		
	}

}
