package fr.univavignon.rodeo.imp;

import java.util.List;

import fr.univavignon.rodeo.api.*;

public class Specie implements ISpecie
{
	/**
	 *  Animals list of the specie
	 **/
	private List<IAnimal> animals;
	
	/** 
	 * Name of the specie
	 **/
	private String name;
	
	/** 
	 * Area who found the specie
	 **/
	private int area;
	
	/**
	 * Create a specie
	 * @param n name
	 * @param a area found
	 * @param li list of animals
	 */
	public Specie(final String name, final int area, final List<IAnimal> animals)
	{
		this.name = name;
		this.area = area;
		this.animals = animals;
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
	 * Getter of area
	 */
	public int getArea() 
	{
		return area;
	}

	@Override
	/**
	 * Getter of animals list
	 */
	public List<IAnimal> getAnimals() 
	{
		return animals;
	}
}
