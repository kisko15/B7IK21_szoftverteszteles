package hu.uni.miskolc.teszteles.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class AutoRendszamTest {
	
	@Parameters
	public static Collection data() {
		List data = new ArrayList();
		data.add(new Object[] {"AAAA-123"});
		data.add(new Object[] {"AAA123"});
		data.add(new Object[] {"aaa123"});
		data.add(new Object[] {"AAA-1234"});
		data.add(new Object[] {"AAQ-123"});
		data.add(new Object[] {"AAA-AAA"});
		data.add(new Object[] {"123-123"});
		
		return data;
	}
	
	String rendszam;

	public AutoRendszamTest(String rendszam) {
		this.rendszam = rendszam;
	}

	
	@Test(expected = RednszamNemMegfelelo.class)
	public void testRosszRendszam() throws RednszamNemMegfelelo {
		Auto auto = new Auto();
		auto.setRendszam(rendszam);
	}
}
