import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_3040 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarfs = new int[9];
		
		for (int i = 0; i < dwarfs.length; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		
		List<Integer> list = null;
		
		A:for (int i = 0; i < (1<<9); i++) {
			int sum = 0;
			list = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				if((i&(1<<j)) != 0) {
					sum+=dwarfs[j];
					list.add(dwarfs[j]);
				}
				
			}
			if(sum==100&& list.size()==7) {
				break A;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
