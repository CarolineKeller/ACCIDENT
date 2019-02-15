
public class Match extends Strategy2 {

	Field myField;
	// Alliance friendlyAlliance;
	// Alliance enemyAlliance;
	Robot r4541;
	Robot r2;
	Robot r3;
	static int hatchPoints = 2;
	static int cargoPoints = 3;
	double cargoPointsPerSecond = 0;
	double hatchPointsPerSecond = 0;

	public Match() {
	}

	public double calculateHatchPoints() {
		hatchPointsPerSecond = hatchPoints / r4541.getHatchTime();
		return hatchPointsPerSecond;
	}

	public double calculateCargoPoints() {
		cargoPointsPerSecond = cargoPoints / r4541.getCargoTime();
		return cargoPointsPerSecond;
	}
	
	public void calculatePossibleLeftRocketHatches() {
		possibleLeftRocketHatches = 6 - leftHatchNum;
	}
	
	public void calculatePossibleLeftRocketCargo() {
		possibleLeftRocketCargo = 6 - leftCargoNum;
	}
	
	public void calculatePossibleRightRocketHatches() {
		possibleRightRocketHatches = 6 - rightHatchNum;
	}
	
	public void calculatePossibleRightRocketCargo() {
		possibleRightRocketCargo = 6 - rightCargoNum;
	}
	
	public void calculatePossibleShipHatches() {
		possibleShipHatches = 6 - shipHatchNum;
	}
	
	public void calculateShipCargo() {
		possibleShipCargo = 6 - shipCargoNum;
	}
	

	public String bestMove() {
		String leftRocketHatch = "Put a hatch on the left rocket";
		String leftRocketCargo = "Put cargo in the left rocket";
		String rightRocketHatch = "Put a hatch on the right rocket";
		String rightRocketCargo = "Put cargo in the right rocket";
		String shipHatch = "Put a hatch on the cargo ship";
		String shipCargo = "Put cargo in the cargo ship";
		possibleLeftRocketCargo *= 2;
		
		calculatePossibleLeftRocketHatches();
		calculatePossibleRightRocketHatches();
		calculatePossibleShipHatches();

		if ((possibleLeftRocketCargo + possibleLeftRocketHatches) < (possibleRightRocketCargo + possibleRightRocketHatches)){

			if (possibleLeftRocketCargo >= 2) {
				if (calculateHatchPoints() > calculateCargoPoints()) {
					return leftRocketHatch;
				} else if (calculateHatchPoints() < calculateCargoPoints()) {
					return leftRocketCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else {
				return leftRocketHatch;
			}
		}else if ((possibleRightRocketCargo + possibleRightRocketHatches) < (possibleLeftRocketCargo + possibleLeftRocketCargo)) {
			if (possibleRightRocketCargo >= 2) {
				if (calculateHatchPoints() > calculateCargoPoints()) {
					return rightRocketHatch;
					
				} else if (calculateHatchPoints() < calculateCargoPoints()) {
					return rightRocketCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else {
				return rightRocketHatch;
			}
		}else if (leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6) {
			if (possibleShipCargo >= 2) {
				if (calculateHatchPoints() > calculateCargoPoints()) {
					return shipHatch;
				} else if (calculateHatchPoints() < calculateCargoPoints()) {
					return shipCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else {
				return shipHatch;
			}
		
		}else {
			return "-";
		}

	}
}
