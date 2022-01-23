package uicomponents;

import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class QueriesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public QueriesPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{41, 61, 0, 114, 114, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 25, 27, 0, 19, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Add");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 3;
		gbc_chckbxNewCheckBox.gridy = 1;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JButton btnNewButton_1 = new JButton("New button");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
	}

}
