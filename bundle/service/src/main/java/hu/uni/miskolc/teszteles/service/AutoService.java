package hu.uni.miskolc.teszteles.service;

import java.time.LocalDate;
import java.util.Collection;

import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import hu.uni.miskolc.teszteles.core.Auto;
import hu.uni.miskolc.teszteles.core.RednszamNemMegfelelo;
import hu.uni.miskolc.teszteles.dao.AutoDao;
import hu.uni.miskolc.teszteles.dao.exception.AutoNemTalalhato;
import hu.uni.miskolc.teszteles.dao.exception.RendszerMarFoglalt;

public class AutoService {
	
private AutoDao dao;
	
	
	public AutoService(AutoDao dao) {
		super();
		this.dao = dao;
	}



	public Collection<Auto> getAllAuto(){
		return dao.readAllAutos();
	}
	
	public Auto getAutoByRendszam(String rendszam) throws AutoNemTalalhato, RednszamNemMegfelelo {
		return dao.readAutoById(rendszam);
	}
	
	
	public Collection<Auto> getAllKorozottAuto(){
		Collection<Auto> autok = getAllAuto();
		Collection<Auto> korozott = autok.stream().filter(a -> a.isKorozott()).collect(Collectors.toList());
		return korozott;
	}
	
	public Collection<Auto> getAllAutoDatumKozott(LocalDate tol, LocalDate ig){
		Collection<Auto> autok = getAllAuto();
		Predicate<Auto> pred = a -> a.getGyartasiIdo().isAfter(tol) && a.getGyartasiIdo().isBefore(ig);
		CollectionUtils.filter(autok, pred);
		return autok;
		
	}
	
	public void addAuto(Auto auto) throws RendszerMarFoglalt {
		dao.createAuto(auto);
	}
	
	public void deleteAuto(Auto auto) {
		dao.deleteAuto(auto);
	}
	
	public void updateAuto(Auto auto) {
		dao.updateAuto(auto);
	}
	
	
}
