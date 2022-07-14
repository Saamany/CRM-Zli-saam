package ch.zli.m223.ksh19a.se.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.se.CRM.model.AppKurs;
import ch.zli.m223.ksh19a.se.CRM.model.AppKursImpl;

public interface KursRepository extends JpaRepository<AppKursImpl, Long>{
	default AppKurs insert(String kursName, String klasseName) {
		AppKursImpl kurs = new AppKursImpl(kursName);
		return save(kurs);
	}

	Optional<AppKursImpl> findKursByKursName(String kursName);
}
