package aps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea_1248 {
	private static int[][] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int v = Integer.parseInt(st.nextToken()); //정점의 개수
			int e = Integer.parseInt(st.nextToken()); //간선의 개수
			int f1 = Integer.parseInt(st.nextToken()); //공통조상 찾을 정점 1
			int f2 = Integer.parseInt(st.nextToken()); // 공통조상 찾을 정점 2
			
			// 트리 만듬
			tree = new int[v+1][3]; //0번 인덱스 안쓰려고
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < v-1; i++) { // v-1 : 간선 개수
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(tree[p][0] == 0) {
					tree[p][0] = c;
				}else {
					tree[p][1] = c;
				}
				
				tree[c][2] = p;
			}
			
			
			// 비교할 정점들의 조상을 list로 담음
			List<Integer> p1 = new ArrayList<>();
			List<Integer> p2 = new ArrayList<>();
			while(tree[f1][2] != 0) {
					p1.add(tree[f1][2]);
					f1 = tree[f1][2];
		
			}
			while(tree[f2][2] != 0) {
				p2.add(tree[f2][2]);
				f2 = tree[f2][2];
				
			}
			
			// 리스트의 뒷부분은 무조건 공통 조상, 각 리스트 뒤부터 탐색하면서 달라지는 순간 그 앞에 있는데 제일 가까운 공통 조상 
			int parent = 1;
			int a = p1.size()-1;
			int b = p2.size()-1;
			while(true) {
			
				if(!(p1.get(a).equals(p2.get(b)))) { /**Integer라서 객체 비교 해야함!!!!!! ==비교하면 1만 나옴ㅠㅠ*/
					parent = p1.get(a+1);
					break ;
				}else if(a == 0 || b==0) { //조상이 1만 있을 경우처리, 아래와 같은 경우 이게 if문으로 위로 올라가면 b=0조건에 걸려소 break, 그래서 공통 부모가 1이 나옴
										   //[19, 42, 8, 48, 15, 45, 21, 1]
										   //[41, 21, 1]
					break;
				}
				a--;
				b--;
			}
			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(testCase).append(" ").append(parent).append(" ").append(count(parent)));
			
			
		}//테케
	}//main
	
	public static int count(int v) {
		if (v == 0) return 0;
	    
	    // 현재 노드 카운트
	    int count = 1;
	    
	    // 왼쪽 자식과 오른쪽 자식이 존재하면 재귀적으로 탐색
	    if (tree[v][0] != 0) {
	        count += count(tree[v][0]); //왼쪽 자식이 있다면, 왼쪽 자식을 루트로 하는 서브트리의 모든 노드를 재귀적으로 카운트
	    }
	    if (tree[v][1] != 0) {
	        count += count(tree[v][1]); //오른쪽 자식이 있다면, 오른쪽 자식을 루트로 하는 서브트리의 모든 노드를 재귀적으로 카운트
	    }
	    
	    return count;
		
	}

}
