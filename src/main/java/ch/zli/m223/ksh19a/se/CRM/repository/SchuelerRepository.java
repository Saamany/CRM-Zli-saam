package ch.zli.m223.ksh19a.se.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;
import ch.zli.m223.ksh19a.se.CRM.model.AppKlasseImpl;
import ch.zli.m223.ksh19a.se.CRM.model.Schueler;
import ch.zli.m223.ksh19a.se.CRM.model.SchuelerImpl;

public interface SchuelerRepository extends JpaRepository<SchuelerImpl, Long> {
	
	default Schueler insert(String schuehlerName, AppKlasse appKlasse) {
		//Cast to Impl
		AppKlasseImpl klasseImpl=(AppKlasseImpl)appKlasse;
		
		//Create new Role
		SchuelerImpl newSchuehler= new SchuelerImpl(schuehlerName, klasseImpl);
		
		//save Role to DB
		SchuelerImpl savedNewSchuehler = save(newSchuehler);
		
		//Update users role list
		klasseImpl.addSchuehlerToList(savedNewSchuehler);
		
		//retrn new role
		return savedNewSchuehler;
	}
	
	Optional<SchuelerImpl> findSchuelerBySchuelerName(String schuelerName);
	

}
