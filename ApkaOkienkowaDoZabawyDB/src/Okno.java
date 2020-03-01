import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.activation.CommandInfo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Okno extends JFrame {

	Okno() {

		JPanel p = new JPanel();
		JLabel tekst = new JLabel("Co chcesz zrobiæ?");
		JButton przycisk;
		JComboBox lista;
		String[] tablica = { "dodaj", "usuñ" };

		setSize(400, 100);
		setLocation(100, 100);
		setTitle("zabawa DB");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		przycisk = new JButton("Click");
		lista = new JComboBox(tablica);
		// p.setLayout(new FlowLayout(1));
		// p.setLayout(new GridLayout(1, 2));

		przycisk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String napis = (String) lista.getSelectedItem();
				System.out.println(napis);
				if (napis.contains("dodaj")) {
					JPanel p1 = new JPanel();
					JTextField im, nazw, wie;
					JButton click = new JButton("Dodaj!");
					JLabel imieTxt = new JLabel("podaj imiê");
					JLabel nazwiskoTxt = new JLabel("podaj nazwisko");
					JLabel wiekTxt = new JLabel("podaj wiek");
					im = new JTextField(10);
					nazw = new JTextField(10);
					wie = new JTextField(10);
					click.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String imie = im.getText();
							String nazwisko = nazw.getText();
							String wiek = wie.getText();
							ObslugaDB.createConnection();
							ObslugaDB.dodajDoDB(ObslugaDB.createConnection(), imie, nazwisko, wiek);
						}
					});
					setSize(400, 400);
					p1.setLocation(400, 200);
					p1.setLocation(200, 200);
					p1.setLayout(new GridLayout(5, 5));
					p1.add(im);
					p1.add(imieTxt);
					p1.add(nazw);
					p1.add(nazwiskoTxt);
					p1.add(wie);
					p1.add(wiekTxt);
					p1.add(click);
					add(p1);
				} else {
					JPanel p1 = new JPanel();
					JComboBox listaUsun;
					String[] tablicaUsun = {};
					JTextField lpField;
					lpField = new JTextField(5);
					JButton click = new JButton("Click");
					JLabel lpTxt = new JLabel("podaj nr ucznia");
					p.setSize(350, 350);
					p.setLocation(200, 200);
					listaUsun = new JComboBox(ObslugaDB.uczniowieZDB(ObslugaDB.createConnection()));
					click.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String lp1 = (String) listaUsun.getSelectedItem();
							String nowy = "";
							for (int j = 0; j < lp1.length(); j++) {
								if (lp1.charAt(j) >= '0' && lp1.charAt(j)<= '9') {
									nowy += Character.toString(lp1.charAt(j));
								} else {
									break;
								}
							}
							System.out.println(nowy);
							ObslugaDB.createConnection();
							ObslugaDB.usunZDB(ObslugaDB.createConnection(), nowy);
						}
					});
					// for(int i=0;i<tablicaUsun.length;i++){
					// tablicaUsun[i]="";
					// }
					// listaUsun = new
					// JComboBox(ObslugaDB.uczniowieZDB(ObslugaDB.createConnection(),
					// tablicaUsun));
					setSize(400, 200);
					p1.setLocation(200, 200);
					p1.setLayout(new GridLayout(4, 4));
					p1.add(lpField);
					p1.add(lpTxt);
					p1.add(listaUsun);

					p1.add(click);
					add(p1);
				}
			}
		});
		p.setBackground(Color.pink);
		p.add(tekst);
		p.add(lista);
		p.add(przycisk);
		add(p);
	}
}