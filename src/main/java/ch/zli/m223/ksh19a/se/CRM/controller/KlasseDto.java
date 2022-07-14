package ch.zli.m223.ksh19a.se.CRM.controller;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;

public class KlasseDto {
	public final Long id;
	public final String klasseName;
	public List<String> schuelerList;

	
	public KlasseDto(AppKlasse klasse) {
		id = klasse.getId();
		klasseName = klasse.getKlasseName(); 
		schuelerList = new ArrayList<>();
		for (var schuehler : klasse.getSchuehlerNamen()) {
			schuelerList.add(schuehler.getSchuehlerName());
			
		}
	}
	

}
