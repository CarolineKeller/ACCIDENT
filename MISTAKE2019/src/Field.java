
public class Field {
	
	Rocket leftRocket = new Rocket();
	Rocket rightRocket = new Rocket();
	CargoShip cargoShip = new CargoShip();
	
	public Field(Rocket lr, Rocket rr, CargoShip cs) {
		leftRocket = lr;
		rightRocket = rr;
		cargoShip = cs;
	}
	
	public Field() {
	
	}

}
