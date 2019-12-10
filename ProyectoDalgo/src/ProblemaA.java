import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaA {
	
	
	static int longestRepeatedSubstring(String str, int n) { 
		
        int LCSRe[][] = new int[n + 1][n + 1]; 
  
        String res = ""; // To store result  
        int res_length = 0; // To store length of result  
  
        // building table in bottom-up manner  
        int i, index = 0; 
        for (i = 1; i <= n; i++) { 
            for (int j = i + 1; j <= n; j++) { 
                // (j-i) > LCSRe[i-1][j-1] to remove  
                // overlapping  
                if (str.charAt(i - 1) == str.charAt(j - 1) 
                        && LCSRe[i - 1][j - 1] < (j - i)) { 
                    LCSRe[i][j] = LCSRe[i - 1][j - 1] + 1; 
  
                    // updating maximum length of the  
                    // substring and updating the finishing  
                    // index of the suffix  
                    if (LCSRe[i][j] > res_length) { 
                        res_length = LCSRe[i][j]; 
                        index = Math.max(i, index); 
                    } 
                } else { 
                    LCSRe[i][j] = 0; 
                } 
            } 
        } 
  
        // If we have non-empty result, then insert all  
        // characters from first character to last  
        // character of String  
        if (res_length > 0) { 
            for (i = index - res_length + 1; i <= index; i++) { 
                res += str.charAt(i - 1); 
            } 
        } 
  
        return res_length; 
    } 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String size;
		size = br.readLine();
		int rta = 0;
		String info=br.readLine();
//		while(!size.equals("0"))
//		{
//			info = br.readLine();
//			datos=info.split(" ");
//			rta=0;
//			int i = 0;
//			int j = datos.length/2;
//			int divider = datos.length/2;
//			for (j=divider, i=0; divider!=0; i++,j++) {
//				if(j==datos.length-1)
//				{
//					divider=divider/2;
//					i=0;
//				}
//				if(datos[i].equals(datos[j]))
//				{
//					rta++;
//				}
//				rta++;
//			}
//			System.out.println(rta);
//			size = br.readLine();
//			
//		}
		rta= longestRepeatedSubstring(info, Integer.parseInt(size));
		System.out.println(rta);
		
	}

}
