import java.io.IOException;
import java.util.Scanner;

public class swea_1217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = 10;
		Scanner sc = new Scanner(System.in);
		
		for(int testCase=1; testCase<=T; testCase++) {
			sc.nextInt(); //testCase번호 버리기
			
			
			int num = sc.nextInt();
			int N = sc.nextInt();
			
			System.out.println("#"+testCase+" "+(pow(N,num)));

		}
	}
	public static int pow(int N,int num) {
		if(N<=0) {
			return 1;
		}
		return num*pow(N-1,num);
	}

}
