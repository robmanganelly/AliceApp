package uitools;

import java.awt.Color;
import java.awt.Font;
import java.util.*;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomTableCellRenderer() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public CustomTableCellRenderer(int alignment) {
		// TODO Auto-generated constructor stub
		super();
		this.setHorizontalAlignment(alignment);
	}
	
	public CustomTableCellRenderer(int alignment, Color color) {
		// TODO Auto-generated constructor stub
		super();
		this.setHorizontalAlignment(alignment);
		this.setColor(color);
	}
	public CustomTableCellRenderer(int alignment, Color color, Font font) {
		// TODO Auto-generated constructor stub
		super();
		this.setHorizontalAlignment(alignment);
		this.setColor(color);
		this.setFont(font);
	}
	
	public void center() {
		this.setHorizontalAlignment( JLabel.CENTER );
	}
	
	public void setColor(Color c) {
		this.setBackground(c);
		ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(new Color[] {
				Color.RED, Color.BLACK, Color.BLUE, Color.GREEN, Color.DARK_GRAY
		}));
		if (colors.contains(c)) {
			this.setForeground(Color.WHITE);
		}else {
			this.setForeground(Color.BLACK);
		}
		
	}

}
