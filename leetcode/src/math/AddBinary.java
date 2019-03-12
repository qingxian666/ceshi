package math;

public class AddBinary {
	public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
       int i = a.length() - 1, j = b.length() -1, carry = 0;
       
       while (i >= 0 || j >= 0|| carry>0) {
          int valueA = i < 0 ? 0 : a.charAt(i--) - '0';
          int valueB = j < 0 ? 0 : b.charAt(j--) - '0';
          int sum = valueA + valueB + carry;
           
           sb.insert(0, Character.forDigit(sum % 2, 10));
           carry = sum / 2;
       }
       
       return sb.toString();
   }
}
