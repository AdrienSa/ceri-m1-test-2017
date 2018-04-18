package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.*;

import fr.univavignon.rodeo.api.*;

@RunWith(MockitoJUnitRunner.class)
public class IGameStateTest
{
	protected static ISpecie spe = ISpecieTest.getTestInstance();
	
	protected static IAnimal ani = IAnimalTest.getTestInstance();
	
	//protected static SpecieLevel spL;
	
	protected static IGameState getTestInstance()
	{
		IGameState gameMock = Mockito.mock(IGameState.class);
		Mockito.doThrow(IllegalStateException.class).when(gameMock).exploreArea();
		Mockito.doThrow(IllegalArgumentException.class).when(gameMock).catchAnimal(null);
		Mockito.doThrow(IllegalStateException.class).when(gameMock).catchAnimal(ani);
		Mockito.doThrow(IllegalArgumentException.class).when(gameMock).getSpecieLevel(null);
		Mockito.when(gameMock.getSpecieLevel(spe)).thenReturn(SpecieLevel.NOVICE);
		Mockito.when(gameMock.getProgression()).thenReturn(10);
		return gameMock;
	}
	
	@Test(expected=IllegalStateException.class)
	public void testExploreArea()
	{
		final IGameState gameS = getTestInstance();
		gameS.exploreArea();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCatchAnimalNull()
	{
		final IGameState gameS = getTestInstance();
		gameS.catchAnimal(null);
	}
	
	@Test(expected=IllegalStateException.class)
	public void testCatchAnimal()
	{
		final IGameState gameS = getTestInstance();
		gameS.catchAnimal(ani);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetSpecieLevelEx()
	{
		final IGameState gameS = getTestInstance();
		gameS.getSpecieLevel(null);
	}
	
	@Test
	public void testGetSpecieLevel()
	{
		final IGameState gameS = getTestInstance();
		assertEquals(gameS.getSpecieLevel(spe),SpecieLevel.NOVICE);
	}
	
	@Test
	public void testGetProgression()
	{
		final IGameState gameS = getTestInstance();
		assertEquals(gameS.getProgression(),10);
	}
}
