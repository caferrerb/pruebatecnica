import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner input = new Scanner(System.in);
		int cases = Integer.valueOf(input.nextLine());
		for (int t = 0; t < cases; t++) {

			
			
			String[] data = input.nextLine().split(" ");
			int n = Integer.valueOf(data[0]);
			int ops = Integer.valueOf(data[1]);

			Map<String,long[]> tabla=new HashMap<>();
			
			
			for (int o = 0; o < ops; o++) {
				String orden = input.nextLine();
				ejecutarOrder(orden,tabla);
			}
			//System.out.println("***************************************");
		}
    }
    
    
    
   public static long ejecutarOrder(String linea,Map<String,long[]> tabla) {
		String data[] = linea.split(" ");
		String orden = data[0].toLowerCase();
		if (orden.startsWith("update")) {
			update(data,tabla);
			return 0;
		}

		if (orden.startsWith("query")) {
			System.out.println(query(data,tabla));
		}
		return 0;

	}
	
	public static void update(String data[],Map<String,long[]> tabla) {
		Long x=Long.valueOf(data[1]);
		Long y=Long.valueOf(data[2]);
		Long z=Long.valueOf(data[3]);
		Long w=Long.valueOf(data[4]);
		
		//valores[x-1][y-1][z-1]=w;
		long[] t= {x,y,z,w};
		
		tabla.put(x+"-"+y+"-"+z,t);
		
	}
	
	public static long query(String data[],Map<String,long[]> tabla) {
		long x1=Long.valueOf(data[1]);
		long y1=Long.valueOf(data[2]);
		long z1=Long.valueOf(data[3]);
		
		long x2=Long.valueOf(data[4]);
		long y2=Long.valueOf(data[5]);
		long z2=Long.valueOf(data[6]);
		
		
		long s=0;
		
		
		for (long[] t : tabla.values()) {
			
			if(t[0]>=x1 && t[0]<=x2 && t[1]>=y1 && t[1]<=y2 && t[2]>=z1 && t[2]<=z2) {
				s+=t[3];
			}
		}
		

		return s;
	}
}