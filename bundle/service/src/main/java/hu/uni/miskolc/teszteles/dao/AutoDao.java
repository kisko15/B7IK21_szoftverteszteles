package hu.uni.miskolc.teszteles.dao;

import java.util.Collection;

import hu.uni.miskolc.teszteles.core.Auto;
import hu.uni.miskolc.teszteles.core.RednszamNemMegfelelo;
import hu.uni.miskolc.teszteles.dao.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles.dao.exception.RendszerMarFoglalt;

public interface AutoDao {

	public Collection<Auto> readAllAutos();
	
	public Auto readAutoById(String rendszam) throws AutoNemTalalhato, RednszamNemMegfelelo;
	
	public void createAuto(Auto auto) throws RendszerMarFoglalt;

	public void updateAuto(Auto auto);
	
	public void deleteAuto(Auto auto);
	
	public void deleteAutoById(String rendszam);
	
	
}
