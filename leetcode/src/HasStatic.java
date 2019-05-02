
public class HasStatic {// 1
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
       
        int p[][]={{1},{3,2},{4,5,6},{0}};
        System.out.println(p[1][2]);
    }
}