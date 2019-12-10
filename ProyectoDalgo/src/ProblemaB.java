import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

import javax.naming.ldap.SortControl;
import javax.swing.SortOrder;

public class ProblemaB {
	
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
	
	
	static int CeilIndex(int A[], int l, int r, int key) 
    { 
        while (r - l > 1) { 
            int m = l + (r - l) / 2; 
            if (A[m] >= key) 
                r = m; 
            else
                l = m; 
        } 
  
        return r; 
    } 
  
    static int LongestIncreasingSubsequenceLength(Tupla A[], int size) 
    { 
        // Add boundary case, when array size is one 
  
        int[] tailTable = new int[size]; 
        int len; // always points empty slot 
  
        tailTable[0] = A[0].b; 
        len = 1; 
        int lin=0;
        for (int i = 1; i < size; i++) { 
            if (A[i].b > tailTable[0]) 
                // new bigest value 
                tailTable[0] = A[i].b; 
  
            else if (A[i].b < tailTable[len - 1]) 
            {
                // A[i] wants to extend largest subsequence 
            	lin++;
                tailTable[len++] = A[i].b; 
            }
  
            else
                // A[i] wants to be current end candidate of an existing 
                // subsequence. It will replace ceil value in tailTable 
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i].b)] = A[i].b; 
        } 
  
        return lin; 
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
			
			int resp=LongestIncreasingSubsequenceLength(datos, datos.length);
			System.out.println(resp);
			
			
			indiv = br.readLine();
		}
		
	}

}
