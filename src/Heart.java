/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Graphics;
import java.awt.Image;

public class Heart {

	/* Meiwen Zhou
	 NetID:29845750
	 Project4
	 MW 2:00pm Lab
	 I did not collaborate with anyone on this assignment.
	*/
	public int x,y;
	
	public enum State{
		ALIVE,
		DEAD
	}
	public State state = State.ALIVE;

	public Heart(int x, int y){

		this.x = x;
		this.y = y;
		state = State.ALIVE;

	}

	Image heart = ImageUtils.loadImage("Graphics/heart.png");

	public void drawHeart (Graphics g){
		
		switch (state){
		case ALIVE:
			g.drawImage(heart,x,y,null);
			break;
			
		case DEAD:
			break;
		}
	}

}