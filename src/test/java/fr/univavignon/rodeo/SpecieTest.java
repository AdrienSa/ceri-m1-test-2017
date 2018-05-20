package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.*;

public class SpecieTest extends ISpecieTest
{
	/**
	 * List of Animal of the specie
	 */
	private static List<IAnimal> listA;
	/**
	 * Area of the specie
	 */
	private static int area;
	
	/**
	 * Initialize the specie instance
	 * @return the specie
	 */
	protected static ISpecie getTestInstance()
	{
		IEnvironmentProvider envP = new EnvironmentProvider();
		ISpecie spe = envP.getEnvironment("SAVANNAH").getSpecies().get(0);
		listA = envP.getEnvironment("SAVANNAH").getSpecies().get(0).getAnimals();
		area = envP.getEnvironment("SAVANNAH").getSpecies().get(0).getArea();
		return spe;
	}
	
	@Test
	@Override
	/**
	 * Test of getArea
	 */
	public void testGetArea()
	{
		final ISpecie spe = getTestInstance();
		assertEquals(spe.getArea(),area);
	}
	
	@Test
	@Override
	/**
	 * Test of getAnimals
	 */
	public void testGetAnimals()
	{
		final ISpecie spe = getTestInstance();
		assertEquals(spe.getAnimals(),listA);
	}
}
