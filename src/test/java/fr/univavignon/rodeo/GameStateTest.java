package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.*;

public class GameStateTest extends IGameStateTest
{
	/**
	 * Progression of the game state
	 */
	private static int progression;
	
	/**
	 * Animal to catch
	 */
	private static IAnimal animal;
	
	/**
	 * Specie to have specie level
	 */
	private static ISpecie specie;
	
	/**
	 * Specie level of the specie
	 */
	private static SpecieLevel speLvl;
	
	protected static IGameState getTestInstance()
	{
		IGameState gs = new GameState("Test");
		progression = gs.getProgression();
		animal = new Animal("Babouin",0,true,true,true);
		IEnvironmentProvider envP = new EnvironmentProvider();
		specie = envP.getEnvironment("SAVANNAH").getSpecies().get(0);
		//speLvl = SpecieLevel.NOVICE;
		//gs.catchAnimal(envP.getEnvironment("SAVANNAH").getSpecies().get(0).getAnimals().get(0));
		speLvl = gs.getSpecieLevel(specie);
		return gs;
	}
	
	@Test(expected=IllegalStateException.class)
	@Override
	/**
	 * Test exploreArea
	 */
	public void testExploreArea()
	{
		final IGameState gameS = getTestInstance();
		gameS.exploreArea();
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Override
	/**
	 * Test catchAnimal (with IllegalArgumentException expected)
	 */
	public void testCatchAnimalNull()
	{
		final IGameState gameS = getTestInstance();
		gameS.catchAnimal(null);
	}
	
	@Test(expected=IllegalStateException.class)
	@Override
	/**
	 * Test catchAnimal (with IllegalStateException expected, animal unknown)
	 */
	public void testCatchAnimal()
	{
		final IGameState gameS = getTestInstance();
		gameS.catchAnimal(animal);
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Override
	/**
	 * Test getSpecieLevel (with IllegalArgumentException expected)
	 */
	public void testGetSpecieLevelEx()
	{
		final IGameState gameS = getTestInstance();
		gameS.getSpecieLevel(null);
	}
	
	@Test
	@Override
	/**
	 * Test getSpecieLevel
	 */
	public void testGetSpecieLevel()
	{
		final IGameState gameS = getTestInstance();
		assertEquals(gameS.getSpecieLevel(specie),speLvl);
	}
	
	@Test
	@Override
	/**
	 * Test getProgression
	 */
	public void testGetProgression()
	{
		final IGameState gameS = getTestInstance();
		assertEquals(gameS.getProgression(),progression);
	}
}
