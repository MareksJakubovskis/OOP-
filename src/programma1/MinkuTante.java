package programma1;

import javax.swing.JOptionPane;

public class MinkuTante {

	public static void main(String[] args) {
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
		}
	}	

}
