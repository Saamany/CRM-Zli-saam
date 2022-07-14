package ch.zli.m223.ksh19a.se.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.se.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.se.CRM.exception.UserAlreadyExistsException;
import ch.zli.m223.ksh19a.se.CRM.exception.UserNotFoundException;
import ch.zli.m223.ksh19a.se.CRM.model.AppKlasse;
import ch.zli.m223.ksh19a.se.CRM.repository.KlasseRepository;

@Service
public class KlasseServiceImpl implements KlasseService {

	@Autowired
	private KlasseRepository klasseRepository;

	@Override
	public List<AppKlasse> getAllKlassen() {
		return new ArrayList<>(klasseRepository.findAll());
	}

	@Override
	public AppKlasse getKlasse(long id) {

		return klasseRepository.findById(id).orElseThrow(() -> {
			throw new UserNotFoundException("Invalid User ID");
		});
	}

	@Override
	public AppKlasse insertKlasse(String klasseName) {
		if (klasseName == null)
			throw new InvalidArgumentException("Name must not be null");
		{

			// if(user with userName exists) throw new UserAllreadyExistsException("jddj");
			if (klasseRepository.findKlasseByKlasseName(klasseName).isPresent()) {// if not null
				throw new UserAlreadyExistsException("User with name" + klasseName + "already exists");
			}

		}
		return klasseRepository.insert(klasseName);
	}

	@Override
	public void deleteKlasseById(Long id) {
		// TODO Auto-generated method stub
		if(id == null) {
			throw new InvalidArgumentException("Name must be null");
		}
	}
}
