package gen3check;

import gen3check.gui.MainWindow;

import javax.swing.UIManager;

import gen3check.util.DataListUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {

		DataListUtil.init();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		Controller controller = new Controller(new ToolEngine());
		MainWindow MW = new MainWindow(controller);

		String[] vals = MW.getIVCheckPanel().getVals();
		for (int i = 0; i < 43; i++) System.out.println(vals[i]);


		try {
			//File fp = new File("/home/jacob/git/Gen3IV_v2/filename.txt");
			FileWriter myWriter = new FileWriter("/home/jacob/git/Gen3IV_v2/filename.txt");
			for (int i = 0; i < 43; i++) myWriter.write(vals[i] + "\n");
			myWriter.close();
		}
		catch (IOException e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
		}
	}
}
