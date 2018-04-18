package fr.univavignon.rodeo.imp;

import java.util.Map;

import fr.univavignon.rodeo.api.*;

public class GameState implements IGameState
{
	private String name;
	
	private int progression;
	
	private Map<ISpecie, SpecieLevel> levels;
	
	private Map<ISpecie, Integer> totalXp;
	
	public GameState(final String name, final int progression)
	{
		this.name = name;
		this.progression = progression;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exploreArea() throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void catchAnimal(IAnimal animal) throws IllegalArgumentException,
			IllegalStateException {
		// TODO Auto-generated method stub
		// récupère l'xp et l'ajoute à l'xp total de l'espece
		
	}

	@Override
	public SpecieLevel getSpecieLevel(ISpecie specie)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getProgression() {
		// TODO Auto-generated method stub
		return progression;
	}

}
