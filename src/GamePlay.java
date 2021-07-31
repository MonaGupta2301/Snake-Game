import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener,ActionListener
{

	 private int[] SnakeXLength=new int[1000];
	 private int[] SnakeYLength=new int[1000];

	 //Movement of Snake
	 private boolean right=false; 
	 private boolean left=false;
	 private boolean up=false;
	 private boolean down=false;
	 
	 //Snake image icon
	 private ImageIcon rightmouth;
	 private ImageIcon leftmouth;
	 private ImageIcon upmouth;
	 private ImageIcon downmouth;
	 private ImageIcon snakeimage;
	 
	 private int[] enemyXpos= {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,
			 600,625,650,675,700,725,750,775,800,825,850};
	 private int[] enemyYpos= {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,
			 600,625,650};
	 
	 private ImageIcon enemyimage;
	 
	 private Random random=new Random();
	 
	 private int Xpos = random.nextInt(34);
	 private int Ypos = random.nextInt(23);
	 
	 private Timer timer;
	 private int delay=100;
	 	 
	 private int lengthOfSnake=3;
	 private int moves=0;
	 
     private int score=0;
	 
	 public GamePlay()
     {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        timer = new Timer(delay,this);
        timer.start();
     }
     public void paint(Graphics g)
     {
    	 //initial Position 
    	 if(moves==0)
    	  {
    		 SnakeXLength[0]=100;
    		 SnakeXLength[1]=75;
    		 SnakeXLength[2]=50;
    		 
    		 SnakeYLength[0]=100;
    		 SnakeYLength[1]=100;
    		 SnakeYLength[2]=100;		 
    	  }
    	  
    	  
    	 //boder of title Image
    	 g.setColor(Color.BLACK);
    	 g.drawRect(24,10,851,55);
    	 g.setColor(Color.BLACK);
    	 g.fillRect(25, 11, 850,54);
    	 
    	 //SnakeGame Name
    	 g.setColor(Color.cyan);
         g.setFont(new Font("Times New Roman",Font.BOLD,25));
  	     g.drawString("__SNAKE GAME__", 290, 44 );
    	 

    	 //Score
    	 g.setColor(Color.ORANGE);
         g.setFont(new Font("Times New Roman",Font.BOLD,20));
  	     g.drawString("Score :"+score, 750, 30 );

    	 g.setColor(Color.ORANGE);
         g.setFont(new Font("Times New Roman",Font.BOLD,20));
  	     g.drawString("Length :"+lengthOfSnake, 750, 50 );
    	 
  	     //boder of Game Play
    	 g.setColor(Color.BLACK);
    	 g.drawRect(24,74,851,577);
    	 g.setColor(Color.BLACK);
    	 g.fillRect(25, 75, 850,576);

        //design the mouth of snake
    	 rightmouth= new ImageIcon("rightmouth.png");
    	 rightmouth.paintIcon(this, g, SnakeXLength[0], SnakeYLength[0]);
    	 
    	 for(int i=0;i<lengthOfSnake;i++)
    	 {
    		 if(i==0 && right)
    		 {
    			 rightmouth= new ImageIcon("rightmouth.png");
    	    	 rightmouth.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
    		 }
    		 if(i==0 && left)
    		 {
    			 leftmouth= new ImageIcon("leftmouth.png");
    	    	 leftmouth.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
    		 }
    		 if(i==0 && up)
    		 {
    			 upmouth= new ImageIcon("upmouth.png");
    	    	 upmouth.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
    		 }
    		 if(i==0 && down)
    		 {
    			 downmouth= new ImageIcon("downmouth.png");
    	    	 downmouth.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);
    		 }
    		 if(i!=0)
    		 {
    			 snakeimage= new ImageIcon("snakeimage.png");
    	    	 snakeimage.paintIcon(this, g, SnakeXLength[i], SnakeYLength[i]);    			 
    		 }
    	 }
    	 
    	 enemyimage=new ImageIcon("enemy.png");
    	 enemyimage.paintIcon(this, g, enemyXpos[Xpos], enemyYpos[Ypos]);
    	 
    	 //head is colliding to enemy or not
    	 if(enemyXpos[Xpos]==SnakeXLength[0] && enemyYpos[Ypos]==SnakeYLength[0])
    	 {
    		 lengthOfSnake++;
    		 score++;
    		 Xpos=random.nextInt(34);
    		 Ypos=random.nextInt(23);
    	 }
    	 
    	 //body Is Colliding Or not
    	 for(int i=1;i<lengthOfSnake;i++)
    	 { 
    		  if((SnakeXLength[i]==SnakeXLength[0]) &&( SnakeYLength[i]==SnakeYLength[0]) )
    		  {
    			  right=false;
    			  left=false;
    		      up=false;
    			  down=false;
    			  
    			  //Game Over
    			  g.setColor(Color.RED);
    		      g.setFont(new Font("arial",Font.BOLD,30));
    		  	  g.drawString("____GAME OVER___", 300, 300 );
    		  	  
                  //Score Displaying....
    			  g.setColor(Color.cyan);
    		      g.setFont(new Font("arial",Font.BOLD,20));
    		  	  g.drawString("+ + + Score is :"+score+" + + + ", 300, 340 );
    		  
    		   	 //press Enter to restart....
    			  g.setColor(Color.cyan);
    		      g.setFont(new Font("arial",Font.BOLD,20));
    		  	  g.drawString("Press Enter to Restart again... ", 300, 380 );
    		  
    		  }
    		 
    	 }
    	 g.dispose();
    }
	@Override
	public void actionPerformed(ActionEvent e)
	{
	   if(right)
	   {
		   for(int i =lengthOfSnake-1;i>=0;i--)
		   {
			   SnakeYLength[i+1]=SnakeYLength[i];
		   }
		   for(int i =lengthOfSnake;i>=0;i--)
		   {
              if(i==0)
              {
            	  SnakeXLength[i]=SnakeXLength[i]+25;
              }
              else
              {
            	  SnakeXLength[i]=SnakeXLength[i-1];
              }
              if(SnakeXLength[i]>850)
              {
            	  SnakeXLength[i]=25;  
              }
		   }
		   repaint();
	   }
	   if(left)
	   {
		   for(int i =lengthOfSnake-1;i>=0;i--)
		   {
			   SnakeYLength[i+1]=SnakeYLength[i];
		   }
		   for(int i =lengthOfSnake;i>=0;i--)
		   {
              if(i==0)
              {
            	  SnakeXLength[i]=SnakeXLength[i]-25;
              }
              else
              {
            	  SnakeXLength[i]=SnakeXLength[i-1];
              }
              if(SnakeXLength[i]<25)
              {
            	  SnakeXLength[i]=850;  
              }
		   }
		   repaint();
	   }
	   if(up)
	   {
		   for(int i =lengthOfSnake-1;i>=0;i--)
		   {
			   SnakeXLength[i+1]=SnakeXLength[i];
		   }
		   for(int i =lengthOfSnake;i>=0;i--)
		   {
              if(i==0)
              {
            	  SnakeYLength[i]=SnakeYLength[i]-25;
              }
              else
              {
            	  SnakeYLength[i]=SnakeYLength[i-1];
              }
              if(SnakeYLength[i]<75)
              {
            	  SnakeYLength[i]=625;  
              }
		   }
		   repaint();
	   }
	   if(down)
	   {
		   for(int i =lengthOfSnake-1;i>=0;i--)
		   {
			   SnakeXLength[i+1]=SnakeXLength[i];
		   }
		   for(int i =lengthOfSnake;i>=0;i--)
		   {
              if(i==0)
              {
            	  SnakeYLength[i]=SnakeYLength[i]+25;
              }
              else
              {
            	  SnakeYLength[i]=SnakeYLength[i-1];
              }
              if(SnakeYLength[i]>625)
              {
            	  SnakeYLength[i]=75;  
              }
		   }
		   repaint();
	   }
	  
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
	   

		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		 {
		     moves++;
	         if(left==false)
     	     {
		        right=true;
             }
   	         else
		     {
	     		   right=false;
		    	   left=true;
		     }
		     up=false;
			 down=false;
		  }
	   if(e.getKeyCode()==KeyEvent.VK_LEFT)
	   {
		   moves++;
		   if(!right)
		   {
		     left=true;
		   }
		   else
		   {
			   left=false;
			   right=true;
		   }
		   up=false;
		   down=false;
	   }
	   if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	   {
		   moves++;
		   if(!left)
		   {
		     right=true;
		   }
		   else
		   {
			   right=false;
			   left=true;
		   }
		    up=false;
		   down=false;
	   }
	   if(e.getKeyCode()==KeyEvent.VK_UP)
	   {
		   moves++;
		   if(!down)
		   {
		     up=true;
		   }
		   else
		   {
			   up=false;
			   down=true;
		   }
		    left=false;
		   right=false;
	   }
	   if(e.getKeyCode()==KeyEvent.VK_DOWN)
	   {
		   moves++;
		   if(!up)
		   {
		     down=true;
		   }
		   else
		   {
			   down=false;
			   up=true;
		   }
		    left=false;
		    right=false;
	   }
	   if(e.getKeyCode()==KeyEvent.VK_ENTER)
	   {
		   score=0;
		   moves=0;
		   lengthOfSnake=3;
           repaint();
	   }
	}
	
	
	@Override
	public void keyReleased(KeyEvent arg0) 	{}
	@Override
	public void keyTyped(KeyEvent arg0) {}
	
 }

