import java.util.HashSet;
import java.util.Set;

public class Intersection {
	String name;
	Set<Street> outgoingStreets = new HashSet<>();
	boolean deadEnd = false;
	
	Intersection() {}
	
	@Override
	public String toString() {
		return "X";
	}
}
