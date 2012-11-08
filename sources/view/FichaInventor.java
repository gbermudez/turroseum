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
import java.awt.Dialog.ModalityType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class FichaInventor extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public FichaInventor(final Inventor inventor) {
		setModal(true);
		setBounds(100, 100, 437, 288);
		
		setResizable(false);
		setTitle("Turroseum v1.0 | INVENTORES | " + inventor.getNombre());
		getContentPane().setLayout(null);
		
		JLabel lblInventor = new JLabel("INVENTOR");
		lblInventor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInventor.setBounds(148, 12, 130, 31);
		getContentPane().add(lblInventor);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.RED);
		lblNombre.setBounds(12, 68, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblAnioDeNacimiento = new JLabel("Anio De Nacimiento:");
		lblAnioDeNacimiento.setForeground(Color.RED);
		lblAnioDeNacimiento.setBounds(12, 111, 148, 15);
		getContentPane().add(lblAnioDeNacimiento);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar De Nacimiento:");
		lblLugarDeNacimiento.setForeground(Color.RED);
		lblLugarDeNacimiento.setBounds(12, 151, 165, 15);
		getContentPane().add(lblLugarDeNacimiento);
		
		JLabel namelbl = new JLabel(inventor.getNombre());
		namelbl.setBounds(83, 68, 342, 15);
		getContentPane().add(namelbl);
		
		JLabel nacilbl = new JLabel(String.valueOf(inventor.getAnioN()));
		nacilbl.setBounds(168, 111, 268, 15);
		getContentPane().add(nacilbl);
		
		JLabel lugarlbl = new JLabel(inventor.getLugarN());
		lugarlbl.setBounds(179, 151, 246, 15);
		getContentPane().add(lugarlbl);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(289, 237, 147, 23);
		getContentPane().add(label);
		
		JButton btnNewButton = new JButton("Inventores Contemporaneos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new InventoresContemporaneos(inventor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(83, 200, 246, 25);
		getContentPane().add(btnNewButton);
		
		setVisible(true);
		
	}
}
