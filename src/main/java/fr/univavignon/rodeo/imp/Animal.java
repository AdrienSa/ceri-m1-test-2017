package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.*;

public class Animal implements IAnimal
{
	private String name;
	
	private int xp;
	
	private boolean secret;
	
	private boolean endangered;
	
	private boolean boss;
	
	public Animal(final String n, final int x, final boolean s, final boolean e, final boolean b)
	{
		name = n;
		xp = x;
		secret = s;
		endangered = e;
		boss = b;
	}
	
	@Override
	public String getName() 
	{
		return name;
	}

	@Override
	public int getXP() 
	{
		return xp;
	}

	@Override
	public boolean isSecret() 
	{
		return secret;
	}

	@Override
	public boolean isEndangered() 
	{
		return endangered;
	}

	@Override
	public boolean isBoss()
	{
		return boss;
	}
	
	
}
