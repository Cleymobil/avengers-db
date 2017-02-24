package io.avengers.ui;

import javax.swing.JPanel;

import io.avengers.domain.Hero;

import javax.swing.JLabel;

import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;

public class HeroPanel extends JPanel {
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public HeroPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JLabel lblName = new JLabel("Name");
		panel.add(lblName);


	}

	public void addHeroes(Set<Hero> heroes) {
		for (Hero hero : heroes) {
			JLabel label = new JLabel(hero.getName());
			getPanel().add(label);

		}
	}

	public JPanel getPanel() {
		return panel;
	}
}
