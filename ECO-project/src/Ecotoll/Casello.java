package Ecotoll;

public class Casello implements Comparable {

	public Autostrada codiceAutostrada;
	public String nome;
	public float km;
	
	
	public Autostrada getCodiceAutostrada() {
		return codiceAutostrada;
	}
	
	
	public void setCodiceAutostrada(Autostrada codiceAutostrada) {
		this.codiceAutostrada = codiceAutostrada;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getKm() {
		return km;
	}
	
	
	public void setKm(float km) {
		this.km = km;
	}
	
	
	public Casello(Autostrada codiceAutostrada, String nome, float km) {
		
		this.codiceAutostrada = codiceAutostrada;
		this.nome = nome;
		this.km = km;
	}
	
	
    //Method equals
    
    @Override
	public String toString() {
		return "Casello [codiceAutostrada=" + codiceAutostrada + ",  nome=" + nome + ", km="
				+ km + "]";
	}
	public boolean equals(Object o){
        if (o instanceof Casello){
            return (((Casello)o).codiceAutostrada == codiceAutostrada);
        }
        else {
             return false;
             }
        
    }


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		
		if (this.km<(((Casello) o).getKm())) return 1;
			
		return 0;

	}

	
	
}
