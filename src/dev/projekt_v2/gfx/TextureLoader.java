package dev.projekt_v2.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TextureLoader {

	public static BufferedImage loadImage(String src){
		try {
			return ImageIO.read(TextureLoader.class.getResource(src));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
