package aufgabe_2;

	import java.util.Scanner;

import org.amcgala.TurtleMode;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.jboss.netty.buffer.TruncatedChannelBuffer;
	

	public class Main extends TurtleMode{
		
		static float houseWidth;
		static float doorStartPosition;

	@Override public void turtleCommands() {
		
		float houseHeight = 100;
		float doorHeight = 40;
		
		/*Hintergrund zeichnen */
		up();
		turnRight(90);
		move(250);
		turnLeft(90);
		down();
		move(50);
		turnLeft(50);
		move(200);
		turnRight(100);
		move(200);
		turnLeft(50);
		move(500);
		
		
		/*Haus zeichnen (BETA)*/
		
		//Zur Startposition f�r Haus
		up();
		turnRight(90);
		move(250);
		turnRight(90);
		move(50);
		down();
		
		//Haus-Geruest
		move(houseWidth); //breite
		turnRight(90);
		move(houseHeight); //hoehe
		turnRight(90);
		move(houseWidth); //breite
		turnRight(90);
		move(houseHeight); //hoehe
		
		//Dach
		float roofSideLength = roofSideLength(houseWidth, houseHeight);
		float bottomAngle = bottomAngle(houseHeight, roofSideLength);
		float topAngle = topAngle(bottomAngle);
		System.out.println("DEBUG: ");
		System.out.println("Laenge Dach: " + roofSideLength);
		System.out.println("Winkel unten: " + bottomAngle);
		System.out.println("Winkel oben: " + topAngle);
		
		
		up();
		turnRight(180);
		move(houseHeight);
		turnLeft(bottomAngle);
		down();
		move(roofSideLength);
		turnLeft(topAngle);
		move(roofSideLength);
		up();
		
		//Tuer (feste Breite) TODO: Stimmt nicht mehr
		up();
		turnRight(90);
		move(33);
		turnRight(90);
		down();
		move(doorHeight);
		turnLeft(90);
		move(33);
		turnLeft(90);
		move(doorHeight);
		//Fenster(feste Anzahl)
		up();
		turnLeft(90);
		move(56);
		turnLeft(90);
		move(55);
		turnLeft(90);
		move(10);
		down();
		move(30);
		
		
		
		

		

		
		

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		houseWidth = 300; // TODO: maximal 400!
		
		//System.out.println("Bitte Zahl eingeben: ");
		//int test = in.nextInt();
		new Main();

	}
	
	/**
	 * Calculates the length of the sides of the roof.
	 * Uses Pythagoras.
	 * @param houseWidth width of the house
	 * @param houseHeight height of the house
	 * @return length of one roof side
	 */
	public float roofSideLength (float houseWidth, float houseHeight) {
		
		
		float width = houseWidth/2;
		float roofSideLength = (float) Math.sqrt(houseHeight*houseHeight + width*width);
		
		
		return roofSideLength;
	}
	
	
	/**
	 * Calculates the Angles at the bottom of the roof.
	 * Uses the formula sin(a) = gk/hyp <=> asin(gk/hyp) = a
	 * @param houseHeight height of the house
	 * @param roofSideLength length of one side of the roof
	 * @return the bottom angle
	 */
	public float bottomAngle (float houseHeight, float roofSideLength) {
		
		
		float gk = houseHeight;
		System.out.println("DEBUG: GK: " + gk);
		float hyp = roofSideLength;
		System.out.println("DEBUG: HYP: " + hyp);
		float sinBot = gk/hyp;
		float bottomAngle =(float) ((float) 90-  (Math.asin(sinBot)) * (180/Math.PI));
		System.out.println("DEBUG: BOTTOMANGLE: " + bottomAngle);
		
		
		
		return bottomAngle;
	}
	
	/**
	 * Calculates the angle at the top of the roof.
	 * @param bottomAngle bottom angle
	 * @return top angle
	 */
	public float topAngle(float bottomAngle){
		
		float topAngle = 180 - 2*bottomAngle;
		System.out.println("DEBUG: TOPANGLE: " + topAngle);
		
		return topAngle;
		
	}
	}

