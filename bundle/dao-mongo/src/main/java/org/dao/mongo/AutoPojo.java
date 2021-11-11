package org.dao.mongo;

import java.time.LocalDate;

import org.bson.codecs.pojo.annotations.BsonId;

import hu.uni.miskolc.teszteles.core.enumm.Kivitel;
import hu.uni.miskolc.teszteles.core.enumm.Uzemanyag;
import hu.uni.miskolc.teszteles.core.enumm.Valto;

public class AutoPojo {
	public String gyarto;
	public String modell;
	public Integer hengerurtartalom;
	@BsonId
	public String rendszam;
	public Uzemanyag uzemanyag;
	public LocalDate gyartasiIdo;
	public String szinHex;
	public boolean korozott;
	public String forgalmiSzama;
	public Valto valto;
	public Kivitel kivitel;
	public int ajtokSzama;
	
	public String getGyarto() {
		return gyarto;
	}
	public void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public Integer getHengerurtartalom() {
		return hengerurtartalom;
	}
	public void setHengerurtartalom(Integer hengerurtartalom) {
		this.hengerurtartalom = hengerurtartalom;
	}
	public String getRendszam() {
		return rendszam;
	}
	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
	}
	public Uzemanyag getUzemanyag() {
		return uzemanyag;
	}
	public void setUzemanyag(Uzemanyag uzemanyag) {
		this.uzemanyag = uzemanyag;
	}
	public LocalDate getGyartasiIdo() {
		return gyartasiIdo;
	}
	public void setGyartasiIdo(LocalDate gyartasiIdo) {
		this.gyartasiIdo = gyartasiIdo;
	}
	public String getSzinHex() {
		return szinHex;
	}
	public void setSzinHex(String szinHex) {
		this.szinHex = szinHex;
	}
	public boolean isKorozott() {
		return korozott;
	}
	public void setKorozott(boolean korozott) {
		this.korozott = korozott;
	}
	public String getForgalmiSzama() {
		return forgalmiSzama;
	}
	public void setForgalmiSzama(String forgalmiSzama) {
		this.forgalmiSzama = forgalmiSzama;
	}
	public Valto getValto() {
		return valto;
	}
	public void setValto(Valto valto) {
		this.valto = valto;
	}
	public Kivitel getKivitel() {
		return kivitel;
	}
	public void setKivitel(Kivitel kivitel) {
		this.kivitel = kivitel;
	}
	public int getAjtokSzama() {
		return ajtokSzama;
	}
	public void setAjtokSzama(int ajtokSzama) {
		this.ajtokSzama = ajtokSzama;
	}
	public AutoPojo() {
		super();
	}
	public AutoPojo(String gyarto, String modell, Integer hengerurtartalom, String rendszam, Uzemanyag uzemanyag,
			LocalDate gyartasiIdo, String szinHex, boolean korozott, String forgalmiSzama, Valto valto, Kivitel kivitel,
			int ajtokSzama) {
		super();
		this.gyarto = gyarto;
		this.modell = modell;
		this.hengerurtartalom = hengerurtartalom;
		this.rendszam = rendszam;
		this.uzemanyag = uzemanyag;
		this.gyartasiIdo = gyartasiIdo;
		this.szinHex = szinHex;
		this.korozott = korozott;
		this.forgalmiSzama = forgalmiSzama;
		this.valto = valto;
		this.kivitel = kivitel;
		this.ajtokSzama = ajtokSzama;
	}
	
	
}