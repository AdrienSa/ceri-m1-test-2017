package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.*;

public class EnvironmentTest extends IEnvironmentTest
{
	/**
	 * Number of area in the environment
	 */
	private static int areas;
	
	/**
	 * List of species in the environment
	 */
	private static List<ISpecie> listS;
	
	/**
	 * Initialize the environment for test
	 * @return the environment
	 */
	protected static IEnvironment getTestInstance()
	{
		IEnvironmentProvider envP = new EnvironmentProvider();
		IEnvironment env = envP.getEnvironment("JUNGLE");
		areas = envP.getEnvironment("JUNGLE").getAreas();
		listS = envP.getEnvironment("JUNGLE").getSpecies();
		return env;
	}
	
	/**
	 * Test of getAreas
	 */
	@Test
	@Override
	public void testGetAreas()
	{
		final IEnvironment env = getTestInstance();
		assertEquals(env.getAreas(),areas);
	}
	
	/**
	 * Test of getSpecies
	 */
	@Test
	@Override
	public void testGetSpecies()
	{
		final IEnvironment env = getTestInstance();
		assertEquals(env.getSpecies(),listS);
	}
}
