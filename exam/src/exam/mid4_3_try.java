package exam;
import java.util.*;

public class mid4_3_try {
    
    static int n; // 고양이(집)의 수
    static char[] houseHairs; // 집에서 발견된 털 색깔
    static List<Set<Character>> catHairs; // 각 고양이가 가진 털 색깔 집합
    static int matchCount; // 가능한 매칭의 수
    static boolean[] used; // 이미 사용한 고양이를 표시하기 위한 배열
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        
        for (int tc = 1; tc <= T; tc++) {
            n = sc.nextInt(); // 고양이(집)의 수
            
            // 집에서 발견된 털 색깔들
            houseHairs = new char[n];
            for (int i = 0; i < n; i++) {
                houseHairs[i] = sc.next().charAt(0);
            }
            
            // 각 고양이가 가진 털 색깔 집합
            catHairs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt(); // 현재 고양이가 가진 털의 색깔 종류 수
                Set<Character> colors = new HashSet<>();
                
                for (int j = 0; j < a; j++) {
                    colors.add(sc.next().charAt(0));
                }
                
                catHairs.add(colors);
            }
            
            // 가능한 매칭 경우의 수 계산
            matchCount = 0;
            used = new boolean[n]; // 초기화
            
            // 재귀 함수를 통해 모든 가능한 매칭 탐색
            findMatches(0);
            
            System.out.println("#" + tc + " " + matchCount);
        }
        
        sc.close();
    }
    
    // 재귀적으로 모든 가능한 고양이-집 매칭을 찾는 함수
    static void findMatches(int houseIndex) {
        // 모든 집에 고양이가 배정되었다면 매칭 완료
        if (houseIndex == n) {
            matchCount++; // 가능한 매칭 수 증가
            return;
        }
        
        // 현재 집에 배정할 수 있는 모든 고양이 시도
        for (int catIndex = 0; catIndex < n; catIndex++) {
            // 이미 사용된 고양이는 건너뛰기
            if (used[catIndex]) {
                continue;
            }
            
            // 현재 집에서 발견된 털 색깔이 현재 고양이의 털 색깔 중 하나인지 확인
            if (catHairs.get(catIndex).contains(houseHairs[houseIndex])) {
                used[catIndex] = true; // 고양이 사용 표시
                findMatches(houseIndex + 1); // 다음 집으로 이동
                used[catIndex] = false; // 백트래킹
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
//

