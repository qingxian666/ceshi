
public class Test {

	/*java.util.HashMap map=new java.util.HashMap();  
	map.put("name",null);       
	map.put("name","Jack"); 
	System.out.println(map.size());*/
	    
        /*Object o = new Object() {   
             public boolean equals(Object obj) {   
                 return true;  
         } 
     };    
     System.out.println(o.equals("Fred"));*/
	
	 public int add(int a,int b){    
         try { 
             return a+b;       
         } 
        catch (Exception e) {   
            System.out.println("catch”Ôæ‰øÈ"); 
         } 
         finally{  
             System.out.println("finally”Ôæ‰øÈ"); 
         } 
         return 0; 
    } 
     public static void main(String argv[]){ 
         Test test =new Test(); 
         System.out.println("∫Õ «£∫"+test.add(9, 34)); 
     }
     
} 


