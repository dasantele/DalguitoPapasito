import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaC {
	
    static int INF = 10000; 
  
  

    /**
     * La funcion revisa si el punto q esta en el segmento que comienza en p y termina en r
     * @param px coordenada x de p
     * @param py coordenada y de p
     * @param qx coordenada x de q
     * @param qy coordenada y de q
     * @param rx coordenada x de r
     * @param ry coordenada y de r
     * @return
     */
    static boolean estaEnLinea(int px, int py, int qx, int qy, int rx, int ry)  
    { 
        if (qx <= Math.max(px, rx) && 
            qx >= Math.min(px, rx) && 
            qy <= Math.max(py, ry) && 
            qy >= Math.min(py, ry)) 
        { 
            return true; 
        } 
        return false; 
    } 
  
    // To find orientation of ordered triplet (p, q, r). 
    // The function returns following values 
    // 0 --> p, q and r are colinear 
    // 1 --> Clockwise 
    // 2 --> Counterclockwise 
    /**
     * Haya la orientacion de tres puntos conectados por dos segmentos
     * @param px
     * @param py
     * @param qx
     * @param qy
     * @param rx
     * @param ry
     * @return 0 si son colineares, 1 para sentido horario, dos para sentido antihorario.
     */
    static int orientacion(int px, int py, int qx, int qy, int rx, int ry)  
    { 
        int val = (qy - py) * (rx - qx) 
                - (qx - px) * (ry - qy);  
  
        if (val == 0)  
        { 
            return 0; // colinear 
        } 
        return (val > 0) ? 1 : 2; // clock or counterclock wise 
    } 
  
    // The function that returns true if  
    // line segment 'p1q1' and 'p2q2' intersect. 
    static boolean seInterseca(int p1x, int p1y, int q1x, int q1y, int p2x, int p2y, int q2x, int q2y)  
    { 
        // Find the four orientations needed for  
        // general and special cases 
        int o1 = orientacion(p1x, p1y, q1x, q1y, p2x, p2y); 
        int o2 = orientacion(p1x, p1y, q1x, q1y, q2x, q2y); 
        int o3 = orientacion(p2x, p2y, q2x, q2y, p1x, p1y); 
        int o4 = orientacion(p2x, p2y, q2x, q2y, q1x, q1y); 
  
        // General case 
        if (o1 != o2 && o3 != o4) 
        { 
            return true; 
        } 
  
        // Special Cases 
        // p1, q1 and p2 are colinear and 
        // p2 lies on segment p1q1 
        if (o1 == 0 && estaEnLinea(p1x, p1y, p2x, p2y, q1x, q1y))  
        { 
            return true; 
        } 
  
        // p1, q1 and p2 are colinear and 
        // q2 lies on segment p1q1 
        if (o2 == 0 && estaEnLinea(p1x, p1y, q2x, q2y, q1x, q1y))  
        { 
            return true; 
        } 
  
        // p2, q2 and p1 are colinear and 
        // p1 lies on segment p2q2 
        if (o3 == 0 && estaEnLinea(p2x, p2y, p1x, p1y, q2x, q2y)) 
        { 
            return true; 
        } 
  
        // p2, q2 and q1 are colinear and 
        // q1 lies on segment p2q2 
        if (o4 == 0 && estaEnLinea(p2x, p2y, q1x, q1y, q2x, q2y)) 
        { 
            return true; 
        } 
  
        // Doesn't fall in any of the above cases 
        return false;  
    } 
  
    // Returns true if the point p lies  
    // inside the polygon[] with n vertices 
    static int estaAdentro(Integer coordsx[], Integer coordsy[], int n, int px, int py) 
    { 
        // There must be at least 3 vertices in polygon[] 
        if (n < 3)  
        { 
            return -1; 
        } 
  
        // Create a point for line segment from p to infinite 
        //Point extreme = new Point(INF, p.y); 
  
        // Count intersections of the above line  
        // with sides of polygon 
        int count = 0, i = 0; 
        do 
        { 
            int next = (i + 1) % n; 
  
            // Check if the line segment from 'p' to  
            // 'extreme' intersects with the line  
            // segment from 'polygon[i]' to 'polygon[next]' 
            if (seInterseca(coordsx[i],coordsy[i], coordsx[next],coordsy[next], px, py, INF, py))  
            { 
                // If the point 'p' is colinear with line  
                // segment 'i-next', then check if it lies  
                // on segment. If it lies, return true, otherwise false 
                if (orientacion(coordsx[i],coordsy[i], px, py, coordsx[next],coordsy[next]) == 0) 
                { 
                    boolean aux =estaEnLinea(coordsx[i],coordsy[i], px, py, coordsx[next],coordsy[next]); 
                    if(aux)
                    {
                    	return 0;
                    }
                    else
                    {
                    	return -1;
                    }
                } 
  
                count++; 
            } 
            i = next; 
        } while (i != 0); 
  
        // Return true if count is odd, false otherwise 
        boolean rta = count % 2 == 1; // Same as (count%2 == 1) 
        if(rta)
        {
        	return 1;
        }
        else
        {
        	return -1;
        }

    } 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String constrains, datos[];
		constrains = br.readLine();
		while(!constrains.equals("0 0 0 0"))
		{
			String[] list = constrains.split(" ");
			Integer[] xcoords = new Integer[Integer.parseInt(list[1])];
			Integer[] ycoords = new Integer[Integer.parseInt(list[1])];
			datos = br.readLine().split(" ");
			for (int i = 0, j=0; i < Integer.parseInt(list[1])*2; i=i+2, j++) {
				xcoords[j] = Integer.parseInt(datos[i]);
				ycoords[j] = Integer.parseInt(datos[i+1]);
				}
			int rta = estaAdentro(xcoords, ycoords, xcoords.length, Integer.parseInt(list[2]), Integer.parseInt(list[3]));
			System.out.println(rta);
			constrains = br.readLine();
		}		
		
	}

}
