package ch.zli.m223.ksh19a.se.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;
import ch.zli.m223.ksh19a.se.CRM.service.KlasseService;

@Controller
public class KlasseWebController {

	@Autowired
	private KlasseService klasseService;

	@GetMapping("/klasseList")
	String getUserList(Model model) {
		List<AppKlasse> klasseList = klasseService.getAllKlassen();
		model.addAttribute("klassen", klasseList);
		return "klasseList";
	}
}
