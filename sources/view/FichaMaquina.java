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
import model.Parte;
import model.Periodo;
import model.Principio;
import model.SQLHandler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class FichaMaquina extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FichaMaquina(final Invento invento) throws SQLException {
		setResizable(false);
		setModal(true);
		
		final SQLHandler handler = new SQLHandler();

		setBounds(100, 100, 419, 541);
		getContentPane().setLayout(null);
		
		JLabel lblInvento = new JLabel("MAQUINA");
		lblInvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvento.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInvento.setBounds(12, 12, 388, 31);
		getContentPane().add(lblInvento);
		
		JLabel lblName = new JLabel(invento.getNombre());
		lblName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblName.setForeground(Color.RED);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 71, 388, 15);
		getContentPane().add(lblName);
			
		
		
		
		JLabel lblPeriodo = new JLabel(invento.getPeriodo().getNombre());
		lblPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriodo.setForeground(Color.GRAY);
		lblPeriodo.setBounds(12, 109, 388, 15);
		getContentPane().add(lblPeriodo);
		
		JLabel lblDescripcion = new JLabel(invento.getDescripcion());
		lblDescripcion.setForeground(Color.DARK_GRAY);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(12, 143, 388, 59);
		getContentPane().add(lblDescripcion);
		
		JLabel lblInventores = new JLabel("Principios");
		lblInventores.setBounds(12, 237, 93, 15);
		getContentPane().add(lblInventores);
		
		final JComboBox comboPrincipios = new JComboBox();		
		comboPrincipios.setBounds(12, 264, 317, 24);
		getContentPane().add(comboPrincipios);
		ArrayList<Principio> principios = handler.getPrincipios(invento.getId());
		
		
		Iterator<Principio> ite3 = principios.iterator();
		
		while (ite3.hasNext()) {
			comboPrincipios.addItem(ite3.next());
		}
		
		
		JButton verPrincipios = new JButton("Ver");
		verPrincipios.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if (comboPrincipios.getSelectedIndex() >= 0) {
					try {
						new FichaPrincipio((Principio)comboPrincipios.getSelectedItem());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					
				}
			}
		});
		verPrincipios.setBounds(341, 264, 59, 25);
		getContentPane().add(verPrincipios);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(270, 481, 147, 15);
		getContentPane().add(label);
		
		JButton btnVotar = new JButton("Votar");
		btnVotar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					handler.sumarVoto(invento.getId());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVotar.setBounds(12, 471, 80, 25);
		getContentPane().add(btnVotar);
		
		JButton btnRelacionados = new JButton("Relacionados");
		btnRelacionados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new MaquinasRelacionadas(invento);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRelacionados.setBounds(100, 471, 129, 25);
		getContentPane().add(btnRelacionados);
		
		final JComboBox comboPartes = new JComboBox();
		comboPartes.setBounds(12, 327, 317, 24);
		getContentPane().add(comboPartes);
		
		ArrayList<Parte> partes = handler.getPartes(invento.getId());
		Iterator<Parte> it = partes.iterator();
		
		while (it.hasNext()) {
			comboPartes.addItem(it.next());
		}
		
		
		JLabel lblPartes = new JLabel("Partes");
		lblPartes.setBounds(12, 300, 93, 15);
		getContentPane().add(lblPartes);
		
		JButton verPartes = new JButton("Ver");
		verPartes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboPartes.getSelectedIndex() >= 0) {
					new FichaParte((Parte)comboPartes.getSelectedItem());
				}
				else {
					
				}
			
			}
		});
		verPartes.setBounds(341, 327, 59, 25);
		getContentPane().add(verPartes);
		
		final JComboBox comboInventor = new JComboBox();
		comboInventor.setBounds(12, 387, 317, 24);
		getContentPane().add(comboInventor);
		ArrayList<Inventor> inventores = handler.getInventoresByInvento(invento.getId());
		
		
		Iterator<Inventor> ite = inventores.iterator();
		
		while (ite.hasNext()) {
			comboInventor.addItem(ite.next());
		}
		JLabel label_2 = new JLabel("Inventor/es");
		label_2.setBounds(12, 360, 93, 15);
		getContentPane().add(label_2);
		
		
		
		JButton verInventor = new JButton("Ver");
		verInventor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (comboInventor.getSelectedIndex() >= 0) {
					setVisible(false);
					new FichaInventor((Inventor)comboInventor.getSelectedItem());
				}
				else {
					
				}
			
			}
		});
		verInventor.setBounds(341, 387, 59, 25);
		getContentPane().add(verInventor);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		handler.sumarVista(invento.getId());
			
		
		
		setVisible(true);
	}
}
