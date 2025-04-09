import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_3040_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarfs = new int[9];
		int sum = 0;
		for (int i = 0; i < dwarfs.length; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
			sum+=dwarfs[i];
		}
		
		
		for (int i = 0; i < dwarfs.length-1; i++) {
			for (int j = 1; j < dwarfs.length; j++) {
				if(sum-dwarfs[i]-dwarfs[j] == 100) {
					for (int k = 0; k < dwarfs.length; k++) {
						if(dwarfs[k] == dwarfs[i] || dwarfs[k] == dwarfs[j]) continue;
						System.out.println(dwarfs[k]);
					}
				}
			}
		}
		
	}

}
