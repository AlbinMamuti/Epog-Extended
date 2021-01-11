package src.Cache;

public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cache myCache = new Cache();
		myCache.access(92);
		myCache.access(91);
		myCache.access(92);
		myCache.print();
		System.out.println();
		myCache.access(93);
		myCache.access(93);
		myCache.access(91);
		myCache.access(91);
		myCache.print();
		System.out.println();
		myCache.access(93);
		myCache.print();
		System.out.println();
		myCache.access(92);
		myCache.print();
		System.out.println((10 / 3 <= 1) && (4.5 / 1.5 > (8 % 4) / 0));
	}

}
