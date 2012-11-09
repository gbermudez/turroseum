package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PanelMain extends JFrame {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PanelMain dialog = new PanelMain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PanelMain() {
		setBounds(100, 100, 583, 334);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JButton btnAltaInventor = new JButton("Alta Inventor");
		btnAltaInventor.setBounds(14, 140, 146, 25);
		getContentPane().add(btnAltaInventor);
		
		JButton btnAltaInvento = new JButton("Alta Invento");
		btnAltaInvento.setBounds(195, 141, 146, 25);
		getContentPane().add(btnAltaInvento);
	}

}
