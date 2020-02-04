package uke6.kino_full;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilmsvisningTest {

	@Test
	public void Filmvisningtest() {
		Film f1 = new Film("Alexander",15,"USA");
		Film f2 = new Film("Bad Santa",11,"USA");
		
		Sal s1 = new Sal("Nova 3",140);
		Sal s2 = new Sal("Prinsen 4",40);
		Sal s3 = new Sal("Prinsen 2",240);

		Filmvisning fv1 = new Filmvisning(f1, s1, "20:00", 85);
		Filmvisning fv2 = new Filmvisning(f1, s2, "17:00", 75);
		Filmvisning fv3 = new Filmvisning(f2, s3, "18:50", 70);
		assertEquals("Filmvisning [film=Film [alder=15, filmtittel=Alexander, nasjonalitet=USA], sal=Sal [navn=Nova 3, plasser=140], tid=20:00, pris=85]", fv1.toString());
		assertEquals("Filmvisning [film=Film [alder=15, filmtittel=Alexander, nasjonalitet=USA], sal=Sal [navn=Prinsen 4, plasser=40], tid=17:00, pris=75]", fv2.toString());
		assertEquals("Filmvisning [film=Film [alder=11, filmtittel=Bad Santa, nasjonalitet=USA], sal=Sal [navn=Prinsen 2, plasser=240], tid=18:50, pris=70]", fv3.toString());
	}

}
