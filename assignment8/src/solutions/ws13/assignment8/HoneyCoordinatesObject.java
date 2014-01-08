package solutions.ws13.assignment8;

import org.amcgala.agent.World.InformationObject;

import scala.Product;
import scala.Serializable;
import scala.collection.Iterator;

public class HoneyCoordinatesObject implements InformationObject{
	
	int xCoord, yCoord;

	public HoneyCoordinatesObject(int x, int y) {
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
