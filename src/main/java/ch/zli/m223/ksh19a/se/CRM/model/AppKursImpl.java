package ch.zli.m223.ksh19a.se.CRM.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "AppKurs")
public class AppKursImpl implements AppKurs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String kursName;
	
	@OneToOne(mappedBy = "appKurs", cascade = CascadeType.ALL)
	private LehrerImpl lehrer;
	/*
	 * @Column(unique = true)
	 * private String klasseName;
	 */
	
	@OneToOne
	private AppKlasseImpl klasse;
	
	protected AppKursImpl() {
		/* for JPA only */
		
	}

	public AppKursImpl(String kursName) {
		this.kursName = kursName;
		//this.klasseName = klasseName;
	}

	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getKursName() {
		// TODO Auto-generated method stub
		return kursName;
	}

	@Override
	public AppKlasseImpl getKlasse() {
		return klasse;
	}

	@Override
	public Lehrer getLehrer() {
		// TODO Auto-generated method stub
		return lehrer;
	}
	
	

	




	

}
