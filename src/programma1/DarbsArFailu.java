package programma1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class DarbsArFailu {
	static void saglabat(Minka runcis, String fNosaukums) {
		try {
			FileWriter fw = new FileWriter(fNosaukums, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(runcis.nolasitAtribututs());
			pw.println("+++++++++++++++++++++++++");
			pw.close();
			JOptionPane.showMessageDialog(null, "Darbi saglabāti failā"+fNosaukums,
					"Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda ierakstot failā!",
					"Kļūda", JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	static void nolasit(String fNosaukums) {
		String teksts, str = "";
		try {
			FileReader fr = new FileReader(fNosaukums);
			BufferedReader br = new BufferedReader(fr);
			while((teksts = br.readLine()) !=null) {
				str += teksts + "\n";
			}
			br.close();
			JOptionPane.showMessageDialog(null, str, "Saglabātie kaķi", JOptionPane.PLAIN_MESSAGE);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kļūda nolasot failu!",
					"Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}
}
