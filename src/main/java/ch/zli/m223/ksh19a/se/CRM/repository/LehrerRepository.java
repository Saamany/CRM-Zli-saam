package ch.zli.m223.ksh19a.se.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.se.CRM.model.AppKurs;
import ch.zli.m223.ksh19a.se.CRM.model.AppKursImpl;
import ch.zli.m223.ksh19a.se.CRM.model.LehrerImpl;
import ch.zli.m223.ksh19a.se.CRM.model.Schueler;
import ch.zli.m223.ksh19a.se.CRM.model.SchuelerImpl;

public interface LehrerRepository extends JpaRepository<LehrerImpl, Long> {
	
	default Schueler insert(String schuehlerName, AppKurs appKurs) {
		//Cast to Impl
		AppKursImpl kursImpl=(AppKursImpl)appKurs;
		
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
