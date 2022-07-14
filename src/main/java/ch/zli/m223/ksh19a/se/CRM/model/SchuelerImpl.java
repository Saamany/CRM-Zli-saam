package ch.zli.m223.ksh19a.se.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Schuehler")
public class SchuelerImpl implements Schueler{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String schuehlerName;
	@ManyToOne
	private AppKlasseImpl appKlasse;
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getSchuehlerName() {
		// TODO Auto-generated method stub
		return schuehlerName;
	}
	
	protected SchuelerImpl() {
		/*
		 * for JPA only
		 */
	}
	
	public SchuelerImpl(String schuehlerName, AppKlasseImpl appKlasse) {
		this.schuehlerName = schuehlerName;
		this.appKlasse = appKlasse;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
