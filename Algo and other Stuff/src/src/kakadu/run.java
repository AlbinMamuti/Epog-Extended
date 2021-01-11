package src.kakadu;

public class run {

	public static void main(String[] args) {
		I1 a = new Alpha();
		a.method1();
		System.out.println();
		Beta b = new Beta();
		b.method1();
		System.out.println();
		I1 ba = new Beta();
		ba.method1();
		System.out.println();
		I2 ab = new Beta();
		((I1)ab).method1();
		System.out.println();
		Alpha al = new Beta();
		al.method1();
		System.out.println();
		Alpha ag = new Gamma();
		ag.method1();
		System.out.println();
		Phi p = new Phi();
		p.method1();
		System.out.println();
		Alpha ai = new Iota();
		//((Gamma)a).method0();
		System.out.println();
		Iota aii = new Iota();
		aii.method1();
		System.out.println();
		Eta ae = new Eta();
		ae.method1();
	}

}
