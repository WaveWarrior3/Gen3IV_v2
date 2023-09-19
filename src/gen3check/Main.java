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


		//JFileChooser fc = new JFileChooser();
		//if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		//	String file_tmp = fc.getSelectedFile().getAbsolutePath();
		//	System.out.println(file_tmp);
		//}

		// Read data from file
		try {
			File fp = new File("/home/jacob/git/Gen3IV_v2/filename.txt");
			Scanner myReader = new Scanner(fp);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				//System.out.println(data);
			}
			myReader.close();
		}
		catch (IOException e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
		}
		

		// Write data to file
		/*
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

		*/
	}
}
