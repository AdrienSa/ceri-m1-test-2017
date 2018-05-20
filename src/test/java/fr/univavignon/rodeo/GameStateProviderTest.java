package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.*;

public class GameStateProviderTest extends IGameStateProviderTest
{
	/**
	 * GameState
	 */
	private static IGameState gs;
	
	/**
	 * Initialize the GameStateProvider
	 * @return
	 */
	protected static IGameStateProvider getTestInstance()
	{
		IGameStateProvider gsP = new GameStateProvider();
		IGameState gs2 = new GameState("Test");
		gsP.save(gs2);
		gs = gsP.get("Test");
		return gsP;
	}
	
	@Test
	@Override
	/**
	 * Test get
	 */
	public void testGet()
	{
		final IGameStateProvider gameS = getTestInstance();
		assertEquals(gameS.get("Test").getName(),gs.getName());
		assertEquals(gameS.get("Test").getProgression(),gs.getProgression());
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Override
	/**
	 * Test get (with IllegalArgumentException expected)
	 */
	public void testGetEx()
	{
		final IGameStateProvider gameS = getTestInstance();
		gameS.get(null);
	}
	
	@Test
	/**
	 * Test save
	 */
	public void testSave()
	{
		final IGameStateProvider gameS = getTestInstance();
		gameS.save(gs);
		IGameState gs2 = gameS.get("Test");
		assertEquals(gs2.getProgression(),gs.getProgression());
		assertEquals(gs2.getName(),gs.getName());
	}
	
	@Test(expected=IOException.class)
	/**
	 * Test save (with null)
	 */
	public void testSaveNull()
	{
		final IGameStateProvider gameS = getTestInstance();
		gameS.save(null);
	}
}
