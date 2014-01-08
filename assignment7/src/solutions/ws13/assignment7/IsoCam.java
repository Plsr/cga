
package solutions.ws13.assignment7;

 
import org.amcgala.camera.AbstractCamera;

import org.amcgala.math.Matrix;

import org.amcgala.math.Vector3d;

import org.amcgala.renderer.Pixel;
 

/**
 * Kamera, die die isometrische Projektion implementiert.
 */

public class IsoCam extends AbstractCamera {

     /**
     *
     * @param vup Das Oben der Kamera
     * @param direction Der Punkt, zu dem die Kamera blickt
     */

    public IsoCam(Vector3d vup, Vector3d position, Vector3d direction) {
        this.up = vup;
        this.location = position;
        this.direction = direction;
        update();
    }

 
    @Override
    protected Matrix getProjectionMatrix() {
        // TODO Rueckgabe der Projektionsmatrix
        return projectionMatrix;
    }

     @Override
    public Pixel project(Vector3d vector3d) {
        // TODO Anwenden der Projektionmatrix auf den uebergebenen Vektor.
        Matrix point = projectionMatrix.times(vector3d.toMatrix());
        return new Pixel(point.get(0, 0) / point.get(3, 0), point.get(1, 0) / point.get(3, 0));
    }

     @Override
    public void update() {
        // TODO Aktualisieren der Projektionsmatrix, nachdem Parameter der Kamera geaendert wurden.
    	 this.n = direction.sub(location).times(-1);
        this.u = up.cross(n).normalize();
        this.v = n.cross(u).normalize();

        double[][] projectionValues = {
                {0.5*Math.sqrt(3), 0, -0.5*Math.sqrt(3), 0},
                {-0.5, 1,-0.5, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 1}
        };

         Matrix projection = new Matrix(projectionValues);
         Vector3d dd = Vector3d.createVector3d(direction.dot(u), direction.dot(v), direction.dot(n));

        double[][] viewValues = {
                {u.getX(), u.getY(), u.getZ(), dd.x},
                {v.getX(), v.getY(), v.getZ(), dd.x},
                {n.getX(), n.getY(), n.getZ(), dd.z},
                {0, 0, 0, 1}
        };
        
        //Debug
        if(Main.debug){
	        for(int i = 0; i < 4 ; i++){
	        	System.out.println("|||");
	        	for (int j = 0; j < 4; j++) {
					System.out.println(viewValues[i][j]);
				}
	        }
        }

        Matrix view = new Matrix(viewValues);
        projectionMatrix = projection.times(view);
    }
 

}
