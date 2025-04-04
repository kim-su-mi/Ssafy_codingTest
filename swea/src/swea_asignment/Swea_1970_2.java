package swea_asignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 동적 계획법
 * 거스름돈이 1원일떄~~~~주어진 값일때까지의 필요한 동전의 수를 셈 
 */
public class Swea_1970_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] changes = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
        
        for(int testCase=1; testCase<=T; testCase++) {
            
            int change = Integer.parseInt(br.readLine()); //거스름돈 
            
            // dp[i]는 금액 i를 만드는데 필요한 최소 동전 개수
            int[] dp = new int[change+1];
            
            // 각 금액을 만들기 위해 사용된 동전 종류를 저장할 배열
            int[][] result = new int[change+1][changes.length];
            
            // 초기값 설정: 불가능 표시를 위한 큰 값
            for (int i = 1; i <= change; i++) {
                dp[i] = Integer.MAX_VALUE - 1; // 오버플로우 방지를 위해 -1
            }
            dp[0] = 0; // 0원은 0개의 동전으로 만들 수 있음 (중요!)
            
            // 각 동전에 대해 처리
            for (int i = 0; i < changes.length; i++) {
                int coin = changes[i];
                
                // 현재 동전으로 만들 수 있는 모든 금액에 대해 처리
                for (int j = coin; j <= change; j++) {
                    // 이전 상태보다 현재 동전을 사용한 경우가 더 적은 동전을 사용하는 경우
                    if (dp[j - coin] != Integer.MAX_VALUE - 1 && dp[j - coin] + 1 < dp[j]) {
                        dp[j] = dp[j - coin] + 1;
                        
                        // 이전 상태에서 사용한 동전 정보 복사
                        for (int k = 0; k < changes.length; k++) {
                            result[j][k] = result[j - coin][k];
                        }
                        
                        // 현재 동전 추가
                        result[j][i]++;
                    }
                }
            }
            
            sb.append("#").append(testCase).append("\n");
            for (int i = 0; i < changes.length; i++) {
                sb.append(result[change][i]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}