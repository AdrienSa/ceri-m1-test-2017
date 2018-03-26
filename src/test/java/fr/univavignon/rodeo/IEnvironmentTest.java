package fr.univavignon.rodeo;

import static org.junit.Assert.*;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.*;

import fr.univavignon.rodeo.api.*;

@RunWith(MockitoJUnitRunner.class)
public class IEnvironmentTest
{
	protected static List<ISpecie> listS = IntStream
			.range(0, 2)
			.mapToObj(i -> ISpecieTest.getTestInstance())
			.collect(Collectors.toList());
	
	protected static IEnvironment getTestInstance()
	{
		IEnvironment envMock = Mockito.mock(IEnvironment.class);
		/*ISpecie spe1Mock = ISpecieTest.getTestInstance();
		ISpecie spe2Mock = ISpecieTest.getTestInstance();
		listS.add(spe1Mock);
		listS.add(spe2Mock);*/
		Mockito.when(envMock.getAreas()).thenReturn(5);
		Mockito.when(envMock.getSpecies()).thenReturn(listS);
		return envMock;
	}

	@Test
	public void testGetAreas()
	{
		final IEnvironment env = getTestInstance();
		assertEquals(env.getAreas(),5);
	}
	
	@Test
	public void testGetSpecies()
	{
		final IEnvironment env = getTestInstance();
		assertEquals(env.getSpecies(),listS);
	}

}
