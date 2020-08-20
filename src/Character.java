/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Character{

	public int x,y;
	public int gravity;
	public int width = 73;
	public int height = 113;


	public enum State{
		STANDING, 
		JUMPING
	}
	protected State state = State.STANDING;

	public Character (int x, int y){
		this.x = x;
		this.y = y;
		state = State.STANDING;
		gravity = 10;
	}

	Image standingImage = ImageUtils.loadImage("Graphics/character-standing.png");
	Image jumpingImage = ImageUtils.loadImage("Graphics/character-jump.png"); //?????

	public void drawCharacter(Graphics g){

		switch(state){
		case STANDING:
			g.drawImage(standingImage,x,y,null);
			break;
		case JUMPING: 
			g.drawImage(jumpingImage,x,y,null);
			break;

		}
	}

	public void update(){

	}
}

