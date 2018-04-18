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
	private List<String> availableEnvironments;
	
	private static final String FILE_PATH = "src/main/resources/AnimalList.csv";
	

	public EnvironmentProvider(List<String> availableEnvironments)
	{
		this.availableEnvironments = availableEnvironments;
	}
	
	@Override
	public List<String> getAvailableEnvironments() {
		// TODO Auto-generated method stub
		return availableEnvironments;
	}

	@Override
	public IEnvironment getEnvironment(String name) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		try {
			System.out.println(new File(".").getAbsolutePath());
			final List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
			
			for (String line : lines) {
				String[] s = line.split(",");
				System.out.println(s.length);
				System.out.println(s[0]);
				if(s.length > 1)
				{
					System.out.println(s[1]);
					System.out.println("Secret : "+s[11]);
					System.out.println("Boss : "+s[12]);
					System.out.println("Endangered : "+s[13]);
				}
		        
		      }
			
		}
		catch(final IOException e)
		{
			throw new IllegalStateException(e);
		}
		return null;
	}
	
	public static void main(String [] args)
	{
		List<String> s =  new ArrayList<String>();
		s.add("Savannah");
		s.add("Jungle");
		
		EnvironmentProvider e = new EnvironmentProvider(s);
		e.getEnvironment("Savannah");
		
	}
	
}
