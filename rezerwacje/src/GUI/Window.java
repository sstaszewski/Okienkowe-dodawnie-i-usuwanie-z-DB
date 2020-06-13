package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.ObslugaDB;

public class Window extends JFrame {
	public Window() {
		JTextField wybranyDzien = new JTextField();
		JPanel mainPanel = new JPanel();
		JButton pokazPokoje = new JButton("Pokaz dostepne pokoje");
		setSize(300, 300);
		setLocation(100, 100);
		setTitle("rezerwacja");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pokazPokoje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel wyborPokoiPanel = new JPanel();
				// wywala liste dostepnych pokoi
				// for

				JComboBox listaDostepnychPokoi;
				listaDostepnychPokoi = new JComboBox(ObslugaDB.wyswietlDostepnePokoje());
				
				for (int i = 0; i < 7; i++) {
					JButton button = new JButton();
				}

				// JLabel saved= new JLabel("zarezerwowano");

				mainPanel.setVisible(true);

//				wyborPokoiPanel.add(saved);
				add(wyborPokoiPanel);
			}
		});
		mainPanel.add(wybranyDzien);
		mainPanel.add(pokazPokoje);
		add(mainPanel);
	}

}
