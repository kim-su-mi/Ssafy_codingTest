import java.io.BufferedReader; //
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Algo1_서울_12반_김수미 { //class시작
	private static int[][] arr; //배열
	private static int cnt; // 켜진 조명 수 
	private static int N; //미술관 크기
	public static void main(String[] args) throws IOException {//메인 사작
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));//입력
		int T = Integer.parseInt(br.readLine()); //테스트 케이스
		for (int tc = 1; tc <= T; tc++) {//testcase for문
			N = Integer.parseInt(br.readLine()); //N입력
			arr = new int[N][N]; //arr생성
			cnt = 0; //초기화
			List<Integer> list = new ArrayList<>(); //조명의 위치 담을 list
			for (int i = 0; i < arr.length; i++) { //입력값 넣기 위한 for문
				StringTokenizer st = new StringTokenizer(br.readLine());//st로 한줄씩 입력
				for (int j = 0; j < arr.length; j++) {//입력값 넣기 위한 for문
					int a = Integer.parseInt(st.nextToken()); // 값 1개씩 받아옴
//					if(a != 1) total++; //벽이 아니면 증가
					if(a == 2) {//조명이면
						list.add(i); //조명의 위치 행
						list.add(j);//조명의 위치열
					}
					arr[i][j] = a;//배열에 담음
				}
			}
			int size = list.size()/2; //리스트의 사이즈
			for (int i = 0; i < size; i++) {//조명의 갯수만큼 만복
				int x = list.remove(0); // 조명 위치의 행
				int y = list.remove(0);// 조명 위치의 열
				up(x,y); //조명의 위쪽 체크
				down(x,y);//조명의 아래쪽 체크
				left(x,y);//조명의 왼쪽 체크
				right(x,y);//조명의 오른쪽 체크
			}
			for (int i = 0; i < arr.length; i++) { // 2차원 배열 탐색
				for (int j = 0; j < arr.length; j++) {// 2차원 배열 탐색
					if(arr[i][j] == 0) cnt++;//조명 켜진 곳 카운트
				}
			}
			System.out.println("#"+tc+" "+(cnt));//출력
		}
	}
	//위 
	public static void up(int i,int j) {//위쪽 탐색
		while(--i>=0) {
			if (arr[i][j] == 1 || arr[i][j] == 2) {
				break; //탈출
			}//end if
			arr[i][j] = 3; //조명 켬
		}
	}
	//아래
	public static void down(int i,int j) {//아래쪽 탐색
		while(++i<N) {
			if (arr[i][j] == 1 || arr[i][j] == 2) {
				break;//탈출
			}
			arr[i][j] = 3; //조명 켬
		}
	}
	//좌
	public static void left(int i,int j) {//왼쪽 탐색
		while(--j>=0) {
			if (arr[i][j] == 1 || arr[i][j] == 2) {
				break;//탈출
			}
			arr[i][j] = 3; //조명 켬
		}
	}
	//우
	public static void right(int i,int j) {//오른쪽 탐색
		while(++j<N) {
			if (arr[i][j] == 1 || arr[i][j] == 2) {
				break;//탈출
			}
			arr[i][j] = 3; //조명 켬
		}
	}

}


