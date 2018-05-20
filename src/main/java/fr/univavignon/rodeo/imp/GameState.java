package fr.univavignon.rodeo.imp;

import java.util.HashMap;
import java.util.Map;

import fr.univavignon.rodeo.api.*;

public class GameState implements IGameState
{
	/**
	 * Name of the game state
	 */
	private String name;
	
	/**
	 * Progression of the game state
	 */
	private int progression;
	
	/**
	 * Map of each specie her specieLevel
	 */
	private Map<ISpecie, SpecieLevel> levels;
	
	/**
	 * Map for each specie her xp
	 */
	private Map<ISpecie, Integer> totalXp;
	
	/**
	 * Map of all animal with catch or not
	 */
	private Map<IAnimal, Boolean> animalCatch;
	
	/**
	 * Number of current area
	 */
	private int currentArea;
	
	/**
	 * Current environment
	 */
	private IEnvironment currentEnv;
	
	/**
	 * EnvironmentProvider
	 */
	private EnvironmentProvider envProv;
	
	/**
	 * Number of current animal caught
	 */
	private int currentNumberAnimalCaught;
	
	/**
	 * Max number of animal to catch in area
	 */
	private int maxNumberAnimalOfArea;
	
	/**
	 * Total number of animal caught
	 */
	private int animalCaught;
	
	/**
	 * Total number of animal
	 */
	private int totalAnimal;
	
	public GameState(final String name, final int progression)
	{
		this.name = name;
		this.progression = progression;
		levels = new HashMap<ISpecie,SpecieLevel>();
		totalXp = new HashMap<ISpecie, Integer>();
		animalCatch = new HashMap<IAnimal, Boolean>();
		envProv = new EnvironmentProvider();
		currentArea = 1;
		currentEnv = envProv.getEnvironment("SAVANNAH");
		currentNumberAnimalCaught = 0;
		animalCaught = 0;
		totalAnimal = 0;
		maxNumberAnimalOfArea = 0;
		SpecieLevel speLev = SpecieLevel.NOVICE;
		
		for (IEnvironment env : envProv.getEnvironments()) 
		{
			for(ISpecie spe : env.getSpecies())
			{
				totalXp.put(spe, 0);
				levels.put(spe,speLev);
				for(IAnimal ani : spe.getAnimals())
				{
					animalCatch.put(ani, false);
					totalAnimal++;
				}
			}
			calculateMaxAnimalArea(env);
		}
	}
	
	public GameState(final String name)
	{
		this.name = name;
		progression = 0;
		levels = new HashMap<ISpecie,SpecieLevel>();
		totalXp = new HashMap<ISpecie, Integer>();
		animalCatch = new HashMap<IAnimal, Boolean>();
		envProv = new EnvironmentProvider();
		currentArea = 1;
		currentEnv = envProv.getEnvironment("SAVANNAH");
		envProv.getAvailableEnvironments().add(currentEnv.getName());
		currentNumberAnimalCaught = 0;
		animalCaught = 0;
		totalAnimal = 0;
		maxNumberAnimalOfArea = 0;
		SpecieLevel speLev = SpecieLevel.NOVICE;
		
		for (IEnvironment env : envProv.getEnvironments()) 
		{
			for(ISpecie spe : env.getSpecies())
			{
				totalXp.put(spe, 0);
				levels.put(spe,speLev);
				for(IAnimal ani : spe.getAnimals())
				{
					animalCatch.put(ani, false);
					totalAnimal++;
				}
			}
			calculateMaxAnimalArea(env);
		}
		
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
	 * Explore the next area or environment
	 */
	public void exploreArea() throws IllegalStateException 
	{
		int index = envProv.getEnvironments().indexOf(currentEnv);
		if(currentNumberAnimalCaught == maxNumberAnimalOfArea )
		{
			if(currentArea < currentEnv.getAreas())
			{
				currentArea++;
				currentNumberAnimalCaught = 0;
				calculateMaxAnimalArea(currentEnv);
			}
			else if( index < envProv.getEnvironments().size()-1 ){
				currentEnv = envProv.getEnvironments().get(index+1);
				currentArea = 0;
				currentNumberAnimalCaught = 0;
				calculateMaxAnimalArea(currentEnv);
				envProv.getAvailableEnvironments().add(currentEnv.getName());
			}
			else {
				throw new IllegalStateException ("Tous les environnements sont explorés");
			}
		}
		else {
			throw new IllegalStateException("Animaux restant");
		}
	}
	
	@Override
	/**
	 * Catch a specific animal
	 */
	public void catchAnimal(IAnimal animal) throws IllegalArgumentException, IllegalStateException 
	{
		// recupere l'xp et l'ajoute a l'xp total de l'espece
		if(animal == null)
			throw new IllegalArgumentException("Animal null");
		
		boolean isPresent = false;
		// Check if animal exist
		for(Map.Entry<IAnimal, Boolean> ent : animalCatch.entrySet())
		{
			if(ent.getKey().equals(animal))
			{
				isPresent = true;
				break;
			}
		}
		if(!isPresent)
			throw new IllegalStateException("Animal pas present");
		
		animalCatch.put(animal, true);
		animalCaught++;
		currentNumberAnimalCaught++;
		
		//Add the xp to the total
		updateXp(animal);
	}

	@Override
	/**
	 * Getter of specieLevel of a specific specie
	 */
	public SpecieLevel getSpecieLevel(ISpecie specie) throws IllegalArgumentException 
	{
		if(specie == null)
			throw new IllegalArgumentException("Specie null");
		
		calculateSpecieLevel(specie);
		return levels.get(specie);
	}
	
	/**
	 * Calculate the specific level of a specie
	 * @param specie specie to calculate
	 */
	private void calculateSpecieLevel(ISpecie specie)
	{	
		int xp = 0;
		if(totalXp.get(specie) != null)
			xp = totalXp.get(specie);
		
		SpecieLevel speLev = SpecieLevel.NOVICE;
		
		if(xp >= SpecieLevel.WRANGLER.getRequiredXP())
		{
			speLev = SpecieLevel.WRANGLER;
			if(xp >= SpecieLevel.CHAMPION.getRequiredXP())
			{
				speLev = SpecieLevel.CHAMPION;
				if(xp >= SpecieLevel.MASTER.getRequiredXP())
				{
					speLev = SpecieLevel.MASTER;
				}
			}
		}
		levels.put(specie, speLev);
	}

	@Override
	/**
	 * Getter of progression
	 */
	public int getProgression() 
	{
		return updateProgression();
	}
	
	/**
	 * Calculate the progression
	 * @return the percentage of the progression
	 */
	private int updateProgression()
	{
		progression = (int) Math.round(animalCaught/totalAnimal * 100);
		return progression;
	}
	
	/**
	 * Calculate the new xp total
	 * @param animal add the xp of the animal caught
	 */
	private void updateXp(IAnimal animal)
	{
		ISpecie spe = null;
		
		for(Map.Entry<ISpecie, Integer> ent : totalXp.entrySet())
		{
			for(IAnimal ani : ent.getKey().getAnimals()) 
			{
				if(ani.equals(animal))
				{
					spe = ent.getKey();
					break;
				}
			}
		}
		if(spe == null)
		{
			System.out.println("Error !");
			return;
		}
		int xp = totalXp.get(spe);
		totalXp.put(spe, xp + animal.getXP());
	}
	
	/**
	 * Calculate the max number of animal in the area
	 * @param env
	 */
	private void calculateMaxAnimalArea(IEnvironment env)
	{
		int res = 0;
		for(ISpecie spe : env.getSpecies())
			if(spe.getArea() == currentArea+1)
				res += spe.getAnimals().size();
		
		maxNumberAnimalOfArea = res;
	}
}
