package fr.univavignon.rodeo;

import static org.junit.Assert.*;

//import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.*;

import fr.univavignon.rodeo.api.*;

@RunWith(MockitoJUnitRunner.class)
public class ISpecieTest
{
	
	protected static List<IAnimal> listA = IntStream
			.range(0, 2)
			.mapToObj(i -> IAnimalTest.getTestInstance())
			.collect(Collectors.toList());
	
	protected static ISpecie getTestInstance()
	{
		ISpecie speMock = Mockito.mock(ISpecie.class);
		/*IAnimal an1 = IAnimalTest.getTestInstance();
		IAnimal an2 = IAnimalTest.getTestInstance();
		listA.add(an1);
		listA.add(an2);*/
		Mockito.when(speMock.getArea()).thenReturn(5);
		Mockito.when(speMock.getAnimals()).thenReturn(listA);
		return speMock;
	}
	
	@Test
	public void testGetArea()
	{
		final ISpecie spe = getTestInstance();
		assertEquals(spe.getArea(),5);
	}
	
	@Test
	public void testGetAnimals()
	{
		final ISpecie spe = getTestInstance();
		assertEquals(spe.getAnimals(),listA);
	}
}
