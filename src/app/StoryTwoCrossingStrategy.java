package app;

import java.util.List;

public class StoryTwoCrossingStrategy implements ICrossingStrategy {
	Instructions instructions;

	public StoryTwoCrossingStrategy() {
		instructions = new StoryTwoInstructions();
	}


	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
		int flag = 0;
		double weight=0.0;
		for(ICrosser x : boatRiders) {
			if(x instanceof Farmer) flag = 1;
		}
		if(flag == 0) return false;
 
		for (ICrosser x : boatRiders) {
 
			weight=weight+x.getWeight();
		}
		return (weight<=100);
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getInstructions() {
		return instructions.getInstructions();
	}

}
