package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;

import model.Invento;
import model.Periodo;

public class FichaInvento extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FichaInvento(Invento invento) {
		setBounds(100, 100, 419, 399);
		getContentPane().setLayout(null);
		
		JLabel lblInvento = new JLabel("INVENTO");
		lblInvento.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInvento.setBounds(151, 12, 130, 31);
		getContentPane().add(lblInvento);
		
		JLabel lblName = new JLabel(invento.getNombre());
		lblName.setForeground(Color.RED);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 71, 388, 15);
		getContentPane().add(lblName);
		
		//Periodo pe = invento.getPeriodo();
		
		JLabel lblPeriodo = new JLabel("pe.getNombre()");
		lblPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriodo.setForeground(Color.BLACK);
		lblPeriodo.setBounds(12, 109, 388, 15);
		getContentPane().add(lblPeriodo);
		
		JLabel lblDescripcion = new JLabel(invento.getDescripcion());
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(12, 143, 388, 78);
		getContentPane().add(lblDescripcion);
		
		JLabel lblInventores = new JLabel("Inventor/es");
		lblInventores.setBounds(12, 237, 93, 15);
		getContentPane().add(lblInventores);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 264, 317, 24);
		getContentPane().add(comboBox);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(341, 264, 59, 25);
		getContentPane().add(btnVer);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(270, 348, 147, 23);
		getContentPane().add(label);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
	}
}
