package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Inventor;
import model.Parte;

import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.SwingConstants;

public class FichaParte extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public FichaParte(final Parte parte) {
		setModal(true);
		setBounds(100, 100, 437, 216);
		
		setResizable(false);
		setTitle("Turroseum v1.0 ");
		getContentPane().setLayout(null);
		
		JLabel lblInventor = new JLabel("PARTE");
		lblInventor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInventor.setBounds(168, 12, 83, 31);
		getContentPane().add(lblInventor);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(288, 157, 147, 23);
		getContentPane().add(label);
		
		JLabel descripcion = new JLabel(parte.getNombre());
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		descripcion.setForeground(Color.GRAY);
		descripcion.setBounds(24, 95, 388, 50);
		getContentPane().add(descripcion);
		
		JLabel nombre = new JLabel(parte.getDescripcion());
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		nombre.setForeground(Color.RED);
		nombre.setFont(new Font("Dialog", Font.BOLD, 18));
		nombre.setBounds(24, 57, 388, 15);
		getContentPane().add(nombre);
		
		setVisible(true);
		
	}
}
