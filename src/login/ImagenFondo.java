package login;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class ImagenFondo implements Border {

	public BufferedImage back;
	
	public ImagenFondo(){
		try{
			URL imagePath =new URL(getClass().getResource("../imagenes/Metrrrro.jpg").toString());
		    back =ImageIO.read(imagePath);
		    
			URL imagePath1 =new URL(getClass().getResource("../imagenes/Metrrrro.jpg").toString());
		    back =ImageIO.read(imagePath1);
		    
		}catch(Exception ex){
			
		}
		
	}
	

	@Override
	public Insets getBorderInsets(Component arg0) {
	
		return new Insets(0,0,0,0);
	}

	@Override
	public boolean isBorderOpaque() {
		return false;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	g.drawImage(back,(x+(width-back.getWidth())/2),(y+(height-back.getHeight())/2),null);	
	
		
	}

	
	
	
}
