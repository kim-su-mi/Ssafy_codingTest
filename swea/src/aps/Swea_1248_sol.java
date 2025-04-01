package aps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1248_sol {
	
	private static int cnt;
	private static int[][] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int v = Integer.parseInt(st.nextToken()); //정점의 개수
			int e = Integer.parseInt(st.nextToken()); //간선의 개수
			int a = Integer.parseInt(st.nextToken()); //공통조상 찾을 정점 1
			int b = Integer.parseInt(st.nextToken()); // 공통조상 찾을 정점 2
			
			tree = new int[v+1][3]; // [0] : 왼자. [1]:오자, [2]:부모
			
			st = new StringTokenizer(br.readLine()," ");
			//v-1만큼 들어옴
			for (int i = 0; i <e ; i++) {
				int p =Integer.parseInt(st.nextToken()); //부모
				int c =Integer.parseInt(st.nextToken()); //자식
				
				// 문제에서 부모의 노드 번호가 작은 것부터 준다
				// 왼쪽 자식 부터 줌
				
				if(tree[p][0] == 0) { //왼쪽 자식이 아직 채워지지 않았다면
					tree[p][0] = c; //왼쪽 자식 저장
				}else {
					tree[p][1] = c;//오른쪽 자식 저장
				}
				
				// 부모 정보 저장
				tree[c][2] = p;
			}//트리에 입력
			
			// 공통 조상 찾기
			boolean[] visited = new boolean[v+1];
			
			while(true) { //a정점부터 류트까지 가면서 부모 정점에 표시
				visited[a] = true;
				if(a==1) {
					break;
				}
				a = tree[a][2]; 
			}
			
			while(!visited[b]) { //b정점부터 류트까지 가면서 위에서 남긴 표시 확인
				b = tree[b][2]; 
			}
			// 위에 while문 빠져나오면 b가 가장 가까운 공통 조상
			
			//b를 루트로하는 서브트리개수 세기
//			cnt = 0; //정점 개수 카운팅
//			preOrder(b);
//			sb.append("#").append(testCase).append(" ").append(b).append(" ").append(cnt).append("\n");
			
			sb.append("#").append(testCase).append(" ").append(b).append(" ").append(preOrder(b)).append("\n");

		}//테케
		System.out.println(sb.toString());
		
	}//main
	// 전위순회
//	public static void preOrder(int v) {
//		if(v==0) { //종료파트
//			
//			return;
//		}
//		//재귀파트 V->L->R
//		cnt++; //V
//		preOrder(tree[v][0]); //L
//		preOrder(tree[v][1]); //L
//		
//	}
	public static int preOrder(int v) {
		if(v==0) { //종료파트
			
			return 0;
		}
		//재귀파트 V->L->R
		return v+preOrder(tree[v][0])+preOrder(tree[v][1]);
		 
		
	}
	

}
