package uiblocks;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import uitools.CustomTableCellRenderer;
import uitools.CustomTableFormats;
import uitools.TableDataManager;

public class CustomDataTable extends JTable implements TableDataManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomDataTable() {
		super();
	}
	
	public CustomDataTable(Color gridColor, Color textColor) {
		super();
		this.setGridColor(gridColor);
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
	
	public CustomDataTable buildTable(String[]headersName, ArrayList<ArrayList<Object>> data,  Class[] tableColumnTypes ) throws IndexOutOfBoundsException {
		
		//System.out.println(data.get(0).size() != headersName.length || headersName.length != tableColumnTypes.length);
		
		if (data.get(0).size() != headersName.length || headersName.length != tableColumnTypes.length) {
			throw new IndexOutOfBoundsException("mismatch between headers and data columns lengths");
		}
		
		boolean[] tableColumnEditables = new boolean[headersName.length];	
		for (int i= 0; i < headersName.length; i++ ) {
			tableColumnEditables[i] = false;
		}

		return this.buildTable(headersName, data, tableColumnTypes, tableColumnEditables);
	}
	
	public CustomDataTable buildTable(String[]headersName, ArrayList<ArrayList<Object>> data,  Class[] tableColumnTypes, boolean[] tableColumnEditable ) throws IndexOutOfBoundsException {
		
		//System.out.println(data.get(0).size() != headersName.length || headersName.length != tableColumnTypes.length || headersName.length != tableColumnEditable.length);
		
		if (data.get(0).size() != headersName.length || headersName.length != tableColumnTypes.length || headersName.length != tableColumnEditable.length) {
			throw new IndexOutOfBoundsException("mismatch between headers and data columns lengths");
		}
		
		
		this.setModel(new DefaultTableModel( unpackData(data,headersName.length), headersName) {
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
	
	//style and formatting methods
	
	public void formatColumn(int column, int alignment, Color color1, Color color2, Font font, boolean conditional, Object pivot, CustomTableFormats format){
		//steps:
		// create the renderer
		// set.
		
		CustomTableCellRenderer newColumnRenderer = new CustomTableCellRenderer(alignment, color1, color2, font);
		newColumnRenderer.setConditional(conditional, pivot);
		newColumnRenderer.setFormat(format);
							
		this.getColumnModel().getColumn(column).setCellRenderer(newColumnRenderer);
	}
	
	public void formatColumn(int column, int alignment,int[][] color, Font font, boolean conditional, Object pivot, CustomTableFormats format) {
		Color c1 = new Color(color[0][0], color[0][1], color[0][2]);
		Color c2 = new Color(color[1][0], color[1][1], color[1][2]);
		this.formatColumn(column, alignment, c1, c2, font , conditional, pivot, format);
	} 
	
	public void formatColumn(int column, int alignment, int[][] colors, String fontName, int fontStyle, int fontSize, boolean conditional, Object pivot, CustomTableFormats format) {
		Font f = new Font(fontName, fontStyle, fontSize);
		this.formatColumn(column, alignment, colors, f , conditional, pivot, format);
	} 
	
	
	// this is an overloaded version of the original
		public void setFont(String fontName, int fontWeight, int fontSize) {
			super.setFont(new Font(fontName, fontWeight, fontSize));
		}
			
	// Data management methods
	private Object[][] unpackData(ArrayList<ArrayList<Object>> container,int rowlen) {
		
		System.out.println(container);
		System.out.println("---------------------");
		
				
		var ret = new Object[container.size()][rowlen];
		for (int row = 0; row < container.size(); row++) {
			
			System.out.println(container.get(row));
			System.out.println("---------------------");
			
			ret[row] = container.get(row).toArray();
		}
		return ret;
	}
	
	private ArrayList<ArrayList<Object>> packData (Object[][] rawData, ArrayList<ArrayList<Object>> container){
		for(var row: rawData) {
			var _tmp = new ArrayList<Object>(Arrays.asList(row));
			container.add(_tmp);
		}
		return container;
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
