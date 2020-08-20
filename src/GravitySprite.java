/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
public class GravitySprite extends Character{

	public static int GRAVITY = 10;
	public int vY = 0;
	public int aY = 0;
	public int bound = 350;

	public GravitySprite(int x, int y){
		super (x,y);
	}

	public void setVertSpeed(int v){
		vY = v;
	}

	public void setVertAccel(int a){
		aY = a;
	}


	public int getBound() {
		return bound;
	}

	public void setBound(int bound) {
		this.bound = bound;
	}

	public void update() {

		if(this.y+100 <= bound){
			state = State.JUMPING;
			aY = gravity;
		}

		vY += aY;
		this.y += vY;

		if (this.y+100 >= bound){
			vY = 0;
			aY = 0;
			state = State.STANDING;
		}
	}



}

