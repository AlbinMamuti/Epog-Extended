import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Rezept {

	Einheit letzteEinheit;
	LinkedList<Einheit> pre = new LinkedList<>();
	LinkedList<Einheit> pre2 = new LinkedList<>();
	
	public Rezept(Einheit letzteEinheit) {
		this.letzteEinheit = letzteEinheit;
	}

	public void linearisiere(PrintStream output) {
		
		pre.clear();
		
			for(Einheit e: this.letzteEinheit.vorbedingungen) {
				
				rec(e);
			}
			pre.addLast(letzteEinheit);
			
			
			int count = 1;
			for(Einheit e : pre) {
				output.println(count);
				for(String s: e.schritte) {
					output.println(s);
					
				}
				count ++;
			}
	}
	
	public void rec(Einheit k) {
		
		if(k.vorbedingungen.isEmpty()) {
			pre.addFirst(k);
		}
		else {
			boolean flag = false;
			for(Einheit e: k.vorbedingungen) {
				if(pre.contains(e)) {
					continue;
				} else {
					rec(e);
				}
			}
			if(!flag) {
				pre.addLast(k);
			}
		}
		
	}

	public void vereinfache() {
		
		rec2(letzteEinheit, null);
		
		
		
	}
	
	public void rec2(Einheit k, Einheit previous) {
		
		if(k.vorbedingungen.size() == 1) {
			pre2.add(k);
			Einheit temp = k.vorbedingungen.get(0);
			temp.schritte.addAll(k.schritte);
			if(k.equals(letzteEinheit)) {
				letzteEinheit = temp;
			} else {
				previous.vorbedingungen.remove(k);
				previous.vorbedingungen.add(temp);
			}
			
		} else {
			for(Einheit e : k.vorbedingungen)
				rec2(e, k);
		}
		
	}
}
