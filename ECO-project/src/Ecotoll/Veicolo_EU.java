package Ecotoll;

public class Veicolo_EU extends Veicolo{

	public Veicolo_EU(String modello, String marca, int anno, String targa, float peso, float altezza,
			int asse, char classeveicolo) {
		super(modello, marca, anno, targa, peso, altezza, asse, classeveicolo);
		// TODO Auto-generated constructor stub
	}

	public String categoria;
	public double CO2 ;

	public Veicolo_EU(String modello, String marca, int anno, String targa, float peso, float altezza, int asse,
			char classeveicolo, String categoria, double cO2) {
		super(modello, marca, anno, targa, peso, altezza, asse, classeveicolo);
		this.categoria = categoria;
		CO2 = cO2;
	}

	public double getCO2() {
		return CO2;
	}

	public void setCO2(double cO2) {
		CO2 = cO2;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Veicolo_EU [categoria=" + categoria + ", CO2=" + CO2 + "]";
	}


	

	
}
