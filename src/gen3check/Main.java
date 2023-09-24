package gen3check;

import gen3check.gui.MainWindow;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import gen3check.util.DataListUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		DataListUtil.init();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		Controller controller = new Controller(new ToolEngine());
		MainWindow MW = new MainWindow(controller);


	}
}
