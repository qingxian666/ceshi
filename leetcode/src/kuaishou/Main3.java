package kuaishou;

import java.util.LinkedList;
import java.util.Scanner;
public class Main3 {
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      String s = in.next();
      String[] split = s.split(",");
      int x = Integer.valueOf(split[0]);
      int y = Integer.valueOf(split[1]);
      LinkedList<Integer> list = new LinkedList<>();
      int times = 0;
      int count = 0;
      int temp = x;
      while(temp != y) {
          list.add(temp+1);
          list.add(temp-1);
          list.add(temp*2);
          if(count == 0) {
              count = list.size();
              times++;
          }
          temp = list.removeFirst();
          count--;
      }
      System.out.println(times);
   }
}