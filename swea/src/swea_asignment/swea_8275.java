package swea_asignment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_8275 {
	private static class Note{
		int l;
		int r;
		int s;
		public Note(int l, int r, int s) {
			super();
			this.l = l;
			this.r = r;
			this.s = s;
		}
		@Override
		public String toString() {
			return "Note [l=" + l + ", r=" + r + ", s=" + s + "]";
		}

	}
	private static int N;
	private static int X;
	private static int M;
	private static Note[] notes;
	private static int max;
	private static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int testCase=1; testCase<=T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //햄스터 우리 수
			X = Integer.parseInt(st.nextToken()); // 한 우리에 들어갈 수 있는 최대 햄스터 수
			M = Integer.parseInt(st.nextToken()); // 기록의 개수
			
			
			notes = new Note[M];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken()); // 우리 시작
				int r = Integer.parseInt(st.nextToken()); //우리 끝
				int s = Integer.parseInt(st.nextToken()); // 총 햄스터 수
				notes[i] = new Note(l,r,s);
			}
			max = -1; //초기값이 사용되지 않는 숫자로 넣자
			result = new int[N+1]; //0번방은 안씀, 각 우리의 햄스터 수를 기록, 최대값이 갱신됐을 때,
			perm(1,0,new int[N+1]);
			
			sb.append("#").append(testCase);
			
			if(max == -1) {//모든 조건을 만족하는 햄스터의 배치가 하나도 없다면 
				sb.append(" -1");
			}else {
				
				for (int i = 1; i < result.length; i++) {
					sb.append(" ").append(result[i]);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	/** 중복 순열 , 
	 * index : 1~N번방 중에 현재 작업할 방 번호
	 * arr[] : 현재 작업 중인 햄스터 수 기록할 배열 
	 * sum : index전까지 배치된 햄스터 수의 합 
	 * */
	private static void perm(int index,int sum, int[] arr) {
		//종료 조건 
		if(index > N) {
			// M개의 기록을 모두 만족하는지 확인
			for(Note ni : notes) {
				int temp = 0; //ㅣ~r까지의 합
				
				for (int i = ni.l; i <= ni.r; i++) {
					temp += arr[i];
				}
				if(ni.s != temp) return; // 조건 위배 
			}
			// max갱신 되는지 확인
			if (max < sum) {
				max = sum;
				// arr -> result배열로 깊은 복사 
				System.arraycopy(arr, 1, result, 1, arr.length-1);
			}
			return;
		}
		
		// 재귀 파트 
		for (int i = 0; i <= X; i++) { //중복 순열 순서대로 
			
			arr[index] = i;
			perm(index+1,sum+i,arr);
		}
	}

}
