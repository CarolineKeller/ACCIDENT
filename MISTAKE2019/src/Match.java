
public class Match extends Strategy2 {

	Field myField = new Field();
	// Alliance friendlyAlliance;
	// Alliance enemyAlliance;
	Robot r4541 = new Robot();
	Robot r2 = new Robot();
	Robot r3 = new Robot();
	final int hatchPoints = 2;
	final int cargoPoints = 3;
	double cargoPointsPerSecondR4541 = 0;
	double hatchPointsPerSecondR4541 = 0;
	double cargoPointsPerSecondR2 = 0;
	double hatchPointsPerSecondR2 = 0;
	double cargoPointsPerSecondR3 = 0;
	double hatchPointsPerSecondR3 = 0;
	Strategy2 window;

	public Match() {
	}

	public double calculateHatchPointsR4541() {
		hatchPointsPerSecondR4541 = hatchPoints / r4541.getHatchTime();
		return hatchPointsPerSecondR4541;
	}

	public double calculateCargoPointsR4541() {
		cargoPointsPerSecondR4541 = cargoPoints / r4541.getCargoTime();
		return cargoPointsPerSecondR4541;
	}
	
	public double calculateHatchPointsR2() {
		hatchPointsPerSecondR2 = hatchPoints / r2.getHatchTime();
		return hatchPointsPerSecondR2;
	}

	public double calculateCargoPointsR2() {
		cargoPointsPerSecondR2 = cargoPoints / r2.getCargoTime();
		return cargoPointsPerSecondR2;
	}
	
	public double calculateHatchPointsR3() {
		hatchPointsPerSecondR3 = hatchPoints / r3.getHatchTime();
		return hatchPointsPerSecondR3;
	}

	public double calculateCargoPointsR3() {
		cargoPointsPerSecondR3 = cargoPoints / r3.getCargoTime();
		return cargoPointsPerSecondR3;
	}
	
	public double calculatePossibleLeftRocketHatches() {
		possibleLeftRocketHatches = 6 - window.leftHatchNum;
		return possibleLeftRocketHatches;
	}
	
	public double calculatePossibleLeftRocketCargo() {
		possibleLeftRocketCargo = (window.halfLeftRocketCargo * 2) - window.leftCargoNum;
		return possibleLeftRocketCargo;
	}
	
	public double calculatePossibleRightRocketHatches() {
		possibleRightRocketHatches = 6 - window.rightHatchNum;
		return possibleRightRocketHatches;
	}
	
	public double calculatePossibleRightRocketCargo() {
		possibleRightRocketCargo = (window.halfRightRocketCargo * 2) - window.rightCargoNum;
		return possibleRightRocketCargo;
	}
	
	public double calculatePossibleShipHatches() {
		possibleShipHatches = 8 - window.shipHatchNum;
		return possibleShipHatches;
	}
	
	public double calculatePossibleShipCargo() {
		possibleShipCargo = (window.halfShipCargo * 2) - window.shipCargoNum;
		return possibleShipCargo;
	}
	
	public int timePassed() {
		int timePassed = 150 - window.getTime();
		return timePassed;
	}
	
	Rocket leftRocket = new Rocket(possibleLeftRocketHatches, possibleLeftRocketCargo);
	Rocket rightRocket = new Rocket(possibleRightRocketHatches, possibleRightRocketCargo);
	CargoShip ship = new CargoShip(possibleShipHatches, possibleShipCargo);
	double ht = (r4541.getHatchTime() + r2.getHatchTime() + r3.getHatchTime()) / 3;
	double ct = (r4541.getCargoTime() + r2.getCargoTime() + r3.getCargoTime()) / 3;

	public String bestMoveR4541() {
		String leftRocketHatch = "Put a hatch on the left rocket";
		String leftRocketCargo = "Put cargo in the left rocket";
		String rightRocketHatch = "Put a hatch on the right rocket";
		String rightRocketCargo = "Put cargo in the right rocket";
		String shipHatch = "Put a hatch on the cargo ship";
		String shipCargo = "Put cargo in the cargo ship";
		String r = r4541.getTeamName();
		
		getLeftHatchNum();
		getLeftCargoNum();
		getShipHatchNum();
		getShipCargoNum();
		getRightHatchNum();
		getRightCargoNum();
		
		if (window.rdbtnR4541Defend.isSelected() || window.rdbtnR4541NotWorking.isSelected()) {
			return "-";
		}else if (((leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
				calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct) != 0) && (leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
				calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)) < (rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
						calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)))&& (leftHatchNum != 6) && (leftCargoNum != 6)){
			if (possibleLeftRocketCargo >= 2 || (possibleLeftRocketCargo == 0 && window.leftCargoNum == 6)) {
				if ((hatchPointsPerSecondR4541 > cargoPointsPerSecondR4541) && (window.leftHatchNum != 6)) {
					return r + ": " + leftRocketHatch;
				} else if ((hatchPointsPerSecondR4541 < cargoPointsPerSecondR4541) && (window.leftCargoNum != 6)) {
					return r + ": " + leftRocketCargo;
				}else {
					return r + ": Do a hatch or cargo on the left rocket";
				}
			} else if (possibleLeftRocketCargo > 2) {
				return r + ": " + leftRocketHatch;
			}else if(window.leftHatchNum != 6){
				return r + ": " + leftRocketHatch;
			}
		}else if (((rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
				calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct) != 0) && (rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
				calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)) < (leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
						calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct))) && (rightHatchNum != 6 && rightCargoNum != 6)) {
			if (possibleRightRocketCargo >= 2 || (possibleRightRocketCargo == 0 && window.rightCargoNum == 6)) {
				if ((hatchPointsPerSecondR4541 > cargoPointsPerSecondR4541) && window.rightHatchNum != 6) {
					return r + ": " + rightRocketHatch;
				} else if ((hatchPointsPerSecondR4541 < cargoPointsPerSecondR4541) && rightCargoNum != 6) {
					return r + ": " + rightRocketCargo;
				} else {
					return r + ": Do a hatch or cargo on the right rocket";
				}
			} else if(window.rightHatchNum != 6){
				return r + ": " + rightRocketHatch;
			}
		}else if (leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), calculatePossibleLeftRocketCargo(), window.timedHatchTime, 
				window.timedCargoTime, ht, ct) >= window.getTime() && rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
				calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct) >= window.getTime()) {
			if (possibleShipCargo >= 2) {
				if (hatchPointsPerSecondR4541 > cargoPointsPerSecondR4541 && window.shipHatchNum != 8) {
					return r + ": " + shipHatch;
				} else if (hatchPointsPerSecondR4541 < cargoPointsPerSecondR4541 && window.shipCargoNum != 8) {
					return r + ": " + shipCargo;
				} else {
					return r + ": Do a hatch or cargo on the cargoship";
				}
			} else {
				return shipHatch;
			}
		}else if(leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6 && shipHatchNum == 8 && shipCargoNum == 8) {
			return r + ": climb";
		}else if(((r4541.getClimbTime()) + 8) >= window.getTime() && window.getTime() != 0) {
				return r + ": climb";
		}else {
			return "-";
		}
		return "-";

	}
	
	public String bestMoveR2() {
		String leftRocketHatch = "Put a hatch on the left rocket";
		String leftRocketCargo = "Put cargo in the left rocket";
		String rightRocketHatch = "Put a hatch on the right rocket";
		String rightRocketCargo = "Put cargo in the right rocket";
		String shipHatch = "Put a hatch on the cargo ship";
		String shipCargo = "Put cargo in the cargo ship";
		String r = r2.getTeamName();
		
		getLeftHatchNum();
		getLeftCargoNum();
		getShipHatchNum();
		getShipCargoNum();
		getRightHatchNum();
		getRightCargoNum();
		
		if (window.rdbtnR2Defended.isSelected() || window.rdbtnR2NotWorking.isSelected()) {
			return "-";
		}else if (((leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
				calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct) != 0) && (leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
				calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)) < (rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
						calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)))&& (leftHatchNum != 6) && (leftCargoNum != 6)){
		
			if (possibleLeftRocketCargo >= 2 || (possibleLeftRocketCargo == 0 && window.leftCargoNum == 6)) {
				if ((hatchPointsPerSecondR2 > cargoPointsPerSecondR2) && (window.leftHatchNum != 6)) {
					return r + ": " + leftRocketHatch;
				} else if ((hatchPointsPerSecondR2 < cargoPointsPerSecondR2) && (window.leftCargoNum != 6)) {
					return r + ": " + leftRocketCargo;
				}else {
					return r + ": Do a hatch or cargo on the left rocket";
				}
			} else if (possibleLeftRocketCargo > 2) {
				return r + ": " + leftRocketHatch;
			}else if(window.leftHatchNum != 6){
				return r + ": " + leftRocketHatch;
			}
		}else if (((rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
				calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct) != 0) && (rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
				calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)) < (leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
						calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct))) && (rightHatchNum != 6 && rightCargoNum != 6)) {
			if (possibleRightRocketCargo >= 2 || (possibleRightRocketCargo == 0 && window.rightCargoNum == 6)) {
				if ((hatchPointsPerSecondR2 > cargoPointsPerSecondR2) && window.rightHatchNum != 6) {
					return r + ": " + rightRocketHatch;
				} else if ((hatchPointsPerSecondR2 < cargoPointsPerSecondR2) && rightCargoNum != 6) {
					return r + ": " + rightRocketCargo;
				} else {
					return r + ": Do a hatch or cargo on the right rocket";
				}
			} else {
				return r + ": " + rightRocketHatch;
			}
		}else if (leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6) {
			if (possibleShipCargo >= 2) {
				if (hatchPointsPerSecondR2 > cargoPointsPerSecondR2) {
					return r + ": " + shipHatch;
				} else if (hatchPointsPerSecondR2 < cargoPointsPerSecondR2) {
					return r + ": " + shipCargo;
				} else {
					return r + ": Do a hatch or cargo on the cargoship";
				}
			} else {
				return shipHatch;
			}
		}else if(leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6 && shipHatchNum == 8 && shipCargoNum == 8) {
			return r + ": climb";
		}else if(((r2.getClimbTime()) + 8) >= window.getTime() && window.getTime() != 0) {
				return r + ": climb";
		}else {
			return "-";
		}
		return "-";

	}
	
	public String bestMoveR3() {
		String leftRocketHatch = "Put a hatch on the left rocket";
		String leftRocketCargo = "Put cargo in the left rocket";
		String rightRocketHatch = "Put a hatch on the right rocket";
		String rightRocketCargo = "Put cargo in the right rocket";
		String shipHatch = "Put a hatch on the cargo ship";
		String shipCargo = "Put cargo in the cargo ship";
		String r = r3.getTeamName();
		
		getLeftHatchNum();
		getLeftCargoNum();
		getShipHatchNum();
		getShipCargoNum();
		getRightHatchNum();
		getRightCargoNum();
		
		if (window.rdbtnR3Defended.isSelected() || window.rdbtnR3NotWorking.isSelected()) {
			return "-";
		}else if (((leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
				calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct) != 0) && (leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
				calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)) < (rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
						calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)))&& (leftHatchNum != 6) && (leftCargoNum != 6)){
			if (possibleLeftRocketCargo >= 2 || (possibleLeftRocketCargo == 0 && window.leftCargoNum == 6)) {
				if ((hatchPointsPerSecondR3 > cargoPointsPerSecondR3) && (window.leftHatchNum != 6)) {
					return r + ": " + leftRocketHatch;
				} else if ((hatchPointsPerSecondR3 < cargoPointsPerSecondR2) && (window.leftCargoNum != 6)) {
					return r + ": " + leftRocketCargo;
				}else {
					return r + ": Do a hatch or cargo";
				}
			} else if (possibleLeftRocketCargo > 2) {
				return r + ": " + leftRocketHatch;
			}else if(window.leftHatchNum != 6){
				return r + ": " + leftRocketHatch;
			}
		}else if (((rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
				calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct) != 0) && (rightRocket.calculateCompletionTime(calculatePossibleRightRocketHatches(), 
				calculatePossibleRightRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct)) < (leftRocket.calculateCompletionTime(calculatePossibleLeftRocketHatches(), 
						calculatePossibleLeftRocketCargo(), window.timedHatchTime, window.timedCargoTime, ht, ct))) && (rightHatchNum != 6 && rightCargoNum != 6)) {
			if (possibleRightRocketCargo >= 2 || (possibleRightRocketCargo == 0 && window.rightCargoNum == 6)) {
				if ((hatchPointsPerSecondR3 > cargoPointsPerSecondR3) && window.rightHatchNum != 6) {
					return r + ": " + rightRocketHatch;
				} else if ((hatchPointsPerSecondR3 < cargoPointsPerSecondR3) && rightCargoNum != 6) {
					return r + ": " + rightRocketCargo;
				} else {
					return r + ": Do a hatch or cargo";
				}
			} else {
				return r + ": " + rightRocketHatch;
			}
		}else if (leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6) {
			if (possibleShipCargo >= 2) {
				if (hatchPointsPerSecondR3 > cargoPointsPerSecondR3) {
					return r + ": " + shipHatch;
				} else if (hatchPointsPerSecondR3 < cargoPointsPerSecondR3) {
					return r + ": " + shipCargo;
				} else {
					return r + ": Do a hatch or cargo";
				}
			} else {
				return shipHatch;
			}
		}else if(leftHatchNum == 6 && leftCargoNum == 6 && rightHatchNum == 6 && rightCargoNum == 6 && shipHatchNum == 8 && shipCargoNum == 8) {
			return r + ": climb";
		}else if(((r3.getClimbTime()) + 8) >= window.getTime() && window.getTime() != 0) {
				return r + ": climb";
		}else {
			return "-";
		}
		return "-";

	}
}
