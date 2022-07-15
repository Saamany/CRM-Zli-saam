package ch.zli.m223.ksh19a.se.CRM.controller;

import ch.zli.m223.ksh19a.se.CRM.model.Lehrer;

public class LehrerDto {
	public String lehrerName;
	
	public LehrerDto(Lehrer Lehrer) {
		lehrerName = Lehrer.getLehrerName();
	}

}
