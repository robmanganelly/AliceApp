package uitools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.*;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer implements TableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font tableFont;
	private boolean conditionalRule = false;
	private Object conditionalPivot; // if more conditions added, this type must be changed to object
	private CustomTableFormats columnFormat = CustomTableFormats.inherited;

	public CustomTableCellRenderer() {
		// TODO Auto-generated constructor stub
		super();
	}

	public CustomTableCellRenderer(int alignment) {
		// TODO Auto-generated constructor stub
		super();
		this.setHorizontalAlignment(alignment);
	}

	public CustomTableCellRenderer(int alignment, Color color1, Color color2) {
		// TODO Auto-generated constructor stub
		this(alignment);
		this.setColor(color1,color2);
	}

	public CustomTableCellRenderer(int alignment, Color color1, Color color2, Font font) {
		// TODO Auto-generated constructor stub
		this(alignment, color1, color2);
		this.tableFont = font;
	}

	public CustomTableCellRenderer(int alignment, Color color1,Color color2, String fontName, int fontWeight, int fontSize) {
		// TODO Auto-generated constructor stub
		this(alignment, color1, color2, new Font(fontName, fontWeight, fontSize));

	}

	public void center() {
		this.setHorizontalAlignment(JLabel.CENTER);
	}

	public void setColor(Color c1, Color c2) {
//		final Random r = new Random();
//      c = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256), r.nextInt(256)); // random color. 

		this.setBackground(c1);
		this.setForeground(c2);
		
	}
	public void setFormat(CustomTableFormats format) {	
		this.columnFormat  = format;
	}

	@Override // must override for set formatting
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component cmp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// this line is the one that really sets the font in the table
		cmp.setFont(tableFont);

		// this block sets the conditional rule
		if (this.conditionalRule) {
			// maybe add more steps here depending on the cell; // to perform conditional
			// comparisons based on the class
			// case Date
			if (this.conditionalPivot instanceof Date) {
				// both fields must be convertible to Date, otherwise will fail
				Date _value = (Date) value;
				Date _pivot = (Date) conditionalPivot;
				cmp.setForeground(_pivot.compareTo(_value) > 0 ? Color.BLUE : Color.RED);
			}
			// case integer
			else if (this.conditionalPivot instanceof Integer) { // change this condition if added more comparison cases
				Integer _value = Integer.valueOf(value.toString());
				cmp.setForeground(Double.valueOf(conditionalPivot.toString()) < _value ? Color.BLUE : Color.RED);
			}
			// case double
			else if (this.conditionalPivot instanceof Double) {
				double _value = Double.valueOf(value.toString());
				cmp.setForeground(Double.valueOf(conditionalPivot.toString()) < _value ? Color.BLUE : Color.RED);
			}
			// case String
			else if (this.conditionalPivot instanceof String) {
				String _value = value.toString();
				String _pivot = (String) conditionalPivot;
				boolean ruleCondition = _value.contains(_pivot);

				cmp.setForeground(ruleCondition ? Color.BLUE : Color.RED);
			}
		}
		// this blocks sets the format
		switch(this.columnFormat) {
		case inherited:
			break;
		case simpleDate:
			var _f = new SimpleDateFormat("yyyy/MM/dd");
			setValue(_f.format(value));
			
			break;
			
		case extendedDate:
			var _d = java.text.DateFormat.getInstance();
			setValue(_d.format(value));
			break;
		case currency:
			var _c = NumberFormat.getCurrencyInstance();
			setValue(_c.format(value));
		}
		
		//return cell renderer
		return cmp;
	}

	public void setConditional(boolean conditional, Object pivot) {
		this.conditionalRule = conditional;
		this.conditionalPivot = pivot;
	}
}

