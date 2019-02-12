
public class Rocket {
	
	protected int rocketHatch;
	protected int rocketCargo;
		
	public Rocket(int rh, int rc) {
		rocketHatch = rh;
		rocketCargo = rc;
	}

		
	public Rocket() {
		rocketHatch = 6;
		rocketCargo = 6;
		
	}
	
	
	public int getRocketHatch() {
		return rocketHatch;
	}
	
	public void setRocketHatch(int rh) {
		rocketHatch = rh;
		return;
	}
	
	public int getRocketCargo() {
		return rocketCargo;
	}
	
	public void setRocketCargo(int rc) {
		rocketCargo = rc;
		return;
	}
	

}
