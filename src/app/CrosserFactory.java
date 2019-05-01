package app;

public class CrosserFactory {
	
	ICrosser newCrosser(String type, double weight) {
		if(type.equalsIgnoreCase("FARMER")) {
			return new Farmer(weight);
		}
		else if(type.equalsIgnoreCase("CARNIVORE")) {
			return new Carnivore(weight);
		}
		else if(type.equalsIgnoreCase("HERBIVORE")) {
			return new Herbivore(weight);
		}
		else if(type.equalsIgnoreCase("PLANT")) {
			return new Plant(weight);
		}
		else return null;
	}
}