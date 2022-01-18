package uiblocks;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import uitools.CustomTableCellRenderer;
import uitools.DataManager;

public class CustomDataTable extends JTable implements DataManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomDataTable() {
		super();
	}
	
	public CustomDataTable(Color color, Color textColor) {
		super();
		this.setGridColor(color);
		this.setForeground(textColor);
	}
	
	public CustomDataTable(TableModel dm) {
		super(dm);
	}

	public CustomDataTable(TableModel dm, TableColumnModel cm) {
		super(dm, cm);
	}

	public CustomDataTable(int numRows, int numColumns) {
		super(numRows, numColumns);
	}

	public CustomDataTable(Vector<? extends Vector> rowData, Vector<?> columnNames) {
		super(rowData, columnNames);
	}

	public CustomDataTable(Object[][] rowData, Object[] columnNames) {
		super(rowData, columnNames);
	}

	public CustomDataTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
		super(dm, cm, sm);
	}
	
	public CustomDataTable buildTable(String[]headersName, Object[][] data,  Class[] tableColumnTypes ) throws IndexOutOfBoundsException {
		if (data[0].length != headersName.length || headersName.length != tableColumnTypes.length) {
			throw new IndexOutOfBoundsException("mismatch between headers and data columns lengths");
		}
		
		boolean[] tableColumnEditables = new boolean[headersName.length];	
		for (int i= 0; i < data.length; i++ ) {
			tableColumnEditables[i] = false;
		}

		return this.buildTable(headersName, data, tableColumnTypes, tableColumnEditables);
	}
	
	
	public CustomDataTable buildTable(String[]headersName, Object[][] data,  Class[] tableColumnTypes, boolean[] tableColumnEditable ) throws IndexOutOfBoundsException {
		if (data[0].length != headersName.length || headersName.length != tableColumnTypes.length || headersName.length != tableColumnEditable.length) {
			throw new IndexOutOfBoundsException("mismatch between headers and data columns lengths");
		}
		
		this.setModel(new DefaultTableModel( data, headersName) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = tableColumnTypes;
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = tableColumnEditable;
			
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return this;

	}

	public void formatColumn(int column,int alignment, Color color, Font font ) throws IndexOutOfBoundsException {
		if (column > this.getColumnCount()) throw new IndexOutOfBoundsException("column index out of bounds");
		//TODO		
		this.getColumnModel().getColumn(column).setCellRenderer(new CustomTableCellRenderer(alignment, color, font));
//		recordsTable.setDefaultRenderer(String.class, new CustomTableCellRenderer(JLabel.CENTER));
//      this is for just one column // this is a built in class
//		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//		table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer ); 
//		Font c = new Font("Dialog", Font.BOLD, 15);	
	}
	
	// this is another version of the original
	public void setFont(String fontName, int fontWeight, int fontSize) {
		super.setFont(new Font(fontName, fontWeight, fontSize));
	}

	@Override
	public ArrayList<String> getTableHeaders() {
		// TODO Auto-generated method stub
		var ret = new ArrayList<String>();
		int _cols  = this.getColumnCount();
		
		for(int i = 0; i < _cols; i++) {
			ret.add((String) this.getModel().getValueAt(0,i));
			System.out.print(this.getModel().getValueAt(0,i) + " "); // TODO remove after testing
		}
		return ret;
	}

	@Override
	public ArrayList<ArrayList<Object>> getTableData() {
		var ret = new ArrayList<ArrayList<Object>>();
		var _rows = this.getRowCount();
		
		for (int rowValue = 0; rowValue < _rows; rowValue++) {
			ret.add(this.getRowData(rowValue));
		}
		
		return ret;
	}

	@Override
	public ArrayList<Object> getRowData(int row) {
		var ret = new ArrayList<Object>();
		int _cols  = this.getColumnCount();
		
		for(int i = 0; i < _cols; i++) {
			ret.add((String) this.getModel().getValueAt(row,i));
			System.out.print(this.getModel().getValueAt(row,i) + " "); // TODO remove after testing
		}
		return ret;
	}

	@Override
	public <T> List<T> getColumnData(String colName) {
		int col  = this.getTableHeaders().indexOf(colName);
		return this.getColumnData(col);
	}
	
	@SuppressWarnings("unchecked") // cols will have the same type
	@Override
	public <T> ArrayList<T> getColumnData(int col) {
		int _rows = getRowCount();
		var ret = new ArrayList<T>();
		
		for (int i = 0; i < _rows ; i++) {
			ret.add((T) this.getValueAt(i, col));
			System.out.print(this.getValueAt(i, col) + " "); // TODO remove after testing
		}
		
		return ret;
	}
	
	

	@Override
	public boolean updateCell(int col, int row, Object value) {
		try{
			this.setValueAt(value, row, col);
			return true;
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}

	
	
}
