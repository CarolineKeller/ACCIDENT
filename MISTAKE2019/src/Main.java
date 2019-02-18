import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedReader;


public class Main extends Match{
	
	Score currScore;
	static int hatchPoints = 2;
	private static final String COMMA_DELIMITER = ",";
	static List <Robot> robotList;
	static Robot r;
	static Timer internalTimer;
	static int internalInterval;
	

	public static void main(String[] args) {
		/*Strategy strategy = new Strategy();
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
		
		/*Robot r4541 = new Robot();
		r4541.setHatchTime(Double.parseDouble(strategy.ourHatchTextField.getText()));
		r4541.getHatchTime();
		Robot r2;
		Robot r3; */
		Match match = new Match();
		/*
		Match tempState;
		Score myScore = new Score();
		
		System.out.println(myScore.currHatchPoints);
		
		myScore.calculateMoveScore(hatchPoints);
		System.out.println(myScore.calculateTempScore());
		
		*/
		match.possibleLeftRocketHatches = 3;
		match.possibleLeftRocketCargo = 2;
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("Strategy Data Trial - Sheet1.csv"));
			robotList = new ArrayList <Robot>();
			
			String line = "";
			br.readLine();
			
			while ((line = br.readLine()) != null) {
				String[] data = line.split(COMMA_DELIMITER);
				
				if(data.length > 0) {
					r = new Robot((Double.parseDouble(data[1])), (Double.parseDouble(data[2])), (Double.parseDouble(data[3])), (Integer.parseInt(data[4])));
					robotList.add(r);
				}
			}
			
			for(Robot a : robotList) {
				System.out.println("Hatch Time: " + a.getHatchTime() + "  Cargo Time: " + a.getCargoTime() + "   Climb Time: " + a.getClimbTime() + "   Climb Level: " + a.getClimbLevel() + " ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			}catch(IOException ie) {
				System.out.println("BufferedReader Error");
				ie.printStackTrace();
			}
		
	}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					match.window = new Strategy2();
					match.window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				match.window.getLeftHatchNum();
				match.window.getLeftCargoNum();
				match.window.getRightHatchNum();
				match.window.getRightCargoNum();
				{
					String secs = "150";
				final int delay = 1000;
				final int period = 1000;
		    	internalTimer = new Timer();
		    	internalInterval = Integer.parseInt(secs);


		    	internalTimer.scheduleAtFixedRate(new TimerTask() {
		    	
		        	public void run() {
		        		System.out.println(match.bestMoveR4541());
						match.window.txtrCommandText.setText(match.bestMoveR4541());
		    			
		        	}
		    	}, delay, period);
		}
				
			}
		});
	

		
	}
}