package uicomponents;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import uiblocks.CustomDataTable;
import uitools.CustomTableCellRenderer;
import uitools.CustomTableFormats;

public class RecordsPanel extends JScrollPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomDataTable recordsTable;
	private ArrayList<ArrayList<Object>> data;
	/**
	 * Create the frame.
	 */
	public RecordsPanel( ArrayList<ArrayList<Object>> data) { // TODO convert parameters of build table in constants
		this.data = data;
		
		recordsTable = new CustomDataTable(Color.BLUE, Color.BLACK).buildTable(
			new String[] {"Date", "Performant", "Action", "Relevant Data"},
			this.data,
			new Class[] { Date.class, String.class, String.class, String.class }
		);
	
		recordsTable.setDefaultRenderer(String.class, new CustomTableCellRenderer(JLabel.CENTER,Color.WHITE,Color.BLACK,"Dialog",Font.PLAIN,15));
		recordsTable.setDefaultRenderer(Date.class, new CustomTableCellRenderer(JLabel.RIGHT,Color.WHITE,Color.BLACK,"Dialog",Font.PLAIN,15));
		recordsTable.formatColumn(0, JLabel.RIGHT, Color.white,Color.black, new Font("Dialog",  Font.PLAIN,  12),false,0,CustomTableFormats.extendedDate);
		this.setViewportView(recordsTable);		
	}

}
