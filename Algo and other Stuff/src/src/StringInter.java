package src;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class StringInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> list = algo("12", "ab");
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	public static Set<String> algo(String s, String t){
		Set<String> Solution = new HashSet<String>();
		recutsion(s, t, "",Solution);
		return Solution;
	}
	public static void recutsion(String s, String t, String current, Set<String> solution) {
		
		if(s.length() == 0 || t.length() == 0){
			solution.add(current + s+ t);
		} else {
			recutsion(s.substring(1), t, current+s.substring(0, 1), solution);
			recutsion(s, t.substring(1), current+t.substring(0,1),solution);
		}
		
	}

}
