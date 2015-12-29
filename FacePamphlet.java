/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		// You fill this in
		canvas = new FacePamphletCanvas();
		add(canvas);
		
		/* NORTH */
		txtName = new JTextField(10);
		
		add(new JLabel("Name"), NORTH);
		add(txtName, NORTH);
		add(new JButton("Add"), NORTH);
		add(new JButton("Delete"), NORTH);
		add(new JButton("Lookup"), NORTH);
		
		/* WEST */
		txtStatus = new JTextField(10);
		txtPicture = new JTextField(10);
		txtFriend = new JTextField(10);
		
		add(txtStatus, WEST);
		add(new JButton("Change Status"), WEST);
		add(txtPicture, WEST);
		add(new JButton("Change Picture"), WEST);
		add(txtFriend, WEST);
		add(new JButton("Add Friend"), WEST);
		
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		// You fill this in as well as add any additional methods
	}
    
    /* ivars */
    private FacePamphletCanvas canvas;
    private JTextField txtStatus;
    private JTextField txtPicture;
    private JTextField txtFriend;
    private JTextField txtName;

}
