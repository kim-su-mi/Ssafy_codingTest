import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class swea_1209 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = 10;
//		
//		for(int testCase=0; testCase<T; testCase++) {
//			int t = Integer.parseInt(br.readLine());
//			
//			int[][] arr = new int[100][100];
//			
//			
//			int sum = 0;
//			int max = -1;
//			// 배열에 담으면서 행의 합 중 제일 큰 값 계산
//			for(int i=0; i<100; i++) {
//				StringTokenizer st = new StringTokenizer(br.readLine());
//				sum=0;
//				for(int j=0; j<100; j++) {
//					arr[i][j] = Integer.parseInt(st.nextToken());
//					sum += arr[i][j];
//				}
//				if(sum>max) {
//					max=sum;
//				}
//			}
//			
//			
//			// 각 열의 합
//			for(int i=0; i<100; i++) {
//				sum=0;
//				for(int j=0; j<100; j++) {
//					sum+=arr[j][i];
//				}
//				if(sum>max) {
//					max=sum;
//				}
//			}
//			
//			//오른 대각선 아래
//			sum=0;
//			for(int i=0; i<100; i++) {
//				sum+=arr[i][i];
//			}
//			if(sum>max) {
//				max=sum;
//			}
//			
//			sum=0;
//			for(int i=0,j=100; j==0; i++,j--) {
//				sum+=arr[i][j];
//			}
//			if(sum>max) {
//				max=sum;
//			}
//			
//			
//			StringBuilder sb = new StringBuilder();
//			System.out.println(sb.append("#").append(t).append(" ").append(max));
//			
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = 10;
        for(int t = 1; t <= T; t++) {
            int trash = Integer.parseInt(br.readLine());
            int i_memo[] = new int[100];
            int j_memo[] = new int[100];
            int left_cross = 0;
            int right_cross = 0;
            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j < 100; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    i_memo[i] += temp;
                    j_memo[j] += temp;
                    if(i==j) right_cross += temp;
                    if(i==99-j) left_cross += temp;
                }
            }
            int ij_max = 0;
            for(int i = 0; i < 100; i++) {
                int temp = i_memo[i]>j_memo[i]?i_memo[i]:j_memo[i];
                ij_max = ij_max > temp?ij_max:temp;
            }
            int cross_max = right_cross>left_cross?right_cross:left_cross;
            int max = ij_max>cross_max?ij_max:cross_max;
            bw.write("#"+t+" "+max + "\n");
        }
        bw.flush();
		
		
	}

}
