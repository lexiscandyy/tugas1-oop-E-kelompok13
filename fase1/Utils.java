import java.util.Scanner;

public class Utils{
    static Scanner sc = new Scanner(System.in);
    public int ScanInt(){
        String str = sc.nextLine();
        System.out.println("tekan enter");
        sc.nextLine();
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9') return -1;
        }

        if(str.length() > 10) return -1;
        return Integer.parseInt(str);
    }

    public String ScanString(int lenLimit){
        String str = sc.nextLine();
        System.out.println("tekan enter");
        sc.nextLine();
        return (str.length() > lenLimit ? null : str);
    }
}