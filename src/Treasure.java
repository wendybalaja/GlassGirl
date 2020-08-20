/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Graphics;
import java.awt.Image;
import java.lang.Object;

public class Treasure {

	public int x,y;
	public int width = 23;
	public int height = 23;

	public enum State{
		NORMAL,
		HIT
	}
	public State state = State.NORMAL;

	public Treasure (int x, int y){
		this.x = x;
		this.y = y;
		state = State.NORMAL;
	}


	Image treasure = ImageUtils.loadImage("Graphics/treasure.png");

	public void draw (Graphics g){

		switch (state){
		case NORMAL:
			g.drawImage(treasure,x,y,null);
			break;

		case HIT:
			break;
		}
	}
}
