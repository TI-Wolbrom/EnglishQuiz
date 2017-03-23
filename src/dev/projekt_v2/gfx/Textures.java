package dev.projekt_v2.gfx;

import java.awt.image.BufferedImage;

public class Textures {
	
	public static BufferedImage good, bad;
	
	public static void init(){
		
		TexturesCrop answer = new TexturesCrop(TextureLoader.loadImage("/textures/answer.png"));
		
		good=answer.crop(0,0,650,650);
		bad=answer.crop(650, 0, 650, 650);
		
	}
	

}

