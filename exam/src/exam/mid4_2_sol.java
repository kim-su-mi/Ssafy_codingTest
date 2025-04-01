package exam;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class mid4_2_sol {
	static int ans, N,M,K; // 변수들 스태틱으로 선언
	static int memo[][]; // 나이트와 룩의 위치를 저장하는 배열 선언
	static Set<Integer> cases; // 경우의수를 정수형으로 저장할 것임. 중복 방지를 위한 Set사용
	static int dki[] = {-2,-1,1,2,2,1,-1,-2}; // 나이트 이동경로
	static int dkj[] = {1,2,2,1,-1,-2,-2,-1}; // 나이트 이동경로
	static int dli[] = {-1,0,1,0}; // 룩 이동경로
	static int dlj[] = {0,1,0,-1}; // 룩 이동경로
	
	static void dfs(int depth, int ki,int kj,int li,int lj) { // 백트래킹을 활용한 탐색
		if(depth==K){ // 만약 K번 이동하면
			int temp = ki*1000000+kj*10000+li*100+lj; // 룩과 나이트의 좌표를 고유한 정수로 변환 -> 룩과 킹이 이동해서 같은 자리로 오는 경우 제거해주기 위해 
													  // 좌표가 각각 킹:(10,9) ,룩(7,3)이면 10090703으로 set에서 중복 값을 제거할 수 있음
			if(cases.contains(temp)) return; // 이미 set에 저장되어 있으면 종료
			ans++;// set에 없으면 정답 1증가
			cases.add(temp); // set에 담기
			return;}// 종료
	
		for(int i = 0 ; i <2 ; i++) {// 완전 탐색을 위한 반복문 i==0이면 나이트 이동, i==1이면 룩이동
			if(i==0) {//나이트 이동
				for(int k = 0 ; k < 8 ; k++) {// 팔방 이동
					int nki = ki+dki[k]; // 이동한 나이트 좌표
					int nkj = kj+dkj[k]; // 이동한 나이트 좌표
					if(nki<0||nkj<0||nki>=N||nkj>=M) continue; // 체스판 벗어나면 다음 탐색
					if(memo[nki][nkj]==1) continue; // 룩이 있는 곳이면 다음 탐색
					memo[nki][nkj] = 2; // 나이트 이동
					memo[ki][kj] = 0; // 기존 위치 0으로
					dfs(depth+1,nki,nkj,li,lj); // depth증가 후 dfs실행
					memo[nki][nkj] = 0; // 나이트 위치 원복
					memo[ki][kj] = 2; // 나이트 위치 원복
					
				}// 나이트 이동 종료
			}else {// 룩 이동
				L1:for(int k = 0; k < 4; k++) { // 사방이동
					int nli = li; // 룩 위치
					int nlj = lj; // 룩 위치
					while(true) { // 룩은 이동 거리에 제한이 없음
						nli +=dli[k]; // 이동 후 룩 위치
						nlj +=dlj[k]; // 이동 후 룩 위치
						if(nli<0||nlj<0||nli>=N||nlj>=M) continue L1; // 체스판 벗어나면 다음 탐색
						if(memo[nli][nlj]==2) continue L1; // 나이트 있는 곳이면 다음 탐색
						memo[nli][nlj] = 1; // 룩 이동
						memo[li][lj] = 0; // 기존위이 0으로
						dfs(depth+1,ki,kj,nli,nlj); // depth증가 후 dfs실행
						memo[nli][nlj] = 0; // 룩 위치 원복
						memo[li][lj] = 1; // 룩 위치 원복
					}// 한 방향에 대한 이동 종료
				}// 사방이동 종료
			}//룩이동 종료
		}// 이동 종료	
	}//dfs 메서드 종료
	
	
	
	
	
	public static void main(String[] args) throws Exception{ //메인메서드 시작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 선언
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력을 위한 선언
		StringTokenizer st; // 스트링토크나이저 선언
		int T = Integer.parseInt(br.readLine());//테스트케이스 개수 입력받음
		for(int t = 1; t <= T ; t++) {// 테스트 케이스 별 코드 시행
			st = new StringTokenizer(br.readLine()); // N,M,K 입력받기
			N = Integer.parseInt(st.nextToken()); //체스판의 크기
			M = Integer.parseInt(st.nextToken()); //체스판의 크기
			K = Integer.parseInt(st.nextToken()); //이동 횟수
			ans = 0; // 정답 초기화
			memo = new int[N][M]; // 체스판 초기화
			cases = new HashSet<>(); //경우의수 저장을 위한 Set선언

			int ki = 0 , kj = 0 , li= 0 , lj = 0; // 나이트, 룩 위치 초기화
			for(int i = 0 ; i < N ; i++) { // 체스판 입력받기
				st = new StringTokenizer(br.readLine()); // 줄별로 읽기
				for(int j = 0 ; j < M ; j++) { // 각 위치에 대해서
					memo[i][j] = Integer.parseInt(st.nextToken()); // 입력값 저장 
					if(memo[i][j]==1) { // 룩이면
						li=i;// 룩좌표 저장
						lj=j;// 룩좌표 저장
					}else if(memo[i][j]==2) {//나이트면
						ki=i;// 나이트 좌표 저장
						kj=j;}// 나이트 좌표 저장
				}
			}//체스판 입력 끝
			dfs(0,ki,kj,li,lj); // dfs메서드 시행
			bw.write("#"+t+" "+ans+"\n");// 정답 버퍼에 저장
		}// 테스트케이스별 반복문 종료
		bw.flush();// 정답 출력
	}// 메인메서드 종료
}// 클래스 종료
