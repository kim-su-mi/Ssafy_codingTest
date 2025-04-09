package test;

import java.util.Scanner;
import java.util.Stack;

public class Dfs연습 {
	private static int V;
	private static int[][] adj;





	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); //정점의 개수
		int E = sc.nextInt(); //간선의 개수
		
		adj = new int[V+1][V+1];
		
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			adj[s][e] = 1;
			adj[e][s] = 1;
		}
		
		dfs(1);
		
		
		
		
	}
	
	
	
	
	
	private static void dfs(int start) {
		boolean[] visited = new boolean[V+1];
//		visited[start] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(!visited[curr]) {
				System.out.print(curr+"->");
				visited[curr] = true;
				
				for (int i = 1; i <=V; i++) {
					if(!visited[i] && adj[curr][i] == 1) {
						stack.push(i);
					}
				}
			}
		}
		
		
	}





	static String input = "7 9\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "1 6\r\n"
			+ "2 4\r\n"
			+ "2 7\r\n"
			+ "3 4\r\n"
			+ "4 7\r\n"
			+ "5 6\r\n"
			+ "5 7";

}

