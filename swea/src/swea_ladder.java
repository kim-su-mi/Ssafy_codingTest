import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_ladder {
	public static void main(String[] args) throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		
		for(int testCase=0; testCase<T; testCase++) {
			int t = Integer.parseInt(br.readLine());
			StringTokenizer st;
			
			int xIdx = -1; //초기에 2의 x좌표, 나중엔 나의 현재좌표
			int yIdx = -1; //2의 y좌표
			
			int[][] arr =new int[100][100];
			
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 2) {
						xIdx = j;
						yIdx = i;
					}
				}
			}
			
			
			//아래에서 위로 올라감
			while(yIdx>0) {
				// 좌 확인후 쭉 이동 
				if(xIdx>0 && arr[yIdx][xIdx-1]==1) {
					while(xIdx>0 && arr[yIdx][xIdx-1]==1) {
						xIdx--;
					}
				}
				
				// 우 확인후 쭉 이동 
				else if(xIdx<99 && arr[yIdx][xIdx+1]==1) {
					while(xIdx<99 && arr[yIdx][xIdx+1]==1) {
						xIdx++;
					}
				}
				//좌우 없다면 위로 한칸 이동
				yIdx--;
				
			}

			
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append("#").append(t).append(" ").append(xIdx));
			
		}
		
		
		
	}

}
