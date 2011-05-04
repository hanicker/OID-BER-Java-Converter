import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;


public class Window {

	private JFrame frmOidBerConverter;
	private JTextArea text_normal;
	private JTextArea text_ber;


	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
		frmOidBerConverter.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOidBerConverter = new JFrame();
		frmOidBerConverter.setTitle("OID BER converter");
		frmOidBerConverter.setBounds(100, 100, 450, 259);
		frmOidBerConverter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOidBerConverter.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 11, 434, 24);
		frmOidBerConverter.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Computer network management 10/11 - \r\n\r\nSoceanu Alexandru, Giovanni Toso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 64, 434, 146);
		frmOidBerConverter.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{97, 241, 93, 0};
		gbl_panel_1.rowHeights = new int[]{70, 70, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblBer = new JLabel("Normal");
		GridBagConstraints gbc_lblBer = new GridBagConstraints();
		gbc_lblBer.insets = new Insets(0, 0, 5, 5);
		gbc_lblBer.gridx = 0;
		gbc_lblBer.gridy = 0;
		panel_1.add(lblBer, gbc_lblBer);
		
		JButton btnConverti = new JButton("Convert");
		btnConverti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getText_ber().setText(Main.encodeNormalOID(getText_normal().getText()));
			}
		});
		
		text_normal = new JTextArea();
		text_normal.setLineWrap(true);
		text_normal.setToolTipText("Number separated by dots like 1.3.6.1.2");
		GridBagConstraints gbc_text_normal = new GridBagConstraints();
		gbc_text_normal.insets = new Insets(0, 0, 5, 5);
		gbc_text_normal.fill = GridBagConstraints.BOTH;
		gbc_text_normal.gridx = 1;
		gbc_text_normal.gridy = 0;
		panel_1.add(text_normal, gbc_text_normal);
		GridBagConstraints gbc_btnConverti = new GridBagConstraints();
		gbc_btnConverti.insets = new Insets(0, 0, 5, 0);
		gbc_btnConverti.gridx = 2;
		gbc_btnConverti.gridy = 0;
		panel_1.add(btnConverti, gbc_btnConverti);
		
		JLabel lblBer_1 = new JLabel("BER");
		GridBagConstraints gbc_lblBer_1 = new GridBagConstraints();
		gbc_lblBer_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblBer_1.gridx = 0;
		gbc_lblBer_1.gridy = 1;
		panel_1.add(lblBer_1, gbc_lblBer_1);
		
		text_ber = new JTextArea();
		text_ber.setLineWrap(true);
		text_ber.setToolTipText("Exadecimal value without spaces");
		GridBagConstraints gbc_text_ber = new GridBagConstraints();
		gbc_text_ber.insets = new Insets(0, 0, 0, 5);
		gbc_text_ber.fill = GridBagConstraints.BOTH;
		gbc_text_ber.gridx = 1;
		gbc_text_ber.gridy = 1;
		panel_1.add(text_ber, gbc_text_ber);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getText_normal().setText(Main.decodeNormalOID(getText_ber().getText()));
			}
		});
		GridBagConstraints gbc_btnConvert = new GridBagConstraints();
		gbc_btnConvert.gridx = 2;
		gbc_btnConvert.gridy = 1;
		panel_1.add(btnConvert, gbc_btnConvert);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 35, 434, 20);
		frmOidBerConverter.getContentPane().add(panel_2);
		
		JLabel lblAGiacomettiNmoretti = new JLabel("A. Giacometti, N.Moretti, M. Pantano");
		lblAGiacomettiNmoretti.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblAGiacomettiNmoretti.setForeground(Color.WHITE);
		panel_2.add(lblAGiacomettiNmoretti);
	}
	public JTextArea getText_normal() {
		return text_normal;
	}
	public JTextArea getText_ber() {
		return text_ber;
	}
}
