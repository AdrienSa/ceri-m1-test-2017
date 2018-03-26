package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
//import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import fr.univavignon.rodeo.api.*;

@RunWith(MockitoJUnitRunner.class)
public class IEnvironmentProviderTest
{
	protected static List<String> listSt = Arrays.asList("unix", "windows");
	
	protected static IEnvironment env = IEnvironmentTest.getTestInstance();
	
	protected static IEnvironmentProvider getTestInstance()
	{
		IEnvironmentProvider envPMock = Mockito.mock(IEnvironmentProvider.class);
		/*String s1 = "unix";
		String s2 = "windows";
		listSt.add(s1);
		listSt.add(s2);*/
		Mockito.when(envPMock.getAvailableEnvironments()).thenReturn(listSt);
		Mockito.when(envPMock.getEnvironment("unix")).thenReturn(env);
		return envPMock;
	}
	
	@Test
	public void testGetAvailableEnvironments()
	{
		final IEnvironmentProvider envP = getTestInstance();
		assertEquals(envP.getAvailableEnvironments(),listSt);
	}
	
	@Test
	public void testGetEnvironment()
	{
		final IEnvironmentProvider envP = getTestInstance();
		assertEquals(envP.getEnvironment("unix"),env);
	}
}
