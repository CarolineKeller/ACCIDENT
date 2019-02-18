
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
	Strategy2 window;

	public Match() {
	}

	public double calculateHatchPointsR4541() {
		hatchPointsPerSecond = hatchPoints / r4541.getHatchTime();
		return hatchPointsPerSecond;
	}

	public double calculateCargoPointsR4541() {
		cargoPointsPerSecond = cargoPoints / r4541.getCargoTime();
		return cargoPointsPerSecond;
	}
	
	public double calculatePossibleLeftRocketHatches() {
		possibleLeftRocketHatches = 6 - window.leftHatchNum;
		return possibleLeftRocketHatches;
	}
	
	public double calculatePossibleLeftRocketCargo() {
		possibleLeftRocketCargo = (window.possibleLeftRocketCargo * 2) - window.leftCargoNum;
		return possibleLeftRocketCargo;
	}
	
	public double calculatePossibleRightRocketHatches() {
		possibleRightRocketHatches = 6 - window.rightHatchNum;
		return possibleRightRocketHatches;
	}
	
	public double calculatePossibleRightRocketCargo() {
		possibleRightRocketCargo = (window.possibleRightRocketCargo * 2) - window.rightCargoNum;
		return possibleRightRocketCargo;
	}
	
	public double calculatePossibleShipHatches() {
		possibleShipHatches = 6 - window.shipHatchNum;
		return possibleShipHatches;
	}
	
	public double calculatePossibleShipCargo() {
		possibleShipCargo = (window.possibleShipCargo * 2) - window.shipCargoNum;
		return possibleShipCargo;
	}
	

	public String bestMoveR4541() {
		String leftRocketHatch = "Put a hatch on the left rocket";
		String leftRocketCargo = "Put cargo in the left rocket";
		String rightRocketHatch = "Put a hatch on the right rocket";
		String rightRocketCargo = "Put cargo in the right rocket";
		String shipHatch = "Put a hatch on the cargo ship";
		String shipCargo = "Put cargo in the cargo ship";
		

		if ((calculatePossibleLeftRocketCargo() + calculatePossibleLeftRocketHatches()) < (calculatePossibleRightRocketCargo() + calculatePossibleRightRocketHatches()) && window.leftHatchNum != 6 && window.leftCargoNum != 6){

			if (possibleLeftRocketCargo >= 2) {
				if (calculateHatchPointsR4541() > calculateCargoPointsR4541()) {
					return leftRocketHatch;
				} else if (calculateHatchPointsR4541() < calculateCargoPointsR4541()) {
					return leftRocketCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else {
				return leftRocketHatch;
			}
		}else if ((calculatePossibleRightRocketCargo() + calculatePossibleRightRocketHatches()) < (calculatePossibleLeftRocketCargo() + calculatePossibleLeftRocketCargo()) && rightHatchNum != 6 && rightCargoNum != 6) {
			if (possibleRightRocketCargo >= 2) {
				if (calculateHatchPointsR4541() > calculateCargoPointsR4541()) {
					return rightRocketHatch;
					
				} else if (calculateHatchPointsR4541() < calculateCargoPointsR4541()) {
					return rightRocketCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else {
				return rightRocketHatch;
			}
		}else if (leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6) {
			if (possibleShipCargo >= 2) {
				if (calculateHatchPointsR4541() > calculateCargoPointsR4541()) {
					return shipHatch;
				} else if (calculateHatchPointsR4541() < calculateCargoPointsR4541()) {
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
