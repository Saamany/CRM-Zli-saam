package ch.zli.m223.ksh19a.se.CRM.controller;

import ch.zli.m223.ksh19a.se.CRM.model.Schueler;

public class SchuehlerDto {
	public String schuehlerName;
	
	public SchuehlerDto(Schueler Schuehler) {
		schuehlerName = Schuehler.getSchuehlerName();
	}

}
