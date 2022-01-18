package uicomponents;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uiblocks.CustomDataTable;
import uitools.CustomTableCellRenderer;

import javax.swing.ListSelectionModel;

public class RecordsPanel extends JScrollPane {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CustomDataTable recordsTable;
	private Object[][] data;
	/**
	 * Create the frame.
	 */
	public RecordsPanel(Object[][] data) {
		this.data = data;
		
		recordsTable = new CustomDataTable(Color.BLUE, Color.BLACK).buildTable(
			new String[] {"Date", "Performant", "Action", "Relevant Data"},
			this.data,
			new Class[] { Date.class, String.class, String.class, String.class }
		);
	
		recordsTable.setDefaultRenderer(String.class, new CustomTableCellRenderer(JLabel.CENTER));
		recordsTable.formatColumn(1,JLabel.LEFT, Color.blue, new Font("Dialog",Font.BOLD,15));
		recordsTable.setFont("Dialog", Font.BOLD , 12  );
		this.setViewportView(recordsTable);		

	}
	
	public RecordsPanel() {
		this(new Object[][] {{null,null,null,null}});
	}

}
