import java.io.*;
public class Meituan10{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            String s = br.readLine();
            if(s.length() != 11) {System.out.println("-1"); continue;}
            switch(s.substring(0,3)){
                case "133":
                case "153":
                case "180":
                case "181":
                case "189":
                    System.out.println("China Telecom");break;
                case "130":
                case "131":
                case "155":
                case "185":
                case "186":
                    System.out.println("China Unicom");break;
                case "135":
                case "136":
                case "150":
                case "182":
                case "188":
                    System.out.println("China Mobile Communications");break;
                default: System.out.println("-1");
            }
        }
        br.close();
    }
}

