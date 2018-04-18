package fr.univavignon.rodeo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.*;

import fr.univavignon.rodeo.api.*;

@RunWith(MockitoJUnitRunner.class)
public class IGameStateProviderTest
{
	protected static IGameState gs = IGameStateTest.getTestInstance();
	
	protected static IGameStateProvider getTestInstance()
	{
		IGameStateProvider gspMock = Mockito.mock(IGameStateProvider.class);
		Mockito.when(gspMock.get("Bull")).thenReturn(gs);
		Mockito.doThrow(IllegalArgumentException.class).when(gspMock).get(null);
		return gspMock;
	}
	
	@Test
	public void testGet()
	{
		final IGameStateProvider gameS = getTestInstance();
		assertEquals(gameS.get("Bull"),gs);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetEx()
	{
		final IGameStateProvider gameS = getTestInstance();
		gameS.get(null);
	}
}
