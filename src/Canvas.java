/* Meiwen Zhou
 NetID:29845750
 Project4
 MW 2:00pm Lab
 I did not collaborate with anyone on this assignment.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Canvas extends JPanel implements ActionListener,KeyListener{

	public Background gro;
	public treeBackground treeGro;
	public Timer t;
	public GravitySprite cha;
	public Treasure treasure;
	public Hazards hazard;
	public int seconds;
	public int hazardCount = 5;
	public int treasureCount = 3;
	public static int level = 1;
	public static int timer = 0;
	public static int timerS = 0;
	public int realTimerS = 0;
	public static int score = 0;
	public static JLabel lab1;
	public static JLabel lab2;
	public static JLabel lab3;
	public Heart h1;
	public Heart h2;
	public Heart h3;
	public boolean heartCheck = true;
	public int levelSpeed = 11;

	Color daySky = new Color(165,221,253);
	Color daySun = new Color(250,242,32);




	public Canvas(){
		gro = new Background();
		treeGro = new treeBackground();
		cha = new GravitySprite(130,150);
		treasure = new Treasure(gro.Gro.get(5).x-150,300-gro.Gro.get(7).y-100);
		hazard = new Hazards(gro.Gro.get(7).x-150,300-gro.Gro.get(5).y-20);
		setPreferredSize(new Dimension(800,500));
		t= new Timer(100,this);
		h1 = new Heart (700,10);
		h2 = new Heart (730,10);
		h3 = new Heart (760,10);
		//*//
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		Dimension size = getSize();

		//Draw background sky&sun
		g.setColor(daySky);
		g.fillRect(0, 0,size.width, size.height);
		g.setColor(daySun);
		g.fillOval(400, 50, 100, 100);
		
		treeGro.draw(g);
		gro.draw(g);
		cha.drawCharacter(g);
		treasure.draw(g);
		hazard.draw(g);
		h1.drawHeart(g);
		h2.drawHeart(g);
		h3.drawHeart(g);

		t.start();

	}

	public static void main(String[]args){

		JFrame frame = new JFrame();
		frame.setSize(800, 500);

		Canvas canvas = new Canvas();

		lab1 = new JLabel("Level:1            ", JLabel.LEFT);
		canvas.setLayout(new FlowLayout());
		canvas.add(lab1);

		lab2 = new JLabel("Time: "+ Integer.toString(timer));
		canvas.add(lab2);

		lab3 = new JLabel ("            "+"Score:" + Integer.toString(score));
		canvas.add(lab3);

		frame.add(canvas);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//TimeElapse

	}
	@Override
	public void actionPerformed(ActionEvent e) {


		if(timer==10){
			timerS ++;
			timer=0;
		}
		else{
			timer ++;
			realTimerS ++;
		}
		lab2.setText("Time:"+ Integer.toString(timerS)+":" +Integer.toString(timer));


		if(realTimerS %101 == 0){
			level++;
			lab1.setText("         "+"Level:" + Integer.toString(level));
			levelSpeed -= 1;
		}
		
		if(seconds%7 ==0){
			treeGro.move();
		}


		///background color change 
		if (timerS%2 ==0){
			daySun = new Color(241,238,1);
			daySky = new Color(178,221,250);
		}
		else {
			daySun = new Color(245,242,201);
			daySky = new Color(44,53,106);
		}
		

		seconds++;
 // LEVEL SPEED TEST
		if(seconds%levelSpeed==0){
			score += 10;
			gro.move();
			moveHazard();
			moveTreasure();
			lab3.setText("            "+"Score:" + Integer.toString(score));

		}

		//Make character automatically fall when it is standing at a higher place
		if (cha.y + 30< 500-gro.Gro.get(1).height-20){
			cha.setBound(500-gro.Gro.get(1).height-25);
		}
		else{

			JOptionPane.showMessageDialog(null, "You hit the wall! Game Over! Click to RESTART");
			reset();
		}

		cha.update();
		checkHazard();
		checkTreasure();
		checkFalling();
		repaint();
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){
			cha.setVertSpeed(-30);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_UP){
			cha.setBound(500-gro.Gro.get(2).height-25);
		}
	}

	public void moveHazard(){
		if(hazardCount >= 0){
			hazard.x = gro.Gro.get(hazardCount).x-150;
			hazard.y = (300-gro.Gro.get(hazardCount).y)-20;
			hazardCount -= 1;
		}
		else{
			hazardCount = 6;
			heartCheck = true;
		}
	}

	public void moveTreasure(){
		if(treasureCount >= 0){
			treasure.x = gro.Gro.get(treasureCount).x-150;
			treasure.y = 300-gro.Gro.get(treasureCount).y-100;
			treasureCount -= 1;
		}
		else {
			treasure.state = Treasure.State.NORMAL; // NOTICE HERE
			hazard.state = Hazards.State.NORMAL; //ARRAYLIST(0) IS ACTING WEIRD
			treasureCount = 6;
		}
	}

	public void checkHazard(){
		if (hazard.x > cha.x && hazard.x < (cha.x+ cha.width) && hazard.y > cha.y && hazard.y<  (cha.y+cha.height) ){
			hazard.state = Hazards.State.HIT;
			System.out.println("hit hazard");

			while(heartCheck == true){
				if (h3.state == Heart.State.ALIVE && h2.state == Heart.State.ALIVE && h1.state == Heart.State.ALIVE){
					h3.state = Heart.State.DEAD;
					heartCheck = false;
					break;
				}

				else if (h3.state == Heart.State.DEAD && h2.state == Heart.State.ALIVE && h1.state == Heart.State.ALIVE ){
					h2.state = Heart.State.DEAD;
					heartCheck = false;
					break;
				}
				else if(h3.state == Heart.State.DEAD && h2.state == Heart.State.DEAD && h1.state == Heart.State.ALIVE){
					h1.state = Heart.State.DEAD;
					System.out.println("Game Over!");
					heartCheck = false;
					JOptionPane.showMessageDialog(null, "You're out of hearts. Game Over! Click to RESTART");
					reset();
					break;
				}


			}
		}
	}



	public void checkTreasure(){
		if (treasure.x > cha.x && treasure.x < cha.x+ cha.width && treasure.y > cha.y && treasure.y< cha.y+cha.height ){
			treasure.state = Treasure.State.HIT;
			System.out.println("hit treasure");
			score += 10;

		}
	}
	
	public void checkFalling(){
		if (cha.y + cha.height > 500){
			score -= 100;
			cha.y = 50;
		}
	}

	public void reset(){
		cha.y = 50;
		score = 0;
		level = 1;
		timerS = 0;
		timer = 0;
		levelSpeed = 11;
		h1.state = Heart.State.ALIVE;
		h2.state = Heart.State.ALIVE;
		h3.state = Heart.State.ALIVE;
	}
}


