package ch.zli.m223.ksh19a.se.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.se.CRM.service.KlasseService;

@RestController
@RequestMapping("/api/v1")
public class KlasseRestController {
	@Autowired
	private KlasseService klasseService;

	@GetMapping("/klassen")
	List<KlasseDto> getAllKlasses() {
		// todo get List from service Layer
		return klasseService.getAllKlassen().stream().map(Klasse -> new KlasseDto(Klasse)).collect(Collectors.toList());
	}

	@GetMapping("/klassen/{id}")
	KlasseDto getKlasse(@PathVariable("id") long id) {// suche im Pfad eine variable mit ID, nimm Wert und erstelle eine
													// long
		return new KlasseDto(klasseService.getKlasse(id));
	}

	@PostMapping("/klassen")
	KlasseDto insertKlasse(@RequestBody KlasseInputDto KlasseData) {
		return new KlasseDto(klasseService.insertKlasse(KlasseData.name));
	}
	
	@DeleteMapping("/klassen/{id}")
	void deleteKlasse(@PathVariable("id") Long id) {
		
		klasseService.deleteKlasseById(id);
	}
	
	@GetMapping("/klassen/{id}/schuehler")
	List<SchuehlerDto> getSchuehlerForKlasse(@PathVariable("id") Long id) {
		var Klasse = klasseService.getKlasse(id);
		return Klasse.getSchuehlerNamen().stream().map(r -> new SchuehlerDto(r)).collect(Collectors.toList());
		}
}

