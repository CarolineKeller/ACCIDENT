
public class Score extends Match{
	

	double currHatchPoints = (leftHatchNum + shipHatchNum + rightHatchNum) * hatchPoints;
	double currCargoPoints = (leftCargoNum + shipCargoNum + rightCargoNum) * hatchPoints;
	double currScore = currHatchPoints + currCargoPoints;
	double tempScore = 0;
	double moveScore;
	
	public double calculateMoveScore(int movePoints) {
		moveScore = currScore + movePoints;
		return moveScore;
	}
	
	public double calculateTempScore() {
		if (moveScore > tempScore){
			tempScore = moveScore;
		}
		return tempScore;
	}
	
	
}
