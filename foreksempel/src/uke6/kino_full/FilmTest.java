package uke6.kino_full;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilmTest {

	@Test
	public void Filmtest() {
		Film f2 = new Film("Bad Santa",11,"USA");
		assertEquals("Film [alder=11, filmtittel=Bad Santa, nasjonalitet=USA]", f2.toString());

	}

	@Test
	public void Navntest() {
		Film f2 = new Film("Bad Santa",11,"USA");
		assertEquals("Bad Santa", f2.getFilmtittel());
		
	}
}