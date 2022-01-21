package application;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class AliceLoginWindow {   // TODO refactor login UI code

	private JFrame frame;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new ClearAction(this);
	private JTextField companytextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AliceLoginWindow window = new AliceLoginWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AliceLoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 817, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{143, 499, 150, 0};
		gridBagLayout.rowHeights = new int[]{207, 31, 95, 57, 93, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel applicationTitleLabel = new JLabel("ALICE Application");
		applicationTitleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		applicationTitleLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
				
		GridBagConstraints gbc_applicationTitleLabel = new GridBagConstraints();
		gbc_applicationTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_applicationTitleLabel.gridx = 1;
		gbc_applicationTitleLabel.gridy = 0;
		frame.getContentPane().add(applicationTitleLabel, gbc_applicationTitleLabel);
		
		JLabel loginTitleLabel = new JLabel("Login with your credentials");
		loginTitleLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_loginTitleLabel = new GridBagConstraints();
		gbc_loginTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_loginTitleLabel.fill = GridBagConstraints.BOTH;
		gbc_loginTitleLabel.gridx = 1;
		gbc_loginTitleLabel.gridy = 1;
		frame.getContentPane().add(loginTitleLabel, gbc_loginTitleLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel usernameLabel = new JLabel("Username");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 2;
		gbc_usernameLabel.gridy = 2;
		panel.add(usernameLabel, gbc_usernameLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 3;
		gbc_horizontalStrut.gridy = 2;
		panel.add(horizontalStrut, gbc_horizontalStrut);
		
		usernameTextField = new JTextField();
		usernameTextField.setToolTipText("if you do not have a username contact your provider");
		GridBagConstraints gbc_usernameTextField = new GridBagConstraints();
		gbc_usernameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameTextField.fill = GridBagConstraints.BOTH;
		gbc_usernameTextField.gridx = 4;
		gbc_usernameTextField.gridy = 2;
		panel.add(usernameTextField, gbc_usernameTextField);
		usernameTextField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 2;
		gbc_passwordLabel.gridy = 3;
		panel.add(passwordLabel, gbc_passwordLabel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 3;
		gbc_horizontalStrut_1.gridy = 3;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 3;
		panel.add(passwordField, gbc_passwordField);
		
		JLabel companyLabel = new JLabel("Company");
		GridBagConstraints gbc_companyLabel = new GridBagConstraints();
		gbc_companyLabel.insets = new Insets(0, 0, 5, 5);
		gbc_companyLabel.gridx = 2;
		gbc_companyLabel.gridy = 4;
		panel.add(companyLabel, gbc_companyLabel);
		
		companytextField = new JTextField();
		companyLabel.setLabelFor(companytextField);
		GridBagConstraints gbc_companytextField = new GridBagConstraints();
		gbc_companytextField.insets = new Insets(0, 0, 5, 0);
		gbc_companytextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_companytextField.gridx = 4;
		gbc_companytextField.gridy = 4;
		panel.add(companytextField, gbc_companytextField);
		companytextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		
		JButton clearLoginButton = new JButton("Clear");
		clearLoginButton.setAction(action);
		clearLoginButton.setMnemonic('C');
		buttonGroup.add(clearLoginButton);
		clearLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(clearLoginButton);
		
		JButton submitLoginButton = new JButton("Login");
		submitLoginButton.setMnemonic('L');
		buttonGroup.add(submitLoginButton);
		panel_1.add(submitLoginButton);
	}

	
	private class ClearAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private AliceLoginWindow host;
		
		public ClearAction(AliceLoginWindow host ) {
			putValue(NAME, "Clear");
			putValue(SHORT_DESCRIPTION, "Clearing the login Form");
			this.host = host;
		}
		public void actionPerformed(ActionEvent e) {
			this.host.usernameTextField.setText("");
			this.host.passwordField.setText("");
		}
	}
}
