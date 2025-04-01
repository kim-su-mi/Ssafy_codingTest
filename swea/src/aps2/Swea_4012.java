package aps2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_4012 {
	static List<int[]> comb = new ArrayList<>(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //식재료 수
			int R = 2; // 재료 2개 뽑음
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 원래 2차원 배열에 담으려고 했으나 조합의 갯수를 몰라 배열 선언 불가
			// List에 [0,1], [0,2] , [0,3] ~~~ => [재료1,재료2]이런식으로 배열을 담아서 요리의 모든 경우를 넣음 
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j <N ; j++) {
					comb.add(new int[] {i,j});
				}
			}
			
//			for(int[] a : comb) {
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println(comb);
			// 리스트에서 하나씩 빼서 각 요리의 시너지를 구함
			int size = comb.size();
			int[] synergy = new int[size];
			for (int i = 0; i < size; i++) {
				int[] a = comb.remove(0);
				
//				System.out.println(Arrays.toString(a));
				synergy[i] = arr[a[0]][a[1]] + arr[a[1]][a[0]];
			}
			
//			System.out.println(Arrays.toString(synergy));
			
			// 시너지의 값들을 하나씩 비교해서 뺀 절댓값이 제일 작은 것 저장
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < synergy.length; i++) {
				for (int j = i+1; j < synergy.length; j++) {
					int value = Math.abs(synergy[i]-synergy[j]);
					System.out.println("test : "+testCase+", "+value);
					if(min>value) {
						min = value;
					}
				}
			}
			
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(min));
			
			
		}
		
		
		
	}

}
