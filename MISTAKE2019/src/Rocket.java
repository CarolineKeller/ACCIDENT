
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
	
	public double calculateCompletionTime(double rh, double rc, double h, double c, double ht, double ct) {
		rocketHatch = rh;
		if(rc == 0 && rh == 6) {
			rc += 6;
		}
		rocketCargo = rc;
		double hatchTimeToCompletion = 0;
		if(h > 0) {
			hatchTimeToCompletion = rocketHatch * h;
		}else if(hatchTimeToCompletion == 0) {
			hatchTimeToCompletion = rocketHatch * ht;
		}
		double cargoTimeToCompletion = 0;
		if(c > 0) {
			cargoTimeToCompletion = rocketCargo * c;
		}else if(cargoTimeToCompletion == 0) {
			cargoTimeToCompletion = rocketCargo * ct;
		}
		completionTime = hatchTimeToCompletion + cargoTimeToCompletion;
		return completionTime;
	}
	

}
