package app;

import java.util.ArrayList;
import java.util.List;

public class StoryOneController implements IRiverCrossingController{
	private ICrossingStrategy crossingStrategy;
	
	boolean isBoatOnLeftBank;
	int numberOfSails;
	
	ArrayList<ICrosser> boatRiders = new ArrayList<ICrosser>();
	ArrayList<ICrosser> leftBankCrossers = new ArrayList<ICrosser>();
	ArrayList<ICrosser> rightBankCrossers = new ArrayList<ICrosser>();

	public StoryOneController(ICrossingStrategy crossingStrategy,
			ArrayList<ICrosser> boatRiders, ArrayList<ICrosser> leftBankCrossers,
			ArrayList<ICrosser> rightBankCrossers) {
		isBoatOnLeftBank = true;
		crossingStrategy = new StoryOneCrossingStrategy();
	}

	public void newGame(ICrossingStrategy gameStrategy) {
		crossingStrategy = gameStrategy;
	}

	@Override
	public void resetGame() {
		// TODO Auto-generated method stub
	}

	@Override
	public String[] getInstructions() {

		return crossingStrategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return rightBankCrossers;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return leftBankCrossers;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return isBoatOnLeftBank;
	}

	@Override
	public int getNumberOfSails() {
		return numberOfSails;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		
		if(fromLeftToRightBank) {
			for(ICrosser x : crossers) {
				leftBankCrossers.remove(x);
			}
		}
		else {
			for(ICrosser x : crossers) {
				rightBankCrossers.remove(x);
			}
		}
		for(ICrosser x : crossers) {
			boatRiders.add(x);
		}
		
		if(!crossingStrategy.isValid(rightBankCrossers, leftBankCrossers, boatRiders)) {
			if(fromLeftToRightBank) {
				for(ICrosser x : crossers) {
					leftBankCrossers.add(x);
				}
			}
			else {
				for(ICrosser x : crossers) {
					rightBankCrossers.add(x);
				}
			}
			for(ICrosser x : crossers) {
				boatRiders.remove(x);
			}
			return false;
		}
		else return true;
	}

	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		for(ICrosser x : crossers) {
			if(fromLeftToRightBank) {
				rightBankCrossers.add(x);
			}
			else leftBankCrossers.add(x);
		}
		numberOfSails++;
	}

	public boolean canUndo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRedo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	public ICrossingStrategy getCrossingStrategy() {
		return crossingStrategy;
	}

	public void setCrossingStrategy(ICrossingStrategy crossingStrategy) {
		this.crossingStrategy = crossingStrategy;
	}

}
