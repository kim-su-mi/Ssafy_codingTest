import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj_18352_3 {
    private static int N;
    private static int[] dist;
    private static List<Integer>[] adj;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); //정점, 도시의 개수
        int M = Integer.parseInt(st.nextToken()); //간선, 도로의 개수
        int K = Integer.parseInt(st.nextToken()); //거리의 정보, 최단 거리가 K인 값 구하기 
        int X = Integer.parseInt(st.nextToken()); //출발도시의 번호
        
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dijkstra(X);
        
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                found = true;
                sb.append(i).append('\n');
            }
        }
        
        if (!found) {
            System.out.println(-1);
        } else {
            System.out.print(sb.toString());
        }
    }
    
    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.index;
            int distance = current.distance;
            
            // 현재 노드가 이미 처리된 적이 있다면 무시
            if (dist[now] < distance) continue;
            
            for (int next : adj[now]) {
                int cost = distance + 1; // 모든 간선의 가중치는 1
                
                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < dist[next]) {
                    dist[next] = cost;
                    pq.offer(new Node(next, cost));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        int index;
        int distance;
        
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }
    }
}