package dev.projekt_v2.core;

import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import dev.projekt_v2.gfx.Textures;
import dev.projekt_v2.question.QuestionManager;

public class Application {

	private static ApplicationFrame appFrame;
	
	public static void applyLookAndFeel(String lookAndFeel) {
		try {
			if(lookAndFeel.equalsIgnoreCase("Nimbus")) {
				for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					if("Nimbus".equals(info.getName())) {
						UIManager.setLookAndFeel(info.getClassName());					            
						SwingUtilities.updateComponentTreeUI(appFrame);
						break;
					}
				}
			} else {
				UIManager.setLookAndFeel(lookAndFeel);
				SwingUtilities.updateComponentTreeUI(appFrame);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			// Wczytujemy zdjecia przy starcie programu
			ImageStorage.loadImages();
			
			// Tworzymy pytania przy starcie programu
			QuestionManager.createQuestions();
			
			Textures.init();
			
			appFrame = new ApplicationFrame();
			appFrame.init();
			appFrame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
