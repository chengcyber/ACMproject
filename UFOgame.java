/**
 * File UFOgame.java
 * @author liu.cheng
 * UFO fly line by line , press a key to shoot a bullet,when shoot the UFO ,game over.
 *
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;

public class UFOgame extends GraphicsProgram{
	
	// Clasee variables here
	
	/* refresh Delay */
	private static final int DELAY = 10;
	
	/* modify the UFO size */
	private static final int UFOSIZE_X = 50;
	private static final int UFOSIZE_Y = 20;
	
	/* Bullet speed */
	private static final int BULLET_SPEED = 5;
	
	/* Bullet Size */
	private static final int BULLET_WIDTH = 5;
	private static final int BULLET_HEIGHT = 5;
	
	
	public void run() {
		setup();
		while (!gameOver()) {
			moveUfo();
			moveBullet();
			checkForCollision();
			pause(DELAY);
		}
		
	}
	
	
	//setup initial ufo GRectObject
	private void setup() {
		ufo = new GRect(0,0,UFOSIZE_X,UFOSIZE_Y);
		ufo.setFilled(true);
		add(ufo);
		isToRight = true;
		addMouseListeners();
	}
	
	/* move ufo line by line  */
	private void moveUfo(){
		xVel = rgen.nextInt(10);
		if ( isToRight ) {
			ufo.move(xVel,0);
			if ( ufo.getX() > getWidth()) {
				isToRight = false;
				ufo.move(0, yVel);
			}
		} else {
			ufo.move(-xVel, 0);
			if ( ufo.getX() < 0 ) {
				isToRight = true;
				ufo.move(0, yVel);
			}
		}
	}
	
	/* two situation to stop , shoot ufo or ufo out of screen */
	private boolean gameOver(){
		return (ufo == null) || (ufo.getY() > getHeight() - UFOSIZE_Y) ;
	}
	
	/* click to shoot a bullet, only one bullet alive  */
	public void mouseClicked(MouseEvent e) {
		if ( bullet == null ) {
			bullet = new GOval(0,0,BULLET_WIDTH,BULLET_HEIGHT);
			add(bullet,getWidth()/2,0);
		}
	}
	
	/* move bullet with bullet_speed */
	private void moveBullet() {
		if ( bullet != null ) {
			bullet.move(0, -BULLET_SPEED);
		}
	}
	
	/* check if bullet shoot ufo,check bullet is out of screen */
	private void checkForCollision() {
		collideWithUfo();
		moveOffScreen();
	}
	
	/* check if shot down ufo ,if so remove both variable,and set them to null   */
	private void collideWithUfo() {
		if ( bullet != null ) {
			GObject collObj = getElementAt(bullet.getX(), bullet.getY());
			if (collObj == ufo) {
				remove(ufo);
				remove(bullet);
				ufo = null;
				bullet = null;
			}
		}
	}
	
	private void moveOffScreen() {
		if (bullet != null) {
			if (bullet.getY() < BULLET_HEIGHT) {
				remove(bullet);
				bullet = null;
			}
		}
	}
	
	
	/* private instance variables */
	private GRect ufo;
	private GOval bullet;
	private int xVel = UFOSIZE_X;
	private int yVel = UFOSIZE_Y;
	private boolean isToRight;
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
