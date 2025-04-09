import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mushroom = new int[10];
		
		for (int i = 0; i < 10; i++) {
			mushroom[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		int idx = 0;
		
		for (int i = 0; i < mushroom.length; i++) {
			ans+=mushroom[i];
			if(ans>=100) {
				idx = i;
				break;
			}
		}
		
		if(Math.abs(ans-100)>Math.abs(ans-100-mushroom[idx])) {
			ans = ans-mushroom[idx];
		}
		
		System.out.println(ans);
	}

}
