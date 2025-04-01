package aps;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Swea_1232 {
	static class Node{
		String data;
		int left;
		int right;
		
		public Node(String data) {
			this.data = data;
			this.left = -1;
			this.left = -1;
		}
	}

	private static Node[] tree;
	private static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int testCase=1; testCase<=T; testCase++) {
			N = Integer.parseInt(br.readLine()); //정점의 개수
			tree = new Node[N+1];
		
			//트리 구성
			for (int i = 1; i <=N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int nodeNum =Integer.parseInt(st.nextToken());
				String nodeData = st.nextToken();
				
				tree[nodeNum] = new Node(nodeData);
				
				if(nodeData.equals("+") || nodeData.equals("-") ||nodeData.equals("*") ||nodeData.equals("/")) {
					tree[nodeNum].left = Integer.parseInt(st.nextToken());
                    tree[nodeNum].right = Integer.parseInt(st.nextToken());
				}
			}
//			
			//계산 결과 
			double result = calc(1);
			System.out.println("#"+testCase+" "+(int)result);
			
			
		}//테케
	}//main

	private static double calc(int nodeNum) {
		Node node = tree[nodeNum];
		
		//노드가 숫자인 경우
		if(!(node.data.equals("+") || node.data.equals("-")||node.data.equals("*")||node.data.equals("/"))) {
			return Double.parseDouble(node.data);
		}
		// 노드가 연산자인 경우
        double leftResult = calc(node.left);
        double rightResult = calc(node.right);
        
        switch(node.data) {
            case "+": return leftResult + rightResult;
            case "-": return leftResult - rightResult;
            case "*": return leftResult * rightResult;
            case "/": return leftResult / rightResult;
        }
        
        return 0; // 여기에 도달할 수 없지만 컴파일 에러를 방지하기 위해 추가
	}

	

}
