package fr.univavignon.rodeo.imp;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import fr.univavignon.rodeo.api.*;

public class GameStateProvider implements IGameStateProvider 
{
	/**
	 * File path of saved game
	 */
	private final String FILE_PATH = "src/main/resources/saveGame_";
	
	@Override
	/**
	 * Save the game state
	 */
	public void save(IGameState gameState) 
	{
		if(gameState == null)
		{
			System.out.println("Null erreur");
			throw new IOException("Null erreur");
			return;
		}
		String file = FILE_PATH+gameState.getName()+".txt";
		
		try{
			PrintWriter pw = new PrintWriter(file, "UTF-8");
			pw.print(gameState.getProgression());
			pw.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Get the game state with his name
	 */
	public IGameState get(String name) throws IllegalArgumentException 
	{
		if(name == null)
			throw new IllegalArgumentException("Nom pas valide");
		
		String file = FILE_PATH+name+".txt";
		GameState gameState = null;
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        line = br.readLine();
		    }
		    String lines = sb.toString();
		    
		    int progress = Integer.parseInt(lines);
		    gameState = new GameState(name,progress);
		    
		}catch (IOException e) {
			e.printStackTrace();
		}
		return gameState;
	}
}
