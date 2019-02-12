
public class Match extends Strategy2{
	Field myField;
	//Alliance friendlyAlliance;
	//Alliance enemyAlliance;
	Robot r4541;
	Robot r2;
	Robot r3;
	static int hatchPoints = 2;
	static int cargoPoints = 3;
	double cargoPointsPerSecond = 0;
	
	public Match() {
	}
	
	public double calculateHatchPoints() {
		double hatchPointsPerSecond = hatchPoints / r4541.getHatchTime();
		return hatchPointsPerSecond;
	}
	
	public double calculateCargoPoints() {
		if(myField.leftRocket.rocketHatch >= 2) {
			cargoPointsPerSecond = cargoPoints / r4541.getCargoTime();
		}
		return cargoPointsPerSecond;
	}

}
