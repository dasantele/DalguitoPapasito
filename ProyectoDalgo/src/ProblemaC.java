import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaC {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String constrains, datos[];
		constrains = br.readLine();
		while(!constrains.equals("0 0 0 0"))
		{
			String[] list = constrains.split(" ");
			Integer[] xcoords;
			Integer[] ycoords;
			datos= new String[Integer.parseInt(constrains)];
			for (int i = 0; i < Integer.parseInt(constrains); i++) {
				datos[i] = br.readLine();
			}
			
						
			constrains = br.readLine();
		}		
		
	}

}
