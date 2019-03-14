
public class CargoShip {

	protected double shipHatch;
	protected double shipCargo;
	protected double completionTime;
	
	public CargoShip(double sh, double sc) {
		shipHatch = sh;
		shipCargo = sc;
	}
	
	
	public CargoShip() {
		shipHatch = 8;
		shipCargo = 8;
		
		
	}
	
	public double getShipHatch() {
		return shipHatch;
	}
	
	public void setShipHatch(double sh) {
		shipHatch = sh;
	}
	
	public double getShipCargo() {
		return shipCargo;
	}
	
	public void setShipCargo(double sc) {
		shipCargo = sc;
		return;
	}
	
	public double calculateCompletionTime(double rh, double rc, double h, double c, double ht, double ct) {
		shipHatch = rh;
		shipCargo = rc;
		double hatchTimeToCompletion = 0;
		if(h > 0) {
			hatchTimeToCompletion = shipHatch * h;
		}else if(hatchTimeToCompletion == 0) {
			hatchTimeToCompletion = shipHatch * ht;
		}
		double cargoTimeToCompletion = 0;
		if(c > 0) {
			cargoTimeToCompletion = shipCargo * c;
		}else if(cargoTimeToCompletion == 0) {
			cargoTimeToCompletion = shipCargo * ct;
		}
	
		completionTime = hatchTimeToCompletion + cargoTimeToCompletion;
		return completionTime;
	}
	
	
}
