package ch.zli.m223.ksh19a.se.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;

public interface KlasseService {
	List<AppKlasse> getAllKlassen();

	AppKlasse getKlasse(long id);

	AppKlasse insertKlasse(String klasseName);
	void deleteKlasseById(Long id);

}
