package ch.zli.m223.ksh19a.se.CRM.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;
import ch.zli.m223.ksh19a.se.CRM.repository.KlasseRepository;
import ch.zli.m223.ksh19a.se.CRM.repository.SchuelerRepository;

@Component
public class ServerInitializer implements ApplicationRunner {

	@Autowired
	private KlasseRepository klasseRepository;
	@Autowired
	private SchuelerRepository schuehlerRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		AppKlasse ima = klasseRepository.insert("IM19a");
		schuehlerRepository.insert("peter", ima);
		schuehlerRepository.insert("seter", ima);
		AppKlasse imb = klasseRepository.insert("IM19b");
		schuehlerRepository.insert("leter", imb);
	}

}
