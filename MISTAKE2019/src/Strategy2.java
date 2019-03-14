import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.util.ArrayList;


public class Strategy2 extends Robot implements Serializable{

	/**
	 * 
	 */
	private JFrame frame;
	protected JTextArea textArea;
	protected JTextArea txtrCommandText;
	protected JPanel commandPanel;
	static int interval;
	static Timer timer;
	public String secs = "150";
	protected int leftHatchNum = 0;
	protected int leftCargoNum = 0;
	protected int shipHatchNum = 0;
	protected int shipCargoNum = 0;
	protected int rightHatchNum = 0;
	protected int rightCargoNum = 0;
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private final ButtonGroup buttonGroup3 = new ButtonGroup();
	double possibleLeftRocketHatches = 6;
	double halfLeftRocketCargo = 0;
	double possibleLeftRocketCargo = 0;
	double possibleRightRocketCargo = 0;
	double halfRightRocketCargo = 0;
	double possibleShipCargo = 0;
	double halfShipCargo = 0;
	double possibleRightRocketHatches = 6;
	double possibleShipHatches = 6;
	int setInterval = 0;
	int time;
	public JTextField leftRocketTime;
	public JTextField rightRocketTime;
	JTextArea timeToComplete;
	protected boolean sandstormOver = false;
	protected double timedHatchTime;
	protected double timedCargoTime;
	ArrayList<Double> hatchList = new ArrayList <>();
	ArrayList<Double> cargoList = new ArrayList<>();
	double previousHatchTime;
	double previousCargoTime;
	protected double timedShipHatchTime;
	protected double timedShipCargoTime;
	ArrayList<Double> shipHatchList = new ArrayList<>();
	ArrayList<Double> shipCargoList = new ArrayList<>();
	double previousShipHatchTime;
	double previousShipCargoTime;
	
	
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Strategy2 window = new Strategy2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Strategy2(){
		initialize();
}
	
	protected void initialize() {
		setFrame(new JFrame());
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setBounds(100, 100, 600, 380);
		getFrame().getContentPane().setLayout(null);
		
		JPanel timePanel = new JPanel();
		timePanel.setBounds(6, 6, 169, 59);
		getFrame().getContentPane().add(timePanel);
		timePanel.setLayout(new GridLayout(2, 1, 0, 0));
		
			textArea = new JTextArea();
			textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			textArea.setForeground(Color.BLACK);
			textArea.setEditable(false);
			timePanel.add(textArea);
		
		JPanel buttonPanel = new JPanel();
		timePanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(1, 2, 0, 0));
		
			JButton btnReset = new JButton("RESET");
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					secs = "150";
					interval = 150;
					textArea.setText(null);
					textArea.setText("-");
					timer.cancel();
					timer = null;
				}
			});
			btnReset.setFont(new Font("Monospaced", Font.PLAIN, 17));
			buttonPanel.add(btnReset);
		
			JButton btnStartTimer = new JButton("START");
			btnStartTimer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ( timer != null ) 
						return;
					
					final int delay = 1000;
					final int period = 1000;
			    	timer = new Timer();
			    	interval = Integer.parseInt("300");
			    	textArea.setText(null);
			    	textArea.setText(secs);

			    	timer.scheduleAtFixedRate(new TimerTask() {
			    	
			        	public void run() {
			        		textArea.setText(null);
			            	textArea.setText("" + (setInterval() / 2));
			            	setTime("" + ((setInterval() / 2) - 1));
			        	}
			        	
			        	
			    	}, delay, period);
			    	
			}
				
			private final int setInterval() {
		    	if (interval == 1)
		        	timer.cancel();
		    	return --interval;
				}
			
			});
		
			btnStartTimer.setFont(new Font("Monospaced", Font.PLAIN, 17));
			buttonPanel.add(btnStartTimer);
			
		
		JPanel leftRocketPanel = new JPanel();
		leftRocketPanel.setBounds(6, 89, 119, 156);
		leftRocketPanel.setOpaque(false);
		getFrame().getContentPane().add(leftRocketPanel);
			leftRocketPanel.setLayout(null);
		
			JLabel lblRocket = new JLabel("Left Rocket");
			lblRocket.setForeground(Color.WHITE);
			lblRocket.setBounds(6, 5, 113, 20);
			lblRocket.setFont(new Font("Monospaced", Font.PLAIN, 17));
			leftRocketPanel.add(lblRocket);
			
			JTextArea leftHatchText = new JTextArea("" + leftHatchNum);
			leftHatchText.setForeground(Color.WHITE);
			leftHatchText.setBounds(98, 37, 21, 32);
			leftHatchText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			leftHatchText.setEditable(false);
			leftHatchText.setOpaque(false);
			leftRocketPanel.add(leftHatchText);
		
			JButton btnNewButton = new JButton("Hatch");
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					leftHatchNum++;
					if(leftHatchNum >= 6) {
						leftHatchNum = 6;
					}
					leftHatchText.setText("" + leftHatchNum);
					halfLeftRocketCargo += 0.5;	
					if(sandstormOver == true) {
						double hatchTime;
						if (hatchList.size() == 0) {
							previousHatchTime = 0;
						}
						if(previousHatchTime > (135 - getTime())) {
							if(previousHatchTime > 135) {
								previousHatchTime -= 135;
							}
							hatchTime = (135 - (previousHatchTime - getTime()));
						}else {
						hatchTime = (getTime() - previousHatchTime);
						}
						hatchList.add(hatchTime);
						previousHatchTime += hatchTime;
					}
				}
			});
			btnNewButton.setBounds(12, 30, 85, 35);
			btnNewButton.setBackground(Color.WHITE);
			leftRocketPanel.add(btnNewButton);
			
			JTextArea leftCargoText = new JTextArea("" + leftCargoNum);
			leftCargoText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			leftCargoText.setForeground(Color.WHITE);
			leftCargoText.setBounds(98, 72, 21, 38);
			leftCargoText.setEditable(false);
			leftCargoText.setOpaque(false);
			leftRocketPanel.add(leftCargoText);
		
			JButton btnCargo = new JButton("Cargo");
			btnCargo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			btnCargo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					leftCargoNum++;
					if(leftCargoNum >= 6) {
						leftCargoNum = 6;
					}
					leftCargoText.setText("" + leftCargoNum);
					if(sandstormOver == true) {
						double cargoTime;
						if (cargoList.size() == 0) {
							previousCargoTime = 0;
						}
						if(previousCargoTime > (135 - getTime())) {
							if(previousCargoTime > 135) {
								previousCargoTime -= 135;
							}
							cargoTime = (135 - (previousCargoTime - getTime()));
						}else {
						cargoTime = (getTime() - previousCargoTime);
						}
						cargoList.add(cargoTime);
						previousCargoTime += cargoTime;
					}
				}
			});
			btnCargo.setBounds(12, 64, 85, 35);
			leftRocketPanel.add(btnCargo);
			
			leftRocketTime = new JTextField();
			leftRocketTime.setBounds(6, 124, 107, 26);
			leftRocketPanel.add(leftRocketTime);
			leftRocketTime.setColumns(10);
			
			timeToComplete = new JTextArea("Time to Complete Rocket:");
			timeToComplete.setForeground(Color.WHITE);
			timeToComplete.setFont(new Font("Monospaced", Font.PLAIN, 12));
			timeToComplete.setOpaque(false);
			timeToComplete.setBounds(6, 111, 113, 16);
			leftRocketPanel.add(timeToComplete);
		
		JPanel cargoShipPanel = new JPanel();
		cargoShipPanel.setBounds(220, 134, 137, 123);
		cargoShipPanel.setOpaque(false);
		getFrame().getContentPane().add(cargoShipPanel);
			cargoShipPanel.setLayout(null);
		
			JLabel lblCargoShip = new JLabel("Cargo Ship");
			lblCargoShip.setForeground(Color.WHITE);
			lblCargoShip.setBounds(10, 5, 122, 20);
			lblCargoShip.setFont(new Font("Monospaced", Font.PLAIN, 17));
			cargoShipPanel.add(lblCargoShip);
			
			JTextArea shipHatchText = new JTextArea("" + shipHatchNum);
			shipHatchText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			shipHatchText.setForeground(Color.WHITE);
			shipHatchText.setBounds(95, 37, 25, 32);
			shipHatchText.setOpaque(false);
			cargoShipPanel.add(shipHatchText);
			
			JButton btnHatch = new JButton("Hatch");
			btnHatch.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			btnHatch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					shipHatchNum++;
					if(shipHatchNum >= 8) {
						shipHatchNum = 8;
					}
					shipHatchText.setText("" + shipHatchNum);
					halfShipCargo += 0.5;
					if(sandstormOver == true) {
						double hatchTime;
						if (shipHatchList.size() == 0) {
							previousShipHatchTime = 0;
						}
						if(previousShipHatchTime > (135 - getTime())) {
							if(previousShipHatchTime > 135) {
								previousShipHatchTime -= 135;
							}
							hatchTime = (135 - (previousShipHatchTime - getTime()));
						}else {
						hatchTime = (getTime() - previousShipHatchTime);
						}
						shipHatchList.add(hatchTime);
						previousShipHatchTime += hatchTime;
					}
				}
			});
			btnHatch.setBounds(10, 30, 85, 35);
			cargoShipPanel.add(btnHatch);
			
			JTextArea shipCargoText = new JTextArea("" + shipCargoNum);
			shipCargoText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			shipCargoText.setForeground(Color.WHITE);
			shipCargoText.setOpaque(false);
			shipCargoText.setBounds(95, 72, 25, 27);
			cargoShipPanel.add(shipCargoText);
		
			JButton btnCargo_1 = new JButton("Cargo");
			btnCargo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			btnCargo_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					shipCargoNum++;
					if(shipCargoNum >= 8) {
						shipCargoNum = 8;
					}
					shipCargoText.setText("" + shipCargoNum);
					if(sandstormOver == true) {
						double cargoTime;
						if (shipCargoList.size() == 0) {
							previousShipCargoTime = 0;
						}
						if(previousShipCargoTime > (135 - getTime())) {
							if(previousShipCargoTime > 135) {
								previousShipCargoTime -= 135;
							}
							cargoTime = (135 - (previousShipCargoTime - getTime()));
						}else {
						cargoTime = (getTime() - previousShipCargoTime);
						}
						shipCargoList.add(cargoTime);
						previousShipCargoTime += cargoTime;
					}
				}
			});
			btnCargo_1.setBounds(10, 64, 85, 35);
			cargoShipPanel.add(btnCargo_1);
		
		JPanel rightRocketPanel = new JPanel();
		rightRocketPanel.setBounds(449, 89, 145, 156);
		rightRocketPanel.setOpaque(false);
		getFrame().getContentPane().add(rightRocketPanel);
			rightRocketPanel.setLayout(null);
		
			JLabel lblRightRocket = new JLabel("Right Rocket");
			lblRightRocket.setForeground(Color.WHITE);
			lblRightRocket.setBounds(12, 5, 127, 20);
			lblRightRocket.setFont(new Font("Monospaced", Font.PLAIN, 17));
			rightRocketPanel.add(lblRightRocket);
			
			JTextArea rightHatchText = new JTextArea("" + rightCargoNum);
			rightHatchText.setEditable(false);
			rightHatchText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			rightHatchText.setForeground(Color.WHITE);
			rightHatchText.setOpaque(false);
			rightHatchText.setBounds(118, 32, 21, 22);
			rightRocketPanel.add(rightHatchText);
		
			JButton btnHatch_1 = new JButton("Hatch");
			btnHatch_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			btnHatch_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rightHatchNum++;
					if(rightHatchNum >= 6) {
						rightHatchNum = 6;
					}
					rightHatchText.setText("" + rightHatchNum);
					halfRightRocketCargo += 0.5;
					if(sandstormOver == true) {
						double hatchTime;
						if (hatchList.size() == 0) {
							previousHatchTime = 0;
						}
						if(previousHatchTime > (135 - getTime())) {
							if(previousHatchTime > 135) {
								previousHatchTime -= 135;
							}
							hatchTime = (135 - (previousHatchTime - getTime()));
						}else {
						hatchTime = (getTime() - previousHatchTime);
						}
						hatchList.add(hatchTime);
						previousHatchTime += hatchTime;
					}
				}
			});
			btnHatch_1.setBounds(12, 30, 85, 35);
			rightRocketPanel.add(btnHatch_1);
			
			JTextArea rightCargoText = new JTextArea("" + rightCargoNum);
			rightCargoText.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			rightCargoText.setForeground(Color.WHITE);
			rightCargoText.setOpaque(false);
			rightCargoText.setBounds(118, 65, 21, 43);
			rightRocketPanel.add(rightCargoText);
		
			JButton btnCargo_2 = new JButton("Cargo");
			btnCargo_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			btnCargo_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rightCargoNum++;
					if(rightCargoNum >= 6) {
						rightCargoNum = 6;
					}
					rightCargoText.setText("" + rightCargoNum);
					if(sandstormOver == true) {
						double cargoTime;
						if (cargoList.size() == 0) {
							previousCargoTime = 0;
						}
						if(previousCargoTime > (135 - getTime())) {
							if(previousCargoTime > 135) {
								previousCargoTime -= 135;
							}
							cargoTime = (135 - (previousCargoTime - getTime()));
						}else {
						cargoTime = (getTime() - previousCargoTime);
						}
						cargoList.add(cargoTime);
						previousCargoTime += cargoTime;
					}
				}
			});
			btnCargo_2.setBounds(12, 65, 85, 35);
			rightRocketPanel.add(btnCargo_2);
			
			rightRocketTime = new JTextField();
			rightRocketTime.setBounds(12, 124, 130, 26);
			rightRocketPanel.add(rightRocketTime);
			rightRocketTime.setColumns(10);
			
			JTextArea txtrTimeToComplete = new JTextArea();
			txtrTimeToComplete.setFont(new Font("Monospaced", Font.PLAIN, 12));
			txtrTimeToComplete.setForeground(Color.WHITE);
			txtrTimeToComplete.setText("Time to Complete");
			txtrTimeToComplete.setOpaque(false);
			txtrTimeToComplete.setBounds(12, 105, 127, 20);
			rightRocketPanel.add(txtrTimeToComplete);
			
		
		commandPanel = new JPanel();
		commandPanel.setBounds(291, 6, 303, 71);
		getFrame().getContentPane().add(commandPanel);
		commandPanel.setLayout(null);
		
			JLabel lblCommand = new JLabel("Command:");
			lblCommand.setFont(new Font("Monospaced", Font.PLAIN, 14));
			lblCommand.setBounds(0, 0, 262, 16);
			commandPanel.add(lblCommand);
			
		
			txtrCommandText = new JTextArea();
			txtrCommandText.setEditable(false);
			txtrCommandText.setBounds(0, 17, 303, 54);
			commandPanel.add(txtrCommandText);
		
		JPanel panelRdBtn1 = new JPanel();
		panelRdBtn1.setBounds(6, 272, 137, 80);
		panelRdBtn1.setOpaque(false);
		getFrame().getContentPane().add(panelRdBtn1);
		panelRdBtn1.setLayout(null);
		
			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Defended");
			rdbtnNewRadioButton_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup1.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setBounds(2, 16, 141, 23);
			panelRdBtn1.add(rdbtnNewRadioButton_1);
		
			JRadioButton rdbtnNotWorking = new JRadioButton("Not Working");
			rdbtnNotWorking.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup1.add(rdbtnNotWorking);
			rdbtnNotWorking.setBounds(2, 33, 129, 23);
			panelRdBtn1.add(rdbtnNotWorking);
		
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Normal");
			rdbtnNewRadioButton.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup1.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBounds(2, 51, 141, 23);
			panelRdBtn1.add(rdbtnNewRadioButton);
			
			JLabel lblRobot = new JLabel("Robot 4541");
			lblRobot.setFont(new Font("Monospaced", Font.PLAIN, 14));
			lblRobot.setBounds(22, 5, 80, 16);
			panelRdBtn1.add(lblRobot);
		
		JPanel panelRdBtn2 = new JPanel();
		panelRdBtn2.setBounds(220, 272, 169, 80);
		panelRdBtn2.setOpaque(false);
		getFrame().getContentPane().add(panelRdBtn2);
		panelRdBtn2.setLayout(null);
		
			JRadioButton rdbtnNotWorking_1 = new JRadioButton("Not Working");
			rdbtnNotWorking_1.setForeground(Color.WHITE);
			rdbtnNotWorking_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup2.add(rdbtnNotWorking_1);
			rdbtnNotWorking_1.setBounds(15, 33, 141, 23);
			panelRdBtn2.add(rdbtnNotWorking_1);
		
			JRadioButton rdbtnDefended = new JRadioButton("Defended");
			rdbtnDefended.setForeground(Color.WHITE);
			rdbtnDefended.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup2.add(rdbtnDefended);
			rdbtnDefended.setBounds(15, 16, 141, 23);
			panelRdBtn2.add(rdbtnDefended);
		
			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Normal");
			rdbtnNewRadioButton_2.setForeground(Color.WHITE);
			rdbtnNewRadioButton_2.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup2.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setBounds(15, 51, 141, 23);
			panelRdBtn2.add(rdbtnNewRadioButton_2);
			
			JLabel lblRobot_1 = new JLabel("Robot 2");
			lblRobot_1.setForeground(Color.WHITE);
			lblRobot_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
			lblRobot_1.setBounds(44, 6, 61, 16);
			panelRdBtn2.add(lblRobot_1);
		
		JPanel panelRdBtn3 = new JPanel();
		panelRdBtn3.setBounds(449, 272, 145, 80);
		panelRdBtn3.setOpaque(false);
		getFrame().getContentPane().add(panelRdBtn3);
		panelRdBtn3.setLayout(null);
		
			JRadioButton rdbtnDefended_1 = new JRadioButton("Defended");
			rdbtnDefended_1.setForeground(Color.WHITE);
			rdbtnDefended_1.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup3.add(rdbtnDefended_1);
			rdbtnDefended_1.setBounds(6, 16, 115, 23);
			panelRdBtn3.add(rdbtnDefended_1);
		
			JRadioButton rdbtnNormal = new JRadioButton("Normal");
			rdbtnNormal.setForeground(Color.WHITE);
			rdbtnNormal.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup3.add(rdbtnNormal);
			rdbtnNormal.setBounds(6, 51, 115, 23);
			panelRdBtn3.add(rdbtnNormal);
		
			JRadioButton rdbtnNotWorking_2 = new JRadioButton("Not Working");
			rdbtnNotWorking_2.setForeground(Color.WHITE);
			rdbtnNotWorking_2.setFont(new Font("Monospaced", Font.PLAIN, 14));
			buttonGroup3.add(rdbtnNotWorking_2);
			rdbtnNotWorking_2.setBounds(6, 33, 133, 23);
			panelRdBtn3.add(rdbtnNotWorking_2);
			
			JLabel lblRobot_2 = new JLabel("Robot 3");
			lblRobot_2.setFont(new Font("Monospaced", Font.PLAIN, 14));
			lblRobot_2.setForeground(Color.WHITE);
			lblRobot_2.setBounds(38, 5, 61, 16);
			panelRdBtn3.add(lblRobot_2);
			
			JPanel panel = new JPanel();
			panel.setBounds(162, 66, 137, 39);
			panel.setOpaque(false);
			frame.getContentPane().add(panel);
			
			JCheckBox chckbxSandstormOver = new JCheckBox("Sandstorm Over", sandstormOver);
			chckbxSandstormOver.setFont(new Font("Monospaced", Font.PLAIN, 14));
			chckbxSandstormOver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(chckbxSandstormOver.isSelected()) {
						sandstormOver = true;
					}else {
						sandstormOver = false;
					}
				}
			});
			chckbxSandstormOver.setForeground(Color.WHITE);
			chckbxSandstormOver.setVisible(true);
			chckbxSandstormOver.setOpaque(false);
			panel.add(chckbxSandstormOver);
			
			JLabel label = new JLabel("");
			Image pics = new ImageIcon(this.getClass().getResource("/SpaceBkgrndMed.png")).getImage();
			label.setIcon(new ImageIcon(pics));
			label.setBounds(0, 0, 600, 358);
			getFrame().getContentPane().add(label);
			
			
			
	}
	
	public int getLeftHatchNum() {
		return leftHatchNum;
	}
	
	public void setLeftHatchNum(int lh) {
		leftHatchNum = lh;
		return;
	}
	
	public int getLeftCargoNum() {
		return leftCargoNum;
	}
	
	public int getShipHatchNum() {
		return shipHatchNum;
	}
	
	public int getShipCargoNum() {
		return shipCargoNum;
	}
	
	public int getRightHatchNum() {
		return rightHatchNum;
	}
	
	public int getRightCargoNum() {
		return rightCargoNum;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(String t) {
		if(textArea != null) {
			time = Integer.parseInt(t);
		}
		return;
	}
	
	public double setTimedHatchTime() {
		double total = 0;
		for(int i = 0; i < hatchList.size();i++) {
			total += hatchList.get(i);
		}
		timedHatchTime = 135 - (total / hatchList.size());
		return timedHatchTime;
	}
	
	public double setTimedCargoTime() {
		double total = 0;
		for(int i = 0; i < cargoList.size();i++) {
			total += cargoList.get(i);
		}
		timedCargoTime = 135 - (total / cargoList.size());
		return timedCargoTime;
	}
	
	public double setTimedShipHatchTime() {
		double total = 0;
		for(int i = 0; i < shipHatchList.size();i++) {
			total += shipHatchList.get(i);
		}
		timedShipHatchTime = 135 - (total / shipHatchList.size());
		return timedShipHatchTime;
	}
	
	public double setTimedShipCargoTime() {
		double total = 0;
		for(int i = 0; i < shipCargoList.size();i++) {
			total += shipCargoList.get(i);
		}
		timedShipCargoTime = 135 - (total / shipCargoList.size());
		return timedShipCargoTime;
	}
}