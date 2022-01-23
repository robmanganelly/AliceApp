package uicomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class RecordsPanel extends JPanel implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] FIELDS = new String[]{"Date", "Performant", "Action", "Relevant Data"};
	private static final Class[] COLUMNTYPES = new Class[] {Date.class, String.class, String.class, String.class };
	private CustomDataTable recordsTable;
	private ArrayList<ArrayList<Object>> data;
	private JScrollPane scrollPane;
	private FiltersPanel filtersPanel;
	private JTextField dateFilterTextField, performantFilterTextField, actionFilterTextField, relevantDataFilterTextField;
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
		gridBagLayout.rowWeights = new double[]{0.05, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		filtersPanel = new FiltersPanel();
		dateFilterTextField= new JTextField(); 
		performantFilterTextField= new JTextField(); 
		actionFilterTextField= new JTextField(); 
		relevantDataFilterTextField = new JTextField();
		scrollPane = new JScrollPane();
		recordsTable = new CustomDataTable(Color.BLUE, Color.BLACK).buildTable(FIELDS,this.data,COLUMNTYPES);
		
		//add components to ui
		this.add(filtersPanel,new GbcManager().gridx(0).gridy(0).fill(GridBagConstraints.HORIZONTAL).insets(0,0,0,5).build());
		this.add(scrollPane, new GbcManager().gridx(0).gridy(1).fill(GridBagConstraints.BOTH).build());
		
        // add specific filters
		filtersPanel.addFilter(dateFilterTextField);
		filtersPanel.addFilter(performantFilterTextField);
		filtersPanel.addFilter(actionFilterTextField);
		filtersPanel.addFilter(relevantDataFilterTextField);
		
		//add table
		this.scrollPane.setViewportView(recordsTable);		
		recordsTable.setDefaultRenderer(String.class, new CustomTableCellRenderer(JLabel.CENTER,Color.WHITE,Color.BLACK,"Dialog",Font.PLAIN,15));
		recordsTable.setDefaultRenderer(Date.class, new CustomTableCellRenderer(JLabel.RIGHT,Color.WHITE,Color.BLACK,"Dialog",Font.PLAIN,15));
		recordsTable.formatColumn(0, JLabel.RIGHT, Color.white,Color.black, new Font("Dialog",  Font.PLAIN,  12),false,0,CustomTableFormats.extendedDate);
	
		//add listeners
		recordsTable.addMouseListener(this);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Component cmp = e.getComponent();
		System.out.println(cmp);
		
		if (cmp == this.recordsTable) {
			System.out.println("launching manage State in child component");
			this.filtersPanel.manageDetailsButtonVisibility(recordsTable.isRowSelected(recordsTable.getSelectedRow()));
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

}
