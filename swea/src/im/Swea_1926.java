package im;

import java.util.Scanner;

public class Swea_1926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			int num = i;
			int cnt = 0;
				while(num !=0) {
					if(num%10 == 3|| num%10==6|| num%10==9) {
						cnt++;
						
					}
					num = num/10;
				}
				
				if(cnt == 0) {
					sb.append(i).append(" ");
					
				}else {
					for (int j = 0; j < cnt; j++) {
						sb.append("-");
					}
					sb.append(" ");
					
				}
		}
		
		System.out.println(sb);
	}

}
