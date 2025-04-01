import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[][] arr = new char[5][];
		int maxLength = Integer.MIN_VALUE;
		
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			int num = str.length();
			maxLength = Math.max(num, maxLength);
			arr[i] = str.toCharArray();
			
		}
//		System.out.println(Arrays.deepToString(arr));
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < 5; j++) {
				if(i >= arr[j].length) continue;
				sb.append(arr[j][i]);
			}
		}
			
		System.out.println(sb);
	}

}
//ABCDE
//abcde
//01234
//FGHIJ
//fghij

//AABCDD
//afzz
//09121
//a8EWg6
//P5h3kx