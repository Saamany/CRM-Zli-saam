package ch.zli.m223.ksh19a.se.CRM.model;

public interface AppKurs {
	public Long getId();
	public String getKursName();
	public AppKlasse getKlasse();
	public Lehrer getLehrer();
	//public List<Schuehler> getSchuehlerNamen();
}
