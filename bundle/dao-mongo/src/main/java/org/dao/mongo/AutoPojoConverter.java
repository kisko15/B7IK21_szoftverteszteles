package org.dao.mongo;

import hu.uni.miskolc.teszteles.core.Auto;
import hu.uni.miskolc.teszteles.core.GyartasiIdoNemMegfelelo;
import hu.uni.miskolc.teszteles.core.RednszamNemMegfelelo;
import hu.uni.miskolc.teszteles.core.exceptions.AjtokSzamaNemMegfelelo;


public class AutoPojoConverter {
	
	public static AutoPojo autoToPojoConvert(Auto auto) {
		AutoPojo pojo = new AutoPojo(auto.getGyarto(), auto.getModell(), auto.getHengerurtartalom(), 
				auto.getRendszam(), auto.getUzemanyag(), auto.getGyartasiIdo(), auto.getSzinHex(),
				auto.isKorozott(), auto.getForgalmiSzama(), auto.getValto(), auto.getKivitel(), 
				auto.getAjtokSzama());
		return pojo;
	}
	
	public static Auto pojoToAutoConvert(AutoPojo pojo)  {
		Auto auto;
		try {
			auto = new Auto(pojo.getGyarto(), pojo.getModell(), pojo.getHengerurtartalom(), 
					pojo.getRendszam(), pojo.getUzemanyag(), pojo.getGyartasiIdo(), pojo.getSzinHex(),
					pojo.isKorozott(), pojo.getForgalmiSzama(), pojo.getValto(), pojo.getKivitel(), 
					pojo.getAjtokSzama());
			return auto;
		} catch (RednszamNemMegfelelo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GyartasiIdoNemMegfelelo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AjtokSzamaNemMegfelelo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}