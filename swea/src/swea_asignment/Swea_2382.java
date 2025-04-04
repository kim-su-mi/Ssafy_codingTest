package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Swea_2382 {
	static int[][] micro;
	static int[] dr = {0,-1,1,0,0}; //상(1)하(2)좌(3)우(4) , 입력에서 1부터 들어오므로 0은 버림
	static int[] dc = {0,0,0,-1,1};
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //map의 크기 , N*N
			int M = Integer.parseInt(st.nextToken()); //격리 시간 
			int K = Integer.parseInt(st.nextToken()); //군집 정보 수
			
			micro = new int[K][4]; //미생물의 군집 정보 // 0: 행 위치, 1: 열위치, 2: 미생물 수 , 3:이동 방향 
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					micro[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < M; i++) { 
				round();
			}
			int totalCnt = 0; //M번의 격리 이후 남은 미생물의 총 수
			for (int i = 0; i < micro.length; i++) {
				totalCnt+=micro[i][2];
			}
			
			sb.append("#").append(testCase).append(" ").append(totalCnt).append("\n");
			
			
		}
		System.out.println(sb.toString());

	}
	private static void round() {
		for (int i = 0; i < micro.length; i++) {

				if(micro[i][2] <=0) continue;
				// 위치 이동
				micro[i][0] = micro[i][0] + dr[micro[i][3]];
				micro[i][1] = micro[i][1] + dc[micro[i][3]];
				if(micro[i][0] == 0 || micro[i][1] == 0 || micro[i][0] == N-1 || micro[i][1] == N-1) {
					micro[i][2] = micro[i][2]/2; // 군집 수 절반으로 줄임 
					int idx = micro[i][3];
					micro[i][3] = micro[i][3] % 2 == 1 ? micro[i][3] + 1 : micro[i][3] - 1; // 방향 전환 , 1<->2 , 3<->4
				}
		}
		
		// 위치별로 미생물 군집 그룹화
	    Map<String, List<Integer>> positionMap = new HashMap<>();
		for (int i = 0; i < micro.length; i++) {
			if(micro[i][2] <=0) continue; //미생물이 없으면 건너뜀
			
			String key = micro[i][0]+","+micro[i][1]; // ex. 1,2는 map의 위치 인덱스
			
			// map에 없으면 생성 
	        if(!positionMap.containsKey(key)) {
	            positionMap.put(key, new ArrayList<>());
	        }
	        // map의 이 위치에 대한 리스트에 미생물 군집 인덱스 추가
	        positionMap.get(key).add(i); 
			
			
		}
		
		for(Map.Entry<String, List<Integer>> entry : positionMap.entrySet()) {
			List<Integer> clusterIndices = entry.getValue(); //해당 좌표에 위치한 군집들의 인덱스를 list로 가져옴 
			
			if(clusterIndices.size()>1) { //해당 좌표에 여러 군집이 있다는 얘기
				
				// 가장 많은 미생물을 가진 군집 찾기
				int maxMicro = 0;
				int maxMicroIdx = -1;
				int totalMicro = 0;
				for(int idx : clusterIndices) {
					totalMicro += micro[idx][2]; // 미생물 더함
					
					if(micro[idx][2] > maxMicro) {
						maxMicro = micro[idx][2];
						maxMicroIdx = idx;
	                }
				}
				
				 // 가장 큰 군집을 제외한 모든 군집의 미생물 수를 0으로 설정
	            for(int idx : clusterIndices) {
	                if(idx != maxMicroIdx) {
	                    micro[idx][2] = 0;
	                }
	            }
	            
	            micro[maxMicroIdx][2] = totalMicro;
			}
		}

	}

}
