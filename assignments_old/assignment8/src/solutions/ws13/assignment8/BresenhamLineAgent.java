package solutions.ws13.assignment8;

import org.amcgala.agent.World;
import org.amcgala.agent.World.Index;

public class BresenhamLineAgent {
	
	 private int x1;
	 private int y1;
	 private int dx;
	 private int dy;
	 private int sx;
	 private int sy;
	 private int x;
	 private int y;
	 private int err;
	 World.Index point;

	public BresenhamLineAgent(int x0, int y0, int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;

        dx = Math.abs(x1 - x0);
        dy = Math.abs(y1 - y0);
              
        sx = (x0 < x1) ? 1 : -1;
        sy = (y0 < y1) ? 1 : -1;

        this.x = x0;
        this.y = y0;

        this.err = (2 * dy) - dx; 
    }
	
	public Index getNextPoint () {
		if (x == x1 && y == y1) {
            World.Index done = new World.Index(-1,-1);
            return done;
        } else {
        	bresenham();
            World.Index point = new World.Index(x, y);
            return point;
        }
	}
	
	public void bresenham() {
   
    	if(err >= 0){
    		y += sy;
    		err -= (dx * 2);
    	}
    	
    	if(err < 0){
    		x += sx;
    		err += (dy * 2);
    	}
    	

    }

}
