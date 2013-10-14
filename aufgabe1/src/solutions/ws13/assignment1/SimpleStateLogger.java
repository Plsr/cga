package solutions.ws13.assignment1;

import akka.actor.Actor;
import akka.japi.Creator;
import org.amcgala.RGBColor;
import org.amcgala.Scene;
import org.amcgala.agent.Agent;
import org.amcgala.agent.StateLoggerAgent;
import org.amcgala.agent.World;
import org.amcgala.math.Vertex3f;
import org.amcgala.shape.Rectangle;

import java.util.Map;

/**
 *
 */
public final class SimpleStateLogger extends StateLoggerAgent {
    Scene scene = new Scene("SimpleStateLogger");
    Rectangle[][] rectangles;


    @Override
    public void onInit() {
        rectangles = new Rectangle[worldWidth][worldHeight];

        for (int x = 0; x < rectangles.length; x++) {
            for (int y = 0; y < rectangles[0].length; y++) {
                rectangles[x][y] = new Rectangle(new Vertex3f(x * scaleX, y * scaleY, -1), (float) scaleX, (float) scaleY);
                rectangles[x][y].setColor(RGBColor.GREEN);
                scene.addShape(rectangles[x][y]);
            }
        }
        

        framework.addScene(scene);
    }

    @Override
    public void onUpdate(Map<World.Index, World.Cell> cells, Map<Agent.AgentID, Agent.AgentState> agents) {
    	//Oben Links: [0][5], weiss der Teufel warum.
    	
    	float grey;
    	
    	
    	for (Map.Entry<World.Index, World.Cell> x : cells.entrySet()) {
    		grey = 1 - x.getValue().value();
    		this.rectangles[x.getKey().x()][x.getKey().y()].setColor(new RGBColor(grey, grey, grey));
    		
    		for (Map.Entry<Agent.AgentID, Agent.AgentState> y : agents.entrySet()) {
    			this.rectangles[y.getValue().position().x()][y.getValue().position().y()].setColor(RGBColor.RED);
			}
    		
		}
        /*
         * TODO Visualisierung
         *
         * Die Methode bekommt alle wichtigen Informationen der Simulation ??ber die Parameter cells und agents ??bergeben.
         *
         * cells:
         * ??ber diese Map k??nnen Informationen ??ber die Zellen der Welt abgefragt werden. World.Index ist die 2d Koordinate
         * der Zelle in der Welt, World.Cell beinhaltet den Wert der Zelle. Dieser Wert liegt im Interval [0,0;1,0].
         *
         * agents:
         * ??ber diese Map kann der aktuelle Zustand aller in der Simulation befindlichen Agenten abgefragt werden.
         * Die f??r die L??sung der Aufgabe wichtigste Information ist die der Position des Agenten.
         *
         *
         * 1. Einf??rben des entsprechenden Rechtecks r aus dem Array rectangles. Eine Zelle mit dem Wert 0 sollte wei?? und
         * eine Zelle mit dem Wert 1 sollte schwarz dargestellt werden. Werte dazwischen bekommen einen entsprechenden Grauwert
         * zugewiesen.
         *
         * 2. Markieren der Rechtecke, auf denen sich ein Agent befindet in einer beliebigen anderen Farbe (z.B. Rot).
         */
    }

    static class StateLoggerCreator implements Creator<Actor> {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
        public Actor create() throws Exception {
            return new SimpleStateLogger();
        }
    }
}
