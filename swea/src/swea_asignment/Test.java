package swea_asignment;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();
		
		map.put(1, 2);
		map.put(1, 3);
	
		Integer a = map.get(1);
//		if(a == 1) {
			System.out.println(a);
			
//		}
		
		System.out.println(map.get(2));
	}

}
