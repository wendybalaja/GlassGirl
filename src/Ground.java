/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public class Ground extends JComponent {
 
	public int x,y,height;
	public int width;
	public Color lowerGround = new Color (107,127,69);
	public Color upperGround = (Color.green);

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Ground (int x){
		this.x = x;
		this.width=100;
		int k= (int) (Math.random()*5);
		if(k==0){
			this.height=100;
		}
		else if (k==1){
			this.height=130;
		}
		else if (k==2){
			this.height=160;
		}
		else if (k==3){
			this.height=190;
		}
		else {
			this.height = 0;
		}
	}
	
	public void drawGround(Graphics g){
		g.setColor(upperGround);
		g.fillRect(x,500-height,width,500-20);
		g.setColor(lowerGround);
		g.fillRect(x,520-height, width, 500-(height-20));
	}
}
