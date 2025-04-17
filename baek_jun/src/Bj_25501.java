import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_25501 {
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			cnt = 0;
			String str = br.readLine();
			int yesNo = isPalindrome(str);
			sb.append(yesNo+" "+cnt+"\n");
			
		}
		
		System.out.println(sb.toString());
	}
	
	// 회문이면 : 0 / 아니면 : 1
	    public static int recursion(String s, int l, int r){
	    	cnt++;
	        if(l >= r) return 1;
	        else if(s.charAt(l) != s.charAt(r)) return 0;
	        else return recursion(s, l+1, r-1);
	    }
	    public static int isPalindrome(String s){
	        return recursion(s, 0, s.length()-1);
	    }

}
