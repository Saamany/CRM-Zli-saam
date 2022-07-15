package ch.zli.m223.ksh19a.se.CRM.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public interface AppKlasse extends UserDetails{
	public Long getId();
	public String getKlasseName();
	public List<Schueler> getSchuehlerNamen();
}
