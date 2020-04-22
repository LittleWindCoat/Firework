import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import javax.swing.JPanel;

/*
 *Name:LWC
 *I did not collaborate with anyone on this assignment.
 */

public class Canvas extends JPanel {

	protected double cos, sin;
	double theta;
	protected static double LocationX, LocationY, HolderY;
	protected int colorChoice,explosionChoice, time;
	double k;
	protected static final double gravity=9.8;
	protected static int speed;
	protected static int degree;

	//This set the canvas size and make it visible and make the starting point of the firework.
	public Canvas () {
		setVisible(true);
		setSize(600, 600);
		HolderY = getHeight()-300;
	}
	
	public void drawTrajectoryLine(){
		repaint();
	}
	
	//This method chooses the color of the fireworks
	public Color colorGame(){
		if(Firework.choice == 0){
			System.out.println("This white");
			return Color.WHITE;
		}else if(Firework.choice == 1){
			return Color.PINK;
		}else if(Firework.choice == 2){
			return Color.BLUE;
		}else if(Firework.choice == 3){
			return Color.GREEN;
		}else if(Firework.choice == 4){
			return Color.ORANGE;
		}return Color.lightGray;
	}

	//This method decides the type of the fireworks
	public void explosionGame(Graphics g, double LocationX, double LocationY){

		//Type1 explosion
		if(Firework.explosionchoice==0){
			g.setColor(colorGame());
			int size =20;
			for(int i = 0; i <= 360; i++){
				//g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				g.drawLine((int)LocationX,(int)LocationY,(int)(LocationX+sin*(size/2)),(int)(LocationY+cos*(size/2)));
				cos = (size/2)*Math.cos(Math.toRadians(theta));
				sin = (size/2)*Math.sin(Math.toRadians(theta));
				theta+= 10;
			}
		}
		
		//Type2 explosion
		if(Firework.explosionchoice==1){
			g.setColor(Color.MAGENTA);
			int size =200;
			int n = 15;
			int unitw = getWidth()/n;
			int unith = getHeight()/n;

			for (int i=0 ;i<20 ;i++ ){
				g.drawLine(((int)LocationX+(size/2)),((int)LocationY),getWidth()-i*unitw,i*unith);
			}
			for (int i=0 ;i<20 ;i++ ){
				g.drawLine(((int)LocationX+(size/2)),((int)LocationY),getWidth()-i*unitw,getHeight()-i*unith);
			}
			for (int i=0 ;i<20 ;i++ ){
				g.drawLine(((int)LocationX+(size/2)),((int)LocationY),getWidth()-i*unitw,getHeight()-i*unith);
			}
			for (int i=0 ;i<20 ;i++ ){
				g.drawLine(((int)LocationX+(size/2)),((int)LocationY),getWidth()-i*unitw,i*unith);
			}
			g.setColor(colorGame());
			for(int i = 0; i <= 360; i++){
				g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				cos = (size/2)*Math.cos(Math.toRadians(theta));
				sin = (size/2)*Math.sin(Math.toRadians(theta));
				theta+= 25;
			}
		}
		
		//Type3 explosion
		if(Firework.explosionchoice==2){
			int size = 300;
			int n = 15;
			int unitw = getWidth()/n;
			int unith = getHeight()/n;
			g.setColor(Color.PINK);

			for (int i=0 ;i<15 ;i++ ){

				g.drawLine(((int)LocationX+(size/2)),((int)LocationY),i*unitw,200);
			}
			for (int i=0 ;i<15 ;i++ ){
				g.drawLine(((int)LocationX+(size/2)),((int)LocationY), 200, i*unith);
			}
			for (int i=0 ;i<15 ;i++ ){
				g.drawLine(((int)LocationX+(size/2)),((int)LocationY),200,i*unith);
			}
			for (int i=0 ;i<15 ;i++ ){
				g.drawLine(((int)LocationX+(size/2)),((int)LocationY),getWidth()-i*unitw,200);
			}
			g.setColor(colorGame());
			for(int i = 0; i <= 360; i++){
				g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				cos = (size/2)*Math.cos(Math.toRadians(theta));
				sin = (size/2)*Math.sin(Math.toRadians(theta));
				theta+= 70;
			}
		}
		
		//Type4 explosion
		if(Firework.explosionchoice==3){
			int size = 200;
			int centerx = ((int)LocationX+(size/2));
			int centery = ((int)LocationY);


			for(int i = 1; i < 12; i++){
				g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				if (i == 1){
					g.setColor(Color.BLUE);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				else if (i == 2){
					g.setColor(Color.RED);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 3){
					g.setColor(Color.GREEN);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 4){
					g.setColor(Color.YELLOW);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 5){
					g.setColor(Color.LIGHT_GRAY);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 6){
					g.setColor(Color.PINK);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 7){
					g.setColor(Color.CYAN);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 8){
					g.setColor(Color.ORANGE);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 9){
					g.setColor(Color.MAGENTA);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 10){
					g.setColor(Color.MAGENTA);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 11){
					g.setColor(Color.RED);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
				if (i == 12){
					g.setColor(Color.YELLOW);
					g.drawOval(centerx - (i * 5), centery - (i * 5), (i * 10), (i * 10));
				}
			}
			g.setColor(colorGame());
			for(int i = 0; i <= 360; i++){
				g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				cos = (size)*Math.cos(Math.toRadians(theta));
				sin = (size)*Math.sin(Math.toRadians(theta));
				theta+= 55;
			}
			g.setColor(Color.RED);
			for(int i = 0; i <= 360; i++){
				g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				cos = (size/2)*Math.cos(Math.toRadians(theta));
				sin = (size/2)*Math.sin(Math.toRadians(theta));
				theta+= 55;
			}
		}
		
		//Type5 explosion
		if(Firework.explosionchoice==4){
			int size = 200;
			g.setColor(colorGame());
			for(int i = 0; i <= 360; i++){
				g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				cos = (size)*Math.cos(Math.toRadians(theta));
				sin = (size)*Math.sin(Math.toRadians(theta));
				theta+= 55;
			}
			g.setColor(Color.RED);
			for(int i = 0; i <= 360; i++){
				g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				cos = (size/2)*Math.cos(Math.toRadians(theta));
				sin = (size/2)*Math.sin(Math.toRadians(theta));
				theta+= 55;
			}
			g.setColor(Color.YELLOW);
			for(int i = 0; i <= 360; i++){
				g.drawLine(((int)LocationX+(size/2))+(int)cos,((int)LocationY)+(int)sin,((int)LocationX+(size/2)),((int)LocationY));
				cos = (size/4)*Math.cos(Math.toRadians(theta));
				sin = (size/4)*Math.sin(Math.toRadians(theta));
				theta+= 55;
			}
		}
	}

	//This method draws the circles curve (6 circles)
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		if(time ==0){
		}
		time=0;
		
		speed = Firework.speed_slider.getValue();
		degree = Firework.degree_slider.getValue();

		//#0
		LocationX = (speed*Math.cos(Math.toRadians(degree))*time);
		double k = (speed*Math.sin(Math.toRadians(degree))*time)-(.5*gravity)*(Math.pow(time,2));
		System.out.println(k);
		LocationY = HolderY-k;
		System.out.println("Y："+ LocationY);
		g.setColor(colorGame());
		g.drawOval((int)LocationX, (int)LocationY, 30, 30);
		time+=1;

		//#1
		LocationX = (speed*Math.cos(Math.toRadians(degree))*time);
		k = (speed*Math.sin(Math.toRadians(degree))*time)-(.5*gravity)*(Math.pow(time,2));
		System.out.println(k);
		LocationY = HolderY-k;
		System.out.println("Y："+ LocationY);
		g.drawOval((int)LocationX, (int)LocationY, 30, 30);
		time+=1;

		//#2
		LocationX = (speed*Math.cos(Math.toRadians(degree))*time);
		k = (speed*Math.sin(Math.toRadians(degree))*time)-(.5*gravity)*(Math.pow(time,2));
		System.out.println(k);
		LocationY = HolderY-k;
		System.out.println("Y："+ LocationY);
		g.drawOval((int)LocationX, (int)LocationY, 30, 30);
		time+=1;

		//#3
		LocationX = (speed*Math.cos(Math.toRadians(degree))*time);
		k = (speed*Math.sin(Math.toRadians(degree))*time)-(.5*gravity)*(Math.pow(time,2));
		System.out.println(k);
		LocationY = HolderY-k;
		System.out.println("Y："+ LocationY);
		g.drawOval((int)LocationX, (int)LocationY, 30, 30);
		time+=1;

		//#4
		LocationX = (speed*Math.cos(Math.toRadians(degree))*time);
		k = (speed*Math.sin(Math.toRadians(degree))*time)-(.5*gravity)*(Math.pow(time,2));
		System.out.println(k);
		LocationY = HolderY-k;
		System.out.println("Y："+ LocationY);
		g.drawOval((int)LocationX, (int)LocationY, 30, 30);
		time+=1;
		
		//#5
		LocationX = (speed*Math.cos(Math.toRadians(degree))*time);
		k = (speed*Math.sin(Math.toRadians(degree))*time)-(.5*gravity)*(Math.pow(time,2));
		System.out.println(k);
		LocationY = HolderY-k;
		System.out.println("Y："+ LocationY);
		g.drawOval((int)LocationX, (int)LocationY, 30, 30);
		time+=1;

		//#6
		LocationX = (speed*Math.cos(Math.toRadians(degree))*time);
		k = (speed*Math.sin(Math.toRadians(degree))*time)-(.5*gravity)*(Math.pow(time,2));
		System.out.println(k);
		LocationY = HolderY-k;
		System.out.println("Y："+ LocationY);
		time+=1;

		if(time>=6){
			explosionGame(g,LocationX,LocationY );
		}
		else{
			time=0;
			LocationY=HolderY;
			LocationX=0;
		}

	}
}
