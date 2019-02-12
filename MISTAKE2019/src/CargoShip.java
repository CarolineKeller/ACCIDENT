
public class CargoShip {

	protected int shipHatch;
	protected int shipCargo;
	
	
	public CargoShip(int sh, int sc) {
		shipHatch = sh;
		shipCargo = sc;
	}
	
	
	public CargoShip() {
		shipHatch = 8;
		shipCargo = 8;
		
		
	}
	
	public int getShipHatch() {
		return shipHatch;
	}
	
	public void setShipHatch(int sh) {
		shipHatch = sh;
	}
	
	public int getShipCargo() {
		return shipCargo;
	}
	
	public void setShipCargo(int sc) {
		shipCargo = sc;
		return;
	}
	
	
}
