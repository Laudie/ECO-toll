package Ecotoll;

public class Veicolo {
	
	public String modello;
	public String marca;
	public int anno;
	public String targa;
	public float peso;
	public float altezza;
	public int asse;
	public char classeveicolo;
	

	public int getAsse() {
		return asse;
	}
	public void setAsse(int asse) {
		this.asse = asse;
	}
	public char getClasseveicolo() {
		return classeveicolo;
	}
	public void setClasseveicolo(char classeveicolo) {
		this.classeveicolo = classeveicolo;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltezza() {
		return altezza;
	}
	public void setAltezza(float altezza) {
		this.altezza = altezza;
	}
	
	
	public Veicolo(String modello, String marca, int anno, String targa, float peso, float altezza, int asse,
			char classeveicolo) {
		super();
		this.modello = modello;
		this.marca = marca;
		this.anno = anno;
		this.targa = targa;
		this.peso = peso;
		this.altezza = altezza;
		this.asse = asse;
		this.classeveicolo = classeveicolo;
	}
	
	
	@Override
	public String toString() {
		return "Veicolo [modello=" + modello + ", marca=" + marca + ", anno=" + anno + ", targa=" + targa + ", peso="
				+ peso + ", altezza=" + altezza + ", asse=" + asse + ", classeveicolo=" + classeveicolo + "]";
	}
	
	

}
