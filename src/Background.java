/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Component;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.lang.ArrayIndexOutOfBoundsException;
public class Background {
	
	public int x,y;
	public ArrayList<Ground> Gro ;
	
	public Background(){
		Gro= new ArrayList<Ground>();
		
		for(int i=0;i<8;i++){
		 Gro.add(new Ground(i*100));
		 
		}
	}
	
	
public void draw(Graphics g){
	for(int i=0;i<Gro.size();i++){
		Gro.get(i).x=i*100;
		Gro.get(i).drawGround(g);
	}
}
	public void move(){
		Gro.remove(0);
		Gro.add(new Ground(600));
	}
	
	public void update(){
		for(int i=0; i<Gro.size(); i++){
			Gro.get(i).x -= 10;
		}
	}
	
	public int getStanding(){
		return Gro.get(1).y;
	}
}