package gen3check.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import gen3check.Controller;
import gen3check.predictor.IVPredictorWindow;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuBar extends JMenuBar{
	
	private static final long serialVersionUID = 72672451L;
	public MenuBar(final MainWindow mw, final Controller c){
		JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		final JMenuItem openMenuItem = new JMenuItem("IV Predictor");
		openMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				IVPredictorWindow ipw = new IVPredictorWindow(mw,c);
				ipw.showDialog();
			}			
		});
		menu.add(openMenuItem);


		final JMenuItem saveButton = new JMenuItem("Save Data");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Save Button Pressed");
			}	
		});
		menu.add(saveButton);

		final JMenuItem loadButton = new JMenuItem("Load Data");
		loadButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Load Button Pressed");
			}	
		});
		menu.add(loadButton);


		
		final JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				c.requestQuit();
			}			
		});
		menu.add(exitMenuItem);

		
		
		this.add(menu);
		
		menu = new JMenu("Help");
		final JMenuItem aboutMenuItem = new JMenuItem("About..");
		aboutMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "Pokemon Gen 3 Starter Manip v1.2c\nCreated by MKDasher\nModified by JP_Xinnam";
				JOptionPane.showMessageDialog(MenuBar.this, str , "Pokemon Gen 3 Starter Manip", JOptionPane.INFORMATION_MESSAGE);
			}			
		});
		menu.add(aboutMenuItem);
		this.add(menu);
	}
}
