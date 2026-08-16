package programma1;

import java.io.File;
import java.time.Year;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class MinkuTante {
	
	static int skaitlaParbaude(String zinojums, int min, int max) {
		String ievade;
		int skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(zinojums, min);
			if(ievade == null)
				return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < min || skaitlis > max) {
					JOptionPane.showMessageDialog(null, "Norādītais skaitlis ir nederīgā intervālā!", "Nekorekti dati!", JOptionPane.ERROR_MESSAGE);
					continue;
				}
				return skaitlis;
				
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadīts vesels skaitlis!", "Nekorekti Dati!", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
			
	
	static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null)
				return null;
			
			virkne = virkne.trim(); 
		} while (!Pattern.matches("^[\\p{L} ]+$", virkne));
		
		return virkne;
	}

	public static void main(String[] args) {
		/*
		Minka muris = new Minka("Muris", "Siāms", "Pelēks", "Ruta", 2012, true, "Image20260803210340.png" );
		
		
		
		muris.murrat();
		muris.pabarot("Cīsiņi");
		muris.gulet("sedziņa");
		muris.palielinatvecumu();
		muris.nolasitVecumu();
		for(int i=0; i<3; i++ ) {
		muris.medit(); 
		
		}
		Minka loto = new Minka("Loto", "Meinkūns", "Melns", "Ritvars", 2012, false, "Loto.png" );
		JOptionPane.showMessageDialog(null, loto.nolasitAtribututs(), "Atribūti", JOptionPane.INFORMATION_MESSAGE);
		loto.nolasitAtribututs();
		for(int i=0; i<3; i++) {
		loto.medit();
		*/
		String izvele, failaNosaukums = System.getProperty("user.home")
				+ File.separator + "Desktop" + File.separator+ "minkas.txt";
		Minka runcis = null;
		String[] darbibuSaraksts = {"Izveidot kaķi", "Izsaukt metodi", "Saglabāt failā",
				"Apskatīt failā", "Apskatīt saglabāto failu", "Apturēt programmu"};
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, 
					"Izvēlies darbību", "Darbību izvēle", JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, darbibuSaraksts[0]);
			if(izvele == null)
				izvele = "Apturēt programmu";
			
			switch(izvele) {
			case "Izveidot kaķi":
				String minkasV, skirne, spalvasK, saimnieks, cels;
				int dzGads = 0;
				boolean siksnina;
				
				minkasV = virknesParbaude("Ievadi kaķa vārdu", "Rudis");
				spalvasK = virknesParbaude("Kādā krāsā kaķim kažoks", "Ruds");
				saimnieks = virknesParbaude("Kā sauc kaķa saimnieku", "Mirdza");
				skirne = virknesParbaude("Kāda ir kaķa šķirne?", "Meinkūns");
				cels = virknesParbaude("Ievadi bildes nosaukumu", "rudis");
				dzGads = skaitlaParbaude("Norādi kaķa dzimšanas gadu!", (Year.now().getValue()-19), Year.now().getValue());
				int poga = JOptionPane.showConfirmDialog(null, "Vai kaķim ir siksniņa?", "Kaķa siksniņa",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				siksnina = (poga == 0) ? true : false;
				
				runcis = new Minka(minkasV, skirne, spalvasK, saimnieks,
						dzGads, siksnina, cels);
				
				break;
				
			case "Saglabāt failā":
				DarbsArFailu.saglabat(runcis, failaNosaukums);
				break;
			
			case "Apskatīt saglabāto failu":
				DarbsArFailu.nolasit(failaNosaukums);
				break;
				
			case "Apturēt programmu":
				JOptionPane.showMessageDialog(null, "Programma apturēta", "Uz tikšanos",
						JOptionPane.INFORMATION_MESSAGE);
				
				
				break;
				
				
				
			case "Izsaukt metodi":
				String[] metozuSaraksts = {"Paglaudīt", "Nolasīt Atribūtus",
						"Pabarot", "Nolikt gulēt", "Palielināt vecumu", "Apskatīt vecumu",
						"Medīt"};
				String metodes = (String) JOptionPane.showInputDialog(null, "Izvēlies metodi",
						"Metožu izvēle", JOptionPane.QUESTION_MESSAGE, null, metozuSaraksts, metozuSaraksts[0]);
				
				if(metodes == null)
					break;
				
			
				
				switch(metodes) {
				case "Paglaudīt":
					runcis.murrat();
					break;
					
				case "Nolasīt Atribūtus":
					JOptionPane.showMessageDialog(null, runcis.nolasitAtribututs(),
							"Kaķa atribūti", JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "Pabarot":
					String atbilde = runcis.pabarot(virknesParbaude("Ar ko pabarot kaķi?", "Desa"));
					JOptionPane.showMessageDialog(null, "Kaķis atgriež " + atbilde, "Informācija",
							JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "Nolikt gulēt":
					String prieksmets = virknesParbaude("Ko dosi kaķim līdzi uz migu?", "Spilvens");
					if(prieksmets == null || prieksmets.isEmpty())
						runcis.gulet();
					else 
						runcis.gulet(prieksmets);						
					break;
					
				case "Palielināt vecumu":
					runcis.palielinatvecumu();
					break;
					
				case "Apskatīt vecumu":
					runcis.nolasitVecumu();
					break;
					
				case "Medīt":
					runcis.medit();
					break;
									
									
					
				}
				
				}
 				
				
			
	
			
			
		} while (!izvele.equals("Apturēt programmu"));
	}	

}
