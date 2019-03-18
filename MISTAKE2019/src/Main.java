import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.io.BufferedReader;


public class Main extends Rocket{
	
	Score currScore;
	static int hatchPoints = 2;
	private static final String COMMA_DELIMITER = ",";
	static ArrayList <Robot> robotList;
	static String [][] myArray;
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
		Match tempState;
		Score myScore = new Score();
		
		System.out.println(myScore.currHatchPoints);
		
		myScore.calculateMoveScore(hatchPoints);
		System.out.println(myScore.calculateTempScore());
		
		*/
		
	/*	BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("Strategy Data Trial - Sheet1.csv"));
			robotList = new ArrayList <Robot>();
			
			String line = "";
			br.readLine();
			
			myArray = new String[3][5];
			
			int row = 0;
			int col = 0;
			
			while ((line = br.readLine()) != null) {
				String[] data = line.split(COMMA_DELIMITER);
				
				if(data.length > 0) {
					r = new Robot((data[0]), 
							(Double.parseDouble(data[1])), (Double.parseDouble(data[2])), (Double.parseDouble(data[3])), (Integer.parseInt(data[4])));
					robotList.add(r);
				}
				
				for(String str : data) {
					String str_string  = str;
					myArray[row][col] = str_string;
					
					col++;
				}
				row++;
				col = 0;
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
		
	}*/
		Match match = new Match();
		Rocket leftRocket = new Rocket(match.possibleLeftRocketHatches, match.possibleLeftRocketCargo);
		Rocket rightRocket = new Rocket(match.possibleRightRocketHatches, match.possibleRightRocketCargo);
		CargoShip ship = new CargoShip(match.possibleShipHatches, match.possibleShipCargo);
		
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
				final int delay = 1000;
				final int period = 1000;
		    	internalTimer = new Timer();
		    	internalInterval = 3000;


		    	internalTimer.scheduleAtFixedRate(new TimerTask() {
		    	
		        	public void run() {
		        		match.window.setTimedHatchTime();
		        		match.window.setTimedCargoTime();
		        		match.window.setTimedShipHatchTime();
		        		match.window.setTimedShipCargoTime();
		        		
		        		leftRocket.setRocketHatch(match.window.possibleLeftRocketHatches);
		        		leftRocket.setRocketCargo(match.window.possibleLeftRocketCargo);
		        		rightRocket.setRocketHatch(match.window.possibleRightRocketHatches);
		        		rightRocket.setRocketCargo(match.window.possibleRightRocketCargo);
		        		ship.setShipHatch(match.window.possibleShipHatches);
		        		ship.setShipCargo(match.window.possibleShipCargo);
		        		
		        		match.r4541.setTeamName("4541");
		        		/*match.r4541.setTeamName(myArray[0][0]);
		        		match.r4541.setHatchTime(Double.parseDouble(myArray[0][1]));
		        		match.r4541.setCargoTime(Double.parseDouble(myArray[0][2]));
		        		match.r4541.setClimbTime(Double.parseDouble(myArray[0][3]));*/
		        		match.r4541.setClimbTime(1.43);
		        		match.calculateHatchPointsR4541();
		        		match.calculateCargoPointsR4541();
		        		/*match.r2.setTeamName(myArray[0][1]);
		        		match.r2.setHatchTime(Double.parseDouble(myArray[1][1]));
		        		match.r2.setCargoTime(Double.parseDouble(myArray[1][2]));
		        		match.r2.setClimbTime(Double.parseDouble(myArray[1][3]));*/
		        		match.r2.setClimbTime(10.18);
		        		match.calculateHatchPointsR2();
		        		match.calculateCargoPointsR2();
		        		/*match.r3.setTeamName(myArray[2][0]);
		        		match.r3.setHatchTime(Double.parseDouble(myArray[2][1]));
		        		match.r3.setCargoTime(Double.parseDouble(myArray[2][2]));
		        		match.r3.setClimbTime(Double.parseDouble(myArray[2][3]));*/
		        		
		        		match.calculatePossibleLeftRocketHatches();
		        		match.calculatePossibleLeftRocketCargo();
		        		match.calculatePossibleShipHatches();
		        		match.calculatePossibleShipCargo();
		        		match.calculatePossibleRightRocketHatches();
		        		match.calculatePossibleRightRocketCargo();
		        		
		        		double ht = (match.r4541.getHatchTime() + match.r2.getHatchTime() + match.r3.getHatchTime()) / 3;
		        		double ct = (match.r4541.getCargoTime() + match.r2.getCargoTime() + match.r3.getCargoTime()) / 3;
		        		
						match.window.txtrCommandText.setText(match.bestMoveR4541()+ "\n" + match.bestMoveR2() + "\n" + match.bestMoveR3());
						
						String l = leftRocket.calculateCompletionTime(match.calculatePossibleLeftRocketHatches(), match.calculatePossibleLeftRocketCargo(), 
							match.window.timedHatchTime, match.window.timedCargoTime, ht, ct) + " seconds";
						match.window.leftRocketTime.setText(l);
						
						String r = rightRocket.calculateCompletionTime(match.calculatePossibleRightRocketHatches(), match.calculatePossibleRightRocketCargo(), 
							match.window.timedHatchTime, match.window.timedCargoTime, ht, ct) + " seconds";
						match.window.rightRocketTime.setText(r);
						
						String s = ship.calculateCompletionTime(match.calculatePossibleShipHatches(),match.calculatePossibleShipCargo(), 
							match.window.timedShipHatchTime, match.window.timedShipCargoTime, ht, ct) + " seconds";
						match.window.textField.setText(s);
		    			
		        	}
		    	}, delay, period);
				}
				
			}
		});
		
	}
}

