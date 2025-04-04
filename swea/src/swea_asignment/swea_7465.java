package swea_asignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea_7465 {
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		double cost;

		public Edge(int a, int b, double cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", cost=" + cost + "]";
		}

		// 오름 차순 정렬
		@Override
//		public int compareTo(Edge o) {
//			if (this.cost < o.cost)
//				return -1;
//			else if (this.cost > o.cost)
//				return 1;
//			else
//				return 0;
//		}
		public int compareTo(Edge o) {
		    return Double.compare(this.cost, o.cost);
		}

	}

	private static int[] p;
	private static double tax;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 섬의 개수

			int[] x = new int[N];
			int[] y = new int[N];

			// 모든 섬의 x좌표
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}

			// 모든 섬의 y좌표
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}

			// 세율
			tax = Double.parseDouble(br.readLine());

//			System.out.println(Arrays.toString(x));
//			System.out.println(Arrays.toString(y));

			List<Edge> list = new ArrayList<>();
			// 점과 점 사이의 거리
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					double distance = Math.sqrt(dx * dx + dy * dy); // 실제 거리 계산
					list.add(new Edge(i, j, distance));
				}
			}

			// 해저 터널의 길이 오름차순 정렬
			Collections.sort(list);

//			System.out.println(list);
			// 정점-1개의 간선을 뽑아 사이클이 생기지 않게
			p = new int[N];

			// make-set이용해 본인이 대표자가 되도록 초기화
			for (int i = 0; i < N; i++) {
				p[i] = i;
			}

			double totalCost = 0.0;
			int pick = 0;
			int size = list.size(); // 간선의 개수
			for (int i = 0; i < size; i++) {

				int px = findSet(list.get(i).a);
				int py = findSet(list.get(i).b);

				// 사이클 검사
				if (px != py) {
					union(px, py);
					pick++;
					totalCost += Math.pow(list.get(i).cost, 2);
				}

				if (pick == N - 1) {
					break;
				}

			}

			sb.append("#").append(testCase).append(" ").append(Math.round(tax * totalCost)).append("\n");

		}
		System.out.println(sb.toString());

	}

	// 대표자만 들어옴
	private static void union(int px, int py) {
		p[py] = px;

	}

	private static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

}
