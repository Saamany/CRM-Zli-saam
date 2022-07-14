package ch.zli.m223.ksh19a.se.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19a.se.CRM.model.AppKurs;

public interface KursService {
	List<AppKurs> getAllKurse();

	AppKurs getKurse(long id);

	AppKurs insertKurse(String kursName, String klasseName);
	void deleteKursById(Long id);
}
