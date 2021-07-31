import java.awt.Color;

import javax.swing.*;
public class MainClass {

	public static void main(String[] args)
	{
	 JFrame f = new JFrame();
	 f.setTitle("Snake game ");  //setTitle--> Will set The title of the frame
	 f.setBounds(10, 100, 905, 700);//  Syntax: setBound(left margin,top margin,width,height);
	 f.setResizable(false);        // User Should Not Change the size of the frame(it cannot maximize)
	 f.setVisible(true);          //That frame should be visible
	 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when the user click on the close icon that frame must be close
	 f.setBackground(Color.YELLOW);
	    
	 GamePlay gm=new GamePlay();
	 f.add(gm);
	}

}
