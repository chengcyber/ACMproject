/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */
import acm.graphics.*;
public class HangmanCanvas extends GCanvas {
	/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		add(new GLine(Orgx,Orgy,Orgx,Orgy+SCAFFOLD_HEIGHT));
		add(new GLine(Orgx,Orgy,Orgx+BEAM_LENGTH,Orgy));
		add(new GLine(Orgx+BEAM_LENGTH,Orgy,Orgx+BEAM_LENGTH,Orgy+ROPE_LENGTH));
		lab_result = new GLabel("");
		lab_incorrect= new GLabel("incorrect:");
		lab_result.setFont("Courier-16");
		lab_incorrect.setFont("Courier-16");
		add(lab_result,(getWidth()- lab_result.getWidth())/2, getHeight()- lab_result.getAscent());
		add(lab_incorrect, (getWidth()- lab_incorrect.getWidth())/2, getHeight()- lab_result.getAscent() - lab_incorrect.getAscent());
	}
	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game. The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens.
	 */
	public void displayWord(String word) {
		/* You fill this in */
		lab_result.setLabel(word);
	}
	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user. Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		lab_incorrect.setLabel(lab_incorrect.getLabel() + letter);
	}
	
	public void drawNext(int i){
		switch (i) {
			case 6: drawHead();break;
			case 5: drawBody();break;
			case 4: drawLeftArm();break;
			case 3: drawRightArm();break;
			case 2: drawLeftLeg();break;
			case 1: drawRightLeg();break;
			default: 
		}
	}
	
	private void drawHead() {
		add(new GOval(Orgx+BEAM_LENGTH-HEAD_RADIUS,Orgy+ROPE_LENGTH,HEAD_RADIUS*2,HEAD_RADIUS*2));
	}
	
	private void drawBody() {
		add(new GLine(Orgx+BEAM_LENGTH, Orgy+ROPE_LENGTH+HEAD_RADIUS*2,
				Orgx+BEAM_LENGTH, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH));
	}
	
	private void drawLeftArm() {
		add(new GLine(Orgx+BEAM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,
				Orgx+BEAM_LENGTH-UPPER_ARM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD));
		add(new GLine(Orgx+BEAM_LENGTH-UPPER_ARM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,
				Orgx+BEAM_LENGTH-UPPER_ARM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH));
	}
	
	private void drawRightArm() {
		add(new GLine(Orgx+BEAM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,
				Orgx+BEAM_LENGTH+UPPER_ARM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD));
		add(new GLine(Orgx+BEAM_LENGTH+UPPER_ARM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD,
				Orgx+BEAM_LENGTH+UPPER_ARM_LENGTH ,Orgy+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH));
	}
	
	private void drawLeftLeg() {
		add(new GLine(Orgx+BEAM_LENGTH, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH,
				Orgx+BEAM_LENGTH-HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH));
		add(new GLine(Orgx+BEAM_LENGTH-HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH,
				Orgx+BEAM_LENGTH-HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH));
		add(new GLine(Orgx+BEAM_LENGTH-HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH,
				Orgx+BEAM_LENGTH-HIP_WIDTH/2-FOOT_LENGTH, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH));
	}
	private void drawRightLeg() {
		add(new GLine(Orgx+BEAM_LENGTH, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH,
				Orgx+BEAM_LENGTH+HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH));
		add(new GLine(Orgx+BEAM_LENGTH+HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH,
				Orgx+BEAM_LENGTH+HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH));
		add(new GLine(Orgx+BEAM_LENGTH+HIP_WIDTH/2, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH,
				Orgx+BEAM_LENGTH+HIP_WIDTH/2+FOOT_LENGTH, Orgy+ROPE_LENGTH+HEAD_RADIUS*2+BODY_LENGTH+LEG_LENGTH));
	}
	

	
	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	
	/* private instance variable */
	private int Orgx = 60;
	private int Orgy = 30;
	private GLabel lab_result ;
	private GLabel lab_incorrect;
}