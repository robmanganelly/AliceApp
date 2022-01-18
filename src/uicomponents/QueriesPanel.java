package uicomponents;

import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class QueriesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueriesPanel() {
		
		// define layout
		GridBagLayout gbl_queriesPanel = new GridBagLayout();
		gbl_queriesPanel.columnWidths = new int[]{0, 0, 0};
		gbl_queriesPanel.rowHeights = new int[]{0, 0, 0};
		gbl_queriesPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_queriesPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_queriesPanel);
	}

}
