import java.util.*;
import java.util.Map.Entry;
public class MeiTuanQ1 {
public int modifyMatrix(int[][]matrix) {
    int countOdd=0,countEven=0;
    HashMap<Integer,Integer>oddMap=new HashMap<Integer,Integer>();
    HashMap<Integer,Integer>evenMap=new HashMap<Integer,Integer>();
    int n=matrix.length,m=matrix[0].length;
    for(int i=0;i<n;i++)
        for(int j=0;j<m;j++) {
            if((i-j)%2!=0) {
                countOdd++;
                if(!oddMap.containsKey(matrix[i][j]))
                    oddMap.put(matrix[i][j],1);
                else oddMap.put(matrix[i][j],oddMap.get(matrix[i][j])+1);
                 
            }
            else {
                countEven++;
                if(!evenMap.containsKey(matrix[i][j]))
                    evenMap.put(matrix[i][j],1);
                else evenMap.put(matrix[i][j],evenMap.get(matrix[i][j])+1);
            }
        }
    List<Map.Entry<Integer,Integer>> list1 = new ArrayList<Map.Entry<Integer,Integer>>
    (oddMap.entrySet());
    Collections.sort(list1,new Comparator<Map.Entry<Integer,Integer>>() { 
    	@Override public int compare(Entry<Integer, Integer> o1,
                Entry<Integer, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
         
    });
     
    //for(Map.Entry<Integer,Integer> mapping:list1){ 
        //System.out.println(mapping.getKey()+":"+mapping.getValue());    } 
    List<Map.Entry<Integer,Integer>> list2 = new ArrayList<Map.Entry<Integer,Integer>>
    (evenMap.entrySet());
    Collections.sort(list2,new Comparator<Map.Entry<Integer,Integer>>() { 
    	@Override public int compare(Entry<Integer, Integer> o1,
                Entry<Integer, Integer> o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
         
    });
        int oddMax=list1.get(list1.size()-1).getValue();
        int evenMax=list2.get(list2.size()-1).getValue();
        int countOddMax=1;
        int countEvenMax=1;
        for(int i=list1.size()-2;i>=0;i--)
            if(list1.get(i).getValue()!=oddMax){
                countOddMax=list1.size()-1-i;
                break;
            }
        for(int i=list2.size()-2;i>=0;i--)
            if(list2.get(i).getValue()!=evenMax){
                countEvenMax=list2.size()-1-i;
                break;
            }
         
        if(countOddMax==1&&countEvenMax==1&&
                list1.get(list1.size()-1).getKey()==list2.get(list2.size()-1).getKey()
                )
            return Math.min(evenMax, oddMax);
        else 
            return (countEven-evenMax+countOdd-oddMax);
}
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][]matrix= {
                {1,2,1},{1,3,1},{1,1,1}
        };
        System.out.print(new MeiTuanQ1().modifyMatrix(matrix));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        int[][]matrix1=new int[n][m];
                for(int i=0;i<n;i++)
                    for(int j=0;j<m;j++)
                        matrix1[i][j]=sc.nextInt();
        int ans=new MeiTuanQ1().modifyMatrix(matrix);
        System.out.print(ans);
    }
}