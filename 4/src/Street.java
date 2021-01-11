public class Street {
	
	Intersection from;
	Intersection to;
	int length;
	
	Street() {}
	
	@Override
	public String toString() {
		String line = "";
		for (int i = 0; i < length; i++) {
			line += "-";
		}
		return from + " " + line + " " + to;
	}
	
	public void setFromTo(Intersection from, Intersection to, int length) {
		this.from = from;
		this.to =to;
		this.length = length;
	}
}
