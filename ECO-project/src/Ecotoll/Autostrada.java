package Ecotoll;

import java.util.TreeSet;


public class Autostrada {

	public String codiceAutostrada;
	public float tariffa;
	public String luogoInizio;
	public String luogoFine;
	public float lunghezza;
	TreeSet<Casello> caselliList ;
	
	
	
	
	public String getLuogoInizio() {
		return luogoInizio;
	}
	public void setLuogoInizio(String luogoInizio) {
		this.luogoInizio = luogoInizio;
	}
	public String getLuogoFine() {
		return luogoFine;
	}
	public void setLuogoFine(String luogoFine) {
		this.luogoFine = luogoFine;
	}
	public float getlunghezza() {
		return lunghezza;
	}
	public void setlunghezza(float lunghezza) {
		this.lunghezza = lunghezza;
	}
	public String getCodiceAutostrada() {
		return codiceAutostrada;
	}
	public void setCodiceAutostrada(String codiceAutostrada) {
		this.codiceAutostrada = codiceAutostrada;
	}
	public float getTariffa() {
		return tariffa;
	}
	public void setTariffa(float tariffa) {
		this.tariffa = tariffa;
	}
	public TreeSet<Casello> getCaselliList() {
		return caselliList;
	}
	public void setCaselliList(TreeSet<Casello> caselliList) {
		this.caselliList = caselliList;
	}
	
	public Autostrada(String codiceAutostrada, float tariffa, String luogoInizio, String luogoFine, float lunghezza,
			TreeSet<Casello> caselliList) {
		super();
		this.codiceAutostrada = codiceAutostrada;
		this.tariffa = tariffa;
		this.luogoInizio = luogoInizio;
		this.luogoFine = luogoFine;
		this.lunghezza = lunghezza;
		this.caselliList= new TreeSet<Casello>();
	}
	
	
	@Override
	public String toString() {
		return "Autostrada [codiceAutostrada=" + codiceAutostrada + ", tariffa=" + tariffa + ", luogoInizio="
				+ luogoInizio + ", luogoFine=" + luogoFine + ", lunghezza=" + lunghezza + ", caselliList=" + caselliList + "]";
	}
	

	public boolean addCasello(Autostrada autostrada, String nome, float km) {
		Casello casello = new Casello (autostrada, nome, km);
		 return caselliList.add(casello);	
	}
	
	public boolean addCasello(Casello c) {
		return caselliList.add(c);	
	}
}
