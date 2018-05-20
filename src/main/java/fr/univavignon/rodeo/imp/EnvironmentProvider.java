package fr.univavignon.rodeo.imp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fr.univavignon.rodeo.api.*;

public class EnvironmentProvider implements IEnvironmentProvider
{
	/**
	 * List of available environments
	 */
	private List<IEnvironment> availableEnvironments;
	
	/**
	 * File path of the resource
	 */
	private static final String FILE_PATH = "src/main/resources/AnimalList.csv";
	
	/**
	 * List of environments
	 */
	private List<IEnvironment> environments;
	
	/**
	 * Keep the name (with the number of areas or the area who found the animal) and if is
	 * special like secret, endangered, boss and store all information in class
	 * Information are in specific box
	 */
	public EnvironmentProvider()
	{
		try {
			System.out.println(new File(".").getAbsolutePath());
			final List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
			List<ISpecie> spe = new ArrayList<ISpecie>();
			this.environments = new ArrayList<IEnvironment>();
			String speName = "";
			int speAreas = 5;
			int cmpt = 0;
			
			for (String line : lines) {
				String[] s = line.split(",");
				//System.out.println(s.length);
				//System.out.println(s[0]);
				if(s.length > 2)
				{
					List<IAnimal> animals = new ArrayList<IAnimal>();
				//	System.out.println(s[1].substring(0, s[1].length()-1));
				//	System.out.println(s[1].substring(s[1].length()-1));
					if(!s[1].substring(0, s[1].length()-1).equals("-")) {
						//System.out.println(s[1]);
						//System.out.println("CCCCCCCCCCCCCCCCCCCCCCCC");
						IAnimal a1 = new Animal(s[1].substring(0, s[1].length()-1),Integer.parseInt(s[14]),false,false,false);
						animals.add(a1);
					}
					//System.out.println("Secret : "+s[11].substring(0, s[11].length()-1));
					//System.out.println(s[11].substring(s[11].length()-1));
					if(s[11].substring(0, s[11].length()-1).length() > 2) {
						Animal a2 = new Animal(s[11].substring(0, s[11].length()-1),Integer.parseInt(s[15]),true,false,false);
						animals.add(a2);
					}
					//System.out.println("Boss : "+s[12].substring(0, s[12].length()-1));
					//System.out.println(s[12].substring(s[12].length()-1));
					if(s[12].substring(0, s[12].length()-1).length() > 2) {
						Animal a3 = new Animal(s[12].substring(0, s[12].length()-1),Integer.parseInt(s[16]),false,true,false);
						animals.add(a3);
					}
					//System.out.println("Endangered : "+s[13].substring(0, s[13].length()-1));
					//System.out.println(s[13].substring(s[13].length()-1));
					if(s[13].substring(0, s[13].length()-1).length() > 2) {
						Animal a4 = new Animal(s[13].substring(0, s[13].length()-1),Integer.parseInt(s[17]),false,false,true);
						animals.add(a4);
					}
					ISpecie sp = new Specie(s[0],Integer.parseInt(s[1].substring(s[1].length()-1)),animals);
					//System.out.println(s[0]);
					spe.add(sp);
				}
				else
				{
					//System.out.println(eStart.getName()+" "+eStart.getAreas()+" ");
					if(cmpt > 0)
					{
						IEnvironment e = new Environment(speName,speAreas,spe);
						//System.out.println(e.getName()+" "+e.getAreas()+" ");
						environments.add(e);
					}
					speName = s[0];
					speAreas = Integer.parseInt(s[1]);
					spe = new ArrayList<ISpecie>();
					cmpt++;
				}
		    }
		}
		catch(final IOException e)
		{
			throw new IllegalStateException(e);
		}
	}
	
	public EnvironmentProvider(List<IEnvironment> availableEnvironments)
	{
		this.availableEnvironments = availableEnvironments;
	}
	
	/**
	 * Getter of available environments
	 */
	@SuppressWarnings("null")
	@Override
	public List<String> getAvailableEnvironments() 
	{
		List<String> available = new ArrayList<String>();
		
		if(availableEnvironments == null)
		{
			available.add("Error");
			return available;
		}
		
		for(IEnvironment envi : availableEnvironments)
			available.add(envi.getName());
		
		return available;
	}

	@Override
	/**
	 * Getter of an specific environment (use his name)
	 */
	public IEnvironment getEnvironment(String name) throws IllegalArgumentException {
		if(name == null)
			throw new IllegalArgumentException("null argument");
		
		//for(IEnvironment envi : availableEnvironments)
		for(IEnvironment envi : environments)
			if(envi.getName().equals(name))
				return envi;
		
		return null; 
	}
	
	/**
	 * Getter of all environments
	 * @return The list of environment
	 */
	public List<IEnvironment> getEnvironments()
	{
		return this.environments;
	}
}
