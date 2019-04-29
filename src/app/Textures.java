package app;

import java.awt.image.BufferedImage;



public class Textures {
	public BufferedImage[] player = new BufferedImage[8];
	Spritesheet bs, ps;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	
	public Textures() {
		BufferedImageLoader loader = new BufferedImageLoader();
		player_sheet = loader.loadImage("/mansheet.png");
		bs = new Spritesheet(block_sheet);
		ps = new Spritesheet(player_sheet);
		getTextures();
		
	}
	private void getTextures() {
		player[0] = ps.grabImage(13, 1, 47, 54);
		player[1] = ps.grabImage(13, 2, 47, 54);
		player[2] = ps.grabImage(13, 3, 47, 54);
		player[3] = ps.grabImage(13, 4, 47, 54);
		player[4] = ps.grabImage(13, 5, 47, 54);
		player[5] = ps.grabImage(13, 6, 47, 54);
		player[6] = ps.grabImage(13, 7, 47, 54);
		player[7] = ps.grabImage(13, 8, 47, 54);
		
	}
}

