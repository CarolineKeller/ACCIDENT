
public class Robot {
	
	protected double hatchTime;
	protected double cargoTime;
	protected double climbTime;
	protected int climbLevel;
	Strategy strategy;
	
	public Robot(double h, double c, double t, int l) {
		hatchTime = h;
		cargoTime = c;
		climbTime = t;
		climbLevel = l;
	}
	
	public Robot() {
		hatchTime = -1;
		cargoTime = -1;
		climbTime = -1;
		climbLevel = -1;
	}
	
	public double getHatchTime() {
		return hatchTime;
	}
	
	public void setHatchTime(double h) {
		hatchTime = h;
		return;
	}
	
	public double getCargoTime() {
		return cargoTime;
	}

	public void setCargoTime(double c) {
		cargoTime = c;
		return;
	}
	
	public double getClimbTime() {
		return climbTime;
	}
	
	public void setClimbTime(double t) {
		climbTime = t;
		return;
	}
	
	public double getClimbLevel() {
		return climbLevel;
	}
	
	public void setClimbLevel(int l) {
		climbLevel = l;
	}
	

}
