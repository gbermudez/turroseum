package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import org.jdesktop.swingx.autocomplete.*;

import org.jdesktop.swingx.combobox.*;
import org.jdesktop.swingx.decorator.*;

public class Busqueda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busqueda() {
		setResizable(false);
		setTitle("Turroseum v.1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Ingrese datos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 44, 727, 55);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(39, 193, 727, 55);
		comboBox.setEditable(true);
		comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "alejandro", "berenice", "juan", "ana", "bartolo", "diana", "cesar" }));
		comboBox.setName("comboBox");
		
		AutoCompleteDecorator.decorate(comboBox);
		contentPane.add(comboBox);
		
		
		
		
		JRadioButton rdbtnInventor = new JRadioButton("Inventor");
		rdbtnInventor.setBounds(682, 107, 84, 23);
		contentPane.add(rdbtnInventor);
		
		JRadioButton rdbtnInvento = new JRadioButton("Invento");
		rdbtnInvento.setSelected(true);
		rdbtnInvento.setBounds(594, 107, 84, 23);
		contentPane.add(rdbtnInvento);
	}
}
