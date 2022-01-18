package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class MyClock{
	Timer timer;
	JLabel label;
	
	public MyClock(JLabel label) {
		this.label = label;
		this.timer = new Timer(1000,updateClock());
		
	}
	
	public ActionListener updateClock() {
		JLabel _label = this.label;
		return new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				_label.setText(new Date().toString());
			}
		};
	}
	
	public void kill() {
		this.timer.stop();
	}

	public void start() {
		this.timer.start();
	}
}