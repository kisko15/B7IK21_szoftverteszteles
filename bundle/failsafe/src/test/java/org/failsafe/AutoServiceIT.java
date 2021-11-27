package org.failsafe;

import java.time.LocalDate;

import org.dao.mongo.AutoDAOMongo;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.uni.miskolc.teszteles.core.Auto;
import hu.uni.miskolc.teszteles.core.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles.core.RednszamNemMegfelelo;
import hu.uni.miskolc.teszteles.core.enumm.Kivitel;
import hu.uni.miskolc.teszteles.core.enumm.Uzemanyag;
import hu.uni.miskolc.teszteles.core.enumm.Valto;
import hu.uni.miskolc.teszteles.core.exceptions.AjtokSzamaNemMegfelelo;
import hu.uni.miskolc.teszteles.dao.AutoDao;
import hu.uni.miskolc.teszteles.dao.exception.RendszerMarFoglalt;
import hu.uni.miskolc.teszteles.service.AutoService;

public class AutoServiceIT {

	private static AutoService service;
	private static AutoDao dao;
	
	@BeforeClass
	public static void setUp() {
		dao = new AutoDAOMongo("mongodb+srv://test:test@szoftverteszteles2021.bqwgi.mongodb.net/test?retryWrites=true&w=majority", "test", "autok");
		service = new AutoService(dao);
	}
	
	@Before
	public void initData() throws RednszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo, RendszerMarFoglalt {
		((AutoDAOMongo) dao).deleteAll();
		Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12), "#dedede", false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		dao.createAuto(auto);
	}
	
	@Test(expected = RendszerMarFoglalt.class)
	public void test() throws RednszamNemMegfelelo, GyartasiIdoNemMegfelelo, AjtokSzamaNemMegfelelo, RendszerMarFoglalt {
		Auto auto = new Auto("Opel","Astra","1.2" , "ABC-123", Uzemanyag.BENZIN, LocalDate.of(2017, 5,12), "#dedede", false, "123456EE", Valto.MANUALIS_5_FOKOZAT, Kivitel.KOMBI, 5);
		service.addAuto(auto);
	}

	@After
	public void dropData() {
		((AutoDAOMongo) dao).deleteAll();
	}
	
}
