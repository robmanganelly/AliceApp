package uitools;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GbcManager extends GridBagConstraints {
	private int _anchor = GridBagConstraints.CENTER; // TODO fix this
	private int _gridheight = 1; 
	private int _gridwidth = 1;
	private int _gridx = GridBagConstraints.RELATIVE;
	private int _gridy = GridBagConstraints.RELATIVE; 
	private int _fill = GridBagConstraints.NONE;
	private int _ipadx = 0;
	private int _ipady  = 0;
	private double _weightx = 0;
	private double _weighty = 0;
	private Insets _insets = new Insets(0,0,5,5);
	

	private static final long serialVersionUID = 1L;

	public GbcManager(int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, int anchor, int fill, Insets insets, int ipadx, int ipady) {
		super( gridx,  gridy,  gridwidth,  gridheight,  weightx,  weighty,  anchor,  fill,  insets,  ipadx, ipady); // insets.getClass() == Insets.class ? insets : new Insets(0, 0, 5, 5)
	}
	
	/**
	 * @param args int vararg: if want so skip some index declare it as null:  (1)gridx, (2)gridy, (3)gridwidth,  (4)gridheight
	 * 				, (5)weightx, (6)weighty,  (7)anchor,  (8)fill,  (9)insets,  (10)ipadx, (11)ipady
	 */
	public GbcManager(Number ...args) {
		if(args.length >0 && args[0] != null) {
			try {
				super.gridx = (int) args[0];
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(args.length >1 && args[1] != null) {
			super.gridy = (int) args[1];
		}
		if(args.length >2 && args[2] != null) {
			super.gridwidth = (int) args[2];
		}
		if(args.length >3 && args[3] != null) {
			super.gridheight = (int) args[3];
		}
		if(args.length >4 && args[4] != null) {
			super.weightx = (double) args[4];
		}
		if(args.length >5 && args[5] != null) {
			super.weighty = (double) args[5];
		}
		if(args.length >6 && args[6] != null) {
			super.anchor = (int) args[6];
		}
		if(args.length >7 && args[7] != null) {
			super.fill = (int) args[7];
		}
		if(args.length >8 && args[8] != null) {
			super.insets= (new Insets[]{ new Insets(0,0,5,5),new Insets(0,0,0,0) })[(int)args[8]];
		}
		if(args.length >9 && args[9] != null) {
			super.ipadx= (int) args[9];
		}
		if(args.length >10 && args[10] != null) {
			super.ipady = (int) args[10];
		}
		
	}
	public GbcManager(){
		super();
	}
	
	// builder methods
//	public GbcManager build(){
//		if(this._gridx > -10) {
//			super.gridx = this._gridx;
//		}
//		if(this._gridy > -10) {
//			super.gridy = this._gridy;
//		}
//		if(this._gridwidth > -10) {
//			super.gridwidth = this._gridwidth;
//		}
//		if(this._gridheight > -10) {
//			super.gridheight = this._gridheight;
//		}
//		if(this._anchor > -10) {
//			super.anchor = this._anchor;
//		}
//		if(this._fill > -10) {
//			super.fill = this._fill;
//		}
//		if(this._ipadx > -10) {
//			super.ipadx = this._ipadx;
//		}
//		if(this._ipady > -10) {
//			super.ipady = this._ipady;
//		}
//		if(this._weightx > -10) {
//			super.weightx = this._weightx;
//		}
//		if(this._weighty > -10) {
//			super.weighty = this._weighty;
//		}
//		if(this._insets instanceof Insets ) {
//			super.insets = this._insets;
//		}
//		
//		return this;
//	}
	public GbcManager build(){
		
		// set properties value, if not set default values;
		super.gridx = this._gridx;
		super.gridy = this._gridy;
		super.gridwidth = this._gridwidth;
		super.gridheight = this._gridheight;
		super.anchor = this._anchor;
		super.fill = this._fill;
		super.ipadx = this._ipadx;
		super.ipady = this._ipady;
		super.weightx = this._weightx;
		super.weighty = this._weighty;
		super.insets = this._insets;
			
		return this;
	}
	
	public GbcManager gridx(int v) {
		this._gridx = v;
		return this;
	}
	public GbcManager gridy(int v) {
		this._gridy = v;
		return this;
	}
	public GbcManager gridwidth(int v) {
		this._gridwidth = v;
		return this;
	}
	public GbcManager gridheight(int v) {
		this._gridheight = v;
		return this;
	}
	public GbcManager anchor(int v) {
		this._anchor = v;
		return this;
	}
	public GbcManager fill(int v) {
		this._fill = v;
		return this;
	}
	public GbcManager ipadx(int v) {
		this._ipadx = v;
		return this;
	}
	public GbcManager ipady(int v) {
		this._ipady = v;
		return this;
	}
	public GbcManager weightx(double v) {
		this._weightx = v;
		return this;
	}
	public GbcManager weighty(double v) {
		this._weighty = v;
		return this;
	}
	// overloads
	public GbcManager insets(int top, int left, int bottom, int right ) {
		this._insets = new Insets(top,left,bottom,right);
		return this;
	}
	public GbcManager insets(int top, int left, int bottom ) {
		return this.insets(top,left,bottom,0);
	}
	public GbcManager insets(int vertical, int horizontal) {
		return this.insets(vertical,horizontal,vertical,horizontal);
	}
	public GbcManager insets(int equitative) {
		return this.insets(equitative,equitative);
	}	
}
