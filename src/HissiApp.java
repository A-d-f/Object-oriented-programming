import java.util.Scanner;

public class HissiApp {

	public static void main(String[] args) {
		
	Scanner in = new Scanner(System.in); //luodaan "in" niminen olio
	String vastaus;
		
	Hissi hissi= new Hissi(); //tässä on luodaan yksi hissi
	//hissi.kerros=1000; kun Hissi on public, voidaan asettaa arvo, eli voidaan määrittää kerros
	//hissi.tulostaTiedot(); tulosta tiedot muutettiin privateksi
	
	hissi.setKerros(4);
	
	System.out.println("Hissin kerros: " +hissi.getKerros());
	
	do {
	System.out.println("y/a/p");
	vastaus = in.nextLine();
	if (vastaus.equals("y") || vastaus.equals("a")) {
		hissi.meneYlosAlas(vastaus);
	}
	
	} while (!vastaus.equals("p"));
	System.out.println("poistuit hissistä!");

	}

} // HissiApp-luokka loppuu

class Hissi {

	private int kerros; //näkyvä attribuutti //"tämä muutettiin privateksi
	private int minKerros;
	private int maxKerros;
	
	//kerrokset setteri:
	public void setKerros(int haluttuKerros) {
		
		//yksinkertainen validointi
		if(haluttuKerros >= minKerros && haluttuKerros <= maxKerros)
		{
			kerros = haluttuKerros;
		}
		
	}
	

	
	//kerroksen getteri:
	
	public int getKerros()
	{
		return kerros;
	}
	
	public Hissi() { //oletuskonstruktori
		kerros = 1;
		minKerros = -1;
		maxKerros = 4;
	}

	private void tulostaTiedot() { //tietojen tulostaminen
		System.out.println("HISSI");
		System.out.println("kerros: " + kerros);
	}

	public void meneYlosAlas(String suunta) { //hissin "painikkeet"-olio, eli käyttöliittymä
		if (suunta.equals("y") && kerros<=3) {
			kerros++;
		} else if (suunta.equals("a") && kerros>-1) {
			kerros--;
		}
		tulostaTiedot();
	}
}
