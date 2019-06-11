package starter;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; 
	
<<<<<<< HEAD
	private GImage title, background;
	private GButton play, settings;
=======
	private GParagraph title;
	private GImage settings, play, exit;
>>>>>>> branch 'master' of https://github.com/Jvanbladel/StarvingSteve.git
	
	private Player p;
	private GImage playerImage, bg;
	private Timer playerAnimationTimer, playAnimationTimer, fallAnimationTimer;
	
	private ArrayList<GImage> floor;

	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		
<<<<<<< HEAD
		
		play = new GButton("Play", 550, 25, 200, 100, Color.GREEN);
		settings = new GButton("Settings", 550, 150, 200, 100, Color.YELLOW); 
		title = new GImage("../media/images/STARVING STEVE 3.png");
		title.setLocation(0, 9);
		title.setSize(550, 200);
		
		//background.setLocation(0, 9);
		//background.setSize(550, 200);
		
		
		
		//title.setFont("Arial-Bold-72");
=======
		bg = new GImage("../media/images/BG.png");
		bg.setSize(800, 600);
		
		play = new GImage("../media/Buttons/play1.png");
		play.setLocation(550, 75);
		play.setSize(170, 100);
		
		settings = new GImage("../media/Buttons/settings1.png");
		settings.setLocation(550, 250);
		settings.setSize(170, 100);
		
		exit = new GImage("../media/Buttons/exit1.png");
		exit.setLocation(550, 425);
		exit.setSize(170, 100);
	
		title = new GParagraph("Starving\nSteve",50, 100);
		title.setFont("Arial-Bold-72");
>>>>>>> branch 'master' of https://github.com/Jvanbladel/StarvingSteve.git
		
		p = new Player();
		p.changePlayerState(PlayerStates.IDLE);
		playerImage = new GImage(p.getImage());
		playerImage.setSize(400, 400);
		playerImage.setLocation(125, 200);
		
<<<<<<< HEAD
		playerAnimationTimer = new Timer(100, null); 
=======
		floor = new ArrayList<GImage>();
		for(int i = 0; i < 16; i++)
		{
			GImage block = new GImage("../media/images/middle.png");
			block.setSize(50, 50);
			block.setLocation(0 + i*50, 550);
			floor.add(block);
		}
		
		
		
		playerAnimationTimer = new Timer(50, null);
>>>>>>> branch 'master' of https://github.com/Jvanbladel/StarvingSteve.git
		
		playerAnimationTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				GImage newPlayerImage = new GImage(p.getImage());
				newPlayerImage.setLocation(125, 200);
				newPlayerImage.setSize(400, 400);
				
				program.remove(playerImage);
				program.add(newPlayerImage);
				playerImage = newPlayerImage;
			}
		});
		
<<<<<<< HEAD
=======
		playAnimationTimer = new Timer(50, null);
		playAnimationTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				if(playCount < 25)
				{
					GImage newPlayerImage = new GImage(p.getImage());
					newPlayerImage.setLocation(125 + (25*playCount), 200 + (9*playCount));
					newPlayerImage.setSize(400 - 10*playCount,400 - 10*playCount);
					
					program.remove(playerImage);
					program.add(newPlayerImage);
					playerImage = newPlayerImage;
				}
				else
				{
					playAnimationTimer.stop();
					program.switchToTutorial();
				}
				playCount++;
			}
		});
		
		fallAnimationTimer = new Timer(50, null);
		fallAnimationTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				if(fallCount>13)
				{
					p.changePlayerState(PlayerStates.IDLE);
					fallAnimationTimer.stop();
				}
				fallCount++;
			}
		});
>>>>>>> branch 'master' of https://github.com/Jvanbladel/StarvingSteve.git
	}

	@Override
	public void showContents() {
		p.changePlayerState(PlayerStates.IDLE);
		play.setImage("Buttons/play1.png");
		settings.setImage("Buttons/settings1.png");
		exit.setImage("Buttons/exit1.png");
		program.add(bg);
		program.add(play);
		program.add(settings);
		program.add(exit);
		program.add(title);
		program.add(playerImage);
<<<<<<< HEAD
		//program.add(background);
=======
		for(int i = 0; i < floor.size(); i++)
		{
			program.add(floor.get(i));
		}
>>>>>>> branch 'master' of https://github.com/Jvanbladel/StarvingSteve.git
		playerAnimationTimer.start();
	}

	@Override
	public void hideContents() {
		program.remove(bg);
		program.remove(play);
		program.remove(settings);
		program.remove(exit);
		program.remove(title);
		program.remove(playerImage);
<<<<<<< HEAD
		//program.remove(background);
=======
		for(int i = 0; i < floor.size(); i++)
		{
			program.remove(floor.get(i));
		}
>>>>>>> branch 'master' of https://github.com/Jvanbladel/StarvingSteve.git
		playerAnimationTimer.stop();
	}

	private int playCount,fallCount;
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == play && !playAnimationTimer.isRunning() && !fallAnimationTimer.isRunning())
		{
			p.changePlayerState(PlayerStates.RUNNING);
			playCount = 0;
			playerAnimationTimer.stop();
			playAnimationTimer.start();
		}
		else if(obj == settings && !playAnimationTimer.isRunning() && !fallAnimationTimer.isRunning())
			program.changeToSettings();
		else if(obj == exit && !playAnimationTimer.isRunning()&& !fallAnimationTimer.isRunning())
			System.exit(0);
		else if(obj == playerImage && playAnimationTimer.isRunning())
		{
			fallCount = 0;
			p.changePlayerState(PlayerStates.DEAD);
			fallAnimationTimer.start();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play) 
		{
			play.setImage("Buttons/play2.png");
		}
		else if (obj == settings) 
		{
			settings.setImage("Buttons/settings2.png");
		}
		else if (obj == exit) 
		{
			exit.setImage("Buttons/exit2.png");
		}
		else 
		{
			play.setImage("Buttons/play1.png");
			settings.setImage("Buttons/settings1.png");
			exit.setImage("Buttons/exit1.png");
		}
	}
}//test

