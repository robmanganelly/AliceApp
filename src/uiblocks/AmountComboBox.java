package uiblocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class AmountComboBox extends JComboBox<Integer> implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JComponent> _targets;

	@SafeVarargs
	public AmountComboBox(Integer[] elements, JComponent ...targets) {
		super();
		this.setModel(new DefaultComboBoxModel<Integer>());
		for(Integer e: elements) {
			super.addItem(e);
		}
		this._targets = new ArrayList<JComponent>(targets.length);
		for(JComponent target: targets) {
			this._targets.add(target);
		};
		this.addActionListener(this);
		System.out.println(this._targets);
		
	}
	
	public void actionPerformed(ActionEvent e) {
				
		if ((Integer) ( (AmountComboBox) e.getSource() ).getSelectedItem() == 0) {
			manageTargetsVisibility(false);
		}else {
			manageTargetsVisibility(true);
		}
	}
	
	private void manageTargetsVisibility(boolean visibility) {
		this._targets.forEach(
				(JComponent cmp)->{
					try{
						cmp.setVisible(visibility);
					}catch(NullPointerException exc){
						System.out.println(exc.getMessage());
					}
				}
			);
	}
	
	public void appendTarget(JComponent ...target) {
		for (JComponent t: target) {
			try {
				this._targets.add(t);
			}catch(Exception exc) {
				System.out.println(exc);
			}
		}
	}
}
