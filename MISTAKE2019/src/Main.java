
public class Main extends Match{
	
	Robot r4541;
	Robot r2;
	Robot r3;
	Match match;
	Score currScore;
	static int hatchPoints = 2;
	

	public static void main(String[] args) {
		Strategy strategy = new Strategy();
		Robot r4541 = new Robot();
		r4541.setHatchTime(Double.parseDouble(strategy.ourHatchTextField.getText()));
		r4541.getHatchTime();
		Robot r2;
		Robot r3;
		Match match = new Match();
		Match tempState;
		Score myScore = new Score();
		
		System.out.println(myScore.currHatchPoints);
		
		myScore.calculateMoveScore(hatchPoints);
		System.out.println(myScore.calculateTempScore());
		
		
		
		/*
		JFrame frame = new JFrame();
		frame.setVisible(true);
		Strategy strategy = new Strategy();
		strategy.Runnable();
		strategy.initialize(); */
	}

}