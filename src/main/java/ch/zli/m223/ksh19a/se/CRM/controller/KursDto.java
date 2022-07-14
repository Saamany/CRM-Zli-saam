package ch.zli.m223.ksh19a.se.CRM.controller;

import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;
import ch.zli.m223.ksh19a.se.CRM.model.AppKurs;


public class KursDto {
	public final Long id;
	public final String kursName;
	public final Long klasseId;
;
	AppKlasse klasse;

	
	public KursDto(AppKurs kurs) {
		id = kurs.getId();
		kursName = kurs.getKursName(); 
		klasseId = klasse.getId();
	}
}
