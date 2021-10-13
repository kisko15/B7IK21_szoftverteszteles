package hu.uni.miskolc.teszteles.core;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import hu.uni.miskolc.teszteles.core.exceptions.AjtokSzamaNemMegfelelo;

public class AutoTest {

	Auto testAuto;
	@Before
	public void initAuto() {
		testAuto = new Auto();
	}

	@Test
	public void testAjtokSzamaMegfelelo() throws AjtokSzamaNemMegfelelo {
		Auto auto = new Auto();
		auto.setAjtokSzama(3);
	}
	
	@Test(expected = AjtokSzamaNemMegfelelo.class)
	public void testAjtokSzamaTulAlacsony() throws AjtokSzamaNemMegfelelo {
		Auto auto = new Auto();
		auto.setAjtokSzama(-1);
	}
	
	@Test(expected = AjtokSzamaNemMegfelelo.class)
	public void testAjtokSzamaTulMagas() throws AjtokSzamaNemMegfelelo {
		Auto auto = new Auto();
		auto.setAjtokSzama(6);
	}
	
	@Test
	public void testJoRendszem() throws RednszamNemMegfelelo {
		String rendszam = "ABC-123";
		testAuto.setRendszam(rendszam);
		
	}
	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testKotojelNelkuliRendszem() throws RednszamNemMegfelelo {
		String rendszam = "ABAC-123";
		testAuto.setRendszam(rendszam);
	}
	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testTulHosszuSzamosRendszem() throws RednszamNemMegfelelo {
		String rendszam = "ABC-1234";
		testAuto.setRendszam(rendszam);
	}
	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testTulHosszuBetusRendszem() throws RednszamNemMegfelelo {
		String rendszam = "ABCA-123";
		testAuto.setRendszam(rendszam);
	}
	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testCsakSzamokRendszem() throws RednszamNemMegfelelo {
		String rendszam = "111-123";
		testAuto.setRendszam(rendszam);
	}
	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testCsakBetukRendszem() throws RednszamNemMegfelelo {
		String rendszam = "ABC-ABC";
		testAuto.setRendszam(rendszam);
	}
	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testKisBetusRendszem() throws RednszamNemMegfelelo {
		String rendszam = "abc-123";
		testAuto.setRendszam(rendszam);
	}
	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testQBetuvelRendszem() throws RednszamNemMegfelelo {
		String rendszam = "AAQ-123";
		testAuto.setRendszam(rendszam);
	}
	
	@Test
	public void testJoGyartasiIdo() throws GyartasiIdoNemMegfelelo {
		String gyartasiIdo = "2021-04-17";
		testAuto.setGyartasiIdo(LocalDate.parse(gyartasiIdo));
	}
	
	@Test(expected = GyartasiIdoNemMegfelelo.class)
	public void testKoraiGyartasiIdo() throws GyartasiIdoNemMegfelelo{
		String gyartasiIdo = "0222-04-17";
		testAuto.setGyartasiIdo(LocalDate.parse(gyartasiIdo));
	}
	
	@Test(expected = GyartasiIdoNemMegfelelo.class)
	public void testKesoiGyartasiIdo() throws GyartasiIdoNemMegfelelo{
		String gyartasiIdo = "2022-04-17";
		testAuto.setGyartasiIdo(LocalDate.parse(gyartasiIdo));
	}
}
