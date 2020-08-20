/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Graphics;
import java.awt.Image;

public class Hazards {

	public int x,y;
	public int width = 30;
	public int heiht = 30;

	public enum State{
		NORMAL,
		HIT
	}

	public State state = State.NORMAL;

	public Hazards (int x, int y){
		this.x= x;
		this.y= y;
		state= State.NORMAL;
	}

	Image hazard = ImageUtils.loadImage("Graphics/hazard.png");

	public void draw (Graphics g){

		switch (state){
		case NORMAL:
			g.drawImage(hazard,x,y,null);
			break;

		case HIT:
			break;
		}	
	}
}
