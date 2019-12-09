import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaA {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String size, datos[];
		size = br.readLine();
		int rta = 0;
		while(!size.equals("0"))
		{
			datos = br.readLine().split(" ");
			rta=0;
			int i = 0;
			int j = datos.length/2;
			int divider = datos.length/2;
			for (j=divider, i=0; divider!=0; i++,j++) {
				if(j==datos.length-1)
				{
					divider=divider/2;
					i=0;
				}
				if(datos[i].equals(datos[j]))
				{
					rta++;
				}
				rta++;
			}
			System.out.println(rta);
			size = br.readLine();
			
		}
		
	}

}
