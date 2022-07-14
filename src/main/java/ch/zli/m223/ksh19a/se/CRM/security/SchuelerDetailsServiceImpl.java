package ch.zli.m223.ksh19a.se.CRM.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.se.CRM.repository.SchuelerRepository;

@Service
public class SchuelerDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SchuelerRepository schuelerRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return (UserDetails) schuelerRepository.findSchuelerBySchuelerName(username).orElseThrow(() -> {
			throw new UsernameNotFoundException(username);
		});
	}

}
