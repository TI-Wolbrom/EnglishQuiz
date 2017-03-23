package dev.projekt_v2.gfx;

import java.awt.image.BufferedImage;

public class TexturesCrop {

	private BufferedImage texture;
	
	
	public TexturesCrop(BufferedImage texture){
		this.texture=texture;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		
		return texture.getSubimage(x, y, width, height);
	}
}
