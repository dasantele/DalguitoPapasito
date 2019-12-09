import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaB {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String indiv, datos[];
		indiv = br.readLine();
		while(!indiv.equals("0"))
		{
			datos= new String[Integer.parseInt(indiv)];
			for (int i = 0; i < Integer.parseInt(indiv); i++) {
				datos[i] = br.readLine();
			}
			
			
			
			indiv = br.readLine();
		}
		
	}

}
