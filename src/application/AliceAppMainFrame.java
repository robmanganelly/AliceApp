package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uiblocks.MyClock;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.GridBagConstraints;
import java.awt.Font;
import uicomponents.AdministrativePanel;
import uicomponents.DiaryPanel;
import uicomponents.InventoryPanel;
import uicomponents.ProfilePanel;
import uicomponents.QueriesPanel;
import uicomponents.RecordsPanel;
import uitools.ApplicationData;
import uitools.GbcManager;

import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class AliceAppMainFrame extends JFrame implements ApplicationData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel dateLabel, usernameLabel;
	private MyClock applicationClock;
	private final JPanel contentPane = new JPanel(), mainTabPanel  = new JPanel();
	private JTabbedPane mainFrameTab;
	private DiaryPanel diaryPanel;						//subclass
	private InventoryPanel inventoryPanel;				//subclass
	private RecordsPanel recordsPanel;					//subclass
	private QueriesPanel queriesPanel;					//subclass
	private ProfilePanel profilePanel;					//subclass
	private AdministrativePanel administrativePanel;	//subclass

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AliceAppMainFrame frame = new AliceAppMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AliceAppMainFrame() {
		
		//fake data //TODO to be set
		INVENTORY_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{"1549894646ased","tenis de mujer",123,250,"de mexico",null,"carmelitas",null,null} )));
		INVENTORY_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{"1549894646ased","zapatos de nino",2,125,"suela baja",null,"rojos",null,null} )));
		INVENTORY_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{"1549894646ased","otra cosa",1,4500,"modelo",null,null,null,null} )));
		INVENTORY_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{"1549894646ased","tenis de hombre",345,1450,"suela blanca",null,"varios",null,null} )));
		INVENTORY_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{"1549894646ased","medias de nina",34,4800,"media de escuela",null,"blanca",null,null} )));
		INVENTORY_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{"1549894646ased","tacones de mujer",12,120,"de usa",null,"varios",null,null} )));
		INVENTORY_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{"1549894646ased","zapatos de bebe",3456,4510,"yusniel",null,"negros",null,null} )));
		RECORDS_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{new Date(),"efrerfe","sale",null} )));
		RECORDS_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{new Date(),"owner","purchase",null} )));
		RECORDS_DATA.add(new ArrayList<Object>(Arrays.asList(new Object[]{new Date(),"administrator","transport","see details: important"} )));
		
		
		// set frame layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1305, 789);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 852, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 50, 377, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		//create UI elements
		diaryPanel = new DiaryPanel();
		inventoryPanel = new InventoryPanel(INVENTORY_DATA);
		recordsPanel = new RecordsPanel(RECORDS_DATA);
		queriesPanel = new QueriesPanel();
		profilePanel = new ProfilePanel();
		administrativePanel = new AdministrativePanel();
		
		
		usernameLabel = new JLabel("Welcome: ${{username}}");
		usernameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		usernameLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		usernameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
				
		
		dateLabel = new JLabel("Date: 01/01/2022 - 13:50");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("Dialog", Font.ITALIC, 14));
					
		
		mainTabPanel.setLayout(new BoxLayout(mainTabPanel, BoxLayout.X_AXIS));		
		
		
		mainFrameTab = new JTabbedPane(JTabbedPane.TOP);
		mainFrameTab.setAutoscrolls(true);
		
		
		//adding tabs
		mainFrameTab.addTab("Diary", null, diaryPanel, "use this tab to register actions during day");
		mainFrameTab.addTab("Inventory", null, inventoryPanel,"this is a readonly tab for controlling items on selected inventory ");
		mainFrameTab.addTab("Records", null, recordsPanel, "this tab shows the records of the store");
		mainFrameTab.addTab("Data Queries", null, queriesPanel, "Get detailed data about your store");
		mainFrameTab.addTab("Profile", null, profilePanel, "View and Edit your Profile");
		mainFrameTab.addTab("Administrative Tools", null, administrativePanel, "this panel is for administrative purposes only");
		
		
		//adding elements
		contentPane.add(usernameLabel, new GbcManager(1,1,null,null,null,null,GridBagConstraints.WEST,null,0));
		contentPane.add(dateLabel, new GbcManager(2,1,null,null,null,null,GridBagConstraints.EAST,null,0));
		contentPane.add(mainTabPanel, new GbcManager(1,2,2,null,null,null,null,GridBagConstraints.BOTH,0));
		mainTabPanel.add(mainFrameTab);
				
		
		// initialization business-rendering logic
		this.applicationClock = new MyClock(this.dateLabel);
		this.applicationClock.start(); // does clock automatically closes itself or does it leaks ?
		
		//diary
		
		this.diaryPanel.initAmount(0); // TODO modify this after loading data
				
		// init logic : in the end after all field declarations
		this.set_initialization();
	}
	
	//set initialization logic (not rendering )
	private void set_initialization() {}
}



