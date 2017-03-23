package dev.projekt_v2.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageStorage {

	private static ArrayList<BufferedImage> images = new ArrayList<>();
	
	public static void loadImages() throws IOException {		
		BufferedImage img = ImageIO.read(ClassLoader.getSystemResource("res/answer.png"));
		
		TexturesCrop answer = new TexturesCrop(img);
		
		images.add(ImageIO.read(ClassLoader.getSystemResource("res/domyslnyMenu.jpg"))); // ID: 0
		images.add(ImageIO.read(ClassLoader.getSystemResource("res/nimbusMenu.jpg"))); // ID: 1
		images.add(answer.crop(0, 0, 650, 650)); // ID: 2 [good]
		images.add(answer.crop(650, 0, 650, 650)); // ID: 3 [bad]
	}
	
	public static BufferedImage getImage(int id) {
		return images.get(id);
	}
	
}
