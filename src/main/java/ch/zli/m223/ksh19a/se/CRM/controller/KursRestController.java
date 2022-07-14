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

import ch.zli.m223.ksh19a.se.CRM.service.KursService;


@RestController
@RequestMapping("/api/v1")
public class KursRestController {
	@Autowired
	private KursService kursService;

	@GetMapping("/kurse")
	List<KursDto> getAllKursee() {
		// todo get List from service Layer
		return kursService.getAllKurse().stream().map(kurse -> new KursDto(kurse)).collect(Collectors.toList());
	}

	@GetMapping("/kurse/{id}")
	KursDto getKurse(@PathVariable("id") long id) {// suche im Pfad eine variable mit ID, nimm Wert und erstelle eine
													// long
		return new KursDto(kursService.getKurse(id));
	}

	@PostMapping("/kurse")
	KursDto insertKurse(@RequestBody KursInputDto KurseData,@RequestBody KlasseInputDto KlasseData) {
		return new KursDto(kursService.insertKurse(KurseData.name, KlasseData.name));
	}
	
	@DeleteMapping("/kurse/{id}")
	void deleteKurse(@PathVariable("id") Long id) {
		
		kursService.deleteKursById(id);
	}
	
	@GetMapping("/kurse/{id}/klasse")
	KlasseDto getKlasseForKurs(@PathVariable("id") Long id) {
		return new KlasseDto( kursService.getKurse(id).getKlasse());
		
		}
}


