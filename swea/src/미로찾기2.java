import java.util.*;

public class 미로찾기2 {
    static int ROWS = 10;
    static int COLS = 10;
    static String[][] map = new String[ROWS][COLS];
    static boolean[][] path = new boolean[ROWS][COLS];
    static int[][][] parent = new int[ROWS][COLS][2]; // 경로 추적용
    static boolean[][] visited = new boolean[ROWS][COLS];

    static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        String input = " G R R G T G G R G X\r\n" +
                       " G R R G T R G G G G\r\n" +
                       " G R R G R R R G R R\r\n" +
                       " F A G G G G G G G G\r\n" +
                       " G R T T R G R G E1 G\r\n" +
                       " G G T T R G G G G G\r\n" +
                       " R G G G G G E2 R G R\r\n" +
                       " G G R W W W G G G G\r\n" +
                       " G G R W W W R R R G\r\n" +
                       " H G G G A1 G G G G G";

       

       

        bfs(8, 0 );
        printPath();
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        parent[startX][startY] = new int[]{-1, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            if (map[x][y].equals("T")) {
                markPath(x, y);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < ROWS && ny < COLS &&
                    !visited[nx][ny] && (map[nx][ny].equals("G") || map[nx][ny].equals("T"))) {

                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    parent[nx][ny] = new int[]{x, y};
                }
            }
        }
    }

    static void markPath(int x, int y) {
        while (x != -1 && y != -1) {
            path[x][y] = true;
            int[] p = parent[x][y];
            x = p[0];
            y = p[1];
        }
    }

    static void printPath() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(path[i][j] ? "● " : "· ");
            }
            System.out.println();
        }
    }
}
