
public class Rocket {
	
	protected double rocketHatch;
	protected double rocketCargo;
	protected double completionTime;
		
	public Rocket(double rh, double rc) {
		rocketHatch = rh;
		rocketCargo = rc;
	}
		
	public Rocket() {
		rocketHatch = 6;
		rocketCargo = 6;
	}
	
	public double getRocketHatch() {
		return rocketHatch;
	}
	
	public void setRocketHatch(double rh) {
		rocketHatch = rh;
		return;
	}
	
	public double getRocketCargo() {
		return rocketCargo;
	}
	
	public void setRocketCargo(double rc) {
		rocketCargo = rc;
		return;
	}
	
	public double calculateCompletionTime(double rh, double rc, double h, double c) {
		rocketHatch = rh;
		rocketCargo = rc;
		double hatchTimeToCompletion = rocketHatch * h;
		double cargoTimeToCompletion = rocketCargo * c;
		completionTime = hatchTimeToCompletion + cargoTimeToCompletion;
		return completionTime;
	}
	

}
