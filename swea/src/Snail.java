
public class Snail {
	public static void main(String[] args) {
		
		// 오 하 왼 상
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		
		int dir =0;
		
		int r = 10;
		int c = 0;

		int[][] arr = new int[10][10];
		int num = 1;
		
		// 10*10
		for (int i = 0; i <10 ; i++) {
			for (int j = 0; j < 10; j++) {
				// 방향 전환
				// 값이 0이 아니거나 ,범위:a<0 a>=10이상
				int newR = r+dr[dir];
				int newC = c+dc[dir];
				if(newR<0 || newR>=10 ||newC<0||newC>=10||arr[newR][newC]!=0) {
					dir = ++dir%4;
					newR = r+dr[dir];
					newC = c+dc[dir];
				}
				r = newR;
				c = newC;
				arr[newR][newC] = num++;
			}
		}
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
		
	}

}
