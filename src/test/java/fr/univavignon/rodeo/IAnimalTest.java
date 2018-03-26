package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.*;

import fr.univavignon.rodeo.api.IAnimal;

/**
 * 
 * @author Sartori Adrien
 */
@RunWith(MockitoJUnitRunner.class)
public class IAnimalTest 
{	
	protected static IAnimal getTestInstance()
	{
		
		IAnimal animalMock = Mockito.mock(IAnimal.class);
		Mockito.when(animalMock.getXP()).thenReturn(100);
		Mockito.when(animalMock.isSecret()).thenReturn(true);
		Mockito.when(animalMock.isEndangered()).thenReturn(false);
		Mockito.when(animalMock.isBoss()).thenReturn(false);
		return animalMock;
	}
	
	@Test
	public void testGetXp()
	{
		final IAnimal animal = getTestInstance();
		assertEquals(animal.getXP(),100);
	}
	
	@Test
	public void testIsSecret()
	{
		final IAnimal animal = getTestInstance();
		assertEquals(animal.isSecret(),true);
	}
	
	@Test
	public void testIsEndangered()
	{
		final IAnimal animal = getTestInstance();
		assertEquals(animal.isEndangered(),false);
	}
	
	@Test
	public void testIsBoss()
	{
		final IAnimal animal = getTestInstance();
		assertEquals(animal.isBoss(),false);
	}
}
