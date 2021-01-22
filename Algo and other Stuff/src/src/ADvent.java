package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
 
public class ADvent {
	
	public static void main(String[] arg) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(new File("EBNF.txt"));
		ArrayList<Pass> p = new ArrayList<>();
		String s = scanner.nextLine();
		System.out.println(s);
		
		
		while(scanner.hasNext()) {
			String b = scanner.nextLine();
			if(b=="") {
				System.out.println("DIS MAMI");
				continue;
			} else {
				System.out.println(b);
			}
		}
		
	}
	
	
	
}
class PassPort{
   String gry;
   String pid;
   String eyr;
   String hcl;
   String byr;
   String iyr; String cid;
   String hgt;
}

class Pass{
	int lowerbound;
	int upperboud;
	Character m;
	String password;
	boolean flag;
	
	Pass(int l, int u, Character m, String p){
		this.lowerbound = l;
		this.upperboud = u;
		this.m = m;
		this.password = p;
		flag = is();
	}
	
	public boolean is() {
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i = 0; i < password.length(); i++) {
			if(map.containsKey(password.charAt(i))) {
				int temp = map.get(password.charAt(i));
				map.replace(password.charAt(i), temp+1);
			} else {
				map.put(password.charAt(i), 1);
			}
		}
		
		if(map.containsKey(this.m)) {
			if(map.get(this.m) >= this.lowerbound) {
				if(map.get(this.m) <= this.upperboud) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}
