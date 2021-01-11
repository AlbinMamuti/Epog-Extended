import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class City {
	
	Set<Street> streets = new HashSet<>();
	Set<Intersection> intersections = new HashSet<>();
	
	City() {}
	
	Set<Street> deadEnds() {
		
		Set<Street> Sackgassen = new HashSet<>();
		Set<Street> temp = new HashSet<>();
		temp.addAll(streets);
		Set<Intersection> intersect = new HashSet<>();
		Set<Intersection> SackgassenInt = new HashSet<>();
		intersect.addAll(intersections);
			
		for(Intersection e : intersect) {
			if(e.outgoingStreets.isEmpty()) {
				e.deadEnd = true;
				SackgassenInt.add(e);
			}
		}
		
		for(int i = 0; i < 20; i++) {
//			for(Street t : temp) {
//				for(Intersection k : SackgassenInt) {
//					if(t.to == k || ) {
//						Sackgassen.add(t);
//					}
//				}
//			}
			boolean flag = false;
			for(Intersection e : intersect) {
				for(Street s : e.outgoingStreets) {
					for(Intersection k : SackgassenInt) {
						if(s.to.equals(k)) {
							Sackgassen.add(s);
							
						}
					}
					if(Sackgassen.containsAll(e.outgoingStreets)) {
						SackgassenInt.add(e);
					}
				}
			}
		}
		
		return Sackgassen;
	}
	Set<Street> rec (){
		return null;
	}
	
	Set<Square> reachableSquares(String squareName, int distance) {
		boolean flag = false;
		Intersection root = null;
		Set<Square> ret = new HashSet<>();
		Set<Intersection> reach = new HashSet<>();
		for(Intersection e : intersections) {
			if(e.name != null) {
				if(e.name.equals(squareName)) {
					flag = true;
					root = e;
					break;
				}
			}
		}
		if(!flag) {
			throw new IllegalArgumentException();
		} else if(distance<0) {
			throw new IllegalArgumentException();
		} else if(distance == 0) {
			for(Intersection e : intersections) {
				if(e.name.equals(squareName)) {
					ret.add((Square) e);
					return ret;
				}
			}
		} else {
			
			reach.add(root);
			boolean kek = true;
			LinkedList<Intersection> list = new LinkedList<>(); 
			list.addFirst(root);
			
			while(!list.isEmpty() && kek) {
				Intersection temp = list.removeFirst();
				for(Street s : temp.outgoingStreets) {
					if(s.length <= distance) {
						list.addFirst(s.to);
						reach.add(s.to);
						distance -= s.length;
					}
				}
				
				
				
			}
			
			
		}
		
	
		for(Intersection e: reach) {
			if(e.name != null) {
				ret.add((Square)e);
			}
		}
		
		
		return ret;
	}
}
