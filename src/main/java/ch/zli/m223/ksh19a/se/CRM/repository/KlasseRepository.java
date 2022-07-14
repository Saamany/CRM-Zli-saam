package ch.zli.m223.ksh19a.se.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;
import ch.zli.m223.ksh19a.se.CRM.model.AppKlasseImpl;

public interface KlasseRepository extends JpaRepository<AppKlasseImpl, Long> {

	default AppKlasse insert(String klasseName) {
		AppKlasseImpl klasse = new AppKlasseImpl(klasseName);
		return save(klasse);
	}

	Optional<AppKlasseImpl> findKlasseByKlasseName(String klassename);

}
