import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemaB {


	static int lista [];

	static class Tupla implements Comparable<Tupla>
	{

		int indice;
		int a;
		int b;

		public Tupla(int i, int pA, int pB) {
			this.indice=i;
			this.a=pA;
			this.b=pB;

		}


		public int compareTo(Tupla o) {
			if(this.a>o.a)
			{
				return 1;
			}
			else if(this.a==o.a)
			{
				return 0;
			}
			else {
				return -1;
			}
		}

	}


	static int solucion(Tupla arreglo[], int n) 
	{ 
		int listaDeDecrecimiento[] = new int[n]; 
		int i, j, max = 0;

		for (i = 0; i < n; i++) 
			listaDeDecrecimiento[i] = 1; 

		
		for (i = 1; i < n; i++) 
			for (j = 0; j < i; j++) 
				if (arreglo[i].b < arreglo[j].b &&  
						listaDeDecrecimiento[i] < listaDeDecrecimiento[j] + 1)
				{
					listaDeDecrecimiento[i] = listaDeDecrecimiento[j] + 1; 

				}

		
		for (i = 0; i < n; i++) 
		{
			if (max < listaDeDecrecimiento[i]) 
			{
				
				max = listaDeDecrecimiento[i];
			}
		}

		lista= new int [max];
		int ayuda=0;
		for (int k = 0; k < n-1; k++) {
			if(listaDeDecrecimiento[k]!=listaDeDecrecimiento[k+1])
			{
				lista[ayuda++]=arreglo[k].indice;
			}
			if(n-1==k+1)
			{
				if(arreglo[k].indice<arreglo[k+1].indice)
				{
					lista[ayuda++]=arreglo[k].indice;
				}
				else
				{
					lista[ayuda++]=arreglo[k+1].indice;
				}
			}
		}

		// returns the length 
		// of the LDS 
		return max; 
	}  



	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String indiv;
		Tupla datos[];
		indiv = br.readLine();

		while(!indiv.equals("0"))
		{



			datos= new Tupla[Integer.parseInt(indiv)];
			for (int i = 0; i < Integer.parseInt(indiv); i++) {
				String lista[]=br.readLine().split(" ");
				datos[i]=new Tupla(Integer.parseInt(lista[0]), Integer.parseInt(lista[1]), Integer.parseInt(lista[2]));

			}
			Arrays.sort(datos);

			int resp=solucion(datos, datos.length);
			String cadena="";
			for (int i = 0; i < lista.length; i++) {
				cadena+=lista[i]+" ";
			}
			if(resp<=1)
			{
				resp=0;
				cadena="*";
			}

			System.out.println(resp);
			System.out.println(cadena);


			indiv = br.readLine();
		}

	}

}
