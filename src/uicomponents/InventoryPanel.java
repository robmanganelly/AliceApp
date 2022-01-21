package uicomponents;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import uiblocks.CustomDataTable;
import uitools.CustomTableCellRenderer;
import uitools.CustomTableFormats;
import uitools.GbcManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.Font;

public class InventoryPanel extends JPanel implements MouseListener, ItemListener, ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomDataTable inventoryTable;
	private JPanel panel;
	private JSeparator separator;
	private JScrollPane scrollTableContainer;
	private JTextField idFilterTextField;
	private JTextField itemNameFiltertextField;
	private JTextField remainFilterTextField;
	private JTextField salesPriceFilterTextField;
	private JTextField modelFilterTextField;
	private JTextField brandFilterTextField;
	private JTextField colorFilterTextField;
	private JTextField imeiFilterTextField;
	private JTextField notesFilterTextField;
	private Component verticalStrut;
	private JCheckBox enableFilterCheckBox;
	private JButton applyFilterButton;
	private JButton showDetailsButton;
	private ArrayList<ArrayList<Object>> data;
	private static final String[] TABLEHEADERS = new String[] { "Product  id", "Item Name", "Remain", "Sales Price", "Model", "Brand", "Color", "IMEI", "Notes" };
	@SuppressWarnings("rawtypes")
	private static final Class[] COLUMNTYPES = new Class[] { String.class, String.class, Integer.class, Double.class, String.class, String.class, String.class, String.class, String.class};
	 

	/**
	 * Create the panel.
	 */
	public InventoryPanel(ArrayList<ArrayList<Object>> inventoryData) {
		this.data = inventoryData;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1211, 0};
		gridBagLayout.rowHeights = new int[]{36, 339, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 290, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		//add layout main panel 
		add(panel, new GbcManager().gridx(0).gridy(0).fill(GridBagConstraints.BOTH).insets(0,0,5,0).build());//0.0.5.0 must rectify 
		
		//initialize ui components 
		verticalStrut = Box.createVerticalStrut(20);
		showDetailsButton = new JButton("Show Details of Selected Row");
		/* action */showDetailsButton.addActionListener(this);
		enableFilterCheckBox = new JCheckBox("Filters");
		/* font */enableFilterCheckBox.setFont(new Font("Dialog", Font.BOLD, 15));
		applyFilterButton = new JButton("Apply");
		separator = new JSeparator();
		/* color */separator.setForeground(Color.BLACK);
		idFilterTextField = new JTextField();
		/* columns */idFilterTextField.setColumns(10);
		itemNameFiltertextField = new JTextField();
		/* columns */itemNameFiltertextField.setColumns(10);
		remainFilterTextField = new JTextField();
		/* columns */remainFilterTextField.setColumns(10);
		salesPriceFilterTextField = new JTextField();
		/* columns */salesPriceFilterTextField.setColumns(10);
		modelFilterTextField = new JTextField();
		/* columns */modelFilterTextField.setColumns(10);
		brandFilterTextField = new JTextField();
		/* columns */brandFilterTextField.setColumns(10);
		colorFilterTextField = new JTextField();
		/* columns */colorFilterTextField.setColumns(10);
		imeiFilterTextField = new JTextField();
		/* columns */imeiFilterTextField.setColumns(10);
		notesFilterTextField = new JTextField();
		/* columns */notesFilterTextField.setColumns(10);
		
		
		//add ui components inside panel//  new GbcManager(0,0,null,null,null,null,null,GridBagConstraints.null,0,null,null ) 
		panel.add(verticalStrut, new GbcManager().gridx(0).gridy(0).fill(GridBagConstraints.HORIZONTAL).insets(0,0,5,0).ipady(1).build());		
		panel.add(showDetailsButton, new GbcManager().gridx(0).gridy(1).gridwidth(2).fill(GridBagConstraints.HORIZONTAL).insets(0,5,0,5).build());
		panel.add(enableFilterCheckBox, new GbcManager().gridx(7).gridy(1).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		panel.add(applyFilterButton, new GbcManager().gridx(8).gridy(1).fill(GridBagConstraints.HORIZONTAL).insets(0,0,5,5).build());
		panel.add(separator, new GbcManager().gridx(0).gridy(2).gridwidth(9).fill(GridBagConstraints.HORIZONTAL).insets(5,0,5,0).build());		
		panel.add(idFilterTextField, new GbcManager().gridx(0).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		panel.add(itemNameFiltertextField, new GbcManager().gridx(1).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		panel.add(remainFilterTextField, new GbcManager().gridx(2).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());		
		panel.add(salesPriceFilterTextField, new GbcManager().gridx(3).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());		
		panel.add(modelFilterTextField, new GbcManager().gridx(4).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		panel.add(brandFilterTextField, new GbcManager().gridx(5).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		panel.add(colorFilterTextField, new GbcManager().gridx(6).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		panel.add(imeiFilterTextField, new GbcManager().gridx(7).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		panel.add(notesFilterTextField, new GbcManager().gridx(8).gridy(4).anchor(GridBagConstraints.WEST).fill(GridBagConstraints.HORIZONTAL).build());
		
		//creating ui Table to embed inside a panel
		inventoryTable = new CustomDataTable().buildTable(TABLEHEADERS, this.data, COLUMNTYPES);
		inventoryTable.setDefaultRenderer(String.class, new CustomTableCellRenderer(JLabel.CENTER));
		inventoryTable.setDefaultRenderer(Number.class, new CustomTableCellRenderer(JLabel.RIGHT,Color.white,Color.black));
		inventoryTable.formatColumn(1, SwingConstants.CENTER, new int[][] {new int[] {39,105,255},new int[]{255,255,255}}, "Dialog", Font.BOLD, 12,false,0,CustomTableFormats.inherited);
		inventoryTable.formatColumn(2, SwingConstants.CENTER, Color.white,Color.BLACK, new Font("Dialog", Font.BOLD, 12),true,100,CustomTableFormats.inherited);
		inventoryTable.formatColumn(3, SwingConstants.CENTER, Color.white,Color.black, new Font("Dialog", Font.BOLD, 12),false,0,CustomTableFormats.currency);
//		inventoryTable.formatColumn(2, SwingConstants.RIGHT,Color.WHITE,new Font("Dialog",Font.BOLD,20)).setConditionalTextColor(0, Color.GREEN, Color.GRAY,2);
		inventoryTable.setAutoCreateRowSorter(true);
		inventoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		inventoryTable.getColumnModel().getColumn(1).setPreferredWidth(250);
		
		this.scrollTableContainer = new JScrollPane();
		this.scrollTableContainer.setViewportView(inventoryTable);
		GridBagConstraints gbc_scrollTableContainer = new GridBagConstraints();
		gbc_scrollTableContainer.fill = GridBagConstraints.BOTH;
		gbc_scrollTableContainer.gridx = 0;
		gbc_scrollTableContainer.gridy = 1;
		this.add(scrollTableContainer, gbc_scrollTableContainer);
		
		
		//adding action listeners
		enableFilterCheckBox.addItemListener(this);	
		inventoryTable.addMouseListener(this);
		
		//rendering logic
		this.manageFilterState(false);
		this.showDetailsButton.setVisible(false);	
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		System.out.println("TODO create dialog for showing details ");
		Component sourceComponent = arg0.getComponent();
		System.out.println(sourceComponent);
		if(sourceComponent.getClass() == this.inventoryTable.getClass()) {
			//TODO store id in a field for load details if button pressed
			System.out.println(inventoryTable.getValueAt(inventoryTable.getSelectedRow(), 0)); // this is the id.
			System.out.println("ok"); // maybe set the id value in a field ? after launch the details whrn button clicked. remember clean field when button visib is false
			
			this.showDetailsButton.setVisible(this.inventoryTable.isRowSelected(this.inventoryTable.getSelectedRow()));
		}else {
			System.out.println("nope");
			this.showDetailsButton.setVisible(false);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		boolean state = e.getStateChange() == ItemEvent.SELECTED;
		Object source = e.getItemSelectable();
		if (source == this.enableFilterCheckBox){
			this.manageFilterState(state);
		}else {
			System.out.println("nothing selected");
			return;
		}
		
	}

	private void manageFilterState(boolean state) {
		this.idFilterTextField.setVisible(state);
		this.itemNameFiltertextField.setVisible(state);
		this.remainFilterTextField.setVisible(state);
		this.salesPriceFilterTextField.setVisible(state);
		this.modelFilterTextField.setVisible(state);
		this.brandFilterTextField.setVisible(state);
		this.colorFilterTextField.setVisible(state);
		this.imeiFilterTextField.setVisible(state);
		this.notesFilterTextField.setVisible(state);
		this.applyFilterButton.setVisible(state);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
