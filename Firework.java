import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JRadioButton;

/*
 *Name:LWC
 *I did not collaborate with anyone on this assignment.
 */

public class Firework extends JFrame implements ActionListener, ChangeListener, ItemListener, KeyListener, MouseListener, MouseMotionListener  {

	//Global Variables
	double Launchangle;
	double SPeed;
	int a;
	
	//Canvas
	Canvas canvas;
	
	//Labels and Slider
	JLabel speed;
	static JSlider degree_slider;
	static JSlider speed_slider;
	JLabel Speed;
	JLabel angle;
	
	//Render button
	JButton render;
	
	//Button Groups 
	ButtonGroup COLOR;
	ButtonGroup TYPE;
	
	//Radio Buttons
	JRadioButton white;
	JRadioButton pink;
	JRadioButton green;
	JRadioButton black;
	JRadioButton blue;
	JRadioButton type1;
	JRadioButton type2;
	JRadioButton type3;
	JRadioButton type4;
	JRadioButton type5;
	
	//Integer variables
	public static int choice;
	public static int explosionchoice;
	
	//Timer
	protected  Timer time;
	
	//Instructor
	public Firework() {
		
		//Set the title for the window
		setTitle("我真的不懂艺术Firework");
		//嘻嘻嘻
		
		//Create new canvas
		canvas = new Canvas();
		
		//new Sliders and add sliders to the ChangeListener method
		degree_slider = new JSlider();
		speed_slider = new JSlider();
		this.add(speed_slider);
		this.add(degree_slider);
		degree_slider.addChangeListener(this);
		speed_slider.addChangeListener(this);

		//Initializing labels
		Speed = new JLabel("speed");
		angle = new JLabel("angle");
		this.add(Speed);
		this.add(angle);

		//render button to ActionCommand
		render = new JButton("render");
		render.setActionCommand("render");
		this.add(render);
		render.addActionListener(this);

		//Initializing RadioButtons and set text for them
		white = new JRadioButton("white");
		pink =  new JRadioButton("pink");
		green =  new JRadioButton("green");
		black =  new JRadioButton("orange");
		blue =  new JRadioButton("blue");
		type1 =  new JRadioButton("type1");
		type2 = new JRadioButton("type2");
		type3 =  new JRadioButton("type3");
		type4 = new JRadioButton("type4");
		type5 =  new JRadioButton("type5");
			
		//Add all the RadioButtons to the ButtonGroups 
		COLOR = new ButtonGroup ();
		TYPE = new ButtonGroup ();

		//Initializing panels
		JPanel canvas_p = new JPanel();
		JPanel setting_p = new JPanel();
		JPanel render_p = new JPanel();
		// sub panel
		JPanel color_p = new JPanel();
		JPanel type_p = new JPanel();
		JPanel degree_p = new JPanel();
		JPanel speed_p = new JPanel();

		//Set the layout for the setting panel
		this.setLayout(new BorderLayout());
		setting_p.setLayout(new GridLayout(4,1));
		degree_p.setLayout(new GridLayout(3, 1));
		speed_p.setLayout(new GridLayout(3, 1));
		canvas_p.setLayout(new GridLayout(1,1));

		//Add canvas to the 
		canvas_p.add(canvas);
		canvas_p.setSize(600, 600);

		//add the sliders and labels to the degree panel and speed canvas
		degree_p.add(angle);
		degree_p.add(degree_slider);
		speed_p.add(Speed);
		speed_p.add(speed_slider);

		//add radio buttons to color panel and type panel
		color_p.add(white);
		color_p.add(pink);
		color_p.add(blue);
		color_p.add(green);
		color_p.add(black);
		type_p.add(type1);
		type_p.add(type2);
		type_p.add(type3);
		type_p.add(type4);
		type_p.add(type5);
		white.setSelected(true);
		type1.setSelected(true);

		//Add radio buttons to the button groups 
		COLOR.add(white);
		COLOR.add(pink);
		COLOR.add(blue);
		COLOR.add(green);
		COLOR.add(black);
		TYPE.add(type1);
		TYPE.add(type2);
		TYPE.add(type3);
		TYPE.add(type4);
		TYPE.add(type5);

		//Add degree, speed, color, type panels to setting panel
		setting_p.add(degree_p);
		setting_p.add(speed_p);
		setting_p.add(color_p);
		setting_p.add(type_p);
		render_p.add(render);

		//Set the boarder layouts
		this.add(canvas_p, BorderLayout.CENTER);
		this.add(render_p, BorderLayout.SOUTH);
		this.add(setting_p, BorderLayout.WEST);

		//Set the background color for panels and canvas
		render_p.setBackground(Color.PINK);
		canvas_p.setBackground(Color.CYAN);
		setting_p.setBackground(Color.RED);
		color_p.setBackground(Color.YELLOW);
		type_p.setBackground(Color.GREEN);
		canvas.setBackground(Color.BLACK);
		
		//Add colors and types to ItemListener
		white.addItemListener(this);
		pink.addItemListener(this);
		blue.addItemListener(this);
		green.addItemListener(this);
		black.addItemListener(this);
		type1.addItemListener(this);
		type2.addItemListener(this);
		type3.addItemListener(this);
		type4.addItemListener(this);
		type5.addItemListener(this);

	//	time = new Timer(1000, new Firework());
	}

	//If hit the "render" button, the canvas will driaw
	public void actionPerformed(ActionEvent e) {
		if(render.getActionCommand()=="render"){
			 canvas.drawTrajectoryLine ();
		}
	}

	public void ActionListner(ActionEvent e){
	}
	
	//get value for the sliders
	public void stateChanged(ChangeEvent e) {
		if(degree_slider==e.getSource()){
			angle.setText("Angle: "+Integer.toString(degree_slider.getValue()));
		}
		else if (speed_slider==e.getSource()){
			Speed.setText("Speed: "+Integer.toString(speed_slider.getValue()));
		}
	}
	
	//color buttons and type buttons
	public void itemStateChanged(ItemEvent e) {
		if(white == e.getSource() && white.isSelected()){
			pink.setSelected(false);
			blue.setSelected(false);
			green.setSelected(false);
			black.setSelected(false);
			choice = 0;
			System.out.println("Action class"+choice);

		}
		else if(pink == e.getSource() && pink.isSelected()){
			white.setSelected(false);
			blue.setSelected(false);
			green.setSelected(false);
			black.setSelected(false);
			choice= 1;
			System.out.println("Action class"+choice);
		}
		else if(blue == e.getSource() && blue.isSelected()){
			pink.setSelected(false);
			white.setSelected(false);
			green.setSelected(false);
			black.setSelected(false);
			choice= 2;
		}
		else if(green == e.getSource() && green.isSelected()){
			pink.setSelected(false);
			blue.setSelected(false);
			white.setSelected(false);
			black.setSelected(false);
			choice= 3;
		}
		else if(black == e.getSource() && black.isSelected()){
			pink.setSelected(false);
			blue.setSelected(false);
			green.setSelected(false);
			white.setSelected(false);
			choice= 4;
		}
		
		if(type1 == e.getSource() && type1.isSelected()){
			type2.setSelected(false);
			type3.setSelected(false);
			type4.setSelected(false);
			type5.setSelected(false);
			explosionchoice = 0;
			

		}
		if(type2 == e.getSource() && type2.isSelected()){
			type1.setSelected(false);
			type3.setSelected(false);
			type4.setSelected(false);
			type5.setSelected(false);
			explosionchoice= 1;
	
		}
		if(type3 == e.getSource() && type3.isSelected()){
			type2.setSelected(false);
			type1.setSelected(false);
			type4.setSelected(false);
			type5.setSelected(false);
			explosionchoice= 2;
		}
		if(type4 == e.getSource() && type4.isSelected()){
			type2.setSelected(false);
			type3.setSelected(false);
			type1.setSelected(false);
			type5.setSelected(false);
			explosionchoice= 3;
		}
		if(type5 == e.getSource() && type5.isSelected()){
			type2.setSelected(false);
			type3.setSelected(false);
			type4.setSelected(false);
			type1.setSelected(false);
			explosionchoice= 4;
		}
		
	}

	//Ignore
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
