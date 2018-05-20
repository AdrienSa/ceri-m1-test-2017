package fr.univavignon.rodeo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.univavignon.rodeo.api.*;
import fr.univavignon.rodeo.imp.*;

public class EnvironmentProviderTest extends IEnvironmentProviderTest
{
	/**
	 * List of available environments
	 */
	private static List<String> listSt;
	
	/**
	 * List of environments
	 */
	private static IEnvironment env;
	
	/**
	 * Initialize the EnvironmentProvider
	 * @return The EnvironmentProvider
	 */
	protected static IEnvironmentProvider getTestInstance()
	{
		IEnvironmentProvider envP = new EnvironmentProvider();
		listSt = envP.getAvailableEnvironments();
		env = envP.getEnvironment("MONTAIN");
		return envP;
	}
	
	@Test
	@Override
	/**
	 * Test getAvailableEnvironments
	 */
	public void testGetAvailableEnvironments()
	{
		final IEnvironmentProvider envP = getTestInstance();
		assertEquals(envP.getAvailableEnvironments(),listSt);
	}
	
	@Test
	@Override
	/**
	 * Test getEnvironment
	 */
	public void testGetEnvironment()
	{
		final IEnvironmentProvider envP = getTestInstance();
		assertEquals(envP.getEnvironment("MONTAIN"),env);
	}
	
	@Test(expected=IllegalArgumentException.class)
	/**
	 * Test getEnvironment (with IllegalArgumentException expected)
	 */
	public void testGetEnvironmentNull()
	{
		final IEnvironmentProvider envP = getTestInstance();
		envP.getEnvironment(null);
	}
}
