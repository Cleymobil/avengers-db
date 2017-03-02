package io.avengers.ui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;

public class HomePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePanel() {
		//setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));

		JPanel homePicturePanel = new JPanel();
		JLabel image = new JLabel( new ImageIcon( "C:\\code\\workspace\\avengers-db\\AvengersHome3.png"));
		homePicturePanel.setLayout(new BorderLayout());
		homePicturePanel.add(image, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		homePicturePanel.add(panel, BorderLayout.CENTER);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);

	}

}
