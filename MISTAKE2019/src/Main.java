import java.awt.EventQueue;

public class Main extends Match{
	
	Robot r4541;
	Robot r2;
	Robot r3;
	Match match;
	Score currScore;
	static int hatchPoints = 2;
	

	public static void main(String[] args) {
		Strategy strategy = new Strategy();
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
		Match match = new Match();/*
		Match tempState;
		Score myScore = new Score();
		
		System.out.println(myScore.currHatchPoints);
		
		myScore.calculateMoveScore(hatchPoints);
		System.out.println(myScore.calculateTempScore());
		
		*/
		
		Strategy2 s2 = new Strategy2();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Strategy2 window = new Strategy2();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		s2.leftHatchNum = 2.0;
		match.possibleLeftRocketHatches = 4;
		System.out.println(match.possibleLeftRocketCargo);
		System.out.println(match.bestMove());
		
		
	}

}