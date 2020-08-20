/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;

public class Tree {

	public int x,y;
	public Image tree;
	
	public Tree(int x){
		this.x = x;
		y = 300;
		int k = (int)(Math.random()*3);
		if (k ==0){
			tree = ImageUtils.loadImage("Graphics/tree.png");
		}
		else if (k==1){
			tree = ImageUtils.loadImage("Graphics/tree-2.png");
		}
		else if (k==2){
			tree = ImageUtils.loadImage("Graphics/tree-3.png");
		}
		
	}
	
			
	
	public void draw (Graphics g){
		g.drawImage(tree, x, y, null);
		Color dirt = new Color(68,46,44);
		g.setColor(dirt);
		g.fillRect(x-20, y+110,100,120);
	}
}
