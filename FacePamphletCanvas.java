/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;

import java.awt.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		// You fill this in
		super();
		msgLabel = new GLabel(EMPTY_LABEL_TEXT);
		msgLabel.setFont(MESSAGE_FONT);
		nameLabel = new GLabel(EMPTY_LABEL_TEXT);
		nameLabel.setFont(PROFILE_NAME_FONT);
		noimgLabel = new GLabel("No image");
		noimgLabel.setFont(PROFILE_IMAGE_FONT);
		noimgRect = new GRect(0,0,IMAGE_WIDTH,IMAGE_HEIGHT);
		statLabel = new GLabel("No current status");
		statLabel.setFont(PROFILE_STATUS_FONT);
		frdLabel = new GLabel("Freinds:");
		frdLabel.setFont(PROFILE_FRIEND_LABEL_FONT);
//		frdList = new ArrayList<String>();
		// TEST
//		canvas.add(new GLabel("" + (getHeight() - STATUS_MARGIN)),100,100);
//		add(new GLabel("" + (this.getWidth() ),100,120));
//		add(new GLabel("" + this.getHeight()), 100 ,140);
	}

	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		// You fill this in
		this.remove(msgLabel);
		msgLabel.setLabel(msg); 
		add(msgLabel, this.getWidth() / 2 - msgLabel.getWidth() / 2,
				this.getHeight() - BOTTOM_MESSAGE_MARGIN);
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		// You fill this in
		removeAll();
		/* name */
		nameLabel.setLabel(profile.getName());
		add(nameLabel, LEFT_MARGIN, TOP_MARGIN + nameLabel.getAscent());
		/* image */
		if(profile.getImage()==null) {
			add(noimgLabel, LEFT_MARGIN + IMAGE_WIDTH / 2 - noimgLabel.getWidth() / 2,
					nameLabel.getY() + IMAGE_MARGIN + IMAGE_HEIGHT / 2 );
			add(noimgRect, LEFT_MARGIN, nameLabel.getY() + IMAGE_MARGIN);
		} else {
			img = profile.getImage();
			add(img, LEFT_MARGIN, nameLabel.getY() + IMAGE_MARGIN);
		}
		/* status */
		statLabel.setLabel(profile.getStatus());
		add(statLabel, LEFT_MARGIN, nameLabel.getY() + IMAGE_MARGIN * 2 + IMAGE_HEIGHT + statLabel.getAscent());
		/* Friends */
		add(frdLabel, this.getWidth() / 2, nameLabel.getY() + frdLabel.getAscent());
		Iterator it = profile.getFriends();
		int cnt = 1;
		while(it.hasNext()){
			GLabel label = new GLabel(it.next().toString());
			label.setFont(PROFILE_FRIEND_FONT);
			add(label, this.getWidth() / 2, 
					nameLabel.getY() + frdLabel.getAscent() + label.getAscent() * cnt++ );
		}
	}

	private GLabel msgLabel;
	private GLabel nameLabel;
	private GLabel statLabel;
	private GLabel noimgLabel;
	private GRect noimgRect;
	private GImage img;
//	private ArrayList<String> frdList;
	private GLabel frdLabel;
}
