
public class Score extends Match{
	
	{
	this.leftHatchNum = 3;
	}
	int currHatchPoints = (leftHatchNum + shipHatchNum + rightHatchNum) * hatchPoints;
	int currCargoPoints = (leftCargoNum + shipCargoNum + rightCargoNum) * hatchPoints;
	int currScore = currHatchPoints + currCargoPoints;
	int tempScore = 0;
	int moveScore;
	
	public int calculateMoveScore(int movePoints) {
		moveScore = currScore + movePoints;
		return moveScore;
	}
	
	public int calculateTempScore() {
		if (moveScore > tempScore){
			tempScore = moveScore;
		}
		return tempScore;
	}
	
}
