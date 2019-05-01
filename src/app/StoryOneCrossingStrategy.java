package app;

import java.util.ArrayList;
import java.util.List;

public class StoryOneCrossingStrategy implements ICrossingStrategy {
	Instructions instructions;
	ICrosser farmer = new Farmer();
	ICrosser carnivore = new Carnivore();
	ICrosser herbivore = new Herbivore();
	ICrosser plant = new Plant();
	ArrayList<ICrosser> initialCrossers = new ArrayList<ICrosser>();
	
	public StoryOneCrossingStrategy() {
		instructions =  new StoryOneInstructions();
	}

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
		// boat validation
		int flag = 0;
		for(ICrosser x : boatRiders) {
			if(x instanceof Farmer) flag = 1;
		}
		if(flag == 0) return false;
		if(boatRiders.size() > 2) return false;
		
		// left bank validation
		if(leftBankCrossers.size() == 2) {
			if(Math.abs(leftBankCrossers.get(0).getEatingRank() - leftBankCrossers.get(0).getEatingRank()) == 1) {
				return false;
			}
		}
		
		// right bank validation
				if(rightBankCrossers.size() == 2) {
					if(Math.abs(rightBankCrossers.get(0).getEatingRank() - rightBankCrossers.get(0).getEatingRank()) == 1) {
						return false;
					}
				}
		return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		initialCrossers.add(farmer);
		initialCrossers.add(carnivore);
		initialCrossers.add(herbivore);
		initialCrossers.add(plant);
		return initialCrossers;
	}

	@Override
	public String[] getInstructions() {
		return instructions.getInstructions();
	}

}
