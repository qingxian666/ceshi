package zijietiaodong;

import java.util.Scanner;

public class Main33 {
	public static void main(String[] args) {
	      Scanner in = new Scanner(System.in);
	      int n=in.nextInt();
	      int H[]= new int[n+1];
	      for(int i=1;i<n+1;i++){
	    	  H[i]=in.nextInt();
	      }
	      int m=0;
	     // System.out.println(energyaifirst(H,3));
	      
	     while(!energyaifirst(H,m)){
	    	  m++;
	    	  //System.out.println(m);
	      }
	      
	      System.out.println(m);
	}

	private static boolean energyaifirst(int []nums,int m) {
		// TODO Auto-generated method stub
		int n=nums.length;
		int []	energy=new int[n+1];
				energy[0]=m;
		for(int i=1;i<n;i++){
			energy[i]=(2*energy[i-1]-nums[i]);
			if((energy[i]<0)){
				return false;
			}	
	}
		return true;
	}
	
}
