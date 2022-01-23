package uicomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import uiblocks.CustomDataTable;
import uitools.CustomTableCellRenderer;
import uitools.CustomTableFormats;
import uitools.GbcManager;

public class RecordsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] FIELDS = new String[]{"Date", "Performant", "Action", "Relevant Data"};
	private static final Class[] COLUMNTYPES = new Class[] {Date.class, String.class, String.class, String.class };
	private CustomDataTable recordsTable;
	private ArrayList<ArrayList<Object>> data;
	private JScrollPane scrollPane;
	private JPanel filtersPanel;
	private JTextField dateFilterTextField, performantFilterTextField, actionFilterTextField, relevantDataFilterTextField;
	private JSeparator separator;
	private JButton showDetailsButton;
	private JCheckBox enableFilterCheckBox;
	private JButton applyFilterButton;
	private Component verticalStrut; 
	/**
	 * Create the frame.
	 */
	public RecordsPanel( ArrayList<ArrayList<Object>> data) { // TODO convert parameters of build table in constants
		this.data = data;
		
		//set layout of the main panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{1211, 0};
		gridBagLayout.rowHeights = new int[]{36, 339, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// layout of filterPanel
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		
		
		//create ui components
		filtersPanel = new JPanel();
		/* layout*/filtersPanel.setLayout(gbl_panel);
		verticalStrut = Box.createVerticalStrut(20);
		showDetailsButton = new JButton("Show details of selected Row");
		applyFilterButton  = new JButton("Apply Filters");
		enableFilterCheckBox = new JCheckBox("Filters");
		separator = new JSeparator();
		dateFilterTextField= new JTextField(); 
		performantFilterTextField= new JTextField(); 
		actionFilterTextField= new JTextField(); 
		relevantDataFilterTextField = new JTextField();
		scrollPane = new JScrollPane();
		recordsTable = new CustomDataTable(Color.BLUE, Color.BLACK).buildTable(FIELDS,this.data,COLUMNTYPES);
		
		//add components to ui
		this.add(filtersPanel,new GbcManager().gridx(0).gridy(0).fill(GridBagConstraints.BOTH).insets(0,0,5,0).build());
		this.add(scrollPane, new GbcManager().gridx(0).gridy(1).fill(GridBagConstraints.BOTH).build());
		
		//add filters to panel
		filtersPanel.add(verticalStrut, new GbcManager().gridx(0).gridy(0).fill(GridBagConstraints.HORIZONTAL).insets(0,0,5,0).ipady(1).build());
		filtersPanel.add(showDetailsButton, new GbcManager().gridx(0).gridy(1).gridwidth(2).fill(GridBagConstraints.HORIZONTAL).insets(0,5,0,5).build());
		filtersPanel.add(enableFilterCheckBox, new GbcManager().gridx(7).gridy(1).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		filtersPanel.add(applyFilterButton, new GbcManager().gridx(8).gridy(1).fill(GridBagConstraints.HORIZONTAL).insets(0,0,5,5).build());
		filtersPanel.add(separator, new GbcManager().gridx(0).gridy(2).gridwidth(9).fill(GridBagConstraints.HORIZONTAL).insets(5,0,5,0).build());
		filtersPanel.add(dateFilterTextField,new GbcManager().gridx(0).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		filtersPanel.add(performantFilterTextField,new GbcManager().gridx(1).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		filtersPanel.add(actionFilterTextField,new GbcManager().gridx(2).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		filtersPanel.add(relevantDataFilterTextField,new GbcManager().gridx(3).gridy(4).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		
		//add table
		this.scrollPane.setViewportView(recordsTable);		
		recordsTable.setDefaultRenderer(String.class, new CustomTableCellRenderer(JLabel.CENTER,Color.WHITE,Color.BLACK,"Dialog",Font.PLAIN,15));
		recordsTable.setDefaultRenderer(Date.class, new CustomTableCellRenderer(JLabel.RIGHT,Color.WHITE,Color.BLACK,"Dialog",Font.PLAIN,15));
		recordsTable.formatColumn(0, JLabel.RIGHT, Color.white,Color.black, new Font("Dialog",  Font.PLAIN,  12),false,0,CustomTableFormats.extendedDate);
	}

}
