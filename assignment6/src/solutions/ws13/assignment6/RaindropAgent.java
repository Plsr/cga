/*package solutions.ws13.assignment6;

import org.amcgala.agent.AgentMessages;
import org.amcgala.agent.AmcgalaAgent;
import org.amcgala.agent.Directions;
import org.amcgala.agent.Simulation;
import org.amcgala.agent.World;
import org.amcgala.agent.World.Index;
import org.amcgala.agent.World.JCell;
import org.amcgala.agent.World.JCellWithIndex;

import java.util.Map.Entry;
import java.util.PriorityQueue;


public class RaindropAgent extends AmcgalaAgent {
	private int phase = 0;
	private float travelValue = 0.f;
	private float maxDiff = 0.f;
	private int maxCells = 20;
	private int cellsVisited = 0;
	private Index moveCell = new Index(0, 0);



    @Override
    protected AgentMessages.AgentMessage onUpdate(Simulation.SimulationUpdate update) {
    	//Increase phase every time function is entered
    			phase++; 
    			
    			
    			switch (phase) { 
    				case 1:
    					
    					float cng = update.currentCell().value() + travelValue;
    					
    					return this.changeValue(cng);
    					
    					
    				case 2:
    				

					for (JCellWithIndex n : update.neighbours().values()) {
						
						if(update.currentCell().value() - n.cell().value()  > maxDiff){
							maxDiff = update.currentCell().value() - n.cell().value();
							moveCell = n.index();
						}
						
					}
    				travelValue = 0.4f * maxDiff;
    				maxDiff = 0;
    				return changeValue(update.currentCell().value() - travelValue);
    					
    					
    				case 3: 
    					if(maxCells == cellsVisited){
    						return die();
    					}
    					
    					cellsVisited++;
    					phase = 0;
    					return moveTo(moveCell);
    					
    				default:
    					return die();
    					
    					
    					
       
    			}
    			
    }
}*/








package solutions.ws13.assignment6;

import org.amcgala.agent.AgentMessages;
import org.amcgala.agent.AmcgalaAgent;
import org.amcgala.agent.Directions;
import org.amcgala.agent.Simulation;
import org.amcgala.agent.World;
import org.amcgala.agent.World.Index;
import org.amcgala.agent.World.JCell;
import org.amcgala.agent.World.JCellWithIndex;

import java.util.PriorityQueue;


public class RaindropAgent extends AmcgalaAgent {

	private float abtrag = 0;
	private Integer phase = 1;
	private Integer cells = 0;
	private Integer TTL = 25; 
	private Boolean debug = false;
	private JCellWithIndex max;
	
    @Override
    protected AgentMessages.AgentMessage onUpdate(Simulation.SimulationUpdate update) {
       
    	switch(phase) {
    		case 1:
    			phase = 2;
    			return changeValue(update.currentCell().value() + this.abtrag);
    			
    		case 2:
    			float difference = 0;
    			max = update.neighbours().entrySet().iterator().next().getValue(); // #1 element

			    // Absuchen aller Nachbarzellen. 
    			for (JCellWithIndex neighbour : update.neighbours().values()) {
    			    if(debug) System.out.println(neighbour.index().x() + " / " + neighbour.index().y() + "\n----------------------");
    			    
    			    // Wo ist die Differenz am größten?
    			    if(update.currentCell().value() - neighbour.cell().value() > difference) {
    			    	max = neighbour;
    			    	difference = update.currentCell().value() - neighbour.cell().value();
    			    }
    			}
    			
    			if(debug) System.out.println("Differenz: " + difference + "\n---------------->");
    			
    			// Berechen des Abtrags als von 40% dieser Differenz (maximal) 
    			this.abtrag = 0.4f * difference;
    			
    			// Erniedrigen des Werts der eigenen Zelle um den Abtrag 
    			phase = 3;
    			return changeValue(update.currentCell().value() - this.abtrag);
    			
    		case 3:	
	    		if(cells >= TTL) {
	    			if(debug) System.out.println("Agent verdunstet.");
	    			return die();
	    		}
	    		else {
	    			phase = 1; // Zurücksetzen des Phasenzählers
	    			cells++;
	    			return moveTo(max.index()); // Bewegen auf die in Phase 2 ausgewählte Nachbarzelle mit dem steilsten Abstieg.
	    		}
    	
    		// Dürfte nie passieren
    		default:
    			return die();
    	}    	
   }
}
