package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class mid4 {
	private static int N;// 고양이(집)의 수
	private static int cnt;// 가능한 매칭의 수
	private static boolean[] isUsed; // 이미 사용한 고양이를 표시하기 위한 배열
	private static List<Set<Character>>  list;// 각 고양이가 가진 털 색깔 집합
	private static char[] house;// 집에서 발견된 털 색깔

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); //고양이 수
			st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();
			Set<Character> catHairs;
			cnt = 0;
			
			house = new char[N];
			
			// 집에서 발견된 고양이 털 배열에 넣음
			for (int i = 0; i < house.length; i++) {
				house[i] = st.nextToken().charAt(0);
			}
			
			// 고양이의 털 색깔을 입력 받아 List에 저장
			// 각 고양이의 털 들은 set으로 관리
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken()); //고양이의 털 수 
				catHairs = new HashSet<>();
				for (int j = 0; j < n; j++) {
					catHairs.add(st.nextToken().charAt(0));
				}
				list.add(catHairs);
			}
			
//			System.out.println(Arrays.toString(house));
//			for (int i = 0; i < list.size(); i++) {
//			    System.out.println("고양이 " + (i+1) + "의 털: " + list.get(i));
//			}
			isUsed = new boolean[N];
			// 재귀 함수를 통해 모든 가능한 매칭 탐색
			check(0);
			
			System.out.println("#"+ tc+" "+cnt);
			
		}
		
		
		
	}
	// 재귀적으로 모든 가능한 고양이-집 매칭을 찾는 함수
	private static void check(int houseIdx) {
		if(houseIdx == N) { //모든 고양이를 집에 배정함
			cnt++;
			return;
		}
		// 현재 집에 배정할 수 있는 모든 고양이 시도
		for (int catIdx = 0; catIdx < N; catIdx++) {
			// 이미 사용된 고양이는 건너뛰기
			if(isUsed[catIdx]) continue;
			// 현재 집에서 발견된 털 색깔이 현재 고양이의 털 색깔 중 하나인지 확인
			if(list.get(catIdx).contains(house[houseIdx])) {
				isUsed[catIdx] = true;// 고양이 사용 표시
				check(houseIdx+1);// 다음 집으로 이동
				isUsed[catIdx] = false;// 백트래킹
			}
		}
		
		
		
	}
}

//2
//3
//b w o
//3 b w o
//2 b w
//2 o w
//5
//c d d a f
//3 d c a
//3 s a f
//3 s a f
//4 a b c d
//2 d c


