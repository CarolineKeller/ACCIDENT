import javax.swing.JFrame;

public class Main {
	
	Robot r4541;
	Robot r2;
	Robot r3;
	Match match;
	Score currScore;
	

	public static void main(String[] args) {
		Robot r4541 = new Robot();
		r4541.setHatchTime(5);
		r4541.getHatchTime();
		Robot r2;
		Robot r3;
		Match currState;
		Match tempState;
		Score currScore = new Score();
		System.out.println(currScore.currHatchPoints);
		
		
		
		
		/*
		JFrame frame = new JFrame();
		frame.setVisible(true);
		Strategy strategy = new Strategy();
		strategy.Runnable();
		strategy.initialize(); */
	}

}