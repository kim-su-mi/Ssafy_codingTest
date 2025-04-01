import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_3 {
	private static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int testCase=1; testCase<=T; testCase++) {
			int N = Integer.parseInt(br.readLine()); //딸기 케이크 크기
			
			 arr =new int[N][N];
			
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum+=arr[i][j];
				}
				
			}
			
			int result = 0;
			
			if(sum%4==0) { //전체 숫자의 합이 4의 배수일때만 실행, 똑같은 4등분 가능
				int sum4 = sum/4;
				
		A:		for (int i = 1; i < N; i++) { //반복 영역을 나눌 수 있는 행, i뜻 : i-1행과 i행과 사이를 나누겟다
					for (int j = 1; j < N; j++) {
//						[0,0 ~ i,j], [i,0 ~ N,j] [0,j ~ i,N] [i,j ~ N,N]
						if (sum4 == count(0,0,i,j) 
							&& sum4 == count(i,0,N,j) 
							&& sum4 == count(0,j,i,N) 
							&& sum4 == count(i,j,N,N) ) {
							result = 1;
							break A;
						}
								
								
					}
				}
				
				
			}
			
			// 반복 영역을 나눌 수 있는 행
//				반복 영역을 나눌 수 있는 열
//					if 각 영역의 합이 sum/4와 같은지 체크
//						result = 1; break;

		
			
			
			sb.append("#").append(testCase).append(" ").append(result).append("\n");
			
			
			
		}
		System.out.println(sb.toString());
		
		
		
	}
	// (sr,sc)포함 ~ (er,ec)미포함
	private static int count(int sr, int sc, int er, int ec) {
		int cnt = 0;
		for (int r = sr; r < er; r++) {
			for (int c = sc; c < ec; c++) {
				cnt += arr[r][c];
			}
		}
		
		return cnt;
	}

}
