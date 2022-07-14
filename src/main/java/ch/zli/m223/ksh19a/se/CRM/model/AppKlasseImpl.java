package ch.zli.m223.ksh19a.se.CRM.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "AppKlasse")
public class AppKlasseImpl implements AppKlasse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;
	
	@OneToMany(mappedBy = "appKlasse", cascade = CascadeType.ALL)
	private List<SchuelerImpl> schuehler;
	
	protected AppKlasseImpl() {
		/* for JPA only */
		schuehler = new ArrayList<>();
		
	}

	public AppKlasseImpl(String klasseName) {
		this();
		this.name = klasseName;
	}


	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}


	@Override
	public String getKlasseName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	public void addSchuehlerToList(SchuelerImpl newSchuehler) {
		schuehler.add(newSchuehler);
	}

	@Override
	public List<Schueler> getSchuehlerNamen() {
		// TODO Auto-generated method stub
		return new ArrayList<>(schuehler);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}




	

}
