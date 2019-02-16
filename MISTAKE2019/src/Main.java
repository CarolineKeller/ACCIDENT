import java.awt.EventQueue;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;


public class Main extends Match{
	
	Score currScore;
	static int hatchPoints = 2;
	static Strategy2 window;
	private static final String COMMA_DELIMITER = ",";
	

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
		
		
BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("Strategy Data Trial - Sheet1.csv"));
			List <Robot> robotList = new ArrayList <Robot>();
			
			String line = "";
			br.readLine();
			
			while ((line = br.readLine()) != null) {
				String[] data = line.split(COMMA_DELIMITER);
				
				if(data.length > 0) {
					Robot r = new Robot((Double.parseDouble(data[1])), (Double.parseDouble(data[2])), (Double.parseDouble(data[3])), (Integer.parseInt(data[4])));
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
					window = new Strategy2();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				window.getLeftHatchNum();
				window.getLeftCargoNum();
				window.getRightHatchNum();
				window.getRightCargoNum();
				//for(int i = 0; i < 50; i++) {
				System.out.println(match.bestMoveR4541());
				window.txtrCommandText.setText(match.bestMoveR4541());
				//}
			}
		});
	

		
	}
}