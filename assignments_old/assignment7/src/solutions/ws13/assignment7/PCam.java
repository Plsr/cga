package solutions.ws13.assignment7;

import org.amcgala.camera.AbstractCamera;
import org.amcgala.math.Matrix;
import org.amcgala.math.Quaternion;
import org.amcgala.math.Vector3d;
import org.amcgala.renderer.Pixel;

/**
 * Klasse, die die perspektivische Projektion von Vektoren ermoeglicht.
 */
public class PCam extends AbstractCamera{

    private double d;

    /**
     * Erzeugt eine neue Kamera an einer Position mit einem bestimmten
     * Blickpunkt.
     *
     * @param vup       Das Oben der Kamera
     * @param position  Die Position der Kamera
     * @param direction Der Punkt, zu dem die Kamera blickt
     * @param d         der Abstand der Kamera zur Projektionsebene. Umso kleiner der
     *                  Wert desto gr����er die perspektivische Wirkung
     */
    public PCam(Vector3d vup, Vector3d position, Vector3d direction, double d) {
        this.up = vup;
        this.location = position;
        this.direction = direction;
        this.d = d;
        
        //Debug
        if(Main.debug){
	        double lx = location.getX();
	        double ly = location.getY();
	        double lz = location.getZ();
	        System.out.println("POSITION DER KAMERA: ");
	        System.out.println("x = " + lx);
	        System.out.println("y = " + ly);
	        System.out.println("z = " + lz);
	        
	        
	        double dx = direction.getX();
	        double dy = direction.getY();
	        double dz = direction.getZ();
	        System.out.println("BLICKRICHTUNG DER KAMERA: ");
	        System.out.println("x = " + dx);
	        System.out.println("y = " + dy);
	        System.out.println("z = " + dz);
	        
	        double ux = up.getX();
	        double uy = up.getY();
	        double uz = up.getZ();
	        System.out.println("OBEN DER KAMERA: ");
	        System.out.println("x = " + ux);
	        System.out.println("y = " + uy);
	        System.out.println("z = " + uz);
        }
        
        
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
    	
    	//calculate z-axis of the camera
    	//vector between where it is located and where it looks
    	this.n = location.sub(direction).normalize();
    	//y-axis of the camera (given above)
    	this.u = up.cross(n).normalize();
        //calculate x-axis of the camera
    	this.v = n.cross(u).normalize();
        
    	
    	//Debug
    	if(Main.debug){
	    	double nx = n.getX();
	        double ny = n.getY();
	        double nz = n.getZ();
	        System.out.println("LOKALE Z-ACHSE DER KAMERA: ");
	        System.out.println("x = " + nx);
	        System.out.println("y = " + ny);
	        System.out.println("z = " + nz);
	        
	        double ux = u.getX();
	        double uy = u.getY();
	        double uz = u.getZ();
	        System.out.println("LOKALE X-ACHSE DER KAMERA: ");
	        System.out.println("x = " + ux);
	        System.out.println("y = " + uy);
	        System.out.println("z = " + uz);
	        
	        double vx = v.getX();
	        double vy = v.getY();
	        double vz = v.getZ();
	        System.out.println("LOKALE Y-ACHSE DER KAMERA: ");
	        System.out.println("x = " + vx);
	        System.out.println("y = " + vy);
	        System.out.println("z = " + vz);
    	}
        
         
    	//Matrix as given in script
         double[][] projectionValues = {
                 {1, 0, 0, 0},
                 {0, 1, 0, 0},
                 {0, 0, 0, 0},
                 {0, 0, 1.0/d, 1}
         };
         Matrix projection = new Matrix(projectionValues);
         
         
         Vector3d dd = Vector3d.createVector3d(location.dot(u), location.dot(v), location.dot(n));
         
         //Debug
         if(Main.debug){
	         System.out.println("VEKTOR:");
	         System.out.println(dd.x);
	         System.out.println(dd.y);
	         System.out.println(dd.z);
         }
         
         double[][] viewValues = {
                 {u.getX(), u.getY(), u.getZ(), dd.x},
                 {v.getX(), v.getY(), v.getZ(), dd.y},
                 {n.getX(), n.getY(), n.getZ(), dd.z},
                 {0, 0, 0, 1}
         };
         Matrix view = new Matrix(viewValues);
         projectionMatrix = projection.times(view);
    }
}
