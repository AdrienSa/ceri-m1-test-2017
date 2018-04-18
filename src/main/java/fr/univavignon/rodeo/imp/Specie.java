package fr.univavignon.rodeo.imp;

import java.util.List;

import fr.univavignon.rodeo.api.*;

public class Specie implements ISpecie
{
	/** **/
	private List<IAnimal> animals;
	
	/** **/
	private String name;
	
	/** **/
	private int area;
	
	/**
	 * 
	 * @param n
	 * @param a
	 * @param li
	 */
	public Specie(final String name, final int area, final List<IAnimal> animals)
	{
		this.name = name;
		this.area = area;
		this.animals = animals;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public int getArea() {
		// TODO Auto-generated method stub
		return area;
	}

	@Override
	public List<IAnimal> getAnimals() {
		// TODO Auto-generated method stub
		return animals;
	}
	
}
