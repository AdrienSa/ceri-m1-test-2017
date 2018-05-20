package fr.univavignon.rodeo.imp;

import fr.univavignon.rodeo.api.*;

public class Animal implements IAnimal
{
	/**
	 * Name of the animal
	 */
	private String name;
	
	/**
	 * Xp of the animal
	 */
	private int xp;
	
	/**
	 * True if the animal is secret, else false
	 */
	private boolean secret;
	
	/**
	 * True if the animal is endangered, else false
	 */
	private boolean endangered;
	
	/**
	 * True if the animal is boss, else false
	 */
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
	/**
	 * Getter of name
	 */
	public String getName() 
	{
		return name;
	}

	@Override
	/**
	 * Getter of xp
	 */
	public int getXP() 
	{
		return xp;
	}

	@Override
	/**
	 * True if the animal is secret, else false
	 */
	public boolean isSecret() 
	{
		return secret;
	}

	@Override
	/**
	 * True if the animal is endangered, else false
	 */
	public boolean isEndangered() 
	{
		return endangered;
	}

	@Override
	/**
	 * True if the animal is boss, else false
	 */
	public boolean isBoss()
	{
		return boss;
	}
}
