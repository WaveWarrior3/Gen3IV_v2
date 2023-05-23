/* RestPanel.java
 * 
 * Handles the appearance of the two panels that indicate IVs and Level 5 stats of selected Frame
 * to be easily read & Screen Captured.
 * 
 * - 5/13/18: Currently shows Hidden Power - While useful in R/S/E, not as useful in FR/LG.
 * 		- TODO: Add option to toggle between Hidden Power, Nature, or Both?
 * 			- thebox2.png is already created for just this purpose!
 *
 */
package gen3check.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

//import com.sun.glass.events.KeyEvent;

import rng.PokemonRNG;


import gen3check.Controller;
import gen3check.PokemonFoundData;
import gen3check.pokemon.data.Ability;
import gen3check.pokemon.data.Nature;
import gen3check.pokemon.data.PokemonItem;
import gen3check.pokemon.data.StatPack;
import gen3check.pokemon.Pokemon;

public class RestPanel extends JPanel{
	public RestPanel(MainWindow mainWindow, Controller c) {
		this.mw = mainWindow;
		this.c = c;
		this.setParams();
	}
	
	public JCheckBox[] getNatures(){
		return chkNature;
	}
	
	public void updateSelectedPokemon(Pokemon pokemon, int frame){
		this.selectedPokemon = pokemon;
		this.selectedFrame = frame;
		this.revalidate();
		this.repaint();
	}
	
	private void setParams(){
		this.selectedPokemon = new Pokemon();
		this.chkNature = new JCheckBox[Nature.NATURE_N];
		this.pkmFoundPanel = new PokemonFoundPanel(mw,c,this);
		this.BOXPANEL = new ImageIcon(RestPanel.class.getResource("/image/thebox2.png")).getImage();
		this.setLayout(new BorderLayout());
		this.add(new JPanel(){
			{
				this.setBorder(new TitledBorder("Natures"));
				this.setLayout(new BorderLayout());
				this.add(new JPanel(){
					{
						this.setLayout(new GridLayout(5,5));
						for (int i = 0; i < Nature.NATURE_N; i++){
							chkNature[i] = new JCheckBox(new Nature(i).getName());
							this.add(chkNature[i]);
						}
					}
				}, BorderLayout.CENTER);
				this.add(new JPanel(){
					{
						this.setLayout(new GridLayout(1,2));
						this.add(new JButton("Check All"){
							{
								this.addActionListener(new ActionListener(){
									@Override
									public void actionPerformed(ActionEvent arg0) {
										for (int i = 0; i < Nature.NATURE_N; i++){
											chkNature[i].setSelected(true);
										}
									}
								});
							}
						});
						this.add(new JButton("Uncheck All"){
							{
								this.addActionListener(new ActionListener(){
									@Override
									public void actionPerformed(ActionEvent arg0) {
										for (int i = 0; i < Nature.NATURE_N; i++){
											chkNature[i].setSelected(false);
										}
									}
								});
							}
						});
					}
				}, BorderLayout.SOUTH);
				
					
			}
		}, BorderLayout.NORTH);
		this.add(pkmFoundPanel, BorderLayout.CENTER);
		this.add(new JPanel(){
			{
				this.setLayout(new BorderLayout());
				//this.add(new JPanel(){
				valuesPanel = new JPanel(){
					{
						this.setLayout(new GridLayout(1,3));
						this.add(new JPanel(){
							{
								this.setPreferredSize(new Dimension(205,75));
							}
							@Override
							public void paint(Graphics g) {
								g.drawImage(BOXPANEL,0,0,200,72,this);
								g.setColor(Color.WHITE);
								g.setFont(new Font("default", Font.BOLD,12));
								g.drawString(Integer.toString(selectedPokemon.IV.hp), 19 - Integer.toString(selectedPokemon.IV.hp).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.IV.atk), 51 - Integer.toString(selectedPokemon.IV.atk).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.IV.def), 83 - Integer.toString(selectedPokemon.IV.def).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.IV.spa), 115 - Integer.toString(selectedPokemon.IV.spa).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.IV.spd), 147 - Integer.toString(selectedPokemon.IV.spd).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.IV.spe), 179 - Integer.toString(selectedPokemon.IV.spe).length() * 4, 38);
								// g.drawString(selectedPokemon.getHiddenPowerType().toString() + " " + Integer.toString(selectedPokemon.getHiddenPowerDamage()), 85, 64);
								g.drawString(selectedPokemon.getNature().toString(), 85, 64);
							}
						
						});
						this.add(new JPanel(){
							{
								this.setPreferredSize(new Dimension(205,75));
							}
							@Override
							public void paint(Graphics g) {
								g.drawImage(BOXPANEL,0,0,200,72,this);
								g.setColor(Color.WHITE);
								g.setFont(new Font("default", Font.BOLD,12));
								g.drawString(Integer.toString(selectedPokemon.stat.hp), 19 - Integer.toString(selectedPokemon.stat.hp).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.stat.atk), 51 - Integer.toString(selectedPokemon.stat.atk).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.stat.def), 83 - Integer.toString(selectedPokemon.stat.def).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.stat.spa), 115 - Integer.toString(selectedPokemon.stat.spa).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.stat.spd), 147 - Integer.toString(selectedPokemon.stat.spd).length() * 4, 38);
								g.drawString(Integer.toString(selectedPokemon.stat.spe), 179 - Integer.toString(selectedPokemon.stat.spe).length() * 4, 38);
								// g.drawString(selectedPokemon.getHiddenPowerType().toString() + " " + Integer.toString(selectedPokemon.getHiddenPowerDamage()), 85, 64);
								g.drawString(selectedPokemon.getNature().toString(), 85, 64);
							}
						
						});
					}
//				}, BorderLayout.NORTH);
				};
				this.add(valuesPanel, BorderLayout.NORTH);
				this.add(new JButton("Search Around Frame"){
					{
						this.setPreferredSize(new Dimension(100,30));
						this.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent arg0) {
								pkmFoundPanel.updateGridAround(selectedFrame);
							}
						});
					}
				}, BorderLayout.CENTER);
				
				toggleButton = new JToggleButton("Level 5");
				
				toggleButton.setPreferredSize(new Dimension(100,30));
				toggleButton.addItemListener(new ItemListener(){
					@Override
					public void itemStateChanged(ItemEvent e) {

						//c.toggleLevel(pkmFoundPanel.getSelectedIndex());
						//updateSelectedPokemon(selectedPokemon, selectedFrame);
						
						if (toggleButton.isSelected()) {
							toggleButton.setText("Level 6");
							c.setPokemonSetLevel(6);
						} else {
							toggleButton.setText("Level 5");
							c.setPokemonSetLevel(5);
						}
						//updateSelectedPokemon(selectedPokemon, selectedFrame);
						//vauesPanel.revalidate();
						//valuesPanel.repaint();
						pkmFoundPanel.updateCurrentPokemon();
					}

				});
				/*toggleButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						updateSelectedPokemon(selectedPokemon, selectedFrame);
					}
				});*/
				
				this.add(toggleButton, BorderLayout.EAST);	
			}
//		};
		}, BorderLayout.SOUTH);
//		this.add

		this.chkNature[15].setSelected(true);
		this.chkNature[16].setSelected(true);
		this.chkNature[19].setSelected(true);
	}
	
	private JCheckBox[] chkNature;
	
	private MainWindow mw;
	private Controller c;
	private PokemonFoundPanel pkmFoundPanel;
	private Image BOXPANEL;
	private Pokemon selectedPokemon;
	private int selectedFrame;
	private int toggledLevel;
	private JToggleButton toggleButton;
	private JPanel valuesPanel;
}
