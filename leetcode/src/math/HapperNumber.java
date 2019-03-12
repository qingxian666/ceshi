package math;

import java.util.*;

public class HapperNumber {
	 public boolean isHappy(int n) {
		    Set<Integer> l=new HashSet<Integer>();
		        int s,r;
		        while(l.add(n)){
		            s=0;
		            while(n>0){
		                r=n%10;
		                s+=r*r;
		                n=n/10;
		            }
		            if(s==1){
		                return true;
		            }else {
		                n=s;
		            }
		        }
		        return false;
		    }
}
