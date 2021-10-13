package hu.uni.miskolc.teszteles.core;

import java.time.LocalDate;

public class GyartasiIdoNemMegfelelo extends Exception {
	public GyartasiIdoNemMegfelelo (LocalDate gyartasiIdo) {
		super(gyartasiIdo.toString());
	}
}
