package uicomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import uiblocks.AmountComboBox;
import uitools.GbcManager;

//T0DO: add label to display action to be performed

public class DiaryPanel extends JPanel  implements ItemListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//declaring variables for UI components
	private Component horizontalStrut;
	private Component verticalStrut;
	private JLabel salesFormTitleLabel;
	private JCheckBox retroactiveDataCheckBox;
	private JTextField retroactiveDataTextField;
	private JLabel retroactiveDataLabel;
	private JSeparator separator;
	private JLabel terminalLabel;
	private JComboBox<String> currentTerminalComboBox;
	private JLabel currentSelectedItemLabel;
	private JComboBox<String> selectedItemComboBox;
	private JButton requestItemToAdminButton;
	private JLabel quantityLabel;
	private JLabel retailPriceLabel;
	private JRadioButton originalPriceRadioButton;
	private ButtonGroup radioButtonGroup;
	private JLabel originalPriceLabel;
	private JRadioButton differentPriceRadioButton;
	private JTextField modifiedPriceTextField;
	private JButton insertDataButton;
	private JTextArea commentsTextArea;
	private JScrollPane scrollPaneForCommentsTextArea;
	private JLabel commentsLabel;
	private AmountComboBox itemAmountComboBox;
	//image
	private JLabel productImageContainerLabel;
	private String imagePath = "images/no-image-icon.png";

	
	public DiaryPanel() {
		
		
		//set borders and grid pattern
		
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gbl_diaryPanel = new GridBagLayout();
		gbl_diaryPanel.columnWidths = new int[]{0, 0, 134, 33, 0, 60, 0, 43, 0, 140, 125, 0, 0};
		gbl_diaryPanel.rowHeights = new int[]{0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_diaryPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_diaryPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_diaryPanel);
		
		//creating UI elements
		horizontalStrut = Box.createHorizontalStrut(20);		
		verticalStrut = Box.createVerticalStrut(20);
		salesFormTitleLabel = new JLabel("Sales Form");
		/* font */ salesFormTitleLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		retroactiveDataCheckBox = new JCheckBox("Retroactive");
		retroactiveDataTextField = new JTextField();
		retroactiveDataLabel = new JLabel("use the format dd/mm/yyyy to input retroactive dates");
		/* set label for*/ retroactiveDataLabel.setLabelFor(retroactiveDataTextField);
		separator = new JSeparator();
		terminalLabel = new JLabel("Sales Terminal");
		currentTerminalComboBox = new JComboBox<String>();
		//currentTerminalComboBox.setModel(new DefaultComboBoxModel(new String[] {"my_terminal", "other_terminal_just_for_admin", "other_terminal_just_for_admin", "other_terminal_just_for_admin", "other_terminal_just_for_admin", "other_terminal_just_for_admin", "other_terminal_just_for_admin"}));
		currentSelectedItemLabel = new JLabel("Current Selected Item");
		selectedItemComboBox = new JComboBox<String>();
//		selectedItemComboBox.setModel(new DefaultComboBoxModel(new String[] {"item0", "item1", "item2", "item3", "item4", "item5", "item6"}));
		requestItemToAdminButton = new JButton("Request Item to Administrator");
		/* mnemonic */requestItemToAdminButton.setMnemonic('m');
		quantityLabel = new JLabel("Amount");
		itemAmountComboBox = new AmountComboBox(
				new Integer[]{0,1,2,3,4} // this is fake data //TODO remove this and pass as data on constructor or as a method
			);				
		retailPriceLabel = new JLabel("Retail Price");
		originalPriceRadioButton = new JRadioButton("Original Price");
		originalPriceLabel = new JLabel("$100,000.00");
		/* font */originalPriceLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		differentPriceRadioButton = new JRadioButton("Different Price");
		radioButtonGroup = new ButtonGroup();
		modifiedPriceTextField = new JTextField();
		modifiedPriceTextField.setToolTipText("type here the new price");
		modifiedPriceTextField.setText("0.00");
		modifiedPriceTextField.setColumns(10);		
		commentsLabel = new JLabel("Comments");
		scrollPaneForCommentsTextArea = new JScrollPane();
		commentsTextArea = new JTextArea();
		commentsTextArea.setRows(4);
		commentsLabel.setLabelFor(commentsTextArea);
		scrollPaneForCommentsTextArea.setViewportView(commentsTextArea);
		insertDataButton = new JButton("Insert Data");
		productImageContainerLabel = new JLabel(getImagePath());
		
		
		
		
		//adding previously created components
		this.add(horizontalStrut, new GbcManager(0,0,null,null,null,null,null,null,0));
		this.add(verticalStrut, new GbcManager(0,1,null,null,null,null,null,null,0));
		this.add(salesFormTitleLabel, new GbcManager(1,2,null,null,null,null,null,null,0));
		this.add(retroactiveDataCheckBox, new GbcManager(8,2,null,null,null,null,null,null,0));
		this.add(retroactiveDataTextField, new GbcManager(9,2,null,null,null,null,null,GridBagConstraints.HORIZONTAL,0));		
		this.add(retroactiveDataLabel, new GbcManager(10,2,2,null,null,null,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,0));		
		this.add(separator, new GbcManager(1,3,11,null,null,null,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,0));
		this.add(terminalLabel, new GbcManager(1,4,null,null,null,null,null,null,0));		
		this.add(currentTerminalComboBox, new GbcManager(2,4,6,null,null,null,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,0));
		this.add(currentSelectedItemLabel,  new GbcManager(1,5,null,null,null,null,null,null,0));		
		this.add(selectedItemComboBox, new GbcManager(2,5,6,null,null,null,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,0));
		this.add(requestItemToAdminButton, new GbcManager(2,11,2,null,null,null,null,null,0));
		this.add(quantityLabel, new GbcManager(1,6,null,null,null,null,null,null,0));
		this.add(itemAmountComboBox, new GbcManager(2,6,6,null,null,null,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL,0));
		this.add(retailPriceLabel, new GbcManager(1,7,null,null,null,null,null,null,0));
		this.add(originalPriceRadioButton, new GbcManager(2,7,null,null,null,null,GridBagConstraints.WEST,null,0));
		this.add(originalPriceLabel, new GbcManager(4,7,4,null,null,null,GridBagConstraints.WEST,null,0));
		this.add(differentPriceRadioButton, new GbcManager(2,8,null,null,null,null,null,null,0));
		this.add(modifiedPriceTextField, new GbcManager(4,8,4,null,null,null,null,GridBagConstraints.HORIZONTAL,0));
		this.add(commentsLabel, new GbcManager(1,9,null,null,null,null,GridBagConstraints.NORTH,null,0));
		this.add(scrollPaneForCommentsTextArea, new GbcManager(2,9,6,null,null,null,null,GbcManager.BOTH,0));
		this.add(insertDataButton, new GbcManager(1,11,null,null,null,null,null,null,0));
		this.add(productImageContainerLabel, new GbcManager().gridx(1).gridy(14).gridwidth(7).build());
		
		
		//buttonGroups adding
		radioButtonGroup.add(originalPriceRadioButton);
		radioButtonGroup.add(differentPriceRadioButton);
		
		//adding listeners
		retroactiveDataCheckBox.addItemListener((ItemListener) this);
		
		//implementation logic
		this.set_initialization();
		

	}
	private void set_initialization() {
		
		//sets fields visibility
		itemAmountComboBox.appendTarget(
				modifiedPriceTextField, insertDataButton,originalPriceRadioButton,
				differentPriceRadioButton,retailPriceLabel,commentsLabel,commentsTextArea,
				originalPriceLabel,scrollPaneForCommentsTextArea);
		retroactiveDataCheckBox.setSelected(false);
		
		this.manageRetroactiveSectionState(false);
		initAmount(0);
		originalPriceRadioButton.setSelected(true);
	
	}
	
	
	//events handling
	
	public void itemStateChanged(ItemEvent e) {
		boolean state = e.getStateChange() == ItemEvent.SELECTED;
		Object source = e.getItemSelectable();
		if(source == this.radioButtonGroup) {
			return;
		}else if (source == this.retroactiveDataCheckBox){
			this.manageRetroactiveSectionState(state);
		}else {
			return;
		}
	}
	
	public void initAmount(int i) {
		this.itemAmountComboBox.setSelectedIndex(i);
		this.itemAmountComboBox.firePropertyChange("SelectedItem",0,0);
	}
	
	public void manageRetroactiveSectionState(boolean state) {
		this.retroactiveDataTextField.setVisible(state);
		this.retroactiveDataTextField.setEnabled(state);;
		this.retroactiveDataTextField.setText("");
		this.retroactiveDataLabel.setVisible(state);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private ImageIcon getImagePath() {
		return new ImageIcon(this.imagePath);		
	}
	
	private void setImagePath(String path) { // use this method whenever a item is selected
		this.imagePath = path;
	}

}
