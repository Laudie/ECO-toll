package Test;

import Ecotoll.Autostrada;
import Ecotoll.Casello;
import Ecotoll.Veicolo;
import Ecotoll.Veicolo_EU;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Aggiunta veicoli
	     Veicolo v1 = new Veicolo("AUDI a4","AUDI",2015,"PA239JN",15, (float) 1.20,2, 'A');
	     Veicolo v2 = new Veicolo("FIAT 500X","FIAT",2018,"ED457JS",(float)25.7, (float) 1.90,2,'B');
	     Veicolo v4 = new Veicolo("FIAT ","FIAT",2018,"JS67HN",(float)25.7, (float) 1.70, 2, 'C');
	     
	     
	     //Aggiunta veicoli E1-E6 per con emissione CO2 per 2026
	     Veicolo_EU v5 = new Veicolo_EU("FIAT19","FIAT",2015,"DF345HJ",(float)1.5, (float) 1.20, 2,'A',"E1",100);
	     Veicolo_EU v6 = new Veicolo_EU("FIAT","FIAT",2015,"DF345HJ",(float)1.5, (float) 1.20, 2,'A',"E1",259);
	     Veicolo_EU v7 = new Veicolo_EU("AUDI","audi",2015,"DF345HJ",(float)1.5, (float) 1.20, 2,'A',"E1",233.9);
	     
	     
	     //Aggiunta 3 autostrade (a24,a25,a2)
	     Autostrada a1 = new Autostrada("a24",(float)1.50,"Val Vomano-Basciano","Roma",(float) 158.3, null);
	     Autostrada a2 = new Autostrada("a2",(float)1.90,"Milano","Roma",(float) 448.3, null);
	     
	     
	     //Aggiunta dei caselli nell'autostrada corrispondente
	     a1.addCasello(a1, "Colledara",(float)15); 
	     a1.addCasello(a1, "L'Aquila Ovest", (float)45);
	     
	     
	     //Aggiungo prima i caselli poi li aggiungo nella lista dei caselli in Autostrada
	     Casello c4 = new Casello(a2,"Milano",(float)8);
	     a2.addCasello(c4);
	     Casello c3 = new Casello(a2,"Roma",(float)440);
	     a2.addCasello(c3);
	     Casello c5 = new Casello(a1,"Assergi",(float)50);
	     a1.addCasello(c5);
	     Casello c6 = new Casello(a1,"Roma",(float)344);
	     a1.addCasello(c6); 
	     Casello c7 = new Casello(a1,"L'Aquila Est",(float)59.7);
	     a1.addCasello(c7);
	     
	     
	     //Pedaggio da veicoli v1,v2,v4
		 Pedaggio p1 = new Pedaggio(c5,c6,v1);
	     Pedaggio p2 = new Pedaggio(c6,c7,v2);
	     Pedaggio p3 = new Pedaggio(c4,c3,v4);
	     
	     System.out.println(p1.calcolapedaggio() + " €");
	     System.out.println(p2.calcolapedaggio() + " €");
	     System.out.println(p3.calcolapedaggio() + " €");
	}


}


