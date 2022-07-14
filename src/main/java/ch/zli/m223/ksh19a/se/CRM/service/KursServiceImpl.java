












package ch.zli.m223.ksh19a.se.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.se.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.se.CRM.exception.UserAlreadyExistsException;
import ch.zli.m223.ksh19a.se.CRM.exception.UserNotFoundException;
import ch.zli.m223.ksh19a.se.CRM.model.AppKurs;
import ch.zli.m223.ksh19a.se.CRM.repository.KursRepository;

@Service
public class KursServiceImpl implements KursService{
	@Autowired
	private KursRepository kursRepository;
	
	@Override
	public List<AppKurs> getAllKurse() {
		return new ArrayList<>(kursRepository.findAll());
		
	}

	@Override
	public AppKurs getKurse(long id) {
		// TODO Auto-generated method stub
		return kursRepository.findById(id).orElseThrow(() -> {
			throw new UserNotFoundException("Invalid User ID");
		});
	}

	@Override
	public AppKurs insertKurse(String kursName, String klasseName) {
		// TODO Auto-generated method stub
		if (kursName == null)
			throw new InvalidArgumentException("Name must not be null");
		{

			// if(user with userName exists) throw new UserAllreadyExistsException("jddj");
			if (kursRepository.findKursByKursName(kursName).isPresent()) {// if not null
				throw new UserAlreadyExistsException("User with name" + kursName + "already exists");
			}

		}
		return (AppKurs) kursRepository.insert(kursName, klasseName);
	}

	@Override
	public void deleteKursById(Long id) {
		// TODO Auto-generated method stub
		if(id == null) {
			throw new InvalidArgumentException("Name must be null");
		}
	}

}
