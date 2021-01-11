public class Square extends Intersection {
	
	
	Square() {}
	
	@Override
	public String toString() {
		return "[" + name + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
}
