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
		
		
		/* NORTH */
		txtName = new JTextField(TEXT_FIELD_SIZE);
		
		add(new JLabel("Name"), NORTH);
		add(txtName, NORTH);
		add(new JButton("Add"), NORTH);
		add(new JButton("Delete"), NORTH);
		add(new JButton("Lookup"), NORTH);
		
		/* WEST */
		txtStatus = new JTextField(TEXT_FIELD_SIZE);
		txtPicture = new JTextField(TEXT_FIELD_SIZE);
		txtFriend = new JTextField(TEXT_FIELD_SIZE);
		
		add(txtStatus, WEST);
		add(new JButton("Change Status"), WEST);
		add(txtPicture, WEST);
		add(new JButton("Change Picture"), WEST);
		add(txtFriend, WEST);
		add(new JButton("Add Friend"), WEST);
		
		/* CENTER */
		/* Canvas */
		canvas = new FacePamphletCanvas();
		add(canvas);
		
		
		/* Database */
		db = new FacePamphletDatabase();
		
		/* Listeners */
		addActionListeners();
    }
    
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
		// You fill this in as well as add any additional methods
    	String cmd = e.getActionCommand();
    	if (cmd.equals("Add")) {
    		profile = new FacePamphletProfile(txtName.getText());
    		db.addProfile(profile);
    		canvas.displayProfile(profile);
    		canvas.showMessage("New Profile added");
    	} else if (cmd.equals("Delete")) {
    		if (db.containsProfile(txtName.getText())){
    			db.deleteProfile(txtName.getText());
    			canvas.showMessage(txtName.getText() + " has been deleted");
    		} else {
    			canvas.showMessage("no this file, can not delete");
    		}
    	} else if (cmd.equals("Lookup")) {
    		profile = db.getProfile(txtName.getText());
    		if (profile == null) {
    			canvas.showMessage("no this file, can not lookup");
    		} else {
    			canvas.displayProfile(profile);
    			canvas.showMessage("Here you are");
    		}
    	} else if (cmd.equals("Change Status")) {
    		profile.setStatus(txtStatus.getText());
    		canvas.displayProfile(profile);
    		canvas.showMessage("Status changed");
    	} else if (cmd.equals("Change Picture")) {
			try {
				profile.setImage(new GImage("images\\" + txtPicture.getText()));
				canvas.displayProfile(profile);
				canvas.showMessage("Image changed");
			} catch (Exception ex) {
				canvas.showMessage("No such image file");
			}    		
    	} else if (cmd.equals("Add Friend")) {
    		if(db.containsProfile(txtFriend.getText())) {
    			if(profile.addFriend(txtFriend.getText())) {
    				canvas.displayProfile(profile);
    				canvas.showMessage(txtFriend.getText() + " added as a friend");
    			} else {
    				canvas.showMessage(txtFriend.getText() + " already is a friend");
    			}
    		} else {
    			canvas.showMessage("no file for " + txtFriend.getText());
    		}
    	}
	}
    
    /* ivars */
    private FacePamphletCanvas canvas;
    private JTextField txtStatus;
    private JTextField txtPicture;
    private JTextField txtFriend;
    private JTextField txtName;

    private GLabel msgLabel;
    private FacePamphletDatabase db;
    private FacePamphletProfile profile;
}
