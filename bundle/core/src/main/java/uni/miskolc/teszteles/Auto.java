package uni.miskolc.teszteles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.core.HangalRendelkezo;
import org.core.Kivitel;
import org.core.Uzemanyag;
import org.core.Valto;

public class Auto implements HangalRendelkezo {
	//adott szöveget, adott értéket tárol = Map
	public static Map<String, Integer> hengerurtartalomErtek;
	
	static {
		hengerurtartalomErtek = new HashMap<>();
		hengerurtartalomErtek.put("1.0", 998);
		hengerurtartalomErtek.put("1.2", 1199);
		hengerurtartalomErtek.put("1.4", 1390);
		hengerurtartalomErtek.put("1.6", 1500);
	}
	
	private String gyarto;
	private String model;
	private Integer hengerurtartalom;
	private String rendszam;
	private Uzemanyag uzemanyag;
	private LocalDate gyarasiIdo;
	private String szin;
	private boolean korozott;
	private String forgalmiSzama;
	private Valto valto;
	private Kivitel kivitel;
	private int ajtokSzama;
	
	@Override
	public void dudal() {
		System.out.println("Tütü");
	}

	public String getGyarto() {
		return gyarto;
	}

	protected void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}

	public String getModel() {
		return model;
	}

	protected void setModel(String model) {
		this.model = model;
	}

	public Integer getHengerurtartalom() {
		return hengerurtartalom;
	}

	public void setHengerurtartalom(String hengerurtartalom) {
		this.hengerurtartalom = hengerurtartalomErtek.get(hengerurtartalom);
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

	public LocalDate getGyarasiIdo() {
		return gyarasiIdo;
	}

	public void setGyarasiIdo(LocalDate gyarasiIdo) {
		this.gyarasiIdo = gyarasiIdo;
	}

	public String getSzin() {
		return szin;
	}

	public void setSzin(String szin) {
		this.szin = szin;
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

	protected void setKivitel(Kivitel kivitel) {
		this.kivitel = kivitel;
	}

	public int getAjtokSzama() {
		return ajtokSzama;
	}

	protected void setAjtokSzama(int ajtokSzama) {
		this.ajtokSzama = ajtokSzama;
	}

	public Auto(String gyarto, String model, String hengerurtartalom, String rendszam,
			Uzemanyag uzemanyag, LocalDate gyarasiIdo, String szin, boolean korozott, String forgalmiSzama, Valto valto,
			Kivitel kivitel, int ajtokSzama) {
		super();
		this.gyarto = gyarto;
		this.model = model;
		setHengerurtartalom(hengerurtartalom);
		this.rendszam = rendszam;
		this.uzemanyag = uzemanyag;
		this.gyarasiIdo = gyarasiIdo;
		this.szin = szin;
		this.korozott = korozott;
		this.forgalmiSzama = forgalmiSzama;
		this.valto = valto;
		this.kivitel = kivitel;
		this.ajtokSzama = ajtokSzama;
	}
	
	
	
	
}
