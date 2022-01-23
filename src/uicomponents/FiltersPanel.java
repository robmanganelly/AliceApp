package uicomponents;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import uitools.GbcManager;

public class FiltersPanel extends JPanel implements ActionListener, MouseListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JCheckBox enableFilterCheckBox;
	private JButton applyFilterButton;
	public JButton showDetailsButton;
	private JSeparator separator;
	private JPanel filterBoxPanel;
	private ArrayList<JTextField> filterSet = new ArrayList<JTextField>();
	
	

	public FiltersPanel() {
		// TODO Auto-generated constructor stub
		super();
		initUI();
		
	}

	public FiltersPanel(LayoutManager layout) {
		super();
		initUI();// TODO Auto-generated constructor stub
	}

	public FiltersPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initUI();// TODO Auto-generated constructor stub
	}

	public FiltersPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initUI();// TODO Auto-generated constructor stub
	}
	
	//TODO
	//place the button for show details, place the Title, place the separator and place the filters
	
	private void initUI() {
		// set ui layout
		GridBagLayout filtersPanelConstraints = new GridBagLayout();
		filtersPanelConstraints.columnWidths = new int[]{0, 0, 0, 0};
		filtersPanelConstraints.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		filtersPanelConstraints.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE}; // only second column grows
		filtersPanelConstraints.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		
		
		// Create ui components
		showDetailsButton = new JButton("Show Details");
		/* initial visible state */showDetailsButton.setVisible(false);
		enableFilterCheckBox = new JCheckBox("Filters");
		/* font */enableFilterCheckBox.setFont(new Font("Dialog", Font.BOLD, 15));
		applyFilterButton = new JButton("Apply Filters");
		/* enabled initial state*/ applyFilterButton.setEnabled(false);
		separator = new JSeparator();
		filterBoxPanel = new  JPanel();
		
		//setLayouts
		setLayout(filtersPanelConstraints);
		filterBoxPanel.setLayout(new BoxLayout(filterBoxPanel, BoxLayout.X_AXIS));
		
		
		//add those components			
		add(showDetailsButton, new GbcManager().gridx(0).gridy(1).anchor(GridBagConstraints.WEST).fill(GridBagConstraints.HORIZONTAL).insets(0,5,0,5).build());
		add(enableFilterCheckBox, new GbcManager().gridx(2).gridy(1).anchor(GridBagConstraints.EAST).insets(0,0,0,5).build());
		add(applyFilterButton, new GbcManager().gridx(3).gridy(1).anchor(GridBagConstraints.WEST).insets(0,0,5,5).build());
		add(separator, new GbcManager().gridx(0).gridy(2).gridwidth(9).fill(GridBagConstraints.HORIZONTAL).insets(5,0,5,0).build());
		add(filterBoxPanel,new GbcManager().gridwidth(4).insets(0,0,5,5).fill(GridBagConstraints.HORIZONTAL).gridx(0).gridy(4).build());
		
		//adding listeners
		showDetailsButton.addActionListener(this);
		enableFilterCheckBox.addItemListener(this);	
	}
	
	public void addFilter(JTextField cmp) {
		this.addFilter(cmp,10);
	}
	
	public void addFilter(JTextField cmp, int cols){
		this.filterSet.add(cmp);
		this.filterBoxPanel.add(cmp);
		cmp.setEnabled(false);
		cmp.setColumns(cols);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		for (JTextField tf: this.filterSet) {
//			tf.setVisible(state);
			tf.setEnabled(state);
		}
		applyFilterButton.setEnabled(state);		
	}

	public void manageDetailsButtonVisibility(boolean v) {
		System.out.println(v);
		showDetailsButton.setVisible(v);
	}

}
