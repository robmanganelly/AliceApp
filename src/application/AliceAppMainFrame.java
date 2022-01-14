package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JToolBar;
import java.awt.FlowLayout;

public class AliceAppMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable inventoryTable, recordsTable;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AliceAppMainFrame frame = new AliceAppMainFrame();
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
	public AliceAppMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 852, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 50, 377, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel usernameLabel = new JLabel("Welcome: ${{username}}");
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.anchor = GridBagConstraints.WEST;
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 1;
		gbc_usernameLabel.gridy = 1;
		contentPane.add(usernameLabel, gbc_usernameLabel);
		usernameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		usernameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel dateLabel = new JLabel("Date: 01/01/2022 - 13:50");
		GridBagConstraints gbc_dateLabel = new GridBagConstraints();
		gbc_dateLabel.anchor = GridBagConstraints.EAST;
		gbc_dateLabel.insets = new Insets(0, 0, 5, 5);
		gbc_dateLabel.gridx = 2;
		gbc_dateLabel.gridy = 1;
		contentPane.add(dateLabel, gbc_dateLabel);
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("Dialog", Font.ITALIC, 14));
		
		JPanel mainTabPanel = new JPanel();
		GridBagConstraints gbc_mainTabPanel = new GridBagConstraints();
		gbc_mainTabPanel.gridwidth = 2;
		gbc_mainTabPanel.fill = GridBagConstraints.BOTH;
		gbc_mainTabPanel.insets = new Insets(0, 0, 0, 5);
		gbc_mainTabPanel.gridx = 1;
		gbc_mainTabPanel.gridy = 2;
		contentPane.add(mainTabPanel, gbc_mainTabPanel);
		mainTabPanel.setLayout(new BoxLayout(mainTabPanel, BoxLayout.X_AXIS));
		
		JTabbedPane mainFrameTab = new JTabbedPane(JTabbedPane.TOP);
		mainTabPanel.add(mainFrameTab);
		mainFrameTab.setAutoscrolls(true);
		
				
		inventoryTable = new JTable();
		inventoryTable.setAutoCreateRowSorter(true);
		inventoryTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 0));
				System.out.println("TODO create dialog for showing details ");
			}
		});
		inventoryTable.setPreferredScrollableViewportSize(new Dimension(450, 650));
		inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inventoryTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Product  id", "Item Name", "Remain", "Sales Price", "Model", "Brand", "Color", "IMEI", "Notes"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Double.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		inventoryTable.getColumnModel().getColumn(1).setPreferredWidth(250);
		
		JPanel diaryPanel = new JPanel();
		diaryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainFrameTab.addTab("Diary", null, diaryPanel, "use this tab to register actions during day");
		mainFrameTab.setDisplayedMnemonicIndexAt(0, 0);
		GridBagLayout gbl_diaryPanel = new GridBagLayout();
		gbl_diaryPanel.columnWidths = new int[]{0, 372, 0, 151, 0, 0};
		gbl_diaryPanel.rowHeights = new int[]{0, 32, 0, 0, 0, 0, 0, 0};
		gbl_diaryPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_diaryPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		diaryPanel.setLayout(gbl_diaryPanel);
		
		JLabel lblSalesForm = new JLabel("Sales Form");
		lblSalesForm.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblSalesForm = new GridBagConstraints();
		gbc_lblSalesForm.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalesForm.gridx = 0;
		gbc_lblSalesForm.gridy = 0;
		diaryPanel.add(lblSalesForm, gbc_lblSalesForm);
		
		JLabel terminalLabel = new JLabel("Sales Terminal");
		GridBagConstraints gbc_terminalLabel = new GridBagConstraints();
		gbc_terminalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_terminalLabel.gridx = 0;
		gbc_terminalLabel.gridy = 1;
		diaryPanel.add(terminalLabel, gbc_terminalLabel);
		
		JComboBox currentTerminalComboBox = new JComboBox();
		GridBagConstraints gbc_currentTerminalComboBox = new GridBagConstraints();
		gbc_currentTerminalComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_currentTerminalComboBox.anchor = GridBagConstraints.WEST;
		gbc_currentTerminalComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_currentTerminalComboBox.gridx = 1;
		gbc_currentTerminalComboBox.gridy = 1;
		diaryPanel.add(currentTerminalComboBox, gbc_currentTerminalComboBox);
		
		JLabel lblNewLabel = new JLabel("Current Selected Item");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		diaryPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox selectedItemComboBox = new JComboBox();
		GridBagConstraints gbc_selectedItemComboBox = new GridBagConstraints();
		gbc_selectedItemComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_selectedItemComboBox.anchor = GridBagConstraints.WEST;
		gbc_selectedItemComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_selectedItemComboBox.gridx = 1;
		gbc_selectedItemComboBox.gridy = 2;
		diaryPanel.add(selectedItemComboBox, gbc_selectedItemComboBox);
		
		JButton requestItemToAdminButton = new JButton("Request Item to Administrator");
		requestItemToAdminButton.setMnemonic('m');
		GridBagConstraints gbc_requestItemToAdminButton = new GridBagConstraints();
		gbc_requestItemToAdminButton.anchor = GridBagConstraints.WEST;
		gbc_requestItemToAdminButton.insets = new Insets(0, 0, 5, 5);
		gbc_requestItemToAdminButton.gridx = 3;
		gbc_requestItemToAdminButton.gridy = 2;
		diaryPanel.add(requestItemToAdminButton, gbc_requestItemToAdminButton);
		
		JLabel quantityLabel = new JLabel("Amount");
		GridBagConstraints gbc_quantityLabel = new GridBagConstraints();
		gbc_quantityLabel.insets = new Insets(0, 0, 5, 5);
		gbc_quantityLabel.gridx = 0;
		gbc_quantityLabel.gridy = 3;
		diaryPanel.add(quantityLabel, gbc_quantityLabel);
		
		JComboBox itemAmountComboBox = new JComboBox();
		itemAmountComboBox.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints gbc_itemAmountComboBox = new GridBagConstraints();
		gbc_itemAmountComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemAmountComboBox.anchor = GridBagConstraints.WEST;
		gbc_itemAmountComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_itemAmountComboBox.gridx = 1;
		gbc_itemAmountComboBox.gridy = 3;
		diaryPanel.add(itemAmountComboBox, gbc_itemAmountComboBox);
		
		JLabel lblRetailPrice = new JLabel("Retail Price");
		GridBagConstraints gbc_lblRetailPrice = new GridBagConstraints();
		gbc_lblRetailPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblRetailPrice.gridx = 0;
		gbc_lblRetailPrice.gridy = 4;
		diaryPanel.add(lblRetailPrice, gbc_lblRetailPrice);
		
		JLabel label = new JLabel("$ 100 000.00");
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 4;
		diaryPanel.add(label, gbc_label);
		
		JRadioButton rdbtnDifferentPrice = new JRadioButton("Different Price");
		GridBagConstraints gbc_rdbtnDifferentPrice = new GridBagConstraints();
		gbc_rdbtnDifferentPrice.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnDifferentPrice.gridx = 2;
		gbc_rdbtnDifferentPrice.gridy = 4;
		diaryPanel.add(rdbtnDifferentPrice, gbc_rdbtnDifferentPrice);
		
		textField = new JTextField();
		textField.setToolTipText("type here the new price");
		textField.setText("0.00");
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 4;
		diaryPanel.add(textField, gbc_textField);
		
		JLabel commentsLabel = new JLabel("Comments");
		GridBagConstraints gbc_commentsLabel = new GridBagConstraints();
		gbc_commentsLabel.anchor = GridBagConstraints.NORTH;
		gbc_commentsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_commentsLabel.gridx = 0;
		gbc_commentsLabel.gridy = 5;
		diaryPanel.add(commentsLabel, gbc_commentsLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		diaryPanel.add(scrollPane, gbc_scrollPane);
		
		JButton btnNewButton_1 = new JButton("Insert Data");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 6;
		diaryPanel.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JScrollPane inventoryPanel = new JScrollPane(inventoryTable);
		inventoryPanel.setOpaque(false);
		mainFrameTab.addTab("Inventory", null, inventoryPanel,"this is a readonly tab for controlling items on selected inventory ");
		mainFrameTab.setDisplayedMnemonicIndexAt(1, 0);
		
		recordsTable = new JTable();
		recordsTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Date", "Performant", "Action", "Relevant Data"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
		JScrollPane RecordsPanel = new JScrollPane(recordsTable);
		mainFrameTab.addTab("Records", null, RecordsPanel, "this tab shows the records of the store");
		mainFrameTab.setDisplayedMnemonicIndexAt(2, 0);
		
		JPanel queriesPanel = new JPanel();
		mainFrameTab.addTab("Data Queries", null, queriesPanel, "Get detailed data about your store");
		mainFrameTab.setDisplayedMnemonicIndexAt(3, 0);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		queriesPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		queriesPanel.add(lblNewLabel_4);
		
		JPanel profilePanel = new JPanel();
		mainFrameTab.addTab("Profile", null, profilePanel, "View and Edit your Profile");
		mainFrameTab.setDisplayedMnemonicIndexAt(4, 0);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		profilePanel.add(lblNewLabel_5);
		
		JPanel administrativePanel = new JPanel();
		mainFrameTab.addTab("Administrative Tools", null, administrativePanel, "this panel is for administrative purposes only");
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		administrativePanel.add(lblNewLabel_6);
		mainFrameTab.setDisplayedMnemonicIndexAt(5, 0);
	}
}

