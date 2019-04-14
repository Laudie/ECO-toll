package Test;

import java.util.Date;
import Ecotoll.Autostrada;
import Ecotoll.Casello;
import Ecotoll.Veicolo;
import Ecotoll.Veicolo_EU;

public class Pedaggio {

	public Casello caselloIn;
	public Casello caselloOut;
	public Date DataIn;
	public Date DataOut;
	public Veicolo veicolo;
	public Veicolo_EU veicolo_eu;
	public double iva=0.22;
	
	
	public Pedaggio(Casello caselloIn, Casello caselloOut, Veicolo veicolo) {
		super();
		this.caselloIn = caselloIn;
		this.caselloOut = caselloOut;
		this.veicolo = veicolo;
	}
	
	
	//Costruttore per veicolo Europeo 2021
	public Pedaggio(Casello caselloIn, Casello caselloOut, Date dataIn, Date dataOut, Veicolo_EU veicolo_eu) {
		super();
		this.caselloIn = caselloIn;
		this.caselloOut = caselloOut;
		DataIn = dataIn;
		DataOut = dataOut;
		this.veicolo_eu = veicolo_eu;
	}


	/*Per ora considero solo percorsi in cui il veicolo entra ed esce nella stessa autostrada
	successivamente in base allo svincolo il pedaggio verrà calcolato in base ad minimo km dalla destinazione
	al casello di arrivo
	Per esempio Roma-Bari verrà preso il percorso più breve anche se sono più i modi di arrivare a Bari da Roma*/
	
	public double calcolapedaggio() {
		
		Autostrada a=caselloIn.codiceAutostrada;
		Autostrada b=caselloOut.codiceAutostrada;
		float d=a.getTariffa();
		double maggiorazione=0;
		
		//calcolo della maggiorazione per la classe
		char c=veicolo.getClasseveicolo();
		
		//maggiorazione in base alla classe del veicolo
		switch(c) {
		case 'B':
			maggiorazione=0.50;
			break;
		case 'C':
			maggiorazione=1.00;
			break;
		case 'D':
			maggiorazione=1.50;
			break;
		case 'E':
			maggiorazione=2.00;
			break;
		default :
			maggiorazione=0.10; //Per classe A 
		}
		
		//Caso stessa autostrada di ingresso e uscita
		if(a.equals(b)){
				float e=(caselloIn.getKm()-caselloOut.getKm());
				if(e<0)
					e*=(-1);
				
				//moltiplico la tariffa base per la maggiorazione 
				d*=maggiorazione;
				
				//moltiplico i km per la tariffa maggiorata
				float totale = e*d;
				
				//System.out.println(totale);
				
				//Aggiungo l'iva
				float Ivaaggiunta= (float) (totale*(iva)) ;
				
				//System.out.println(Ivaaggiunta);
				//System.out.println(Ivaaggiunta + totale);
				double arrotondamento=(Math.round((totale + Ivaaggiunta)*10)/10);
				return arrotondamento;		
				}
		
		return 0;
		
	}
	
	//Metodo per il 2021/2026 quando verrà integrato al pagamento del pedaggio anche
	//il traffico (in base alla fascia oraria di ingresso e uscita, POTREBBE ESSERE UN 'IDEA) ed emissione CO2
	//e nel 2026 anche per i mezzi con E1-E6 METODO DA COMPLETARE e migliorare maggiorazione, emissione CO2
	
	public double calcolapedaggioEU() {
		Autostrada a=caselloIn.codiceAutostrada;
		Autostrada b=caselloOut.codiceAutostrada;
		String eu=veicolo_eu.getCategoria(); //Adesso prendo anche E1.E6
		double CO2=veicolo_eu.getCO2(); //Prendo in considerazione anche l'emissione di CO2
		float d=a.getTariffa();
		char c = veicolo_eu.getClasseveicolo();
		double maggiorazione=0;
		
		//Se il veicolo è entrato tra le 12 e le 19. Ad esempio potrebbe essere un idea da basare al traffico.
		//Ovviamente nelle ore diurne ci sarà maggior traffico rispetto a chi viaggi la notte (camionisti per lavoro per esempio)
		
		if((DataIn.getHours()>12) && (DataOut.getHours()<19)) {
			
			
			//maggiorazione in base alla classe del veicolo
			switch(c) {
			case 'B':
				maggiorazione=0.50*d;
				break;
			case 'C':
				maggiorazione=1.00*d;
				break;
			case 'D':
				maggiorazione=1.50*d;
				break;
			case 'E':
				maggiorazione=2.00*d;
				break;
			default :
				maggiorazione=0.10*d; //Per classe A di default
			}
			
				//calcolo anche la Classe europea E1-E6 dove vado a diminuire la tariffa maggiorata in base alla categoria E1-E6
			switch(eu) {
			case "E6":
				maggiorazione-=1.20;
				break;
			case "E5":
				maggiorazione-=1.00;
				break;
			case "E4":
				maggiorazione-=0.90;
				break;
			case "E3":
				maggiorazione-=0.70;
				break;
			case "E2":
				maggiorazione-=0.50;
				break;
			default :
				maggiorazione-=0.30; //Per categoria E1 di default
			}
			
					if(a.equals(b)){
						float e=(caselloIn.getKm()-caselloOut.getKm());
						if(e<0)
							e*=(-1);
						
						float totale = (float) (e*maggiorazione);
						float Ivaaggiunta= (float) (totale*(iva)) ;
						return (totale+Ivaaggiunta);		
						}
				}
				
		return 0;

	}

}
