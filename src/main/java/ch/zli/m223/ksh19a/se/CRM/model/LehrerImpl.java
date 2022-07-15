package ch.zli.m223.ksh19a.se.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Lehrer")
public class LehrerImpl implements Lehrer{
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String lehrerName;
	@ManyToOne
	private AppKursImpl appKurs;
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getLehrerName() {
		// TODO Auto-generated method stub
		return lehrerName;
	}
	
	protected LehrerImpl() {
		/*
		 * for JPA only
		 */
	}
	
	public LehrerImpl(String lehrerName, AppKursImpl appKurs) {
		this.lehrerName = lehrerName;
		this.appKurs = appKurs;
	}



	
	

}
