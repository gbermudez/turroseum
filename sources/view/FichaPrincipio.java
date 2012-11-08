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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;

import com.sun.net.ssl.internal.www.protocol.https.Handler;

import model.Invento;
import model.Inventor;
import model.Periodo;
import model.Principio;
import model.SQLHandler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class FichaPrincipio extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FichaPrincipio(final Principio principio) throws SQLException, IOException {
		setResizable(false);
		setModal(true);
		
		final SQLHandler handler = new SQLHandler();

		setBounds(100, 100, 419, 388);
		getContentPane().setLayout(null);
		
		JLabel lblInvento = new JLabel("PRINCIPIO");
		lblInvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvento.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInvento.setBounds(12, 12, 388, 31);
		getContentPane().add(lblInvento);
		
		JLabel lblName = new JLabel(principio.getNombre());
		lblName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblName.setForeground(Color.RED);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 71, 388, 15);
		getContentPane().add(lblName);
		
		JLabel lblDescripcion = new JLabel(principio.getDescripcion());
		lblDescripcion.setForeground(Color.DARK_GRAY);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(12, 143, 388, 42);
		getContentPane().add(lblDescripcion);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(270, 338, 147, 15);
		getContentPane().add(label);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(12, 191, 388, 135);
		getContentPane().add(lblImagen);
		
		lblImagen.setIcon(handler.getImagen(principio.getId()));
		
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		
		setVisible(true);
	}
}
