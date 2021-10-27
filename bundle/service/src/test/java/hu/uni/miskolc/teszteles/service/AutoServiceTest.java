package hu.uni.miskolc.teszteles.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import hu.uni.miskolc.teszteles.core.Auto;
import hu.uni.miskolc.teszteles.core.RednszamNemMegfelelo;
import hu.uni.miskolc.teszteles.core.enumm.Kivitel;
import hu.uni.miskolc.teszteles.core.enumm.Uzemanyag;
import hu.uni.miskolc.teszteles.core.enumm.Valto;
import hu.uni.miskolc.teszteles.dao.AutoDao;
import hu.uni.miskolc.teszteles.dao.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles.dao.exception.RendszerMarFoglalt;

public class AutoServiceTest {
	
	private AutoService service;
	private Collection<Auto> autok;
	private static AutoDao mock;

	@Before
	public void setUp() throws AutoNemTalalhato, RednszamNemMegfelelo, RendszerMarFoglalt {
		mock = Mockito.mock(AutoDao.class);
		service = new AutoService(mock);
		Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12),
				"#dedede",	false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		Auto auto2 = new Auto("Kia","Picanto","1.0" , "ABC-222", Uzemanyag.BENZIN, LocalDate.of(2012, 8,30),
				"#ffffff",	true, "121212EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.HATCHBACK, 4);
		Auto auto3 = new Auto("Renault","Thalia","1.2" , "ABC-333", Uzemanyag.DIESEL, LocalDate.of(2009, 12,24),
				"#000000",	false, "987654AA", Valto.AUTOMATA, Kivitel.SEDAN, 4);
		autok = new ArrayList();
		autok.add(auto);
		autok.add(auto2);
		autok.add(auto3);


		Mockito.when(mock.readAutoById(ArgumentMatchers.anyString())).
		thenThrow(new AutoNemTalalhato());
		Mockito.doReturn(auto).when(mock).readAutoById("ABC-123");
		Mockito.doReturn(auto2).when(mock).readAutoById("ABC-222");
		Mockito.doReturn(auto3).when(mock).readAutoById("ABC-333");
		Mockito.when(mock.readAllAutos()).thenReturn(autok);
		Mockito.doThrow(RednszamNemMegfelelo.class).when(mock).readAutoById(
				AdditionalMatchers.not(Mockito.matches("\\w\\w\\w-\\d\\d\\d")));
		Mockito.doThrow(RendszerMarFoglalt.class).when(mock).createAuto(auto);
		Mockito.doThrow(RendszerMarFoglalt.class).when(mock).createAuto(auto2);
		Mockito.doThrow(RendszerMarFoglalt.class).when(mock).createAuto(auto3);
	}

	@Test
	public void test() {
		assertEquals(service.getAllAuto().size(), 3);
		for (Auto a : autok) {
			MatcherAssert.assertThat(autok, Matchers.hasItem(a));
		}
	}

	@Test
	public void testVanKorozottAuto() {
		assertNotEquals(service.getAllKorozottAuto().size(),0);
		Mockito.verify(mock, atLeast(1)).readAllAutos();
	}

	@Test
	public void testAutoMasolat() {
		Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12),
				"#dedede",	false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		MatcherAssert.assertThat(autok, Matchers.hasItem(auto));
	}
	@Test
	public void testAutoByRendszam() throws AutoNemTalalhato, RednszamNemMegfelelo {
		service.getAutoByRendszam("ABC-123");

	}
	@Test(expected = RednszamNemMegfelelo.class)
	public void testRosszRendszamLekerdezes() throws AutoNemTalalhato, RednszamNemMegfelelo {
		service.getAutoByRendszam("kiscica");
	}

	@Test(expected = RendszerMarFoglalt.class)
	public void testDuplum() throws RendszerMarFoglalt {
		Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12),
				"#dedede",	false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		service.addAuto(auto);
	}
	@Test
	public void testMegNemFelvittAuto() throws RendszerMarFoglalt {
		Auto auto = new Auto("Opel","Astra","1.2" , "AAA-123", Uzemanyag.DIESEL, LocalDate.of(2016, 11,12),
				"#ffffff",	false, "123789SD", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		service.addAuto(auto);
		Mockito.verify(mock, times(1)).createAuto(auto);
	}
}
