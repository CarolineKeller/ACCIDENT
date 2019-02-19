
public class Robot {
	
	protected String teamName;
	private double hatchTime;
	private double cargoTime;
	private double climbTime;
	private int climbLevel;
	Strategy strategy;
	
	public Robot(String n, double h, double c, double t, int l) {
		teamName = n;
		hatchTime = h;
		cargoTime = c;
		climbTime = t;
		climbLevel = l;
	}
	
	public Robot() {
		teamName = "blank";
		hatchTime = -1;
		cargoTime = -1;
		climbTime = -1;
		climbLevel = -1;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String n) {
		teamName = n;
		return;
	}
	
	public double getHatchTime() {
		//hatchTime = 18;
		return hatchTime;
	}
	
	public void setHatchTime(double h) {
		hatchTime = h;
		return;
	}
	
	public double getCargoTime() {
		//cargoTime = 18;
		return cargoTime;
	}

	public void setCargoTime(double c) {
		cargoTime = c;
		return;
	}
	
	public double getClimbTime() {
		//climbTime = 20;
		return climbTime;
	}
	
	public void setClimbTime(double t) {
		climbTime = t;
		return;
	}
	
	public int getClimbLevel() {
		return climbLevel;
	}
	
	public void setClimbLevel(int l) {
		climbLevel = l;
	}
	
	

}
