import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import  java.io.Serializable;


public class Strategy implements Serializable{

	private static final long serialVersionUID = 123456790L;
	protected JFrame frame;
	protected JTextField ourHatchTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField ourCargoTextField;
	private JTextField ourClimbTextField;
	private JTextField cargoTextField2;
	private JTextField hatchTextField2;
	private JTextField climbTextField2;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField cargoTextField3;
	private JTextField hatchTextField3;
	private JTextField climbTextField3;
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	/*private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldClimb1;
	private final ButtonGroup buttonGroup_Other1 = new ButtonGroup();
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private final ButtonGroup buttonGroup_Other2 = new ButtonGroup();
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private final ButtonGroup buttonGroup_Other3 = new ButtonGroup();
	
	protected Robot friendly1;
	protected Robot friendly2;
	protected Robot friendly3;
	protected Robot enemy1;
	protected Robot enemy2;
	protected Robot enemy3;
	*/
	

	/**
	 * Launch the application.
	 *
	
	public void Runnable() {
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Strategy window = new Strategy();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
 
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Strategy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel ourRobotPanel = new JPanel();
		ourRobotPanel.setBounds(0, 1, 450, 92);
		frame.getContentPane().add(ourRobotPanel);
		ourRobotPanel.setLayout(new GridLayout(2, 2, 0, 0));

			JLabel ourRobot = new JLabel("Team 4541");
			ourRobot.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			ourRobot.setForeground(Color.RED);
			ourRobot.setHorizontalAlignment(SwingConstants.CENTER);
			ourRobotPanel.add(ourRobot);

			JPanel ourCycleTimes = new JPanel();
			ourRobotPanel.add(ourCycleTimes);
			ourCycleTimes.setLayout(new GridLayout(2, 2, 0, 0));

				ourHatchTextField = new JTextField();
				ourCycleTimes.add(ourHatchTextField);
				ourHatchTextField.setColumns(10);

				JLabel ourHatchLabel = new JLabel("hatch cycle time");
				ourCycleTimes.add(ourHatchLabel);

				ourCargoTextField = new JTextField();
				ourCycleTimes.add(ourCargoTextField);
				ourCargoTextField.setColumns(10);

				JLabel lblCargoCycleTime = new JLabel("cargo cycle time");
				ourCycleTimes.add(lblCargoCycleTime);

			JPanel ourClimbTime = new JPanel();
			ourRobotPanel.add(ourClimbTime);
			ourClimbTime.setLayout(new GridLayout(1, 2, 0, 0));

				ourClimbTextField = new JTextField();
				ourClimbTime.add(ourClimbTextField);
				ourClimbTextField.setColumns(10);

				JLabel lblSecondsToClimb = new JLabel("seconds to climb");
				ourClimbTime.add(lblSecondsToClimb);

			JPanel ourClimbLevel = new JPanel();
			ourRobotPanel.add(ourClimbLevel);
			ourClimbLevel.setLayout(new GridLayout(0, 2, 0, 0));

				JRadioButton rdbtnLevel = new JRadioButton("Level 1");
				ourClimbLevel.add(rdbtnLevel);
				buttonGroup.add(rdbtnLevel);

				JRadioButton rdbtnLevel_2 = new JRadioButton("Level 3");
				ourClimbLevel.add(rdbtnLevel_2);
				buttonGroup.add(rdbtnLevel_2);

				JRadioButton rdbtnLevel_1 = new JRadioButton("Level 2");
				ourClimbLevel.add(rdbtnLevel_1);
				buttonGroup.add(rdbtnLevel_1);
		
	/*	JPanel panelOtherAlliance1 = new JPanel();
		panelOtherAlliance1.setBounds(450, 1, 450, 92);
		panelOtherAlliance1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panelOtherAlliance1);
		panelOtherAlliance1.setLayout(new GridLayout(2, 2, 0, 0));
		
			JLabel lblOtherAllianceTeam = new JLabel("Other Alliance Team 1");
			lblOtherAllianceTeam.setHorizontalAlignment(SwingConstants.CENTER);
			lblOtherAllianceTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			panelOtherAlliance1.add(lblOtherAllianceTeam);
		
			JPanel other1CycleTimes = new JPanel();
			other1CycleTimes.setBackground(Color.LIGHT_GRAY);
			panelOtherAlliance1.add(other1CycleTimes);
			other1CycleTimes.setLayout(new GridLayout(2, 2, 0, 0));
			
					textField_1 = new JTextField();
					other1CycleTimes.add(textField_1);
					textField_1.setColumns(10);
		
					JLabel lblHatchCycleTime_2 = new JLabel("hatch cycle time");
					other1CycleTimes.add(lblHatchCycleTime_2);
		
					textField = new JTextField();
					other1CycleTimes.add(textField);
					textField.setColumns(10);
		
					JLabel lblCargoCycleTime_3 = new JLabel("cargo cycle time");
					other1CycleTimes.add(lblCargoCycleTime_3);
		
				JPanel panelOther1Climb = new JPanel();
				panelOther1Climb.setBackground(Color.LIGHT_GRAY);
				panelOtherAlliance1.add(panelOther1Climb);
				panelOther1Climb.setLayout(new GridLayout(0, 2, 0, 0));
		
					textFieldClimb1 = new JTextField();
					panelOther1Climb.add(textFieldClimb1);
					textFieldClimb1.setColumns(10);
			
					JLabel other1ClimbTime = new JLabel("seconds to climb");
					panelOther1Climb.add(other1ClimbTime);
		
					JPanel panelOther1Level = new JPanel();
					panelOther1Level.setBackground(Color.LIGHT_GRAY);
					panelOtherAlliance1.add(panelOther1Level);
					panelOther1Level.setLayout(new GridLayout(2, 2, 0, 0));
			
					JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Level 1");
					buttonGroup_Other1.add(rdbtnNewRadioButton_1);
					panelOther1Level.add(rdbtnNewRadioButton_1);
			
					JRadioButton rdbtnLevel_9 = new JRadioButton("Level 3");
					buttonGroup_Other1.add(rdbtnLevel_9);
					panelOther1Level.add(rdbtnLevel_9);
		
					JRadioButton rdbtnNewRadioButton = new JRadioButton("Level 2");
					buttonGroup_Other1.add(rdbtnNewRadioButton);
					panelOther1Level.add(rdbtnNewRadioButton);
					
					*/

			JPanel panelTeam2 = new JPanel();
			panelTeam2.setBounds(0, 93, 450, 92);
			frame.getContentPane().add(panelTeam2);
			panelTeam2.setLayout(new GridLayout(2, 2, 0, 0));

				JLabel lblOtherTeam2 = new JLabel("Team 2");
				lblOtherTeam2.setHorizontalAlignment(SwingConstants.CENTER);
				lblOtherTeam2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				panelTeam2.add(lblOtherTeam2);

				JPanel cycleTimes2 = new JPanel();
				panelTeam2.add(cycleTimes2);
				cycleTimes2.setLayout(new GridLayout(2, 2, 0, 0));

					hatchTextField2 = new JTextField();
					cycleTimes2.add(hatchTextField2);
					hatchTextField2.setColumns(10);
				
					JLabel lblHatchCycleTime = new JLabel("hatch cycle time");
					cycleTimes2.add(lblHatchCycleTime);

					cargoTextField2 = new JTextField();
					cycleTimes2.add(cargoTextField2);
					cargoTextField2.setColumns(10);

					JLabel lblCargoCycleTime_1 = new JLabel("cargo cycle time");
					cycleTimes2.add(lblCargoCycleTime_1);

				JPanel climbTime2 = new JPanel();
				panelTeam2.add(climbTime2);
				climbTime2.setLayout(new GridLayout(1, 2, 0, 0));

					climbTextField2 = new JTextField();
					climbTime2.add(climbTextField2);
					climbTextField2.setColumns(10);

					JLabel lblSecondsToClimb_1 = new JLabel("seconds to climb");
					climbTime2.add(lblSecondsToClimb_1);

				JPanel climbLevelPanel2 = new JPanel();
				panelTeam2.add(climbLevelPanel2);
				climbLevelPanel2.setLayout(new GridLayout(2, 2, 0, 0));

					JRadioButton rdbtnLevel_3 = new JRadioButton("Level 1");
					buttonGroup_2.add(rdbtnLevel_3);
					climbLevelPanel2.add(rdbtnLevel_3);

					JRadioButton rdbtnLevel_5 = new JRadioButton("Level 3");
					buttonGroup_2.add(rdbtnLevel_5);
					climbLevelPanel2.add(rdbtnLevel_5);

					JRadioButton rdbtnLevel_4 = new JRadioButton("Level 2");
					buttonGroup_2.add(rdbtnLevel_4);
					climbLevelPanel2.add(rdbtnLevel_4);
		
	/*	JPanel panelOtherAlliance2 = new JPanel();
		panelOtherAlliance2.setBounds(450, 93, 450, 92);
		panelOtherAlliance2.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panelOtherAlliance2);
		panelOtherAlliance2.setLayout(new GridLayout(2, 2, 0, 0));
		
				JLabel lblOtherAllianceTeam_1 = new JLabel("Other Alliance Team 2");
				lblOtherAllianceTeam_1.setHorizontalAlignment(SwingConstants.CENTER);
				panelOtherAlliance2.add(lblOtherAllianceTeam_1);
				lblOtherAllianceTeam_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
				JPanel panelOther2CycleTimes = new JPanel();
				panelOther2CycleTimes.setBackground(Color.LIGHT_GRAY);
				panelOtherAlliance2.add(panelOther2CycleTimes);
				panelOther2CycleTimes.setLayout(new GridLayout(2, 2, 0, 0));
			
					textField_6 = new JTextField();
					panelOther2CycleTimes.add(textField_6);
					textField_6.setColumns(10);
			
					JLabel lblHatchCycleTime_3 = new JLabel("hatch cycle time");
					panelOther2CycleTimes.add(lblHatchCycleTime_3);
			
					textField_4 = new JTextField();
					panelOther2CycleTimes.add(textField_4);
					textField_4.setColumns(10);
			
					JLabel lblCargoCycleTime_4 = new JLabel("cargo cycle time");
					panelOther2CycleTimes.add(lblCargoCycleTime_4);
			
				JPanel panelOther2Climb = new JPanel();
				panelOther2Climb.setBackground(Color.LIGHT_GRAY);
				panelOtherAlliance2.add(panelOther2Climb);
				panelOther2Climb.setLayout(new GridLayout(0, 2, 0, 0));
			
					textField_7 = new JTextField();
					panelOther2Climb.add(textField_7);
					textField_7.setColumns(10);
			
					JLabel lblSecondsToClimb_3 = new JLabel("seconds to climb");
					panelOther2Climb.add(lblSecondsToClimb_3);
			
				JPanel panelOther2Level = new JPanel();
				panelOther2Level.setBackground(Color.LIGHT_GRAY);
				panelOtherAlliance2.add(panelOther2Level);
				panelOther2Level.setLayout(new GridLayout(2, 2, 0, 0));
			
					JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Level 1");
					buttonGroup_Other2.add(rdbtnNewRadioButton_3);
					panelOther2Level.add(rdbtnNewRadioButton_3);
			
					JRadioButton rdbtnLevel_10 = new JRadioButton("Level 3");
					buttonGroup_Other2.add(rdbtnLevel_10);
					panelOther2Level.add(rdbtnLevel_10);
			
					JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Level 2");
					buttonGroup_Other2.add(rdbtnNewRadioButton_2);
					panelOther2Level.add(rdbtnNewRadioButton_2);
					*/
		
		JPanel panelTeam3 = new JPanel();
		panelTeam3.setBounds(0, 185, 450, 92);
		frame.getContentPane().add(panelTeam3);
		panelTeam3.setLayout(new GridLayout(2, 2, 0, 0));

			JLabel lblTeam_3 = new JLabel("Team 3");
			lblTeam_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblTeam_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			panelTeam3.add(lblTeam_3);

			JPanel cycleTimes3 = new JPanel();
			panelTeam3.add(cycleTimes3);
			cycleTimes3.setLayout(new GridLayout(2, 2, 0, 0));

				hatchTextField3 = new JTextField();
				cycleTimes3.add(hatchTextField3);
				hatchTextField3.setColumns(10);
		
				JLabel lblHatchCycleTime_1 = new JLabel("hatch cycle time");
				cycleTimes3.add(lblHatchCycleTime_1);

				cargoTextField3 = new JTextField();
				cycleTimes3.add(cargoTextField3);
				cargoTextField3.setColumns(10);

				JLabel lblCargoCycleTime_2 = new JLabel("cargo cycle time");
				cycleTimes3.add(lblCargoCycleTime_2);

			JPanel climbTime3 = new JPanel();
			panelTeam3.add(climbTime3);
			climbTime3.setLayout(new GridLayout(0, 2, 0, 0));
	
				climbTextField3 = new JTextField();
				climbTime3.add(climbTextField3);
				climbTextField3.setColumns(10);

				JLabel lblSecondsToClimb_2 = new JLabel("seconds to climb");
				climbTime3.add(lblSecondsToClimb_2);

			JPanel climbLevelPanel3 = new JPanel();
			panelTeam3.add(climbLevelPanel3);
			climbLevelPanel3.setLayout(new GridLayout(2, 2, 0, 0));

				JRadioButton rdbtnLevel_6 = new JRadioButton("Level 1");
				buttonGroup_3.add(rdbtnLevel_6);
				climbLevelPanel3.add(rdbtnLevel_6);

				JRadioButton rdbtnLevel_8 = new JRadioButton("Level 3");
				buttonGroup_3.add(rdbtnLevel_8);
				climbLevelPanel3.add(rdbtnLevel_8);

				JRadioButton rdbtnLevel_7 = new JRadioButton("Level 2");
				buttonGroup_3.add(rdbtnLevel_7);
				climbLevelPanel3.add(rdbtnLevel_7);
				
		/*	JPanel panelOtherAlliance3 = new JPanel();
			panelOtherAlliance3.setBounds(450, 185, 450, 92);
			panelOtherAlliance3.setBackground(Color.LIGHT_GRAY);
			frame.getContentPane().add(panelOtherAlliance3);
			panelOtherAlliance3.setLayout(new GridLayout(2, 2, 0, 0));
			
			JLabel lblOtherAllianceTeam_3 = new JLabel("Other Alliance Team 3");
			lblOtherAllianceTeam_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblOtherAllianceTeam_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			panelOtherAlliance3.add(lblOtherAllianceTeam_3);
			
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(Color.LIGHT_GRAY);
			panelOtherAlliance3.add(panel_7);
			panel_7.setLayout(new GridLayout(2, 2, 0, 0));
			
				textField_9 = new JTextField();
				panel_7.add(textField_9);
				textField_9.setColumns(10);
			
				JLabel lblHatchCycleTime_4 = new JLabel("hatch cycle time");
				panel_7.add(lblHatchCycleTime_4);
			
				textField_8 = new JTextField();
				panel_7.add(textField_8);
				textField_8.setColumns(10);
			
				JLabel lblCargoCycleTime_5 = new JLabel("cargo cycle time");
				panel_7.add(lblCargoCycleTime_5);
			
			JPanel panel_8 = new JPanel();
			panel_8.setBackground(Color.LIGHT_GRAY);
			panelOtherAlliance3.add(panel_8);
			panel_8.setLayout(new GridLayout(0, 2, 0, 0));
			
				textField_10 = new JTextField();
				panel_8.add(textField_10);
				textField_10.setColumns(10);
			
				JLabel lblSecondsToClimb_4 = new JLabel("seconds to climb");
				panel_8.add(lblSecondsToClimb_4);
			
			JPanel panel_9 = new JPanel();
			panel_9.setBackground(Color.LIGHT_GRAY);
			panelOtherAlliance3.add(panel_9);
			panel_9.setLayout(new GridLayout(2, 2, 0, 0));
			
				JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Level 1");
				buttonGroup_Other3.add(rdbtnNewRadioButton_5);
				panel_9.add(rdbtnNewRadioButton_5);
			
				JRadioButton rdbtnLevel_11 = new JRadioButton("Level 3");
				buttonGroup_Other3.add(rdbtnLevel_11);
				panel_9.add(rdbtnLevel_11);
			
				JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Level 2");
				buttonGroup_Other3.add(rdbtnNewRadioButton_4);
				panel_9.add(rdbtnNewRadioButton_4);
				*/
				
			JButton btnSubmit = new JButton("SUBMIT");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Robot r4541 = new Robot(Double.parseDouble(ourHatchTextField.getText()), Double.parseDouble(ourCargoTextField.getText()), Double.parseDouble(ourClimbTextField.getText()), getButtonSelected(buttonGroup));
					System.out.println(r4541.getHatchTime());
					System.out.println(r4541.getCargoTime());
					System.out.println(r4541.getClimbTime());
					System.out.println(r4541.getClimbLevel());
					
					System.out.println();
					
					Robot r2 = new Robot(Double.parseDouble(hatchTextField2.getText()), Double.parseDouble(cargoTextField2.getText()), Double.parseDouble(climbTextField2.getText()), getButtonSelected(buttonGroup_2));
					System.out.println(r2.getHatchTime());
					System.out.println(r2.getCargoTime());
					System.out.println(r2.getClimbTime());
					System.out.println(r2.getClimbLevel());
					
					System.out.println();
					
					Robot r3 = new Robot(Double.parseDouble(hatchTextField3.getText()), Double.parseDouble(cargoTextField3.getText()), Double.parseDouble(climbTextField3.getText()), getButtonSelected(buttonGroup_3));
					System.out.println(r3.getHatchTime());
					System.out.println(r3.getCargoTime());
					System.out.println(r3.getClimbTime());
					System.out.println(r3.getClimbLevel());
				}
			});
			btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
			btnSubmit.setBounds(0, 276, 450, 40);
			frame.getContentPane().add(btnSubmit);
			
			
				
	}
	
	protected int getButtonSelected(ButtonGroup group) {
		Enumeration<AbstractButton> buttons = group.getElements();
		while(buttons.hasMoreElements()) {
			AbstractButton currButton = buttons.nextElement();
			if(currButton.isSelected()) {
				String text = currButton.getText();
				if(text.equals("Level 1")) {
					return 1;
				}
				else if(text.equals("Level 2")) {
					return 2;
				}else {
					return 3;
				}
			}
		}
		return -1;
	}
}