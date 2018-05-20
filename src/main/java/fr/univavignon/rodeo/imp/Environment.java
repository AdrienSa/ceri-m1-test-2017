package fr.univavignon.rodeo.imp;

import java.util.List;

import fr.univavignon.rodeo.api.*;

public class Environment implements IEnvironment 
{
	/**
	 * Name of the environment
	 */
	private String name;
	
	/**
	 * Number of areas of the environment
	 */
	private int areas;
	
	/**
	 * Specie list of the environment
	 */
	private List<ISpecie> species;
	
	public Environment(String name, int areas, List<ISpecie> species)
	{
		this.name = name;
		this.areas = areas;
		this.species = species;
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
	 * Getter of areas
	 */
	public int getAreas() 
	{
		return areas;
	}

	@Override
	/**
	 * Getter of the specie list
	 */
	public List<ISpecie> getSpecies() 
	{
		return species;
	}
}
