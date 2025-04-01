import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double a = Integer.parseInt(st.nextToken()); // x1
		double b = Integer.parseInt(st.nextToken()); // y1
		double c = Integer.parseInt(st.nextToken()); //방정식 1의 값
		double d = Integer.parseInt(st.nextToken()); // x2
		double e = Integer.parseInt(st.nextToken()); // y2
		double f = Integer.parseInt(st.nextToken()); //방정식 2의 값
		
		for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
		

	}

}
