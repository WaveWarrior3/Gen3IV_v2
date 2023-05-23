package gen3check;

import javax.swing.JCheckBox;

import gen3check.observers.PokemonListContainerObserver;
import gen3check.pokemon.data.StatPack;

public class Controller {
	private ToolEngine e;
	private int toggledLevel;
	public Controller(ToolEngine e) {
		this.e = e;
		this.toggledLevel = 5;
	}
	
	public void onPokemonGridSelectionChanged(int index){
		this.e.onPokemonGridSelectionChanged(index);
	}
	
	public void addPokemonListContainerObserver(PokemonListContainerObserver observer) {
		this.e.addPokemonListContainerObserver(observer);
	}
	public int getTrainerID(){
		return this.e.getTrainerID();
	}
	public int getPokemonID(){
		return this.e.getPokemonID();
	}
	public PokemonFoundData getPokemon(int index){
		return this.e.getPokemon(index);
	}
	public void requestQuit() {
		this.e.quit();
	}
	public int getToggledLevel() {
		return this.toggledLevel;
	}
	public void toggleLevel(int index) {
		if (this.toggledLevel == 5)
			this.toggledLevel = 6;
		else
			this.toggledLevel = 5;
		
		//this.e.onPokemonGridSelectionChanged(index);
		this.e.updatePanel(index);
	}
	
	public int getPokemonSetLevel() {
		return this.e.getPokemonSetLevel();
	}
	
	public void setPokemonSetLevel(int id) {
		this.e.setPokemonSetLevel(id);
	}
	
	//////////////
	
	public void search(int minFrame, int maxFrame, int trainerID, int pokemonID, StatPack spminus, StatPack spneutral, StatPack spplus, JCheckBox[] natures){
		this.e.search(minFrame,maxFrame,trainerID,pokemonID,spminus,spneutral,spplus, natures);
	}
}
