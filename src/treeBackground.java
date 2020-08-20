/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/
import java.awt.Graphics;
import java.util.ArrayList;

public class treeBackground {

	public int x,y;
	public ArrayList<Tree> TreeGro;
	
	public treeBackground(){
		TreeGro = new ArrayList<Tree>();
		
		for(int i= 0; i<9; i++){
			TreeGro.add(new Tree(i*100));
		}
	}
	
	public void draw(Graphics g){
		for (int i=0; i< TreeGro.size(); i++){
			TreeGro.get(i).x = i*100;
			TreeGro.get(i).draw(g);
		}
	}
	
	public void move(){
		TreeGro.remove(0);
		TreeGro.add(new Tree(600));
	}
	
}
