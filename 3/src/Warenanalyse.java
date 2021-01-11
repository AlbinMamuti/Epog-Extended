import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Warenanalyse {
	
	
	static void analyse(File input, File output) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO
		Map<String, Double> verkaufe = new HashMap<>();
		Map<String, Double> Kunden = new HashMap<>();
		ArrayList<Products> products = new ArrayList<>();
		Scanner scanner = new Scanner(input);
		while(scanner.hasNext()) {
			String product = scanner.next();
			String name =scanner.next();
			int einheit = scanner.nextInt();
			double preis = scanner.nextDouble();
			Waren temp = new Waren(name,product,einheit,preis);
			Products twinkle = new Products(preis, product);
			
			if(verkaufe.containsKey(temp.product)) {
				double tempo = verkaufe.get(temp.product);
				verkaufe.put(temp.product, tempo+temp.umsatz);
			 } else {
				 verkaufe.put(temp.product, temp.umsatz);
			 }
			
			if(Kunden.containsKey(temp.name)) {
				double tem = Kunden.get(temp.name);
				Kunden.put(temp.name, tem + temp.umsatz);
			} else {
				Kunden.put(temp.name, temp.umsatz);
			}
			
			boolean flag = true;
			
			
			
			
			for(Products e: products) {
				if(e.name.equals(twinkle.name)) {
					e.list.add(temp.preis);
					flag = false;
				} 
			
		}
			
			if(flag) {
				products.add(twinkle);
			}
			}
		double max = -1111111111111111.0;
		String gewin = "";
		for(Entry<String, Double> e: verkaufe.entrySet()) {
			if(e.getValue() > max) {
				max = e.getValue();
				gewin = e.getKey();
			}
		}
		double max1 = -1111111111111111.0;
		String gewin1 = "";
		for(Entry<String, Double> e: Kunden.entrySet()) {
			if(e.getValue() > max) {
				max1 = e.getValue();
				gewin1 = e.getKey();
			}
		}
		double max2 = -111111111111111.0;
		String gewin2 = "";
		
		for(Products e : products) {
			e.landb();
		}
		
		for(Products e : products) {
			if(e.diff > max2) {
				max2 = e.diff;
				gewin2 = e.name;
			}
		}
		
		PrintWriter writer = new PrintWriter(output, "UTF-8");
		writer.println(gewin + " " + max);
		writer.println(gewin1 + " " + max1);
		writer.println(gewin2 + " " + max2);
		
		
		writer.close();
		
		
		
	}
}
class Waren{
	String name;
	String product;
	int einheit;
	double preis;
	double umsatz;
	
	
	public Waren(String name, String product, int einheit, double preis) {
		this.name = name;
		this.preis = preis;
		this.product = product;
		this.einheit = einheit;
		umsatz = this.preis*this.einheit;
	}

}	
class Products{
	String name;
	double lowerB;
	double upperB;
	double diff;
	ArrayList<Double> list = new ArrayList<>();
	
	public Products(double preis, String name) {
		list.add(preis);
		this.name = name;
	}
	
	public void landb() {
		Collections.sort(list);
		this.lowerB = list.get(0);
		this.upperB = list.get(list.size()-1);
		diff = Math.abs(lowerB - upperB);
	}
}
