package solutions.ws13.assignment8;

import org.amcgala.agent.World.InformationObject;

import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;

public class spawnCoordinatesObject implements InformationObject{
	
	
	/**
	 * 
	 */
	
	int xCoord, yCoord;

	public spawnCoordinatesObject(int x, int y) {
		// TODO Auto-generated constructor stub
		xCoord = x;
		yCoord = y;
	}
	
	public int getX() {
		return xCoord;
	}
	
	public int getY() {
		return yCoord;
	}

	

}