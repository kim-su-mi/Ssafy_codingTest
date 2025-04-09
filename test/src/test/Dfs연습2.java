package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 * 교재 DFS 연습문제 
 */
public class Dfs연습2 {

	private static int V;
	private static List<Integer>[] adj;
	private static boolean[] visited;


	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt();
		int E = sc.nextInt();
		visited = new boolean[V+1];
		adj = new ArrayList[V+1];
		for (int i = 0; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			adj[s].add(e);
			adj[e].add(s);
		}
		
		
		dfs(1);
		visited = new boolean[V+1];
		System.out.println();
		dfsStack(1);
		
	}
	
	
	private static void dfsStack(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()) {
			int a = stack.pop();
			
			if(!visited[a]) {
				visited[a] = true;
				System.out.print(a+"->");
				
				for(int curr : adj[a]) {
					stack.push(curr);
				}
			}
		}
		
	}


	private static void dfs(int i) {
		visited[i] = true;
		System.out.print(i +"->");
		
		for(int a : adj[i]){
			if(!visited[a]) {
				dfs(a);
			}
		}
		
	}


	static String input = 
			"7 8\r\n"
			+ "1 2\r\n"
			+ "1 3\r\n"
			+ "2 4\r\n"
			+ "2 5\r\n"
			+ "3 7\r\n"
			+ "4 6\r\n"
			+ "5 6\r\n"
			+ "6 7";

}

