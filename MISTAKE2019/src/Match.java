
public class Match extends Strategy2 {

	Field myField;
	// Alliance friendlyAlliance;
	// Alliance enemyAlliance;
	Robot r4541;
	Robot r2;
	Robot r3;
	final int hatchPoints = 2;
	final int cargoPoints = 3;
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
				if ((hatchPointsPerSecond > cargoPointsPerSecond) && window.leftHatchNum != 6) {
					return leftRocketHatch;
				} else if (hatchPointsPerSecond < cargoPointsPerSecond) {
					return leftRocketCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else if (possibleLeftRocketCargo > 2) {
				return leftRocketHatch;
			}else {
				return leftRocketHatch;
			}
		}else if ((calculatePossibleRightRocketCargo() + calculatePossibleRightRocketHatches()) < (calculatePossibleLeftRocketCargo() + calculatePossibleLeftRocketCargo()) && rightHatchNum != 6 && rightCargoNum != 6) {
			if (possibleRightRocketCargo >= 2) {
				if ((hatchPointsPerSecond > cargoPointsPerSecond) && rightHatchNum != 6) {
					return rightRocketHatch;
				} else if ((hatchPointsPerSecond < cargoPointsPerSecond) && rightCargoNum != 6) {
					return rightRocketCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else {
				return rightRocketHatch;
			}
		}else if (leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6) {
			if (possibleShipCargo >= 2) {
				if (hatchPointsPerSecond > cargoPointsPerSecond) {
					return shipHatch;
				} else if (hatchPointsPerSecond < cargoPointsPerSecond) {
					return shipCargo;
				} else {
					return "Do a hatch or cargo";
				}
			} else {
				return shipHatch;
			}
		/*}else if(timer == null) {
			return "-";
		}else if(r4541.getClimbTime() <= (5 + (Integer.parseInt(window.textArea.getText())))) {
			return "climb";
			*/
		}else {
			return "-";
		}

	}
}
