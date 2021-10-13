package hu.uni.miskolc.teszteles.core;

import static org.junit.Assert.*;

import org.junit.Test;

import hu.uni.miskolc.teszteles.core.exceptions.AjtokSzamaNemMegfelelo;

public class AutoTest {


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
	public void testJoRendszem() throws RendszamNemMegfeleleo {
		Auto auto = new Auto();
		String rednszem = "ABC-123";
		auto.setRendszam
	}
	
}
