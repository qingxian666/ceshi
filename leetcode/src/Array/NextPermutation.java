package Array;

public class NextPermutation {
	//自右向左进行一遍扫描，直到找到不按照升序排列的第一个数字，然后再对该数字右边的数字进行自右向左扫描，找到第一个比它大的数字，交换
	public void nextPermutation(int[] nums) {
        if(nums.length<=1){
         return;
     }
     
     int i= nums.length-1;
     
     for(;i>=1;i--){
        
        if(nums[i]>nums[i-1]){ //find first number which is smaller than it's after number
            break;
        }
     }
     
     if(i!=0){
         swap(nums,i-1); //if the number exist,which means that the nums not like{5,4,3,2,1}
     }
     
     reverse(nums,i);    
   }
   
   private void swap(int[] a,int i){
       for(int j = a.length-1;j>i;j--){
           if(a[j]>a[i]){
               int t = a[j];
               a[j] = a[i];
               a[i] = t;
               break;
           }
       }
   }
   
   private void reverse(int[] a,int i){//reverse the number after the number we have found
       int first = i;
       int last = a.length-1;
       while(first<last){
           int t = a[first];
           a[first] = a[last];
           a[last] = t;
           first ++;
           last --;
       }
   }
}
