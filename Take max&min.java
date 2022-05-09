import java.util.*;
public class Main
{
	public static void main(String args[]) {
		int ave;
		int i = 0;
		int max = 0;
		int min = 9999;
		int max_index = 0;
		int min_index= 0;
		int total = 0;
		Scanner s = new Scanner(System.in);
	    int n = s.nextInt();
		int [] arr = new int [n];
	    for(i=0;i<n;i++){
	        int j = s.nextInt();
	        arr[i] = j;
	        if(j>max){
	            max = j;
	            max_index = i;
	        }
	        if(j<min) {
	            min = j;
	            min_index = i;
	        }   
	    }
	    s.close();
	    for(i=0;i<n;i++){
	        total = total+arr[i];
	    }
	   	    ave = (total/n);
	   	    int pl = max-ave;
	   	    arr[max_index] = max-pl;
	   	    arr[min_index] = min+pl;
	   	    for(i=0;i<n;i++) {
	   	    	System.out.print(arr[i]+" ");
	   	    }
	   	System.out.print("\n");
	   	System.out.print("max="+max);
	   	System.out.print(" min="+min);
	   	System.out.print(" total="+total);
	   	System.out.print(" ave="+ave);
	    }
	}
	
