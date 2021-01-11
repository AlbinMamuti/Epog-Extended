import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inspektor {

	public ArrayList<Stall> stalle = new ArrayList<>();

	public void eintrag(String zeile) {
		Scanner scanner = new Scanner(zeile);
		String name;

		name = scanner.next();

		if (scanner.hasNextInt() && scanner.nextInt() < 0) {
			boolean flag = false;
			for (Stall s : stalle) {
				if (s.name.equals(name)) {
					s.infected = true;
					flag = true;
				}
			}
			if (!flag) {
				stalle.add(new Stall(name, true));
			}
		} else {
			boolean flag = false;
			float gelEier = scanner.nextFloat();
			float futterMenge = scanner.nextFloat();
			String futterHersteller = scanner.next();
			for (Stall s : stalle) {
				if (s.name.equals(name)) {
					s.gelEier = gelEier;
					s.futterMenge = futterMenge;
					s.futterHersteller = futterHersteller;
					flag = true;
				}
			}
			if (!flag) {
				stalle.add(new Stall(name, gelEier, futterMenge, futterHersteller));
			}

//			gelEier = scanner.nextFloat();
//			futterMenge = scanner.nextFloat();
//			futterHersteller = scanner.next();
//			stalle.add(new Stall(name, gelEier, futterMenge, futterHersteller));
		}
	}

	public String gefahrenStufe() {
		double counter = 0.0;
		for (Stall s : stalle) {
			if (s.infected)
				counter++;
		}
		if(stalle.isEmpty()) {
			return "OK";
		}
		
		double perc = counter / stalle.size();

		if (perc <= 0.2)
			return "OK";
		else if (perc <= 0.4)
			return "EPIDEMIE";
		else
			return "PANDEMIE";

	}

	public Map<String, String> besteStaelle() {

		Map<String, String> sol = new HashMap<>();

		for (Stall s : stalle) {
			String name = s.name;
			String hersteller = s.futterHersteller;
			if (sol.containsKey(hersteller)) {
				String temp = sol.get(hersteller);
				for (Stall e : stalle) {

					if (e.name.equals(temp)) {
						if (e.infected)
							sol.put(hersteller, e.name);

						else {
							double mm = e.prod();
							double n = s.prod();

							if (mm > n) {
								sol.replace(hersteller, e.name);
							} else {
								sol.replace(hersteller, s.name);
							}
						}
					}
				}
			} else {
				if (!s.infected) {
					sol.put(hersteller, name);
				}
			}
		}
		
		
		return sol;
	}

	public static void main(String[] arg) {
		Inspektor insp = new Inspektor();
		insp.eintrag("Stall-1  0.5  0.1667 XYZ");
		insp.eintrag("Stall-2  -1");
		insp.eintrag("Stall-2  0.7  0.15   ABC");
		insp.eintrag("Stall-3  0.7  0.185  ABC");
	}

}

class Stall {
	String name;
	float gelEier;
	float futterMenge;
	String futterHersteller;
	boolean infected;

	public Stall(String name, float gelEier, float futterMenge, String futterHersteller) {
		this.name = name;
		this.gelEier = gelEier;
		this.futterMenge = futterMenge;
		this.futterHersteller = futterHersteller;
		this.infected = false;
	}

	public Stall(String name, boolean infected) {
		this.name = name;
		this.infected = infected;
	}

	public double prod() {
		double pro = this.gelEier / this.futterMenge;
		return pro;
	}
}
