public class CityBuilder {
	
	static City build() {
		
		City city = new City();
		
		Square lowenplatz =new Square();
		Square Bahnhofplatz = new Square();
		Square Central = new Square();
		Square Polyterrasse = new Square();
		Square Stampfenbachplatz = new Square();
		Square Sihlpost = new Square();
		Intersection Un1 = new Intersection();
		Intersection Un2 = new Intersection();
		Intersection Un3 = new Intersection();
		
		//
		lowenplatz.setName("Loewenplatz");
		Bahnhofplatz.setName("Bahnhofplatz");
		Central.setName("Central");
		Polyterrasse.setName("Polyterrasse");
		Stampfenbachplatz.setName("Stampfenbachplatz");
		Sihlpost.setName("Sihlpost");
		
		//
		city.intersections.add(lowenplatz);
		city.intersections.add(Bahnhofplatz);
		city.intersections.add(Central);
		city.intersections.add(Polyterrasse);
		city.intersections.add(Stampfenbachplatz);
		city.intersections.add(Sihlpost);
		city.intersections.add(Un1);
		city.intersections.add(Un2);
		city.intersections.add(Un3);
		//
		
		Street LowenBhf = new Street();//
		Street BhfUn1 = new Street();//
		Street Un1Sip = new Street();//
		Street BhfSbp = new Street();//
		Street SbpBhf = new Street();//
		Street BhfCen = new Street();//
		Street CenBhf = new Street();//
		Street CenSbp = new Street();//
		Street CenUn2 = new Street();//
		Street Un2Cen = new Street();//
		Street Un2Pol = new Street();//
		Street PolUn2 = new Street();//
		Street PolUn3 = new Street();//
		
		//
		city.streets.add(LowenBhf);
		city.streets.add(BhfUn1);
		city.streets.add(Un1Sip);
		city.streets.add(BhfSbp);
		city.streets.add(SbpBhf);
		city.streets.add(BhfCen);
		city.streets.add(CenBhf);
		city.streets.add(CenSbp);
		city.streets.add(CenUn2);
		city.streets.add(Un2Cen);
		city.streets.add(Un2Pol);
		city.streets.add(PolUn2);
		city.streets.add(PolUn3);
		//
		
		LowenBhf.setFromTo(lowenplatz, Bahnhofplatz, 6);
		lowenplatz.outgoingStreets.add(LowenBhf);
		
		//
		BhfUn1.setFromTo(Bahnhofplatz, Un1, 5);
		Bahnhofplatz.outgoingStreets.add(BhfUn1);
		//
		Un1Sip.setFromTo(Un1, Sihlpost, 6);
		Un1.outgoingStreets.add(Un1Sip);
		//
		BhfSbp.setFromTo(Bahnhofplatz, Stampfenbachplatz, 10);
		Bahnhofplatz.outgoingStreets.add(BhfSbp);
		//
		SbpBhf.setFromTo(Stampfenbachplatz, Bahnhofplatz, 10);
		Stampfenbachplatz.outgoingStreets.add(SbpBhf);
		//
		BhfCen.setFromTo(Bahnhofplatz, Central, 2);
		Bahnhofplatz.outgoingStreets.add(BhfCen);
		//
		CenBhf.setFromTo(Central, Bahnhofplatz, 2);
		Central.outgoingStreets.add(CenBhf);
		//
		CenSbp.setFromTo(Central, Stampfenbachplatz, 9);
		Central.outgoingStreets.add(CenSbp);
		//
		CenUn2.setFromTo(Central, Un2, 7);
		Central.outgoingStreets.add(CenUn2);
		//
		Un2Cen.setFromTo(Un2, Central, 7);
		Un2.outgoingStreets.add(Un2Cen);
		//
		Un2Pol.setFromTo(Un2, Polyterrasse, 8);
		Un2.outgoingStreets.add(Un2Pol);
		//
		PolUn2.setFromTo(Polyterrasse, Un2, 8);
		Polyterrasse.outgoingStreets.add(PolUn2);
		//
		PolUn3.setFromTo(Polyterrasse, Un3, 3);
		Polyterrasse.outgoingStreets.add(PolUn3);
		
		return city;
	}
}
