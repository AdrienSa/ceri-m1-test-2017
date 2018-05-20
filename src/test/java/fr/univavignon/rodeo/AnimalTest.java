package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.*;

public class AnimalTest extends IAnimalTest
{
	//@Override
	/**
	 * Set the instance of Animal for test
	 * @return
	 */
	protected static IAnimal getTestInstance()
	{
		IEnvironmentProvider envP = new EnvironmentProvider();
		IAnimal a = envP.getEnvironment("SAVANNAH").getSpecies().get(0).getAnimals().get(0);
		//System.out.println(envP.getEnvironment("SAVANNAH").getSpecies().get(0).getAnimals().get(0).getName());
		return a;
	}
	
	@Test
	@Override
	/**
	 * Test of getXp
	 */
	public void testGetXp()
	{
		final IAnimal animal = this.getTestInstance();
		assertEquals(animal.getXP(),0);
	}
	
	@Test
	@Override
	/**
	 * Test of isSecret (with false attempt)
	 */
	public void testIsSecret()
	{
		final IAnimal animal = this.getTestInstance();
		assertEquals(animal.isSecret(),false);
	}
	
	/*@Test
	public void testIsNotSecret()
	{
		final IAnimal animal = getTestInstance();
		assertEquals(animal.isSecret(),false);
	}*/
	
	@Test
	@Override
	/**
	 * Test of isEndangered (with false attempt)
	 */
	public void testIsEndangered()
	{
		final IAnimal animal = this.getTestInstance();
		assertEquals(animal.isEndangered(),false);
	}
	
	@Test
	@Override
	/**
	 * Test of isBoss (with false attempt)
	 */
	public void testIsBoss()
	{
		final IAnimal animal = this.getTestInstance();
		assertEquals(animal.isBoss(),false);
	}
}
